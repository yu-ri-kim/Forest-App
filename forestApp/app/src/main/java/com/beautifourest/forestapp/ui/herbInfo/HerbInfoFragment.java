package com.beautifourest.forestapp.ui.herbInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.HerbJson;
import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.FragmentHerbinfoBinding;

/* 허브 상세내용 fragment */
public class HerbInfoFragment extends Fragment {
    HerbInfoViewModel model;
    private CallAnotherActivityNavigator navigator;

    public HerbInfoFragment(){ }

    public static HerbInfoFragment instance(){return new HerbInfoFragment();}
    public HerbInfoFragment(CallAnotherActivityNavigator navigator){this.navigator=navigator;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Object o = DataBindingUtil.inflate(inflater, R.layout.fragment_herbinfo, container, false).getRoot();

        Bundle bundle= getArguments();
        HerbJson herb = (HerbJson) bundle.getSerializable("herb");
        model = new HerbInfoViewModel(herb, navigator);

        getActivity().setTitle("상세보기");
        return (View) o;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentHerbinfoBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }


}
