package com.beautifourest.forestapp.ui.herbRecommend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.BookItemBinding;
import com.beautifourest.forestapp.databinding.BooksearchItemBinding;
import com.beautifourest.forestapp.databinding.HerbItemBinding;

public class HerbAdapter extends BaseAdapter {
    private ObservableArrayList<HerbViewModel> herbs = new ObservableArrayList<>();

    public void addAll(ObservableArrayList<HerbViewModel> herbs) {
        this.herbs = herbs;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return herbs.size();
    }

    @Override
    public HerbViewModel getItem(int i) {
        return herbs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HerbItemBinding binding;
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.herb_item, viewGroup, false);
            view = binding.getRoot();
            view.setTag(binding);
        } else {
            binding = (HerbItemBinding) view.getTag();
        }
        binding.setModel(herbs.get(i));
        return view;
    }
}
