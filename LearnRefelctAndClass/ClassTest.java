package LearnRefelctAndClass;

import java.lang.reflect.Field;

/**Class 类的学习
 * Created by andy on 2018/9/15.
 */
public class ClassTest {
    static void test(Object x) {
        System.out.println("Testing x of type"+x.getClass());
        System.out.println(" x instanceof A"+(x instanceof A));
        System.out.println(" x instanceof B"+(x instanceof B));
        System.out.println(" A.isInstance(x)"+A.class.isInstance(x));
        System.out.println(" B.isInstance(x)"+B.class.isInstance(x));
        System.out.println(" x name: "+x.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
        //test(new A());
        Class aclass = B.class;
        B b = (B)aclass.newInstance();
        b.dosomething();
        System.out.println(aclass.getDeclaredField("fieldValue"));
        Field Bfiled = aclass.getDeclaredField("fieldValue");
        Bfiled.setAccessible(true);
        System.out.println(Bfiled.get(b));
    }
}
class A{}

class B extends A {
    private int fieldValue = 11;
    static void dosomething() {
        System.out.println("do something");
    }

    public B() {
        System.out.println("construct B");
    }
}