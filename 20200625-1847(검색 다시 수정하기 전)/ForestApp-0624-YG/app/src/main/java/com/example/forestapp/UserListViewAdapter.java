package com.example.forestapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import com.example.forestapp.databinding.LayoutBinding;

public class UserListViewAdapter  extends BaseAdapter {
    private ObservableArrayList<UserViewModel> users = new ObservableArrayList<>();

    public void addAll(ObservableArrayList<UserViewModel> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public UserViewModel getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutBinding binding;

        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.layout, viewGroup, false);
            view = binding.getRoot();
            view.setTag(binding);
        } else {
            binding = (LayoutBinding) view.getTag();
        }

        binding.setUser(users.get(i));

        return view;
    }
}
