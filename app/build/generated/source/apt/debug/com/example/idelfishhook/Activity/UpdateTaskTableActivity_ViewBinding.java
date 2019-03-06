// Generated code from Butter Knife. Do not modify!
package com.example.idelfishhook.Activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.idelfishhook.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdateTaskTableActivity_ViewBinding implements Unbinder {
  private UpdateTaskTableActivity target;

  private View view2131230761;

  @UiThread
  public UpdateTaskTableActivity_ViewBinding(UpdateTaskTableActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UpdateTaskTableActivity_ViewBinding(final UpdateTaskTableActivity target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'toolbar'", Toolbar.class);
    target.ta_seq = Utils.findRequiredViewAsType(source, R.id.ta_seq, "field 'ta_seq'", TextView.class);
    target.ta_startPage = Utils.findRequiredViewAsType(source, R.id.ta_startPage, "field 'ta_startPage'", EditText.class);
    target.ta_endPage = Utils.findRequiredViewAsType(source, R.id.ta_endPage, "field 'ta_endPage'", EditText.class);
    target.ta_flag = Utils.findRequiredViewAsType(source, R.id.ta_flag, "field 'ta_flag'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_update, "method 'OnClick'");
    view2131230761 = view;
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
    UpdateTaskTableActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.ta_seq = null;
    target.ta_startPage = null;
    target.ta_endPage = null;
    target.ta_flag = null;

    view2131230761.setOnClickListener(null);
    view2131230761 = null;
  }
}
