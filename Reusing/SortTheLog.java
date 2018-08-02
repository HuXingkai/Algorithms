package Reusing;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Created by andy on 2017/6/5.
 */
public class SortTheLog {
    public static void main(String args[]) {
        File file = new File("D:\\log2.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String readline = null;
        ArrayList<TextFromLog> textList=new ArrayList<>();
        try {
            while ((readline = reader.readLine()) != null) {
                String[] readlines = readline.split("=");
                String et = readlines[2];
                TextFromLog t1 = new TextFromLog(readline, et);
                textList.add(t1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(textList);
        File writeFile = new File("D:\\log1");
        if (!writeFile.exists()){
            try {
                writeFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(writeFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < textList.size(); i++) {


            ps.append(textList.get(i).context+"\r\n");
        }
    }
}

class TextFromLog implements Comparable<Object> {
public String context;
public String timestamp;
public TextFromLog(String context,String timestamp){
        this.context=context;
        this.timestamp=timestamp;
        }
public String getContext(){
        return context;
        }
public String getTimestamp(){
        return timestamp;
        }


    @Override
    public int compareTo(Object o) {
        TextFromLog text=(TextFromLog)o;
        if(Long.valueOf(this.timestamp)>Long.valueOf(text.timestamp)){
            return 1;
        }
        if(Long.valueOf(this.timestamp)<Long.valueOf(text.timestamp)){
            return -1;
        }return 0;
    }
    }


