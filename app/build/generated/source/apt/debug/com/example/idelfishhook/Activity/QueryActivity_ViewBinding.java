// Generated code from Butter Knife. Do not modify!
package com.example.idelfishhook.Activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.idelfishhook.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QueryActivity_ViewBinding implements Unbinder {
  private QueryActivity target;

  private View view2131230758;

  private View view2131230756;

  @UiThread
  public QueryActivity_ViewBinding(QueryActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QueryActivity_ViewBinding(final QueryActivity target, View source) {
    this.target = target;

    View view;
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mToolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.btn_query, "method 'onClick'");
    view2131230758 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_condition_query, "method 'onClick'");
    view2131230756 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    QueryActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;

    view2131230758.setOnClickListener(null);
    view2131230758 = null;
    view2131230756.setOnClickListener(null);
    view2131230756 = null;
  }
}
