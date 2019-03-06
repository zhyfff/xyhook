package com.idelfish.xposed;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.util.FileUtil;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class httpHook implements IXposedHookLoadPackage {


	@Override
	public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
		
		if (loadPackageParam.packageName.equals("com.taobao.idlefish")) {
			XposedBridge.log("Launch app: " + loadPackageParam.packageName);
			XposedHelpers.findAndHookMethod(Application.class, "attach", Context.class, new XC_MethodHook(){
				@Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					
					try {
						httpHook.initHooking(loadPackageParam);
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						XposedBridge.log("NoSuchMethodException");
					}
				}
				
			});
			
		}



	}
	
	public static void initHooking(XC_LoadPackage.LoadPackageParam lpparam) throws NoSuchMethodException {

		XposedHelpers.findAndHookMethod("mtopsdk.mtop.domain.MtopRequest", lpparam.classLoader, "setData",String.class, new XC_MethodHook() {
	        @Override
	        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					XposedBridge.log("MtopRequest beforeHooked ");
					try {
//						param.args[0] = "{\"activeSearch\":false,\"area\":\"朝阳区\","
//								+ "\"bizFrom\":\"IDLE_CAT_GUIDE\",\"city\":\"北京\","
//								+ "\"forceRefreshFilter\":false,\"forceUseTppRepair\":false,"
//								+ "\"fromCombo\":\"Loc\",\"fromKits\":false,\"fromLeaf\":false,"
//								+ "\"fromShade\":false,\"fromSuggest\":false,"
//								+ "\"gps\":\"\",\"kitSearchOnce\":{},"
//								+ "\"mType\":{\"mFrom\":\"error\",\"mParam\":\"error\"},"
//								+ "\"noSelect\":false,\"originJson\":false,\"pageNumber\":1,"
//								+ "\"province\":\"北京\",\"recommend\":false,\"rowsPerPage\":10,"
//								+ "\"searchConditions\":{\"navQueryId\":\"1115\","
//								+ "\"scm\":\"1007.18402.104983.0\"},\"shadeBucketNum\":-1,"
//								+ "\"source\":\"\",\"suggestBucketNum\":-1}";

						String resbody=FileUtil.inPutStreamtool();
						if (!resbody.equals("")){
							param.args[0]= resbody;
						}
						Log.i("httpHook",resbody);

                        XposedBridge.log("MtopRequest  param.args[0]:"+resbody);
					} catch (Exception e) {

					}
	        }
	        
	    });
		
		
		XposedHelpers.findAndHookMethod("mtopsdk.mtop.domain.MtopResponse", lpparam.classLoader, "getDataJsonObject", new XC_MethodHook() {

		        @Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						XposedBridge.log("MtopResponse  afterHook");
						String tmp = null;
						try {
							tmp = param.getResult().toString();
							if (tmp!=null&&tmp.contains("{\"bgColor\"")){

								String finalTmp = tmp;
								new Thread(new Runnable() {
									@Override
									public void run() {
										ResponseMessage.sendPost(finalTmp);

									}
								}).start();


								XposedBridge.log("return->" + tmp + " ");
								Log.i("httpHook-return->",tmp);

							}
						} catch (Exception e) {

						}


				}
		    });





	}




}