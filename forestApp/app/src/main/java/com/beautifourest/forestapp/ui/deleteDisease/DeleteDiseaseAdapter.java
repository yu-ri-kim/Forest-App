package com.beautifourest.forestapp.ui.deleteDisease;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.DeleteItemBinding;

public class DeleteDiseaseAdapter extends BaseAdapter {
    private ObservableArrayList<DiseaseViewModel> diseases=new ObservableArrayList<>();

    public void addAll(ObservableArrayList<DiseaseViewModel> diseases){
        this.diseases=diseases;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return diseases.size();
    }

    @Override
    public DiseaseViewModel getItem(int i) {
        return diseases.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DeleteItemBinding binding;
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(parent.getContext());
            binding= DataBindingUtil.inflate(inflater, R.layout.delete_item,parent,false);
            convertView=binding.getRoot();
            convertView.setTag(binding);
        } else{
            binding=(DeleteItemBinding) convertView.getTag();
        }
        binding.setModel(diseases.get(position));
        return convertView;
    }
}