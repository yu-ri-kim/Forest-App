package com.beautifourest.forestapp.ui.mybookInfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.CommentItemBinding;
import com.beautifourest.forestapp.databinding.MybookItemBinding;
import com.beautifourest.forestapp.ui.mybook.MbViewModel;

public class CommentAdapter extends BaseAdapter{
    private ObservableArrayList<CommentViewModel> comments = new ObservableArrayList<>();

    public void addAll(ObservableArrayList<CommentViewModel> comments) {
        this.comments = comments;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public CommentViewModel getItem(int i) {
        return comments.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CommentItemBinding binding;
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.comment_item, viewGroup, false);
            view = binding.getRoot();
            view.setTag(binding);
        } else {
            binding = (CommentItemBinding) view.getTag();
        }
        binding.setModel(comments.get(i));
        return view;
    }
}
