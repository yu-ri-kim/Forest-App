package com.beautifourest.forestapp.ui.bookInfo;

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

/* 도감 상세정보 fragment */
public class BookInfoFragment extends Fragment {
    BookInfoViewModel model;
    private CallAnotherActivityNavigator navigator;

    public BookInfoFragment() { }
    public static BookInfoFragment instance() {
        return new BookInfoFragment();
    }

    public BookInfoFragment(CallAnotherActivityNavigator navigator) { this.navigator = navigator; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Object o = DataBindingUtil.inflate(inflater, R.layout.fragment_bookinfo, container, false).getRoot();

        Bundle bundle= getArguments();
        PlantJson plant = (PlantJson) bundle.getSerializable("plant");
        model = new BookInfoViewModel(plant, navigator);

        getActivity().setTitle("상세보기");
        return (View) o;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentBookinfoBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }
}