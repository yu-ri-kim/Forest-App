package com.example.forestapp.ui.hurbSearch;

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
import com.example.forestapp.databinding.FragmentHurbsearchBinding;
import com.example.forestapp.ui.bookSearch.BookSearchFragment;
import com.example.forestapp.ui.bookSearch.BookSearchViewModel;

public class HurbSearchFragment extends Fragment {
    HurbSearchViewModel model = new HurbSearchViewModel();
    public HurbSearchFragment() {
        // Required empty public constructor
    }

    public static HurbSearchFragment instance() {
        return new HurbSearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_hurbsearch, container, false).getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentHurbsearchBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }
}