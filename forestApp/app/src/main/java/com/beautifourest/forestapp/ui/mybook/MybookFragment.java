package com.beautifourest.forestapp.ui.mybook;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.FragmentBooksearchBinding;
import com.beautifourest.forestapp.databinding.FragmentMybookBinding;

public class MybookFragment extends Fragment{
    MybookViewModel model;
    GridView gridView;
    UserJson user;
    static MybookAdapter adapter = new MybookAdapter();
    private CallAnotherActivityNavigator navigator;

    public MybookFragment() {
        // Required empty public constructor
    }
    public static MybookFragment instance() {
        return new MybookFragment();
    }

    public MybookFragment(CallAnotherActivityNavigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Object o = DataBindingUtil.inflate(inflater, R.layout.fragment_mybook, container, false).getRoot();

        Bundle bundle= getArguments();
        user = (UserJson) bundle.getSerializable("user");
        Log.d("Test","fragment user mybook: "+user.toString());

        // getActivity().setTitle("나만의 도감");

        return (View) o;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gridView=(GridView) getView().findViewById(R.id.gridView);
        model = new MybookViewModel(user, navigator,gridView ,adapter);

        FragmentMybookBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.setContext(getContext());
        model.setActivity(getActivity());
        model.onCreate();
    }

    @BindingAdapter("app:items")
    public static void setUserList(GridView listView, ObservableArrayList<MbViewModel> myplants) {
        if(listView.getAdapter() == null) {
            listView.setAdapter(adapter);
        }
        else {
            adapter = (MybookAdapter) listView.getAdapter();
        }
        adapter.addAll(myplants);
    }
}