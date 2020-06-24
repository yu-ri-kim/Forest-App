package com.example.forestapp.ui.book;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import com.example.forestapp.R;
import com.example.forestapp.databinding.BookItemBinding;

public class BookAdapter extends BaseAdapter {
    private ObservableArrayList<BookViewModel> plants=new ObservableArrayList<>();

    public void add(ObservableArrayList<BookViewModel> plants){
        this.plants=plants;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return plants.size();
    }

    @Override
    public BookViewModel getItem(int position) {
        return plants.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookItemBinding binding;
        if(convertView==null){
            LayoutInflater inflater= LayoutInflater.from(parent.getContext());
            binding= DataBindingUtil.inflate(inflater, R.layout.book_item,parent,false);
            convertView=binding.getRoot();
            convertView.setTag(binding);
        }   else{
            binding=(BookItemBinding) convertView.getTag();
        }
        binding.setPlant(plants.get(position));
        return convertView;
    }
}
