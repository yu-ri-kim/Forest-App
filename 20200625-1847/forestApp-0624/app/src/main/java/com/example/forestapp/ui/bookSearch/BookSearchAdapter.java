package com.example.forestapp.ui.bookSearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import com.example.forestapp.R;
import com.example.forestapp.databinding.BooksearchItemBinding;
import com.example.forestapp.databinding.FragmentBooksearchBinding;

public class BookSearchAdapter extends BaseAdapter{
    private ObservableArrayList<BkViewModel> plants = new ObservableArrayList<>();

    public void addAll(ObservableArrayList<BkViewModel> plants) {
        this.plants = plants;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return plants.size();
    }

    @Override
    public BkViewModel getItem(int i) {
        return plants.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BooksearchItemBinding binding;
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.booksearch_item, viewGroup, false);
            view = binding.getRoot();
            view.setTag(binding);
        } else {
            binding = (BooksearchItemBinding) view.getTag();
        }
        binding.setPlant(plants.get(i));
        return view;
    }
}
