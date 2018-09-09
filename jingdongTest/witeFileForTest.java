package jingdongTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;


/**
 * Created by andy on 2018/9/9.
 */
public class witeFileForTest {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\huxin\\Desktop\\test1.txt";
        FileOutputStream filewriter = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(filewriter);
        int range = 10000;
        int num = 500000;
        try {
            writer.write(num+"\r\n");
            for (int i=0;i<num;i++) {
                Random random = new Random();
                int a= random.nextInt(range);
                int b= random.nextInt(range);
                int c= random.nextInt(range);
                writer.write(a + " " + b + " " + c+"\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            writer.close();
        }
    }
}
