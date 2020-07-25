package com.beautifourest.forestapp.ui.community;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.beautifourest.forestapp.ui.mushroom.MushroomFragment;
import com.beautifourest.forestapp.ui.mybook.MybookFragment;

import java.util.ArrayList;

/* 탭 관리하는 어뎁터(모두의 도감/나만의 도감) */
public class VPAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<>();

    public VPAdapter(FragmentManager fm){
        super(fm);
        items = new ArrayList<Fragment>();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return itext.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    /* 프래그먼트 추가 */
    public void addFragment(Fragment fragment, String title){
        items.add(fragment); // 탭에 보여질 프레그먼트
        itext.add(title); // 탭 이름
    }
}
