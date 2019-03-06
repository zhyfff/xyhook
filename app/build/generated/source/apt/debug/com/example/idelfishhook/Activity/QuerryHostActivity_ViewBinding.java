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

public class QuerryHostActivity_ViewBinding implements Unbinder {
  private QuerryHostActivity target;

  private View view2131230768;

  @UiThread
  public QuerryHostActivity_ViewBinding(QuerryHostActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QuerryHostActivity_ViewBinding(final QuerryHostActivity target, View source) {
    this.target = target;

    View view;
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mToolbar'", Toolbar.class);
    target.ta_host = Utils.findRequiredViewAsType(source, R.id.ta_host, "field 'ta_host'", TextView.class);
    target.ta_servlet = Utils.findRequiredViewAsType(source, R.id.ta_servlet, "field 'ta_servlet'", TextView.class);
    view = Utils.findRequiredView(source, R.id.but_up, "method 'Onclick'");
    view2131230768 = view;
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
    QuerryHostActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.ta_host = null;
    target.ta_servlet = null;

    view2131230768.setOnClickListener(null);
    view2131230768 = null;
  }
}
