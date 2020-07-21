package com.beautifourest.forestapp.ui.communitybook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.CommunitybookItemBinding;
import com.beautifourest.forestapp.databinding.MybookItemBinding;

/* 게시판 그리드뷰 어뎁터 */
public class CommunitybookAdapter extends BaseAdapter{
    private ObservableArrayList<CbViewModel> myplants = new ObservableArrayList<>();

    public void addAll(ObservableArrayList<CbViewModel> myplants) {
        this.myplants = myplants;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return myplants.size();
    }

    @Override
    public CbViewModel getItem(int i) {
        return myplants.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CommunitybookItemBinding binding;
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.communitybook_item, viewGroup, false);
            view = binding.getRoot();
            view.setTag(binding);
        } else {
            binding = (CommunitybookItemBinding) view.getTag();
        }
        binding.setModel(myplants.get(i));
        return view;
    }
}
