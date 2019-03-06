// Generated code from Butter Knife. Do not modify!
package com.example.idelfishhook.Activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.idelfishhook.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConditionQueryActivity_ViewBinding implements Unbinder {
  private ConditionQueryActivity target;

  private View view2131230759;

  private View view2131230760;

  @UiThread
  public ConditionQueryActivity_ViewBinding(ConditionQueryActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ConditionQueryActivity_ViewBinding(final ConditionQueryActivity target, View source) {
    this.target = target;

    View view;
    target.etId = Utils.findRequiredViewAsType(source, R.id.et_id, "field 'etId'", EditText.class);
    target.etIdName = Utils.findRequiredViewAsType(source, R.id.et_idName, "field 'etIdName'", EditText.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mToolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.btn_query_id, "method 'onClick'");
    view2131230759 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_query_idname, "method 'onClick'");
    view2131230760 = view;
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
    ConditionQueryActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etId = null;
    target.etIdName = null;
    target.mRecyclerView = null;
    target.mToolbar = null;

    view2131230759.setOnClickListener(null);
    view2131230759 = null;
    view2131230760.setOnClickListener(null);
    view2131230760 = null;
  }
}
