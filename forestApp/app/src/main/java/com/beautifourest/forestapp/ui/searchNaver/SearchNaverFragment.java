package com.beautifourest.forestapp.ui.searchNaver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.PlantJson;
import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.FragmentBookinfoBinding;
import com.beautifourest.forestapp.databinding.FragmentSearchnaverBinding;

/* 도감 상세정보 fragment */
public class SearchNaverFragment extends Fragment {
    SearchNaverViewModel model = new SearchNaverViewModel();

    public SearchNaverFragment() { }
    public static SearchNaverFragment instance() {
        return new SearchNaverFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Object o = DataBindingUtil.inflate(inflater, R.layout.fragment_searchnaver, container, false).getRoot();
        getActivity().setTitle("검색하기");
        model.setContext(getContext());
        return (View) o;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentSearchnaverBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }
}