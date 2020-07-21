package com.beautifourest.forestapp.ui.community;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.ui.communitybook.CommunitybookFragment;
import com.beautifourest.forestapp.ui.mybook.MybookFragment;
import com.google.android.material.tabs.TabLayout;

/* 커뮤니티 프래그먼트 */
public class CommunityFragment extends Fragment {
    private CallAnotherActivityNavigator navigator;
    private UserJson user;

    public CommunityFragment(){ }
    public CommunityFragment(CallAnotherActivityNavigator navigator){ this.navigator = navigator; }

    public static CommunityFragment instance(){ return new CommunityFragment(); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_community, container, false);

        ViewPager vp = (ViewPager)v.findViewById(R.id.viewpager);
        VPAdapter adapter = new VPAdapter(getChildFragmentManager());

        // 연동
        TabLayout tab = (TabLayout)v.findViewById(R.id.tab);
        tab.setupWithViewPager(vp);

        // 탭 추가
        Bundle bundle= getArguments();
        user = (UserJson) bundle.getSerializable("user");
        Log.d("Test","fragment community: "+user.toString());

        /* 유저 값 전달 */
        CommunitybookFragment cbFragment = new CommunitybookFragment(navigator);
        Bundle bundle1 = new Bundle();
        bundle1.putSerializable("user", user);
        cbFragment.setArguments(bundle);
        adapter.addFragment(cbFragment, "모두의 도감");
        vp.setAdapter(adapter);

        MybookFragment mbFragment = new MybookFragment(navigator);
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("user", user);
        mbFragment.setArguments(bundle);
        adapter.addFragment(mbFragment, "나만의 도감");
        vp.setAdapter(adapter);

        getActivity().setTitle("Community");

        return v;
    }
}