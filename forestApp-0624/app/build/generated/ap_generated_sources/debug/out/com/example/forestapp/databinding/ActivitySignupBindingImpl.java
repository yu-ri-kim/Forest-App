package com.example.forestapp.databinding;
import com.example.forestapp.R;
import com.example.forestapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySignupBindingImpl extends ActivitySignupBinding implements com.example.forestapp.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView1, 7);
        sViewsWithIds.put(R.id.signupId, 8);
        sViewsWithIds.put(R.id.signupPwd, 9);
        sViewsWithIds.put(R.id.signupName, 10);
        sViewsWithIds.put(R.id.signupSex, 11);
        sViewsWithIds.put(R.id.signupAge, 12);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.EditText mboundView1;
    @NonNull
    private final android.widget.EditText mboundView2;
    @NonNull
    private final android.widget.EditText mboundView3;
    @NonNull
    private final android.widget.EditText mboundView4;
    @NonNull
    private final android.widget.Button mboundView6;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener editTextandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.age.get()
            //         is model.age.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(editText);
            // localize variables for thread safety
            // model
            com.example.forestapp.SignupViewModel model = mModel;
            // model.age
            androidx.databinding.ObservableField<java.lang.String> modelAge = null;
            // model.age.get()
            java.lang.String modelAgeGet = null;
            // model != null
            boolean modelJavaLangObjectNull = false;
            // model.age != null
            boolean modelAgeJavaLangObjectNull = false;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {


                modelAge = model.age;

                modelAgeJavaLangObjectNull = (modelAge) != (null);
                if (modelAgeJavaLangObjectNull) {




                    modelAge.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.uid.get()
            //         is model.uid.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView1);
            // localize variables for thread safety
            // model
            com.example.forestapp.SignupViewModel model = mModel;
            // model != null
            boolean modelJavaLangObjectNull = false;
            // model.uid != null
            boolean modelUidJavaLangObjectNull = false;
            // model.uid
            androidx.databinding.ObservableField<java.lang.String> modelUid = null;
            // model.uid.get()
            java.lang.String modelUidGet = null;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {


                modelUid = model.uid;

                modelUidJavaLangObjectNull = (modelUid) != (null);
                if (modelUidJavaLangObjectNull) {




                    modelUid.set(((java.lang.String) (callbackArg_0)));
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
            com.example.forestapp.SignupViewModel model = mModel;
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
    private androidx.databinding.InverseBindingListener mboundView3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.name.get()
            //         is model.name.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView3);
            // localize variables for thread safety
            // model
            com.example.forestapp.SignupViewModel model = mModel;
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
    private androidx.databinding.InverseBindingListener mboundView4androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.gender.get()
            //         is model.gender.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView4);
            // localize variables for thread safety
            // model
            com.example.forestapp.SignupViewModel model = mModel;
            // model != null
            boolean modelJavaLangObjectNull = false;
            // model.gender != null
            boolean modelGenderJavaLangObjectNull = false;
            // model.gender.get()
            java.lang.String modelGenderGet = null;
            // model.gender
            androidx.databinding.ObservableField<java.lang.String> modelGender = null;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {


                modelGender = model.gender;

                modelGenderJavaLangObjectNull = (modelGender) != (null);
                if (modelGenderJavaLangObjectNull) {




                    modelGender.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivitySignupBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivitySignupBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6
            , (android.widget.EditText) bindings[5]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[11]
            );
        this.editText.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.EditText) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.EditText) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.EditText) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.EditText) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView6 = (android.widget.Button) bindings[6];
        this.mboundView6.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.forestapp.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80L;
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
            setModel((com.example.forestapp.SignupViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.example.forestapp.SignupViewModel Model) {
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModelName((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeModelPwd((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeModelGender((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeModelIsValid((androidx.databinding.ObservableBoolean) object, fieldId);
            case 4 :
                return onChangeModelUid((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeModelAge((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModelName(androidx.databinding.ObservableField<java.lang.String> ModelName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelPwd(androidx.databinding.ObservableField<java.lang.String> ModelPwd, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelGender(androidx.databinding.ObservableField<java.lang.String> ModelGender, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelIsValid(androidx.databinding.ObservableBoolean ModelIsValid, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelUid(androidx.databinding.ObservableField<java.lang.String> ModelUid, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelAge(androidx.databinding.ObservableField<java.lang.String> ModelAge, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
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
        com.example.forestapp.SignupViewModel model = mModel;
        androidx.databinding.ObservableField<java.lang.String> modelName = null;
        androidx.databinding.ObservableField<java.lang.String> modelPwd = null;
        java.lang.String modelAgeGet = null;
        java.lang.String modelUidGet = null;
        java.lang.String modelPwdGet = null;
        androidx.databinding.ObservableField<java.lang.String> modelGender = null;
        androidx.databinding.ObservableBoolean modelIsValid = null;
        androidx.databinding.ObservableField<java.lang.String> modelUid = null;
        boolean modelIsValidGet = false;
        androidx.databinding.ObservableField<java.lang.String> modelAge = null;
        java.lang.String modelGenderGet = null;
        java.lang.String modelNameGet = null;

        if ((dirtyFlags & 0xffL) != 0) {


            if ((dirtyFlags & 0xc1L) != 0) {

                    if (model != null) {
                        // read model.name
                        modelName = model.name;
                    }
                    updateRegistration(0, modelName);


                    if (modelName != null) {
                        // read model.name.get()
                        modelNameGet = modelName.get();
                    }
            }
            if ((dirtyFlags & 0xc2L) != 0) {

                    if (model != null) {
                        // read model.pwd
                        modelPwd = model.pwd;
                    }
                    updateRegistration(1, modelPwd);


                    if (modelPwd != null) {
                        // read model.pwd.get()
                        modelPwdGet = modelPwd.get();
                    }
            }
            if ((dirtyFlags & 0xc4L) != 0) {

                    if (model != null) {
                        // read model.gender
                        modelGender = model.gender;
                    }
                    updateRegistration(2, modelGender);


                    if (modelGender != null) {
                        // read model.gender.get()
                        modelGenderGet = modelGender.get();
                    }
            }
            if ((dirtyFlags & 0xc8L) != 0) {

                    if (model != null) {
                        // read model.isValid
                        modelIsValid = model.isValid;
                    }
                    updateRegistration(3, modelIsValid);


                    if (modelIsValid != null) {
                        // read model.isValid.get()
                        modelIsValidGet = modelIsValid.get();
                    }
            }
            if ((dirtyFlags & 0xd0L) != 0) {

                    if (model != null) {
                        // read model.uid
                        modelUid = model.uid;
                    }
                    updateRegistration(4, modelUid);


                    if (modelUid != null) {
                        // read model.uid.get()
                        modelUidGet = modelUid.get();
                    }
            }
            if ((dirtyFlags & 0xe0L) != 0) {

                    if (model != null) {
                        // read model.age
                        modelAge = model.age;
                    }
                    updateRegistration(5, modelAge);


                    if (modelAge != null) {
                        // read model.age.get()
                        modelAgeGet = modelAge.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xe0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editText, modelAgeGet);
        }
        if ((dirtyFlags & 0x80L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editText, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView4, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView4androidTextAttrChanged);
            this.mboundView6.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0xd0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, modelUidGet);
        }
        if ((dirtyFlags & 0xc2L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, modelPwdGet);
        }
        if ((dirtyFlags & 0xc1L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, modelNameGet);
        }
        if ((dirtyFlags & 0xc4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, modelGenderGet);
        }
        if ((dirtyFlags & 0xc8L) != 0) {
            // api target 1

            this.mboundView6.setEnabled(modelIsValidGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // model
        com.example.forestapp.SignupViewModel model = mModel;
        // model != null
        boolean modelJavaLangObjectNull = false;



        modelJavaLangObjectNull = (model) != (null);
        if (modelJavaLangObjectNull) {


            model.signup();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model.name
        flag 1 (0x2L): model.pwd
        flag 2 (0x3L): model.gender
        flag 3 (0x4L): model.isValid
        flag 4 (0x5L): model.uid
        flag 5 (0x6L): model.age
        flag 6 (0x7L): model
        flag 7 (0x8L): null
    flag mapping end*/
    //end
}