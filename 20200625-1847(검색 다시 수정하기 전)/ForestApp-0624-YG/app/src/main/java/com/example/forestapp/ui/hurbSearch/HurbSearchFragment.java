package com.example.forestapp.ui.hurbSearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.forestapp.R;

public class HurbSearchFragment extends Fragment {

    private HurbSearchViewModel hurbSearchViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        hurbSearchViewModel =
                ViewModelProviders.of(this).get(HurbSearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_hurbsearch, container, false);
        final TextView textView = root.findViewById(R.id.text_hurbsearch);
        hurbSearchViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}