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

public class UpdateGoodsClassActivity_ViewBinding implements Unbinder {
  private UpdateGoodsClassActivity target;

  private View view2131230761;

  @UiThread
  public UpdateGoodsClassActivity_ViewBinding(UpdateGoodsClassActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UpdateGoodsClassActivity_ViewBinding(final UpdateGoodsClassActivity target, View source) {
    this.target = target;

    View view;
    target.gid = Utils.findRequiredViewAsType(source, R.id.gid, "field 'gid'", TextView.class);
    target.gName = Utils.findRequiredViewAsType(source, R.id.gName, "field 'gName'", EditText.class);
    target.num = Utils.findRequiredViewAsType(source, R.id.num, "field 'num'", EditText.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'toolbar'", Toolbar.class);
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
    UpdateGoodsClassActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.gid = null;
    target.gName = null;
    target.num = null;
    target.toolbar = null;

    view2131230761.setOnClickListener(null);
    view2131230761 = null;
  }
}
