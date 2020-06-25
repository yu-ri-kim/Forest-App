package com.example.forestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;

import android.os.Bundle;
import android.widget.ListView;

import com.example.forestapp.databinding.ActivityListBinding;

public class ListActivity extends AppCompatActivity {
    private UsersViewModel usersViewModel = new UsersViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        binding.setModel(usersViewModel);
    }

    @BindingAdapter("app:items")
    public static void setUserList(ListView listView, ObservableArrayList<UserViewModel> users) {
        UserListViewAdapter adapter;

        if(listView.getAdapter() == null) {
            adapter = new UserListViewAdapter();
            listView.setAdapter(adapter);
        }
        else {
            adapter = (UserListViewAdapter) listView.getAdapter();
        }

        adapter.addAll(users);
    }
}