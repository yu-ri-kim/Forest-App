package com.beautifourest.forestapp.ui.insertDisease;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.DiseaseJson;
import com.beautifourest.forestapp.Model.HerbJson;
import com.beautifourest.forestapp.Model.MyplantsJson;
import com.beautifourest.forestapp.Model.PlantJson;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.FragmentInsertdialogBinding;
import com.beautifourest.forestapp.databinding.FragmentMybookBinding;

import java.util.ArrayList;
import java.util.List;

public class InsertDialogFragment extends DialogFragment implements CallAnotherActivityNavigator {
    public static final String TAG_EVENT_DIALOG = "dialog_event";
    InsertDialogViewModel model;
    private List<DiseaseJson> diseaseList; // 전체 정보가 담긴 리스트
    private List<String> diseaseNames=new ArrayList<>();

    private UserJson user;

    private Activity activity; // 액티비티

    public UserJson getUser() {
        return user;
    }

    public void setUser(UserJson user) {
        this.user = user;
    }

    public List<DiseaseJson> getDiseaseList() {
        return diseaseList;
    }


    public void setDiseaseList(List<DiseaseJson> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public InsertDialogFragment() {
        // Required empty public constructor
    }
    public static InsertDialogFragment instance() {
        return new InsertDialogFragment();
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        //createDateListView(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = DataBindingUtil.inflate(inflater, R.layout.fragment_insertdialog, container, false).getRoot();
        makeList(); // 병명 이름만 넣은 리스트 만들기

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)v.findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, diseaseNames));

        model = new InsertDialogViewModel(user,diseaseList,this); // 유저랑 병명 정보 리스트 주기

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentInsertdialogBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }

    public void makeList(){
        for(DiseaseJson d : diseaseList){
            diseaseNames.add(d.getDname()); // 이름만 담긴 리스트 만들기
        }
    }

    @Override
    public void callActivity(UserJson user) {

    }

    @Override
    public void callFragment(UserJson user, int num, List<DiseaseJson> diseaseList) {

    }

    @Override
    public void callFragmentForInfo(int num, PlantJson info, MyplantsJson info2, UserJson user) {

    }

    @Override
    public void callFragmentForInfo(int num, HerbJson herb_info) {

    }

    @Override
    public void callFramgemntForUpdate(int num, MyplantsJson info, UserJson user) {

    }

    @Override
    public void closeFragment() {
        dismiss();
    }

    @Override
    public void forToast(String msg) {
        Toast.makeText(this.activity,msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshFragment(int num) {

    }

    @Override
    public void callImageActivity(List<String> imgs, String name) {

    }
}