package LearnRefelctAndClass.fanshe;

import java.lang.reflect.Field;

/**
 * Created by andy on 2018/9/17.
 * 获取成员变量并调用：
 *
 * 1.批量的
 * 		1).Field[] getFields():获取所有的"公有字段"
 * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 * 	 设置字段的值：
 * 		Field --> public void set(Object obj,Object value):
 * 					参数说明：
 * 					1.obj:要设置的字段所在的对象；
 * 					2.value:要为字段设置的值；

 */
public class Fields {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("LearnRefelctAndClass.fanshe.Student");
        Field f1 = clazz.getField("name");
        System.out.println(f1);

        Field f2 = clazz.getDeclaredField("age");
        System.out.println(f2);

        //获取一个对象
        Object obj = clazz.getConstructor().newInstance();
        //为字段设置值
        f1.set(obj, "刘德华");
        //f2.setAccessible(true);
        f2.set(obj,50);

        Student stu = (Student) obj;
        System.out.println(stu.toString());

    }
}
