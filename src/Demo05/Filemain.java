package Demo05;

import java.io.File;
import java.sql.SQLOutput;

public class Filemain {
    public static void main(String[] args) {
        String path = "E:\\Download";
        filePrint(path,0);
    }

    public static void filePrint(String filePath, int depth){
        //获取文件
        File file = new File(filePath);

        //抛出文件不存在的异常
        if(!file.exists()){
            throw new IllegalArgumentException("文件不存在");
        }

        //打印
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        //为文件
        if (file.isFile()){
            System.out.print("-");
        }
        System.out.println(file.getName());

        //为目录
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files != null) {
                for (File e:files) filePrint(e.getPath(), depth+1);
            }
        }
    }
}
