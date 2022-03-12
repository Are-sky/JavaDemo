package Demo05;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
            //Copy1("C:\\Users\\邱彦祥\\Desktop\\1.bmp","C:\\Users\\邱彦祥\\Desktop\\2.bmp");
            //Copy2("C:\\Users\\邱彦祥\\Desktop\\1.txt","C:\\Users\\邱彦祥\\Desktop\\2.txt");
            //Copy2("C:\\Users\\邱彦祥\\Desktop\\1.txt","C:\\Users\\邱彦祥\\Desktop\\2.txt");
            PrintOutFlash("C:\\Users\\邱彦祥\\Desktop\\2.txt");
            //System.out.println(myScanner().substring(4));
    }

    //字节流可以拷贝任何文件
    public static void Copy1(String srcFilepath,String outFilepath)  {
        try (
             FileOutputStream Fout = new FileOutputStream(outFilepath);
             FileInputStream  Fin = new FileInputStream(srcFilepath);
        ){
             byte[] bytes = new byte[128];
             int len = 0; //实际读到的字节数
             while ((len = Fin.read(bytes,0,128)) > 0){
                 Fout.write(bytes,0,len);
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //字符流不允许拷贝所有类型文件
    public static void Copy2(String srcFilepath,String outFilepath){
        try (
                FileReader fr = new FileReader(srcFilepath);
                FileWriter fw = new FileWriter(outFilepath)
        ) {
            char[] chars = new char[128];
            int len = 0;
            while((len = fr.read(chars,0,128)) > 0){
                System.out.println(String.valueOf(chars,0,len));
                fw.write(chars,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* 缓冲字节流 - 对大文件效率高 */
    public static void BufferCopy(String srcFilepath,String outFilepath){
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFilepath));
                BufferedOutputStream bos = new BufferedOutputStream((new FileOutputStream(outFilepath)));
                ) {
            byte[] bytes = new byte[128];
            int len = 0;
            while((len = bis.read(bytes,0,128)) > 0){
                bos.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //转换流
    public static String myScanner() {
        try (
                InputStreamReader r = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(r);
                ){
            StringBuilder result = null ;
            String line = null;
            while((line = br.readLine()) != null){
                if(line.equalsIgnoreCase("exit")){
                    break;
                }
                result = (result == null ? new StringBuilder("null") : result).append(line);
            }
            return result == null ? null : result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //输出重定向
    public static void PrintOutFlash(String Outpath){
        try(
                FileOutputStream fout = new FileOutputStream(Outpath);
                PrintStream ps = new PrintStream(fout);
                ){
            System.setOut(ps);
            System.out.println("abdfg");
            System.out.println("asdad");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
