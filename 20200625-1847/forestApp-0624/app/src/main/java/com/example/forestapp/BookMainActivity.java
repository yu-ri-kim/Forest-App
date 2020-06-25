package com.example.forestapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.forestapp.Model.UserJson;
import com.example.forestapp.ui.book.BookFragment;
import com.example.forestapp.ui.bookSearch.BookSearchFragment;
import com.example.forestapp.ui.hurbSearch.HurbSearchFragment;
import com.example.forestapp.ui.insertDisease.InsertDialogFragment;
import com.example.forestapp.ui.mybook.MybookFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.List;

public class BookMainActivity extends AppCompatActivity implements CallAnotherActivityNavigator{
    BottomNavigationView bottomNavigationView;
    BookFragment bkFragment;
    BookSearchFragment bksFragment;
    HurbSearchFragment hbsFragment;
    MybookFragment mbFragment;

    //작은 메뉴들



    UserJson u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        //intent
        Intent intent = getIntent();
        u = (UserJson)intent.getExtras().getSerializable("user");
        Log.d("Test",u.toString());

        //프래그먼트 생성
        bkFragment = new BookFragment();
        bksFragment = new BookSearchFragment();
        hbsFragment = new HurbSearchFragment(this);
        mbFragment = new MybookFragment();

        //제일 처음 띄워줄 뷰를 세팅해줍니다. commit();까지 해줘야 합니다.
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,bkFragment).commitAllowingStateLoss();

        //bottomnavigationview의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너를 추가합니다.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){ //menu_bottom.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생시킵니다.
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

                        //번들객체 생성, text값 저장
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("user", u);
                        hbsFragment.setArguments(bundle);
                        return true;
                    }
                    case R.id.navigation_mybook:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,mbFragment).commitAllowingStateLoss();
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public void callActivity(UserJson user) {

    }

    @Override
    public void callFragment(UserJson user, int num, List<String> diseaseList) {
        Log.d("Test","call book main activity");
        Log.d("Test",user.toString());
        Log.d("Test",num+"");

        if(num==0){
            InsertDialogFragment idf = InsertDialogFragment.instance();
            idf.setDiseaseList(diseaseList); // 질병 이름 리스트 set
            idf.show(getSupportFragmentManager(), InsertDialogFragment.TAG_EVENT_DIALOG);
        }
    }
}