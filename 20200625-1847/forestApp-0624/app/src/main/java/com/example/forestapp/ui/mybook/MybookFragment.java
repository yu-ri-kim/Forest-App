package com.example.forestapp.ui.mybook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.forestapp.R;
import com.example.forestapp.databinding.FragmentBooksearchBinding;
import com.example.forestapp.databinding.FragmentMybookBinding;
import com.example.forestapp.ui.bookSearch.BookSearchFragment;
import com.example.forestapp.ui.bookSearch.BookSearchViewModel;

public class MybookFragment extends Fragment {
    MybookViewModel model = new MybookViewModel();
    public MybookFragment() {
        // Required empty public constructor
    }
    public static MybookFragment instance() {
        return new MybookFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("내도감");
        return DataBindingUtil.inflate(inflater, R.layout.fragment_mybook, container, false).getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentMybookBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }
}