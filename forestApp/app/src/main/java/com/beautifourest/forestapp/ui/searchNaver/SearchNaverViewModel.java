package com.beautifourest.forestapp.ui.searchNaver;

import android.app.ProgressDialog;
import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.PlantJson;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.SearchResult;
import com.beautifourest.forestapp.baseViewModel;
import com.beautifourest.forestapp.ui.book.BookViewModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 도감 상세정보 viewmodel */
public class SearchNaverViewModel extends baseViewModel {
    private RequestForServer requestForServer = new RequestForServer();

    public final ObservableField<String> queryMsg=new ObservableField<>();
    public final ObservableField<String> query=new ObservableField<>();
    public final ObservableField<String> content=new ObservableField<>();
    public final ObservableField<String> link=new ObservableField<>();

    Context context;
    ProgressDialog progressDialog;

    public SearchNaverViewModel() { }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate() {
        progressDialog= new ProgressDialog(context);
        progressDialog.setMessage("검색중");
        progressDialog.setCancelable(true);
        progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Horizontal);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    public void search(){
        progressDialog.show();

        /* 실행할 명령어와 서버로 보낼 객체 설정 */
        requestForServer.setOp("getSearchResult");
        requestForServer.setQuery(this.queryMsg.get());
        Log.d("Test",requestForServer.getQuery());

        /* 서버랑 통신 시작 */
        requestForServer.exec(new RetroCallback() {
            @Override
            public void onError(Throwable t) { t.printStackTrace(); }

            @Override
            public void onSuccess(int code, Object receivedData) {
                progressDialog.dismiss();
                SearchResult result =(SearchResult)receivedData;
                List<String> r = result.getResult();
                if(r.size()==0){
                    query.set(queryMsg.get());
                    content.set("검색 결과 없음");
                }
                else{
                    String q = Html.fromHtml(r.get(0)).toString();

                    query.set(q);
                    content.set(r.get(2));
                    link.set(r.get(1));
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

}