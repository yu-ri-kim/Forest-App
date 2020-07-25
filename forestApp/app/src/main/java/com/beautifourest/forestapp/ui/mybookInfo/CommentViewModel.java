package com.beautifourest.forestapp.ui.mybookInfo;

import androidx.databinding.ObservableField;

public class CommentViewModel {
    public final ObservableField<String> cmuid = new ObservableField<>();
    public final ObservableField<String> detail = new ObservableField<>();
    public final ObservableField<String> writeD = new ObservableField<>();

    public CommentViewModel(String cmuid, String detail, String writeD) {
        this.cmuid.set(cmuid);
        this.detail.set(detail);
        this.writeD.set(writeD);
    }
}
