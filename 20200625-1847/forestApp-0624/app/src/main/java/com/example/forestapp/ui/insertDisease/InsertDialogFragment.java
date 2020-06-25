package com.example.forestapp.ui.insertDisease;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.example.forestapp.R;
import com.example.forestapp.databinding.FragmentInsertdialogBinding;
import com.example.forestapp.databinding.FragmentMybookBinding;

import java.util.List;

public class InsertDialogFragment extends DialogFragment {
    public static final String TAG_EVENT_DIALOG = "dialog_event";
    private List<String> diseaseList;

    public List<String> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<String> diseaseList) {
        this.diseaseList = diseaseList;
    }

    InsertDialogViewModel model = new InsertDialogViewModel();

    public InsertDialogFragment() {
        // Required empty public constructor
    }
    public static InsertDialogFragment instance() {
        return new InsertDialogFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = DataBindingUtil.inflate(inflater, R.layout.fragment_insertdialog, container, false).getRoot();
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)v.findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, getDiseaseList()));
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentInsertdialogBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }
}