package com.util;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 存储任务信息到文件
 */
public class FileUtil {

    private static String filesname = "/data/data/com.example.idelfishhook/files/param.txt";

    public static String inPutStreamtool() {
        String content = null;
        FileInputStream inStream = null;
        try {
            File file = new File(filesname);
            inStream = new FileInputStream(file);
            //创建一个字节数组，定义len记录长度
            int len = 0;
            byte[] buf = new byte[16*1024];
            while ((len = inStream.read(buf)) >0) {
                content = new String(buf, 0, len);
//                System.out.println(new String(buf,0,len));
            }

        } catch (IOException e) {
            Log.e("FileUtil",e.toString());
        }finally {
            if (null != inStream)
            {
                try
                {
                    inStream.close();
                }
                catch (IOException e)
                {
                }
            }

        }
        return content;
    }

}
