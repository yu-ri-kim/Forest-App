package com.beautifourest.forestapp.ui.bookSearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.FragmentBooksearchBinding;

public class BookSearchFragment extends Fragment {
    BookSearchViewModel model;
    ListView listView;
    static BookSearchAdapter adapter = new BookSearchAdapter();
    private CallAnotherActivityNavigator navigator;

    public BookSearchFragment() { }

    public BookSearchFragment(CallAnotherActivityNavigator navigator) {
        this.navigator = navigator;
    }

    public static BookSearchFragment instance() {
        return new BookSearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View o= DataBindingUtil.inflate(inflater, R.layout.fragment_booksearch, container, false).getRoot();
        getActivity().setTitle("도감검색");

        return o;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = (ListView) getView().findViewById(R.id.listview_booksearch);
        model = new BookSearchViewModel(listView, adapter, navigator);

        FragmentBooksearchBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }


    @BindingAdapter("app:items")
    public static void setUserList(ListView listView, ObservableArrayList<BkViewModel> plants) {
        if(listView.getAdapter() == null) {
            listView.setAdapter(adapter);
        }
        else {
            adapter = (BookSearchAdapter) listView.getAdapter();
        }
        adapter.addAll(plants);
    }
}