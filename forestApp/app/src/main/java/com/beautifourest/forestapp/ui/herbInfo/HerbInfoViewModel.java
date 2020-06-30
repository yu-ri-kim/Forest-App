package com.beautifourest.forestapp.ui.herbInfo;

import androidx.databinding.ObservableField;

import com.beautifourest.forestapp.CallAnotherActivityNavigator;
import com.beautifourest.forestapp.Model.HerbJson;
import com.beautifourest.forestapp.baseViewModel;

import java.util.ArrayList;
import java.util.List;

public class HerbInfoViewModel extends baseViewModel {
    private CallAnotherActivityNavigator navigator;
    HerbJson herb;
    public final  ObservableField<String> img=new ObservableField<>();
    public final ObservableField<String> name=new ObservableField<>();
    public final ObservableField<String> country=new ObservableField<>();
    public List<String> old_country=new ArrayList<>();
    public final ObservableField<String> herbInt=new ObservableField<>();
    public final ObservableField<String> herbExt=new ObservableField<>();
    public final ObservableField<String> herbmng=new ObservableField<>();
    public final ObservableField<String> herbcaution=new ObservableField<>();

    public HerbInfoViewModel(HerbJson herb, CallAnotherActivityNavigator navigator){
        this.navigator=navigator;
        this.herb=herb;
        this.img.set(herb.getFsImg1());
        this.name.set(herb.getHrbName());
        old_country = herb.getCountry();
        this.herbInt.set(herb.getInternal());
        this.herbExt.set(herb.getExternal());
        this.herbmng.set(herb.getMng());
        this.herbcaution.set(herb.getCaution());

        /* 한국은 무조건 자라는 나라에 포함됨 */
        String tmp = "한국, ";
        for(int i=0;i< old_country.size(); i++){
            tmp += old_country.get(i);
            if(i!= old_country.size()-1){
                tmp+=", ";
            }
        }
        if(old_country.size()==0) tmp = "한국";

        this.country.set(tmp);
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
}