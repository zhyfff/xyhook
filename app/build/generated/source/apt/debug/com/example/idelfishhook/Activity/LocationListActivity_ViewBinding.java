// Generated code from Butter Knife. Do not modify!
package com.example.idelfishhook.Activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.idelfishhook.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LocationListActivity_ViewBinding implements Unbinder {
  private LocationListActivity target;

  @UiThread
  public LocationListActivity_ViewBinding(LocationListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LocationListActivity_ViewBinding(LocationListActivity target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mToolbar'", Toolbar.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LocationListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.mRecyclerView = null;
  }
}
