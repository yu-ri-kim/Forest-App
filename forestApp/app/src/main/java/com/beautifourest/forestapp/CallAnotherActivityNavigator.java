package com.beautifourest.forestapp;

import com.beautifourest.forestapp.Model.DiseaseJson;
import com.beautifourest.forestapp.Model.HerbJson;
import com.beautifourest.forestapp.Model.MyplantsJson;
import com.beautifourest.forestapp.Model.PlantJson;
import com.beautifourest.forestapp.Model.UserJson;

import java.util.List;

/* 화면전환을 위한 인터페이스 */
public interface CallAnotherActivityNavigator {
    void callActivity(UserJson user);
    void callFragment(UserJson user, int num, List<DiseaseJson> diseaseList);
    void callFragmentForInfo(int num, PlantJson info, MyplantsJson info2);
    void callFragmentForInfo(int num, HerbJson herb_info);
    void callFramgemntForUpdate(int num, MyplantsJson info, UserJson user);
    void closeFragment();
    void forToast(String msg);
    void refreshFragment(int num);
    void callImageActivity(List<String> imgs, String name);
}
