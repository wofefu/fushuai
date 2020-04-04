import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        //今日内容： 函数式编程 lambda表达式

        //jdk1.8开始
        //函数式编程特点:允许把函数本身作为参数传入另一个函数，还允许返回一个函数


        //lambda表达式 可以代替一个 单方法的接口

        TestInterface ti = (a, b) -> System.out.println(a + b);


        Comparator<Student> comparator = Comparator.comparingInt(Student::getAge);

        //方法引用

        //使用lambda表达式 就可以不写单抽象方法接口的实现类 从而简化代码

        //除了lambda表达式 还可以直接传入方法引用
        //如果 某个方法的方法签名 和 这个单方法接口的方法签名一致  那么可以直接把这个方法本身传递进去
        //方法签名一致的意思：除了方法名外、参数列表、返回类型都相同
        //java中的所有  成员方法  都有一个隐藏的this参数
        //注意：静态方法不含this参数
        MyInterface m = (s1, s2) -> s1 + s2;
        MyInterface mi = String::concat;
        System.out.println(mi.add("a", "b"));


        String[] arr = {"B", "D", "A", "C"};
        Arrays.sort(arr, String::compareTo);
        //此时 Comparator<String> 方法签名为 参数是两个字符串 返回结果是一个int类型整数
        //如果有一个已经存在的方法 恰好签名一致 也可以直接往上传


        //看到方法引用 就把它看成是一个接口的实例

        //方法引用 除了可以引用静态方法 和实例方法 还可以引用构造方法

        //List<String>转换成List<Student>

        List<String> list = Arrays.asList("张三", "李四");

        //传统做法
//        List<Student> students = new ArrayList<>();
//        for (String n :
//                list) {
//            Student s = new Student(n);
//            students.add(s);
//        }

        //如果想更简单地去进行转换 可以引用Student的构造方法
        //什么方法 的参数是一个字符串 返回结果 是Student实例呢？
        //构造方法
        System.out.println(list.stream().map(Student::new).collect(Collectors.toList()));




        //总结：   如果某个场景  你需要一个实现了某个单方法的接口的匿名实现类
        //就可以使用 lambda表达式 或方法引用 来简化代码



    }
}
