package com.example.forestapp.ui.bookSearch;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.forestapp.R;
import com.example.forestapp.databinding.FragmentBooksearchBinding;

public class BookSearchFragment extends Fragment {
    BookSearchViewModel model = new BookSearchViewModel();


    public BookSearchFragment() {
        // Required empty public constructor
    }

    public static BookSearchFragment instance() {
        return new BookSearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_booksearch, container, false).getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentBooksearchBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }

    @BindingAdapter("app:items")
    public static void setUserList(ListView listView, ObservableArrayList<BkViewModel> plants) {
        BookSearchAdapter adapter;

        if(listView.getAdapter() == null) {
            adapter = new BookSearchAdapter();
            listView.setAdapter(adapter);
        }
        else {
            adapter = (BookSearchAdapter) listView.getAdapter();
        }

        adapter.addAll(plants);
    }
}