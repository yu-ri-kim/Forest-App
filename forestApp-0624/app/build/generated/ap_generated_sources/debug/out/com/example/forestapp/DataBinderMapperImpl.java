package com.example.forestapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.forestapp.databinding.ActivityLoginBindingImpl;
import com.example.forestapp.databinding.ActivitySignupBindingImpl;
import com.example.forestapp.databinding.BookItemBindingImpl;
import com.example.forestapp.databinding.BooksearchItemBindingImpl;
import com.example.forestapp.databinding.FragmentBookBindingImpl;
import com.example.forestapp.databinding.FragmentBooksearchBindingImpl;
import com.example.forestapp.databinding.FragmentHurbsearchBindingImpl;
import com.example.forestapp.databinding.FragmentMybookBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYLOGIN = 1;

  private static final int LAYOUT_ACTIVITYSIGNUP = 2;

  private static final int LAYOUT_BOOKITEM = 3;

  private static final int LAYOUT_BOOKSEARCHITEM = 4;

  private static final int LAYOUT_FRAGMENTBOOK = 5;

  private static final int LAYOUT_FRAGMENTBOOKSEARCH = 6;

  private static final int LAYOUT_FRAGMENTHURBSEARCH = 7;

  private static final int LAYOUT_FRAGMENTMYBOOK = 8;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(8);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.forestapp.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.forestapp.R.layout.activity_signup, LAYOUT_ACTIVITYSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.forestapp.R.layout.book_item, LAYOUT_BOOKITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.forestapp.R.layout.booksearch_item, LAYOUT_BOOKSEARCHITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.forestapp.R.layout.fragment_book, LAYOUT_FRAGMENTBOOK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.forestapp.R.layout.fragment_booksearch, LAYOUT_FRAGMENTBOOKSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.forestapp.R.layout.fragment_hurbsearch, LAYOUT_FRAGMENTHURBSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.forestapp.R.layout.fragment_mybook, LAYOUT_FRAGMENTMYBOOK);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSIGNUP: {
          if ("layout/activity_signup_0".equals(tag)) {
            return new ActivitySignupBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_signup is invalid. Received: " + tag);
        }
        case  LAYOUT_BOOKITEM: {
          if ("layout/book_item_0".equals(tag)) {
            return new BookItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for book_item is invalid. Received: " + tag);
        }
        case  LAYOUT_BOOKSEARCHITEM: {
          if ("layout/booksearch_item_0".equals(tag)) {
            return new BooksearchItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for booksearch_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBOOK: {
          if ("layout/fragment_book_0".equals(tag)) {
            return new FragmentBookBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_book is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBOOKSEARCH: {
          if ("layout/fragment_booksearch_0".equals(tag)) {
            return new FragmentBooksearchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_booksearch is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHURBSEARCH: {
          if ("layout/fragment_hurbsearch_0".equals(tag)) {
            return new FragmentHurbsearchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_hurbsearch is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMYBOOK: {
          if ("layout/fragment_mybook_0".equals(tag)) {
            return new FragmentMybookBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_mybook is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "model");
      sKeys.put(2, "plant");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(8);

    static {
      sKeys.put("layout/activity_login_0", com.example.forestapp.R.layout.activity_login);
      sKeys.put("layout/activity_signup_0", com.example.forestapp.R.layout.activity_signup);
      sKeys.put("layout/book_item_0", com.example.forestapp.R.layout.book_item);
      sKeys.put("layout/booksearch_item_0", com.example.forestapp.R.layout.booksearch_item);
      sKeys.put("layout/fragment_book_0", com.example.forestapp.R.layout.fragment_book);
      sKeys.put("layout/fragment_booksearch_0", com.example.forestapp.R.layout.fragment_booksearch);
      sKeys.put("layout/fragment_hurbsearch_0", com.example.forestapp.R.layout.fragment_hurbsearch);
      sKeys.put("layout/fragment_mybook_0", com.example.forestapp.R.layout.fragment_mybook);
    }
  }
}
