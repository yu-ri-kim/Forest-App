package com.example.forestapp.ui.book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.forestapp.R;
import com.example.forestapp.databinding.FragmentBookBinding;

public class BookFragment extends Fragment {

    BooksViewModel model=new BooksViewModel();

    public BookFragment(){

    }

    public static BookFragment instance(){
        return new BookFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return DataBindingUtil.inflate(inflater, R.layout.fragment_book, container, false).getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        FragmentBookBinding binding=DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }

    @BindingAdapter("app:items")
    public static void setUserList(GridView gridView, ObservableArrayList<BookViewModel> plants){
        BookAdapter adapter;
        if(gridView.getAdapter()==null){
            adapter=new BookAdapter();
            gridView.setAdapter(adapter);
        }
        else{
            adapter=(BookAdapter) gridView.getAdapter();
        }
        adapter.add(plants);
    }
}