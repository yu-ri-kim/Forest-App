package com.beautifourest.forestapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.beautifourest.forestapp.Model.ActivityResultEvent;
import com.beautifourest.forestapp.Model.DiseaseJson;
import com.beautifourest.forestapp.Model.EventBus;
import com.beautifourest.forestapp.Model.HerbJson;
import com.beautifourest.forestapp.Model.MyplantsJson;
import com.beautifourest.forestapp.Model.PlantJson;
import com.beautifourest.forestapp.Model.UserJson;
import com.beautifourest.forestapp.ui.book.BookFragment;
import com.beautifourest.forestapp.ui.bookInfo.BookInfoFragment;
import com.beautifourest.forestapp.ui.bookSearch.BookSearchFragment;
import com.beautifourest.forestapp.ui.herbInfo.HerbInfoFragment;
import com.beautifourest.forestapp.ui.herbRecommend.HerbRcFragment;
import com.beautifourest.forestapp.ui.hurbSearch.HurbSearchFragment;
import com.beautifourest.forestapp.ui.insertDisease.InsertDialogFragment;
import com.beautifourest.forestapp.ui.insertPlants.InsertPlantsDialogFragment;
import com.beautifourest.forestapp.ui.mushroom.MushroomFragment;
import com.beautifourest.forestapp.ui.mybook.MybookFragment;
import com.beautifourest.forestapp.ui.mybookInfo.MybookInfoFragment;
import com.beautifourest.forestapp.ui.updatePlants.UpdatePlantsDialogFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

/* 메인 엑티비티 */
public class BookMainActivity extends AppCompatActivity implements CallAnotherActivityNavigator{
    BottomNavigationView bottomNavigationView;

    /* 도감, 나만의 도감, 검색, 여러 기능들 */
    BookFragment bkFragment;
    MybookFragment mbFragment;
    BookSearchFragment bksFragment;
    HurbSearchFragment hbsFragment;

    /* 허브추천, 버섯감별, 자세한 설명 페이지 */
    HerbRcFragment hrcFragment;
    MushroomFragment mrFragment;
    BookInfoFragment biFragment;
    HerbInfoFragment hiFragment;
    MybookInfoFragment mbiFragment;

    /* 유저 객체 */
    UserJson u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        /* 전달 받은 user 객체 값 얻어옴 */
        Intent intent = getIntent();
        u = (UserJson)intent.getExtras().getSerializable("user");
        Log.d("Test",u.toString());

        /* 프래그먼트 생성 */
        bkFragment = new BookFragment(this);
        bksFragment = new BookSearchFragment(this);
        hbsFragment = new HurbSearchFragment(this);
        mbFragment = new MybookFragment(this);
        hrcFragment = new HerbRcFragment(this);
        mrFragment = new MushroomFragment();
        biFragment = new BookInfoFragment();
        hiFragment=new HerbInfoFragment();
        mbiFragment=new MybookInfoFragment(this);

        /* 제일 처음 띄워줄 뷰를 세팅. commit();까지 해줘야함 */
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,bkFragment).commitAllowingStateLoss();

        /* bottomnavigationview의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너를 추가 */
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                /* menu_bottom.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생 */
                switch (menuItem.getItemId()){
                    case R.id.navigation_book:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,bkFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.navigation_booksearch:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,bksFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.navigation_hurbsearch:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,hbsFragment).commit();

                        /* 유저 값 전달 */
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", u);
                        hbsFragment.setArguments(bundle);
                        return true;
                    }
                    case R.id.navigation_mybook:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,mbFragment,"myFragmentTag").commit();

                        /* 유저 값 전달 */
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", u);
                        mbFragment.setArguments(bundle);
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public void callActivity(UserJson user) { }

    /* 프래그먼트 바꾸기 */
    @Override
    public void callFragment(UserJson user, int num, List<DiseaseJson> diseaseList) {
        /* num
           0 : 관심있는 질병정보 추가하기
           1 : 허브 추천 페이지
           2 : 버섯 ? 독버섯 ?!
           3 : 나만의 도감 추가하기
ㄱ         */

        if(num==0){
            InsertDialogFragment idf = InsertDialogFragment.instance();
            idf.setDiseaseList(diseaseList);
            idf.setUser(u);

            if(!idf.isAdded()) {
                idf.show(getSupportFragmentManager(), InsertDialogFragment.TAG_EVENT_DIALOG);
            }
        }
        else if(num==1){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_layout,hrcFragment).addToBackStack(null);
            transaction.commit();

            /* 유저 값 전달 */
            Bundle bundle = new Bundle();
            bundle.putSerializable("user", u);
            hrcFragment.setArguments(bundle);
        }
        else if(num==2){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_layout,mrFragment).addToBackStack(null);
            transaction.commit();

            /* 유저 값 전달 */
            Bundle bundle = new Bundle();
            bundle.putSerializable("user", u);
            mrFragment.setArguments(bundle);
        }
        else if(num==3){
            InsertPlantsDialogFragment idf = InsertPlantsDialogFragment.instance();
            idf.setUser(u);

            if(!idf.isAdded()) {
                idf.show(getSupportFragmentManager(), InsertDialogFragment.TAG_EVENT_DIALOG);
            }
        }
    }

    /* 상세 내용 보여주기 */
    @Override
    public void callFragmentForInfo(int num, PlantJson info, MyplantsJson info2) {
        /* 검색에서 상세정보창 보여주기 */
        if(num==0){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_layout,biFragment).addToBackStack(null);
            transaction.commit();

            /* 식물 정보 값 전달 */
            Bundle bundle = new Bundle();
            bundle.putSerializable("plant", info);
            biFragment.setArguments(bundle);
        }

        else if(num==1){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_layout,mbiFragment).addToBackStack(null);
            transaction.commit();

            /* 식물 정보 값 전달 */
            Bundle bundle = new Bundle();
            bundle.putSerializable("plant", info2);
            mbiFragment.setArguments(bundle);
        }
    }

    @Override
    public void callFragmentForInfo(int num, HerbJson herb_info) {
        if(num==0){
            Log.d("Test","Check herb fragment");
            Log.d("Test","herb info: "+herb_info.toString());
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_layout,hiFragment).addToBackStack(null);
            transaction.commit();

            /* 식물 정보 값 전달 */
            Bundle bundle = new Bundle();
            bundle.putSerializable("herb", herb_info);

            hiFragment.setArguments(bundle);
        }
    }

    @Override
    public void callFramgemntForUpdate(int num, MyplantsJson info, UserJson user) {
        UpdatePlantsDialogFragment upd = UpdatePlantsDialogFragment.instance();
        upd.setUser(u);
        upd.setMyplants(info);

        if(!upd.isAdded()) {
            upd.show(getSupportFragmentManager(), InsertDialogFragment.TAG_EVENT_DIALOG);
        }
    }

    @Override
    public void closeFragment() {

    }

    @Override
    public void forToast(String msg) {
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshFragment(int num) {
        if(num==0){
            Fragment frg = null;
            frg = getSupportFragmentManager().findFragmentByTag("myFragmentTag");
            final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.detach(frg);
            ft.attach(frg);
            ft.commit();
        }
    }

    /* onActivityResult로 받은 이전 activity의 결과를 eventbus로 전달한다 */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EventBus.getInstance().post(ActivityResultEvent.create(requestCode, resultCode, data));
    }
}