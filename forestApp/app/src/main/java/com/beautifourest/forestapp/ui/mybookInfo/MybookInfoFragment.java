package com.beautifourest.forestapp.ui.mybookInfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.MyplantsJson;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.FragmentMybookinfoBinding;

public class MybookInfoFragment extends Fragment {
    MybookInfoViewModel model;
    private CallAnotherActivityNavigator navigator;

    Activity activity;
    public MybookInfoFragment(){

    }
    public static MybookInfoFragment instance(){return new MybookInfoFragment();}
    public MybookInfoFragment(CallAnotherActivityNavigator navigator){this.navigator=navigator;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Object o = DataBindingUtil.inflate(inflater, R.layout.fragment_mybookinfo, container, false).getRoot();

        Bundle bundle= getArguments();
        MyplantsJson myplant = (MyplantsJson) bundle.getSerializable("plant");
        UserJson user = (UserJson) bundle.getSerializable("user");

        model = new MybookInfoViewModel(myplant, navigator, user);
        activity = getActivity();

        getActivity().setTitle("상세보기");

        if(user.getUid().equals(myplant.getUid())) setHasOptionsMenu(true);
        else{
            setHasOptionsMenu(false);
        }
        return (View) o;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentMybookinfoBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.setActivity(activity);
        model.onCreate();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_sample, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_update :
                Toast.makeText(getActivity(), "update 준비중 ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete :
                model.delete();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
