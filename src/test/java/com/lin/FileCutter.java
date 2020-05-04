package com.lin;

import org.junit.platform.commons.util.StringUtils;

import java.io.*;
import java.util.Calendar;

public class FileCutter {
    /**
     *
     *sourceFile:源文件的路径
     *targetDirectory:保存文件的目录(例:'C:\\')
     *prefix:是分割后文件的前缀(例:'2015-09-09')
     *size:是分隔后单一文件的大小单位是2kb的倍数,size传10，分割后单一文件就是20K。e799bee5baa6e59b9ee7ad9431333337613764传100，文件就是2M一个。
     *
     **/
    public static void cutToMoreFile(String sourceFile, String targetDirectory, String prefix, int size)
    {
        //加载源文件
        File source = new File(sourceFile);
        InputStream in = null;
        OutputStream out = null;
        BufferedReader br = null;
        FileWriter fw = null;
        int len = 0;
        int fileIndex = 1;
        //设置一次加载的大小
        byte[] buffer = new byte[2048];
        try
        {
            //把源文件读到InputStream中
            in = new FileInputStream(source);
            br = new BufferedReader(new InputStreamReader(in));
            //循环
            while(true)
            {
                //分割后的文件流

                for(int i = 0; i < size; i++)
                {
                    String line = null;
                    //如果文件读取完就退回方法。
                    if((line = br.readLine())!=null)
                    {
                        line.replace("/r","");
                        //写入分割后的文件
                        fw = new FileWriter(line);
                    }else
                    {
                        //执行finally内容后,退出方法
                        return;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally
        {
            try {
                //关系流
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String sourceFile = "C:\\corearticle\\lvtvspace\\jspperboot\\src\\test\\resources\\test.txt";
        String targetDirectory = "C:\\corearticle\\lvtvspace\\jspperboot\\src\\test\\resources\\result";
        String prefix = ((Object)(Calendar.getInstance().getTimeInMillis())).toString();
        int size = 5;
        cutToMoreFile(sourceFile,targetDirectory,prefix,size);
    }


}
