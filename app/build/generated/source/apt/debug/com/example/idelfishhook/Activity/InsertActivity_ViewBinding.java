// Generated code from Butter Knife. Do not modify!
package com.example.idelfishhook.Activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.idelfishhook.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InsertActivity_ViewBinding implements Unbinder {
  private InsertActivity target;

  private View view2131230757;

  @UiThread
  public InsertActivity_ViewBinding(InsertActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InsertActivity_ViewBinding(final InsertActivity target, View source) {
    this.target = target;

    View view;
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mToolbar'", Toolbar.class);
    target.et_id = Utils.findRequiredViewAsType(source, R.id.et_id, "field 'et_id'", EditText.class);
    target.et_idName = Utils.findRequiredViewAsType(source, R.id.et_idName, "field 'et_idName'", EditText.class);
    target.et_province = Utils.findRequiredViewAsType(source, R.id.et_province, "field 'et_province'", EditText.class);
    target.et_city = Utils.findRequiredViewAsType(source, R.id.et_city, "field 'et_city'", EditText.class);
    target.et_area = Utils.findRequiredViewAsType(source, R.id.et_area, "field 'et_area'", EditText.class);
    target.et_endPage = Utils.findRequiredViewAsType(source, R.id.et_endPage, "field 'et_endPage'", EditText.class);
    target.scrollView = Utils.findRequiredViewAsType(source, R.id.scrollview, "field 'scrollView'", ScrollView.class);
    view = Utils.findRequiredView(source, R.id.btn_insert, "method 'onClick'");
    view2131230757 = view;
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
    InsertActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.et_id = null;
    target.et_idName = null;
    target.et_province = null;
    target.et_city = null;
    target.et_area = null;
    target.et_endPage = null;
    target.scrollView = null;

    view2131230757.setOnClickListener(null);
    view2131230757 = null;
  }
}
