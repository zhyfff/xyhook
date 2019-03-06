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

public class GoodsListActivity_ViewBinding implements Unbinder {
  private GoodsListActivity target;

  @UiThread
  public GoodsListActivity_ViewBinding(GoodsListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GoodsListActivity_ViewBinding(GoodsListActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'toolbar'", Toolbar.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GoodsListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.mRecyclerView = null;
  }
}
