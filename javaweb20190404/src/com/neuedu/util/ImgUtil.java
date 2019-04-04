package com.neuedu.util;

import javax.servlet.http.Part;
import java.io.*;

public class ImgUtil {

    public static void imgController(Part inputfile,String path,String filename) throws IOException{
        File filepath=new File(path);
        if(!filepath.exists()){
            filepath.mkdir();
        }

        File file=new File(path,filename);//文件要在服务器的文件夹中，File两个参数构造器，第一参数文件夹（目录），第二个参数：文件名
        if(!file.exists()){
            file.createNewFile();
        }

        inputoutput(inputfile,file);


    }

    //4：复制
    private static void inputoutput(Part inputfile,File file) throws IOException{

        //输入流
        InputStream is=inputfile.getInputStream();
        BufferedInputStream bis=new BufferedInputStream(is);
        //输出流
        OutputStream os=new FileOutputStream(file);
        BufferedOutputStream bos=new BufferedOutputStream(os);

        //赋值
        byte[] b=new byte[1024];
        int len=0;
        while((len=bis.read(b))!=-1){
            bos.write(b,0,len);
        }
        bos.flush();

        bos.close();
        bis.close();
        os.close();
        is.close();
    }
}

