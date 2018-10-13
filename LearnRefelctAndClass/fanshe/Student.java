package LearnRefelctAndClass.fanshe;

/**
 * Created by andy on 2018/9/17.
 */
public class Student {

    //**********字段*************//
    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }

    //--------------构造方法-------------
    //默认的构造方法
    Student(String str) {
        System.out.println("默认的构造方法 s=" + str);
    }

    //无参数的构造方法
    public Student() {
        System.out.println("调用了公用的，无参数的构造方法");
    }

    //一个参数的构造方法
    public Student(char name) {
        System.out.println("姓名：" + name);
    }

    //多个参数的构造方法
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("姓名：" + name + "年龄：" + age);
    }

    //受保护的构造方法
    protected Student(boolean n) {
        System.out.println("受保护的构造方法：" + n);
    }

    //私有的构造方法
    private Student(int age) {
        System.out.println("私有的构造方法"  + "年龄：" + age);
    }



    //**************成员方法***************//
    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }
}
