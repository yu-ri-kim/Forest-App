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
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.search_tab, 3);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.ListView mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
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
        super(bindingComponent, root, 2
            , (android.widget.Spinner) bindings[3]
            , (android.widget.EditText) bindings[1]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.ListView) bindings[2];
        this.mboundView2.setTag(null);
        this.searchView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModelSearch((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeModelPlants((androidx.databinding.ObservableArrayList<com.example.forestapp.ui.bookSearch.BkViewModel>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModelSearch(androidx.databinding.ObservableField<java.lang.String> ModelSearch, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelPlants(androidx.databinding.ObservableArrayList<com.example.forestapp.ui.bookSearch.BkViewModel> ModelPlants, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        androidx.databinding.ObservableField<java.lang.String> modelSearch = null;
        androidx.databinding.ObservableArrayList<com.example.forestapp.ui.bookSearch.BkViewModel> modelPlants = null;
        java.lang.String modelSearchGet = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (model != null) {
                        // read model.search
                        modelSearch = model.search;
                    }
                    updateRegistration(0, modelSearch);


                    if (modelSearch != null) {
                        // read model.search.get()
                        modelSearchGet = modelSearch.get();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (model != null) {
                        // read model.plants
                        modelPlants = model.plants;
                    }
                    updateRegistration(1, modelPlants);
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            com.example.forestapp.ui.bookSearch.BookSearchFragment.setUserList(this.mboundView2, modelPlants);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.searchView, modelSearchGet);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.searchView, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, searchViewandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model.search
        flag 1 (0x2L): model.plants
        flag 2 (0x3L): model
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}