package com.example.forestapp.databinding;
import com.example.forestapp.R;
import com.example.forestapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding implements com.example.forestapp.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView1, 4);
        sViewsWithIds.put(R.id.loginimg, 5);
        sViewsWithIds.put(R.id.pwdimg, 6);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.EditText mboundView2;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener idinputandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.name.get()
            //         is model.name.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(idinput);
            // localize variables for thread safety
            // model
            com.example.forestapp.LoginViewModel model = mModel;
            // model.name
            androidx.databinding.ObservableField<java.lang.String> modelName = null;
            // model != null
            boolean modelJavaLangObjectNull = false;
            // model.name != null
            boolean modelNameJavaLangObjectNull = false;
            // model.name.get()
            java.lang.String modelNameGet = null;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {


                modelName = model.name;

                modelNameJavaLangObjectNull = (modelName) != (null);
                if (modelNameJavaLangObjectNull) {




                    modelName.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.pwd.get()
            //         is model.pwd.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // model
            com.example.forestapp.LoginViewModel model = mModel;
            // model.pwd != null
            boolean modelPwdJavaLangObjectNull = false;
            // model.pwd
            androidx.databinding.ObservableField<java.lang.String> modelPwd = null;
            // model != null
            boolean modelJavaLangObjectNull = false;
            // model.pwd.get()
            java.lang.String modelPwdGet = null;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {


                modelPwd = model.pwd;

                modelPwdJavaLangObjectNull = (modelPwd) != (null);
                if (modelPwdJavaLangObjectNull) {




                    modelPwd.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.EditText) bindings[1]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.Button) bindings[3]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[6]
            );
        this.idinput.setTag(null);
        this.loginbtn.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.EditText) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.example.forestapp.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.model == variableId) {
            setModel((com.example.forestapp.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.example.forestapp.LoginViewModel Model) {
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModelIsValid((androidx.databinding.ObservableBoolean) object, fieldId);
            case 1 :
                return onChangeModelName((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeModelPwd((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModelIsValid(androidx.databinding.ObservableBoolean ModelIsValid, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelName(androidx.databinding.ObservableField<java.lang.String> ModelName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelPwd(androidx.databinding.ObservableField<java.lang.String> ModelPwd, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.forestapp.LoginViewModel model = mModel;
        androidx.databinding.ObservableBoolean modelIsValid = null;
        boolean modelIsValidGet = false;
        androidx.databinding.ObservableField<java.lang.String> modelName = null;
        androidx.databinding.ObservableField<java.lang.String> modelPwd = null;
        java.lang.String modelPwdGet = null;
        java.lang.String modelNameGet = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (model != null) {
                        // read model.isValid
                        modelIsValid = model.isValid;
                    }
                    updateRegistration(0, modelIsValid);


                    if (modelIsValid != null) {
                        // read model.isValid.get()
                        modelIsValidGet = modelIsValid.get();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (model != null) {
                        // read model.name
                        modelName = model.name;
                    }
                    updateRegistration(1, modelName);


                    if (modelName != null) {
                        // read model.name.get()
                        modelNameGet = modelName.get();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (model != null) {
                        // read model.pwd
                        modelPwd = model.pwd;
                    }
                    updateRegistration(2, modelPwd);


                    if (modelPwd != null) {
                        // read model.pwd.get()
                        modelPwdGet = modelPwd.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.idinput, modelNameGet);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.idinput, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, idinputandroidTextAttrChanged);
            this.loginbtn.setOnClickListener(mCallback2);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            this.loginbtn.setEnabled(modelIsValidGet);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, modelPwdGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // model
        com.example.forestapp.LoginViewModel model = mModel;
        // model != null
        boolean modelJavaLangObjectNull = false;



        modelJavaLangObjectNull = (model) != (null);
        if (modelJavaLangObjectNull) {


            model.login();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model.isValid
        flag 1 (0x2L): model.name
        flag 2 (0x3L): model.pwd
        flag 3 (0x4L): model
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}