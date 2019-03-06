package zhy.com.uitestcase;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

import zhy.com.uitestcase.util.CMDUtils;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private UiDevice mDevice;
    Instrumentation instrumentation ;
    @Test
    public void useAppContext() throws UiObjectNotFoundException {
//        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
//        mDevice.pressHome();
//        mDevice.pressHome();
//        UiObject x=mDevice.findObject(new UiSelector().text("设置"));
//        x.click();


        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        instrumentation = InstrumentationRegistry.getInstrumentation();
        UiObject txtf1 = mDevice.findObject(new UiSelector().text("综合排序"));
        if (txtf1.exists()){
            RecycleviewMake();
        }else{
            mDevice.pressHome();
            // 获取上下文
            Context context = instrumentation.getContext();
//             启动测试App
            Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.taobao.idlefish");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);

//            UiObject xy = mDevice.findObject(new UiSelector().text("闲鱼"));
//            xy.clickAndWaitForNewWindow();
//            UiObject tv_item_9=mDevice.findObject(new UiSelector().resourceId("com.taobao.idlefish:id/item_9"));
//            tv_item_9.clickAndWaitForNewWindow();
            UiObject tv_all = mDevice.findObject(new UiSelector().text("全部分类"));
            tv_all.clickAndWaitForNewWindow();

            if (!UiMake()){
                UiMake();
            }
        }

    }

    public boolean UiMake() throws UiObjectNotFoundException {
        sleep(2000);
        UiObject tv_like = mDevice.findObject(new UiSelector().text("猜你喜欢"));
        if (tv_like.exists()){
            UiScrollable settings = new UiScrollable(new UiSelector().className("android.widget.FrameLayout"));
            UiObject about = settings.getChildByText(new UiSelector().className("android.widget.TextView"), "热门分类");
            sleep(2000);
            if (about.exists()){
                UiObject tv_list_item=mDevice.findObject(new UiSelector().resourceId("com.taobao.idlefish:id/category_image"));
                tv_list_item.clickAndWaitForNewWindow();
                RecycleviewMake();
                String command = "adb shell am broadcast -a com.example.idelfishhook --es data success";
                CMDUtils.runCMD(command,true,true);

            }
        }else {
            return false;
        }
        return true;
    }

    public void  RecycleviewMake() throws UiObjectNotFoundException {
        UiObject recy = mDevice.findObject(new UiSelector().className("android.support.v7.widget.RecyclerView"));
//        UiObject recy =mDevice.findObject(new UiSelector().resourceId("com.taobao.idlefish:id/search_result_list_view"));
        recy.swipeDown(10);

    }

    public void  sleep(int s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
