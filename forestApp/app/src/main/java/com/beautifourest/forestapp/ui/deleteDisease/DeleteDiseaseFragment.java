package com.beautifourest.forestapp.ui.deleteDisease;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.FragmentDeletediseaseBinding;

public class DeleteDiseaseFragment extends Fragment {
    DeleteDiseaseViewModel model;
    ListView listView;

    static DeleteDiseaseAdapter adapter=new DeleteDiseaseAdapter();
    private CallAnotherActivityNavigator navigator;

    public DeleteDiseaseFragment(){

    }

    public DeleteDiseaseFragment(CallAnotherActivityNavigator navigator){
        this.navigator=navigator;
    }

    public static DeleteDiseaseFragment instance(){return new DeleteDiseaseFragment();}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("관심있는 질병삭제");
        Object o = DataBindingUtil.inflate(inflater, R.layout.fragment_deletedisease, container, false).getRoot();

        Bundle bundle= getArguments();
        UserJson user = (UserJson) bundle.getSerializable("user");
        model=new DeleteDiseaseViewModel(user,listView,adapter,navigator);

        return (View) o;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentDeletediseaseBinding binding=DataBindingUtil.getBinding(getView());
        listView=(ListView)getView().findViewById(R.id.listView);
        model.setListView(listView);
        model.setAdapter(adapter);
        model.setNavigator(navigator);
        binding.setModel(model);
        model.onCreate();
    }

    @BindingAdapter("app:items")
    public static void setDisease(ListView listView, ObservableArrayList<DiseaseViewModel> disease){
        if(listView.getAdapter()==null){
            listView.setAdapter(adapter);
        }
        else{
            adapter=(DeleteDiseaseAdapter) listView.getAdapter();
        }
        adapter.addAll(disease);
    }
}

