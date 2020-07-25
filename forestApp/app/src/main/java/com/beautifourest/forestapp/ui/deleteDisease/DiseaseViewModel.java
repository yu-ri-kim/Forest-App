package com.beautifourest.forestapp.ui.deleteDisease;

import androidx.databinding.ObservableField;

public class DiseaseViewModel {
    public final ObservableField<String> uid=new ObservableField<>();
    public final ObservableField<String> dname=new ObservableField<>();

    public DiseaseViewModel(String uid,String dname){
        this.uid.set(uid);
        this.dname.set(dname);
    }

    @Override
    public String toString(){
        return "DiseaseViewModel{"+
                "dname= "+dname.get()+
                "}";
    }
}
