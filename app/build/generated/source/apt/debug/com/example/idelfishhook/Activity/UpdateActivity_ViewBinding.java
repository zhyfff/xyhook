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

public class UpdateActivity_ViewBinding implements Unbinder {
  private UpdateActivity target;

  private View view2131230761;

  @UiThread
  public UpdateActivity_ViewBinding(UpdateActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UpdateActivity_ViewBinding(final UpdateActivity target, View source) {
    this.target = target;

    View view;
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mToolbar'", Toolbar.class);
    target.etName = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'etName'", EditText.class);
    target.etProvince = Utils.findRequiredViewAsType(source, R.id.et_province, "field 'etProvince'", EditText.class);
    target.etCity = Utils.findRequiredViewAsType(source, R.id.et_city, "field 'etCity'", EditText.class);
    target.etArea = Utils.findRequiredViewAsType(source, R.id.et_area, "field 'etArea'", EditText.class);
    target.etEndpage = Utils.findRequiredViewAsType(source, R.id.et_endPage, "field 'etEndpage'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_update, "method 'onClick'");
    view2131230761 = view;
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
    UpdateActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.etName = null;
    target.etProvince = null;
    target.etCity = null;
    target.etArea = null;
    target.etEndpage = null;

    view2131230761.setOnClickListener(null);
    view2131230761 = null;
  }
}
