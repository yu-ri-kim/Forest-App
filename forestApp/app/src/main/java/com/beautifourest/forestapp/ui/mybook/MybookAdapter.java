package com.beautifourest.forestapp.ui.mybook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.BooksearchItemBinding;
import com.beautifourest.forestapp.databinding.MybookItemBinding;

public class MybookAdapter extends BaseAdapter{
    private ObservableArrayList<MbViewModel> myplants = new ObservableArrayList<>();

    public void addAll(ObservableArrayList<MbViewModel> myplants) {
        this.myplants = myplants;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return myplants.size();
    }

    @Override
    public MbViewModel getItem(int i) {
        return myplants.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MybookItemBinding binding;
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.mybook_item, viewGroup, false);
            view = binding.getRoot();
            view.setTag(binding);
        } else {
            binding = (MybookItemBinding) view.getTag();
        }
        binding.setModel(myplants.get(i));
        return view;
    }
}
