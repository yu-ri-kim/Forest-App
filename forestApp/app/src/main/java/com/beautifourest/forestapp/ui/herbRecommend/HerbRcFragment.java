package com.beautifourest.forestapp.ui.herbRecommend;

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
import com.beautifourest.forestapp.databinding.FragmentHerbrcBinding;

public class HerbRcFragment extends Fragment {
    HerbRcViewModel model;

    public HerbRcFragment() {
        // Required empty public constructor
    }

    UserJson user;
    GridView gridView;
    static HerbAdapter adapter=new HerbAdapter();
    private CallAnotherActivityNavigator navigator;

    public HerbRcFragment(CallAnotherActivityNavigator navigator){
        this.navigator=navigator;
    }

    public static HerbRcFragment instance() {
        return new HerbRcFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Object o = DataBindingUtil.inflate(inflater, R.layout.fragment_herbrc, container, false).getRoot();

        Bundle bundle= getArguments();
        UserJson user = (UserJson) bundle.getSerializable("user");
        model = new HerbRcViewModel(user);
        return (View) o;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentHerbrcBinding binding = DataBindingUtil.getBinding(getView());
        gridView=(GridView)getView().findViewById(R.id.gridView);
        model.setGridView(gridView);
        model.setAdapter(adapter);
        model.setNavigator(navigator);
        binding.setModel(model);
        model.onCreate();
    }

    @BindingAdapter("app:items")
    public static void setUserList(GridView gridView, ObservableArrayList<HerbViewModel> herb){
        if(gridView.getAdapter()==null){
            gridView.setAdapter(adapter);
        }
        else{
            adapter=(HerbAdapter) gridView.getAdapter();
        }
        adapter.addAll(herb);
    }
}