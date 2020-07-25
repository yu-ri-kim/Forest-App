package com.beautifourest.forestapp.ui.mybookInfo;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.Model.Comment;
import com.beautifourest.forestapp.Model.Comments;
import com.beautifourest.forestapp.Model.MyplantsJsons;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.MyplantsJson;
import com.beautifourest.forestapp.Model.PostJsons;
import com.beautifourest.forestapp.Model.RequestForServer;
import com.beautifourest.forestapp.Model.RetroCallback;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.baseViewModel;

import java.util.List;

public class MybookInfoViewModel extends baseViewModel {
    private RequestForServer requestForServer = new RequestForServer(); // 서버 통신 객체
    private CallAnotherActivityNavigator navigator;
    MyplantsJson myplant;
    UserJson user;

    public final ObservableArrayList<CommentViewModel> comments = new ObservableArrayList<>();

    public MybookInfoViewModel() {
    }

    Activity activity;

    public final ObservableField<String> date=new ObservableField<>();
    public final ObservableField<Integer> bid=new ObservableField<>();
    public final ObservableField<String> img=new ObservableField<>();
    public final ObservableField<String> name=new ObservableField<>();
    public final ObservableField<String> ename=new ObservableField<>();
    public final ObservableField<String> lifetime=new ObservableField<>();
    public final ObservableField<String> gbn=new ObservableField<>();
    public final ObservableField<String> classname=new ObservableField<>();
    public final ObservableField<String> isHerb=new ObservableField<>();


    // 댓글
    public final ObservableField<String> detail = new ObservableField<>();

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public MybookInfoViewModel(MyplantsJson myplant, CallAnotherActivityNavigator navigator, UserJson user){
        this.myplant=myplant;
        this.navigator=navigator;
        this.user = user;

        Log.d("Test", "************mybookinfoviewmodel "+user.toString());

        this.date.set(myplant.getUid() + " | " + myplant.getWriteD());
        this.bid.set(myplant.getBid());
        this.name.set(myplant.getFskName());
        this.img.set(myplant.getFsImg1());

        if(myplant.getFseName().equals("null")){
            this.ename.set("");
        }
        else{
            this.ename.set(myplant.getFseName());
        }

        if(myplant.getFsLifeTime().equals("null")){
            this.lifetime.set("");
        }
        else{
            this.lifetime.set(myplant.getFsLifeTime());
        }

        if(myplant.getFsGbn().equals("null")){
            this.gbn.set("");
        }
        else{
            this.gbn.set(myplant.getFsGbn());
        }

        if(myplant.getFsClassname().equals("null")){
            this.classname.set("");
        }
        else{
            this.classname.set(myplant.getFsClassname());
        }

        if(myplant.getIsHerb()==0){
            this.isHerb.set("일반 식물");
        }
        else{
            this.isHerb.set("약용 식물");
        }
        getAllComment();
    }
    @Override
    public void onCreate() {

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

    @BindingAdapter("app:imageURL")
    public static void loadImage(ImageView imageView, String imageURL){
        Glide.with(imageView.getContext()).load(imageURL).apply(new RequestOptions().circleCrop()).into(imageView);
    }

    public void delete(){
        MyplantsJson pj = new MyplantsJson();
        pj.setBid(myplant.getBid());
        pj.setUid(myplant.getUid());

        requestForServer.setOb((Object)pj);
        requestForServer.setOp("deleteTempPlants"); // 실행할 명령 지정

        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                PostJsons data = (PostJsons)receivedData;
                if(data.getStatus().equals("OK")){
                    navigator.forToast("삭제 성공");
                }
                else{
                    navigator.forToast("삭제 실패");
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });
    }

    public void update(){
        Log.d("Test","next plant update diaglog");
        UserJson u = new UserJson();
        u.setUid(myplant.getUid());
        navigator.callFramgemntForUpdate(0, myplant, u);
    }

    public void nextDialog() {

    }

    public void writeComment(){
        Log.d("Test","write comment");
        Log.d("Test",detail.get());

        Comment c = new Comment();
        c.setUid(myplant.getUid()); // 글 작성자
        c.setBid(myplant.getBid()); // 글 번호
        c.setDetail(detail.get()); // 댓글 내용
        c.setCmuid(user.getUid()); // 댓글 작성자 - 현재 유

        requestForServer.setOb((Object)c);
        requestForServer.setOp("writeComment"); // 실행할 명령 지정

        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                PostJsons data = (PostJsons)receivedData;
                if(data.getStatus().equals("OK")){
                    navigator.forToast("댓글이 등록되었습니다");

                }
                else{
                    navigator.forToast("댓글 동륵에 실패했습니다");
                }
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });

    }

    public void getAllComment(){
        Log.d("Test","get comment");

        MyplantsJson mp = new MyplantsJson();
        mp.setBid(myplant.getBid());
        mp.setUid(myplant.getUid());

        requestForServer.setOb((Object)mp);
        requestForServer.setOp("getAllComment"); // 실행할 명령 지정

        requestForServer.exec(new RetroCallback() { // 통신 시작
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                Comments c = (Comments)receivedData;
                List<Comment> data = c.getData();
                Log.d("Test",data.toString());

                comments.clear();
                for(Comment d: data){
                    comments.add(new CommentViewModel(d.getCmuid(),d.getDetail(),d.getWriteD()));
                }
                Log.d("Test", comments.size()+"");
            }

            @Override
            public void onFailure(int code) {
                Log.d("Test","Failure");
            }
        });

    }
}
