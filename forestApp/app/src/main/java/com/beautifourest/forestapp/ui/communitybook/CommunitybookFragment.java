package com.beautifourest.forestapp.ui.communitybook;

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

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.FragmentCommunitybookBinding;
import com.beautifourest.forestapp.databinding.FragmentMybookBinding;

/* 게시판 fragment */
public class CommunitybookFragment extends Fragment{
    private CommunitybookViewModel model;
    private GridView gridView;
    private UserJson user;

    static CommunitybookAdapter adapter = new CommunitybookAdapter();
    private CallAnotherActivityNavigator navigator;

    public CommunitybookFragment() { }

    public CommunitybookFragment(CallAnotherActivityNavigator navigator) {
        this.navigator = navigator;
    }

    public static CommunitybookFragment instance() {
        return new CommunitybookFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Object o = DataBindingUtil.inflate(inflater, R.layout.fragment_communitybook, container, false).getRoot();

        Bundle bundle= getArguments();
        user = (UserJson) bundle.getSerializable("user");

        return (View) o;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gridView=(GridView) getView().findViewById(R.id.gridView);
        model = new CommunitybookViewModel(user, navigator,gridView ,adapter);

        FragmentCommunitybookBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.setContext(getContext());
        model.setActivity(getActivity());
        model.onCreate();
    }

    @BindingAdapter("app:items")
    public static void setUserList(GridView listView, ObservableArrayList<CbViewModel> myplants) {
        if(listView.getAdapter() == null) {
            listView.setAdapter(adapter);
        }
        else {
            adapter = (CommunitybookAdapter) listView.getAdapter();
        }
        adapter.addAll(myplants);
    }
}