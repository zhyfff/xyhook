// Generated code from Butter Knife. Do not modify!
package com.example.idelfishhook.Activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.idelfishhook.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UpdateHostActivity_ViewBinding implements Unbinder {
  private UpdateHostActivity target;

  private View view2131230764;

  @UiThread
  public UpdateHostActivity_ViewBinding(UpdateHostActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UpdateHostActivity_ViewBinding(final UpdateHostActivity target, View source) {
    this.target = target;

    View view;
    target.mtoobar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mtoobar'", Toolbar.class);
    target.et_host = Utils.findRequiredViewAsType(source, R.id.et_host, "field 'et_host'", EditText.class);
    target.et_servlet = Utils.findRequiredViewAsType(source, R.id.et_servlet, "field 'et_servlet'", EditText.class);
    view = Utils.findRequiredView(source, R.id.but_s, "method 'Onclick'");
    view2131230764 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Onclick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    UpdateHostActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mtoobar = null;
    target.et_host = null;
    target.et_servlet = null;

    view2131230764.setOnClickListener(null);
    view2131230764 = null;
  }
}
