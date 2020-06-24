package com.example.forestapp.databinding;
import com.example.forestapp.R;
import com.example.forestapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentBooksearchBindingImpl extends FragmentBooksearchBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.ListView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener searchTabandroidSelectedItemPositionAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.selectedItemPosition.get()
            //         is model.selectedItemPosition.set((java.lang.Integer) callbackArg_0)
            int callbackArg_0 = searchTab.getSelectedItemPosition();
            // localize variables for thread safety
            // model
            com.example.forestapp.ui.bookSearch.BookSearchViewModel model = mModel;
            // model != null
            boolean modelJavaLangObjectNull = false;
            // model.selectedItemPosition != null
            boolean modelSelectedItemPositionJavaLangObjectNull = false;
            // model.selectedItemPosition
            androidx.databinding.ObservableField<java.lang.Integer> modelSelectedItemPosition = null;
            // model.selectedItemPosition.get()
            java.lang.Integer modelSelectedItemPositionGet = null;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {


                modelSelectedItemPosition = model.selectedItemPosition;

                modelSelectedItemPositionJavaLangObjectNull = (modelSelectedItemPosition) != (null);
                if (modelSelectedItemPositionJavaLangObjectNull) {




                    modelSelectedItemPosition.set(((java.lang.Integer) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener searchViewandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of model.search.get()
            //         is model.search.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(searchView);
            // localize variables for thread safety
            // model
            com.example.forestapp.ui.bookSearch.BookSearchViewModel model = mModel;
            // model.search
            androidx.databinding.ObservableField<java.lang.String> modelSearch = null;
            // model != null
            boolean modelJavaLangObjectNull = false;
            // model.search != null
            boolean modelSearchJavaLangObjectNull = false;
            // model.search.get()
            java.lang.String modelSearchGet = null;



            modelJavaLangObjectNull = (model) != (null);
            if (modelJavaLangObjectNull) {


                modelSearch = model.search;

                modelSearchJavaLangObjectNull = (modelSearch) != (null);
                if (modelSearchJavaLangObjectNull) {




                    modelSearch.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentBooksearchBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private FragmentBooksearchBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.Spinner) bindings[2]
            , (android.widget.EditText) bindings[1]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.ListView) bindings[3];
        this.mboundView3.setTag(null);
        this.searchTab.setTag(null);
        this.searchView.setTag(null);
        setRootTag(root);
        // listeners
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
            setModel((com.example.forestapp.ui.bookSearch.BookSearchViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.example.forestapp.ui.bookSearch.BookSearchViewModel Model) {
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
                return onChangeModelSelectedItemPosition((androidx.databinding.ObservableField<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeModelSearch((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeModelPlants((androidx.databinding.ObservableArrayList<com.example.forestapp.ui.bookSearch.BkViewModel>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModelSelectedItemPosition(androidx.databinding.ObservableField<java.lang.Integer> ModelSelectedItemPosition, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelSearch(androidx.databinding.ObservableField<java.lang.String> ModelSearch, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelPlants(androidx.databinding.ObservableArrayList<com.example.forestapp.ui.bookSearch.BkViewModel> ModelPlants, int fieldId) {
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
        com.example.forestapp.ui.bookSearch.BookSearchViewModel model = mModel;
        androidx.databinding.ObservableField<java.lang.Integer> modelSelectedItemPosition = null;
        java.lang.String modelSearchGet = null;
        androidx.databinding.ObservableField<java.lang.String> modelSearch = null;
        androidx.databinding.ObservableArrayList<com.example.forestapp.ui.bookSearch.BkViewModel> modelPlants = null;
        int androidxDatabindingViewDataBindingSafeUnboxModelSelectedItemPositionGet = 0;
        java.lang.Integer modelSelectedItemPositionGet = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (model != null) {
                        // read model.selectedItemPosition
                        modelSelectedItemPosition = model.selectedItemPosition;
                    }
                    updateRegistration(0, modelSelectedItemPosition);


                    if (modelSelectedItemPosition != null) {
                        // read model.selectedItemPosition.get()
                        modelSelectedItemPositionGet = modelSelectedItemPosition.get();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(model.selectedItemPosition.get())
                    androidxDatabindingViewDataBindingSafeUnboxModelSelectedItemPositionGet = androidx.databinding.ViewDataBinding.safeUnbox(modelSelectedItemPositionGet);
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (model != null) {
                        // read model.search
                        modelSearch = model.search;
                    }
                    updateRegistration(1, modelSearch);


                    if (modelSearch != null) {
                        // read model.search.get()
                        modelSearchGet = modelSearch.get();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (model != null) {
                        // read model.plants
                        modelPlants = model.plants;
                    }
                    updateRegistration(2, modelPlants);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            com.example.forestapp.ui.bookSearch.BookSearchFragment.setUserList(this.mboundView3, modelPlants);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.AdapterViewBindingAdapter.setSelectedItemPosition(this.searchTab, androidxDatabindingViewDataBindingSafeUnboxModelSelectedItemPositionGet);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            androidx.databinding.adapters.AdapterViewBindingAdapter.setOnItemSelectedListener(this.searchTab, (androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected)null, (androidx.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected)null, searchTabandroidSelectedItemPositionAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.searchView, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, searchViewandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.searchView, modelSearchGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model.selectedItemPosition
        flag 1 (0x2L): model.search
        flag 2 (0x3L): model.plants
        flag 3 (0x4L): model
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}