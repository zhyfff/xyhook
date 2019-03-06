package com.example.idelfishhook.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.Realm.entry.GoodsClassBean;
import com.Realm.entry.Location;
import com.Realm.entry.TaskBean;
import com.example.idelfishhook.R;
import com.idelfish.xposed.ResponseStateBean;
import com.util.CMDUtils;
import com.util.MyReceiver;
import com.util.RealmHelper;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 任务详情
 */
public class TaskActivity extends BaseActivity {

    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.tx_id)
    TextView tx_id;
    @BindView(R.id.tx_idName)
    TextView tx_idName;
    @BindView(R.id.tx_province)
    TextView tx_province;
    @BindView(R.id.tx_city)
    TextView tx_city;
    @BindView(R.id.tx_area)
    TextView tx_area;
    @BindView(R.id.tx_Endpage)
    TextView tx_Endpage;
    @BindView(R.id.but_start)
    Button but_start;

    private RealmHelper realmHelper;
    private Location location;
    private String param=null;
    private static final String TAG = "TaskActivity";
    private String province;
    private String city;
    private String area;
    private int rpage;
    private List<GoodsClassBean> gcList = new ArrayList<>();
    private int goodsNum;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(mToolbar, "任务详情");
        querryLoc();
        initData();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_task;
    }

    @Override
    public Intent setMenuIntentAdd() {
        return new Intent(this, InsertActivity.class);
    }

    @Override
    public Intent setMenuIntentsearch() {
        return new Intent(this,QueryActivity.class);
    }

    @Override
    public Intent setMenuIntentAddGoodsClass() {
        return new Intent(this,AddGoodsClassActivity.class);
    }

    @Override
    public Intent setMenuIntentQuerryHost() {
        return new Intent(this,QuerryHostActivity.class);
    }

    public void querryLoc(){
        realmHelper = new RealmHelper(this);
        String id=getIntent().getStringExtra("id");
        location =realmHelper.queryLocById(id);
    }

    public void initData(){
        tx_id.setText(location.getId());
        tx_idName.setText(location.getIdName());
        tx_province.setText(location.getProvince());
        tx_city.setText(location.getCity());
        tx_area.setText(location.getArea());
        tx_Endpage.setText(location.getEndPage());
    }



    @OnClick({R.id.but_start,R.id.but_task,R.id.but_taskdetail})
    void OnClick(View view){
        String id=location.getId().trim();
        String area=location.getArea().trim();
        String city=location.getCity().trim();
        String province=location.getProvince().trim();
        String endpage=location.getEndPage().trim();

        switch (view.getId()){
            case R.id.but_start:
                Toast.makeText(this, "ui启动", Toast.LENGTH_SHORT).show();
                try {
//                    /**
//                     * ui线程耗时操作
//                     */
                    HandlerThread mHandlerThread = new HandlerThread("test-handler-thread");
                    mHandlerThread.start();
                    Handler mHandler  = new Handler(mHandlerThread.getLooper()){
                        public void handleMessage(Message msg){
                            while(true){
                                try {
                                    if (init(id).equals("任务运行结束")){
                                        break;
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    };
                    mHandler.sendEmptyMessage(0);
                } catch (Exception e) {
                   Log.e(TAG,e.getMessage());
                }
                break;
            case R.id.but_taskdetail:
                Intent intent = new Intent(TaskActivity.this,TaskTableActivity.class);
                intent.putExtra("seq",id);
                startActivity(intent);
                break;
            case R.id.but_task:
                realmHelper = new RealmHelper(this);
                TaskBean taskBean= new TaskBean();
                taskBean.setSeq(Integer.parseInt(id));
                taskBean.setStartPage(1);
                taskBean.setEndPage(Integer.parseInt(endpage));
                taskBean.setArea(area);
                taskBean.setCity(city);
                taskBean.setProvince(province);
                taskBean.setFlag("1");
                if (!realmHelper.isExistTask(Integer.parseInt(id))){
                    realmHelper.addTask(taskBean);
                    Toast.makeText(TaskActivity.this,"任务创建成功！",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(TaskActivity.this,"任务表已存在！",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }


    /**
     * 开始处理任务的操作
     * @param id
     */
    public String init(String id) throws InterruptedException,IOException {
        String ifOver = null;
        realmHelper = new RealmHelper(this);
        TaskBean  taskBean = realmHelper.querryTaskbySeq(Integer.parseInt(id));
        if (taskBean!=null){
            province =taskBean.getProvince();
            city = taskBean.getCity();
            area = taskBean.getArea();
            gcList=realmHelper.querryAllGoodsClass();
            for (int i=taskBean.getStartPage();i<=taskBean.getEndPage()+1;i++){
                if (i==taskBean.getEndPage()+1||taskBean.getFlag()=="-1"){
                    realmHelper.updateTaskPage(taskBean.getSeq(),i);
                    realmHelper.updateTaskFlag(taskBean.getSeq(),"-1");//运行结束修改任务状态为-1
                    Log.i(TAG,"任务运行结束！！");
                    Toast.makeText(this,"任务运行结束！！",Toast.LENGTH_SHORT).show();
                    ifOver="任务运行结束";
                    break;
                }
                rpage=i;

                for (int k=0;k<gcList.size();k++){
                    goodsNum = gcList.get(k).getNum();
                    Thread UiThread = new UiautomatorThread();
                    UiThread.start();
                    Thread.sleep(30*1000);
                    saveParam("");

                }

                realmHelper.updateTaskPage(taskBean.getSeq(),i);//修改当前页数
            }


        }else{
            Toast.makeText(TaskActivity.this,"请先创建任务表",Toast.LENGTH_SHORT).show();
        }
        return ifOver;
    }

    /**
     * 获取uiautomator组件返回的信息
     * @return
     */
    public String getReceiver(){
        String  content = null;
        while(!MyReceiver.getContent().equals("success")){
            content = MyReceiver.getContent();
            continue;
        }
        Log.i(TAG,"接收到的消息："+content);
        return  content;
    }


    public  void runTask(String province,String city,String area,int rpage,int goodsNum){

            if (!area.equals("")){
                Log.i(TAG,"有区域限制");
                param = "{\"activeSearch\":false,\"area\":\""+area+"\","
                        + "\"bizFrom\":\"IDLE_CAT_GUIDE\",\"city\":\""+city+"\","
                        + "\"forceRefreshFilter\":false,\"forceUseTppRepair\":false,"
                        + "\"fromCombo\":\"Loc\",\"fromKits\":false,\"fromLeaf\":false,"
                        + "\"fromShade\":false,\"fromSuggest\":false,"
                        + "\"gps\":\"\",\"kitSearchOnce\":{},"
                        + "\"mType\":{\"mFrom\":\"error\",\"mParam\":\"error\"},"
                        + "\"noSelect\":false,\"originJson\":false,\"pageNumber\":"+rpage+","
                        + "\"province\":\""+province+"\",\"recommend\":false,\"rowsPerPage\":500,"
                        + "\"searchConditions\":{\"navQueryId\":\""+goodsNum+"\","
                        + "\"scm\":\"1007.18402.104983.0\"},\"shadeBucketNum\":-1,\"sortField\":\"time\",\"sortValue\":\"desc\","
                        + "\"source\":\"\",\"suggestBucketNum\":-1}";
            }else{
                Log.i(TAG,"无区域限制");
                param = "{\"activeSearch\":false,"
                        + "\"bizFrom\":\"IDLE_CAT_GUIDE\",\"city\":\""+city+"\","
                        + "\"forceRefreshFilter\":false,\"forceUseTppRepair\":false,"
                        + "\"fromCombo\":\"Loc\",\"fromKits\":false,\"fromLeaf\":false,"
                        + "\"fromShade\":false,\"fromSuggest\":false,"
                        + "\"gps\":\"\",\"kitSearchOnce\":{},"
                        + "\"mType\":{\"mFrom\":\"error\",\"mParam\":\"error\"},"
                        + "\"noSelect\":false,\"originJson\":false,\"pageNumber\":"+rpage+","
                        + "\"province\":\""+province+"\",\"recommend\":false,\"rowsPerPage\":500,"
                        + "\"searchConditions\":{\"navQueryId\":\""+goodsNum+"\","
                        + "\"scm\":\"1007.18402.104983.0\"},\"shadeBucketNum\":-1,\"sortField\":\"time\",\"sortValue\":\"desc\","
                        + "\"source\":\"\",\"suggestBucketNum\":-1}";
            }

            try {
                Log.i(TAG,param);
                saveParam(param);
//                RealmHelper realmHelper = new RealmHelper(this);
//                ParamBean paramBean = new ParamBean();
//                paramBean.setSeq("1");
//                paramBean.setResbody(param);
//                realmHelper.addParam(paramBean);

            } catch (Exception e) {
                Log.e(getCallingPackage(),e.getMessage());
            }


            String command = generateCommand("zhy.com.uitestcase", "ExampleInstrumentedTest", "useAppContext");
            CMDUtils.CMD_Result rs= CMDUtils.runCMD(command,true,true);
            Log.e(TAG, "run: " + rs.error + "-------" + rs.success);

    }


    /**
     * 保存传入hook的参数到txt文件
     * @param param
     * @throws IOException
     */
    public void saveParam(String param) throws IOException {
        FileOutputStream outStream = openFileOutput("param.txt", Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
        outStream.write(param.getBytes());
        outStream.close();



    }


    /**
     * 生成命令
     * @param pkgName uiautomator包名
     * @param clsName uiautomator类名
     * @param mtdName uiautomator方法名
     * @return
     */
    public  String generateCommand(String pkgName, String clsName, String mtdName) {
        String command = "am instrument -w -r -e debug false -e class "
                + pkgName + "." + clsName + "#" + mtdName + " "
                + pkgName + ".test/android.support.test.runner.AndroidJUnitRunner";
        Log.e("test1: ", command);
        return command;
    }


    /**
     * 运行uiautomator是个费时的操作，不应该放在主线程，因此另起一个线程运行
     */
    public class UiautomatorThread extends Thread {

        @Override
        public void run() {
            super.run();
            runTask(province,city,area,rpage,goodsNum);

        }

    }

    public  class myHandler extends Handler{


        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case ResponseStateBean.ReState:
                    Toast.makeText(TaskActivity.this,msg.obj.toString(),Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(TaskActivity.this,"发送成功",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };





    protected void testRoot() {
        try {
            Process p = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(p.getOutputStream());
            os.writeBytes("exit\n");
            os.flush();
        } catch (IOException e) {
//            Toast.makeText(this, R.string.no_root, Toast.LENGTH_LONG).show();
            e.printStackTrace();
            Log.e("app", e.getMessage());

        }
    }
}

