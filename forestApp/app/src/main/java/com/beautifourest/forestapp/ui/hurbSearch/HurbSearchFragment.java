package com.beautifourest.forestapp.ui.hurbSearch;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.FragmentHurbsearchBinding;

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