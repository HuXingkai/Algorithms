package Reusing;

/**
 * Created by andy on 2017/6/4.
 */
public class TypeChange {
    public static void main(String args[]){
        short a=128;
        byte b=(byte) a;
        int c=32768;
        short d=(short)c;
        System.out.println(d);
        System.out.println(b);
        new A();
    }
}
class B extends Object{
    static{
        System.out.println("Load B");
    }
    public B(){
        System.out.println("Create B");
    }
}
class A extends B{
    static{
        System.out.println("Load A");
    }
    public A(){
        System.out.println("Create A");
    }
}

