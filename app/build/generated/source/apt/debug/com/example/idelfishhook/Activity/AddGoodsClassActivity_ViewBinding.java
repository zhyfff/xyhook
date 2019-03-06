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

public class AddGoodsClassActivity_ViewBinding implements Unbinder {
  private AddGoodsClassActivity target;

  private View view2131230762;

  private View view2131230763;

  @UiThread
  public AddGoodsClassActivity_ViewBinding(AddGoodsClassActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddGoodsClassActivity_ViewBinding(final AddGoodsClassActivity target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'toolbar'", Toolbar.class);
    target.et_gid = Utils.findRequiredViewAsType(source, R.id.et_gid, "field 'et_gid'", EditText.class);
    target.et_gName = Utils.findRequiredViewAsType(source, R.id.et_gName, "field 'et_gName'", EditText.class);
    target.et_num = Utils.findRequiredViewAsType(source, R.id.et_num, "field 'et_num'", EditText.class);
    view = Utils.findRequiredView(source, R.id.but_addgc, "method 'OnClick'");
    view2131230762 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.but_look, "method 'OnClick'");
    view2131230763 = view;
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
    AddGoodsClassActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.et_gid = null;
    target.et_gName = null;
    target.et_num = null;

    view2131230762.setOnClickListener(null);
    view2131230762 = null;
    view2131230763.setOnClickListener(null);
    view2131230763 = null;
  }
}
