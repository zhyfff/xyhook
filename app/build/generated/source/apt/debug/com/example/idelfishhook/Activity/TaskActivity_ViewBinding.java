// Generated code from Butter Knife. Do not modify!
package com.example.idelfishhook.Activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.idelfishhook.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskActivity_ViewBinding implements Unbinder {
  private TaskActivity target;

  private View view2131230765;

  private View view2131230766;

  private View view2131230767;

  @UiThread
  public TaskActivity_ViewBinding(TaskActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TaskActivity_ViewBinding(final TaskActivity target, View source) {
    this.target = target;

    View view;
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mToolbar'", Toolbar.class);
    target.tx_id = Utils.findRequiredViewAsType(source, R.id.tx_id, "field 'tx_id'", TextView.class);
    target.tx_idName = Utils.findRequiredViewAsType(source, R.id.tx_idName, "field 'tx_idName'", TextView.class);
    target.tx_province = Utils.findRequiredViewAsType(source, R.id.tx_province, "field 'tx_province'", TextView.class);
    target.tx_city = Utils.findRequiredViewAsType(source, R.id.tx_city, "field 'tx_city'", TextView.class);
    target.tx_area = Utils.findRequiredViewAsType(source, R.id.tx_area, "field 'tx_area'", TextView.class);
    target.tx_Endpage = Utils.findRequiredViewAsType(source, R.id.tx_Endpage, "field 'tx_Endpage'", TextView.class);
    view = Utils.findRequiredView(source, R.id.but_start, "field 'but_start' and method 'OnClick'");
    target.but_start = Utils.castView(view, R.id.but_start, "field 'but_start'", Button.class);
    view2131230765 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_task, "method 'OnClick'");
    view2131230766 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_taskdetail, "method 'OnClick'");
    view2131230767 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.tx_id = null;
    target.tx_idName = null;
    target.tx_province = null;
    target.tx_city = null;
    target.tx_area = null;
    target.tx_Endpage = null;
    target.but_start = null;

    view2131230765.setOnClickListener(null);
    view2131230765 = null;
    view2131230766.setOnClickListener(null);
    view2131230766 = null;
    view2131230767.setOnClickListener(null);
    view2131230767 = null;
  }
}
