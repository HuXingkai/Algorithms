package LearnRefelctAndClass.fanshe;

/**
 * Created by andy on 2018/9/17.
 *
 * 获取Class对象的三种方式
 * 1 Object ——> getClass();
 * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
 * 3 通过Class类的静态方法：forName（String  className）(常用)
 *
 */

public class fanshe {
    public static void main(String[] args) {
        //第一种方式获取反射对象
        Student stu1 = new Student();//这一new 产生一个Student对象，一个Class对象
        Class stuClass = stu1.getClass();
        System.out.println(stuClass.getName());

        //第2种方式获取反射对象
        Class stuClass2 = Student.class;
        System.out.println(stuClass2==stuClass);

        //第3种方式获取反射对象
        try {
            //注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            Class stuClass3 = Class.forName("LearnRefelctAndClass.fanshe.Student");
            System.out.println(stuClass3 == stuClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
