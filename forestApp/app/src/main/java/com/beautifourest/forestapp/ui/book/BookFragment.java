package com.beautifourest.forestapp.ui.book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.R;
import com.beautifourest.forestapp.databinding.FragmentBookBinding;

/* 전체도감 프래그먼트 */
public class BookFragment extends Fragment {
    BooksViewModel model;
    GridView gridView;
    static BookAdapter adapter=new BookAdapter();
    private CallAnotherActivityNavigator navigator;

    public BookFragment(){ }

    public BookFragment(CallAnotherActivityNavigator navigator){ this.navigator=navigator; }

    public static BookFragment instance(){ return new BookFragment(); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        getActivity().setTitle("도감보기");
        return DataBindingUtil.inflate(inflater, R.layout.fragment_book, container, false).getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        /* gridview의 클릭 이벤트를 위해서 viewmodel에 gridview 값 넣어줌 */
        gridView=(GridView) getView().findViewById(R.id.gridView);
        model=new BooksViewModel(gridView,adapter,navigator);

        FragmentBookBinding binding=DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }



    @BindingAdapter("app:items")
    public static void setUserList(GridView gridView, ObservableArrayList<BookViewModel> plants){
        if(gridView.getAdapter()==null){
            gridView.setAdapter(adapter);
        }
        else{
            adapter=(BookAdapter) gridView.getAdapter();
        }
        adapter.add(plants);
    }
}