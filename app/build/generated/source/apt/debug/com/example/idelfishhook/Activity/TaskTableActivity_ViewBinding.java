// Generated code from Butter Knife. Do not modify!
package com.example.idelfishhook.Activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.idelfishhook.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskTableActivity_ViewBinding implements Unbinder {
  private TaskTableActivity target;

  private View view2131230774;

  @UiThread
  public TaskTableActivity_ViewBinding(TaskTableActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TaskTableActivity_ViewBinding(final TaskTableActivity target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'toolbar'", Toolbar.class);
    target.ta_seq = Utils.findRequiredViewAsType(source, R.id.ta_seq, "field 'ta_seq'", TextView.class);
    target.ta_province = Utils.findRequiredViewAsType(source, R.id.ta_province, "field 'ta_province'", TextView.class);
    target.ta_city = Utils.findRequiredViewAsType(source, R.id.ta_city, "field 'ta_city'", TextView.class);
    target.ta_area = Utils.findRequiredViewAsType(source, R.id.ta_area, "field 'ta_area'", TextView.class);
    target.ta_startPage = Utils.findRequiredViewAsType(source, R.id.ta_startPage, "field 'ta_startPage'", TextView.class);
    target.ta_endPage = Utils.findRequiredViewAsType(source, R.id.ta_endPage, "field 'ta_endPage'", TextView.class);
    target.ta_flag = Utils.findRequiredViewAsType(source, R.id.ta_flag, "field 'ta_flag'", TextView.class);
    view = Utils.findRequiredView(source, R.id.change_task, "method 'OnClick'");
    view2131230774 = view;
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
    TaskTableActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.ta_seq = null;
    target.ta_province = null;
    target.ta_city = null;
    target.ta_area = null;
    target.ta_startPage = null;
    target.ta_endPage = null;
    target.ta_flag = null;

    view2131230774.setOnClickListener(null);
    view2131230774 = null;
  }
}
