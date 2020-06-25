package com.example.forestapp.ui.hurbSearch;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.forestapp.CallAnotherActivityNavigator;
import com.example.forestapp.MainActivity;
import com.example.forestapp.Model.UserJson;
import com.example.forestapp.R;
import com.example.forestapp.databinding.FragmentBooksearchBinding;
import com.example.forestapp.databinding.FragmentHurbsearchBinding;
import com.example.forestapp.ui.bookSearch.BookSearchFragment;
import com.example.forestapp.ui.bookSearch.BookSearchViewModel;

public class HurbSearchFragment extends Fragment{
    HurbSearchViewModel model;
    private CallAnotherActivityNavigator navigator;

    public HurbSearchFragment() {
        // Required empty public constructor
    }

    public HurbSearchFragment(CallAnotherActivityNavigator navigator) {
        this.navigator = navigator;
    }

    public static HurbSearchFragment instance() {
        return new HurbSearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Object o = DataBindingUtil.inflate(inflater, R.layout.fragment_hurbsearch, container, false).getRoot();
        Bundle bundle= getArguments();
        UserJson user = (UserJson) bundle.getSerializable("user");
        Log.d("Test","fragment user: "+user.toString());
        model = new HurbSearchViewModel(user, navigator);
        getActivity().setTitle("약초찾기");
        return (View) o;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentHurbsearchBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }
}