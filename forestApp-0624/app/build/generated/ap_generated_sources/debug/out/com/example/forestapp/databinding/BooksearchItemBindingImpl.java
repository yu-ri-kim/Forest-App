package com.example.forestapp.databinding;
import com.example.forestapp.R;
import com.example.forestapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BooksearchItemBindingImpl extends BooksearchItemBinding  {

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
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public BooksearchItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private BooksearchItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.ImageView) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.plantimage.setTag(null);
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
        if (BR.plant == variableId) {
            setPlant((com.example.forestapp.ui.bookSearch.BkViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPlant(@Nullable com.example.forestapp.ui.bookSearch.BkViewModel Plant) {
        this.mPlant = Plant;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.plant);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePlantData((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangePlantName((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangePlantImg((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangePlantData(androidx.databinding.ObservableField<java.lang.String> PlantData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangePlantName(androidx.databinding.ObservableField<java.lang.String> PlantName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangePlantImg(androidx.databinding.ObservableField<java.lang.String> PlantImg, int fieldId) {
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
        java.lang.String plantImgGet = null;
        java.lang.String plantDataGet = null;
        com.example.forestapp.ui.bookSearch.BkViewModel plant = mPlant;
        androidx.databinding.ObservableField<java.lang.String> plantData = null;
        androidx.databinding.ObservableField<java.lang.String> plantName = null;
        java.lang.String plantNameGet = null;
        androidx.databinding.ObservableField<java.lang.String> plantImg = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (plant != null) {
                        // read plant.data
                        plantData = plant.data;
                    }
                    updateRegistration(0, plantData);


                    if (plantData != null) {
                        // read plant.data.get()
                        plantDataGet = plantData.get();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (plant != null) {
                        // read plant.name
                        plantName = plant.name;
                    }
                    updateRegistration(1, plantName);


                    if (plantName != null) {
                        // read plant.name.get()
                        plantNameGet = plantName.get();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (plant != null) {
                        // read plant.img
                        plantImg = plant.img;
                    }
                    updateRegistration(2, plantImg);


                    if (plantImg != null) {
                        // read plant.img.get()
                        plantImgGet = plantImg.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, plantNameGet);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, plantDataGet);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            com.example.forestapp.ui.bookSearch.BkViewModel.loadImage(this.plantimage, plantImgGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): plant.data
        flag 1 (0x2L): plant.name
        flag 2 (0x3L): plant.img
        flag 3 (0x4L): plant
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}