import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

    //java8 StreamAPI方便有序对象的操作
    public static void main(String[] args) {
        //Stream是java对象的序列 （有序的java对象？）
        //有序的java对象 不就是List么
        //Stream!=List

        //我们用Stream 主要就是为了简化对集合的一系列操作 遍历、转化、过滤、求和等等

        //如何创建Stream实例
        //方式1 Stream.of()方法
        Stream<String> stream = Stream.of("A", "B", "C", "D", "E");
        //用流能进行什么操作呢？
        stream.forEach(System.out::println);

        //方式2 如果是Collection(List/Set)
        List<String> strings = Arrays.asList("Hello", "PUBG", "DOTA2", "只狼");
        Stream<String> stream1 = strings.stream();

        //Stream的常用操作

        //map()方法 是最常用的一个转换方法 将一个Stream转换成另一个Stream（元素的类型变了/值变了）
        List<String> names = Arrays.asList("张三", "李四");
        names.stream().map(Student::new).forEach(System.out::println);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        nums.stream()
                .map(integer -> integer * integer)
                .forEach(System.out::println);

        //filter()方法 过滤出 符合要求的元素
        List<String> games = Arrays.asList("php", "python", "java", "c++", "c#");
        games.stream()
                .filter(game -> game.length() < 4)
                .forEach(System.out::println);
        System.out.println("仅仅是过滤，games是"+games);
        List<Student> ss = Arrays.asList(new Student("张三", 17), new Student("张三", 18)
                , new Student("李四", 20)
                , new Student("阿强", 15)
                , new Student("大哥", 35));

        ss.stream().filter(student -> student.getAge()>18).forEach(System.out::println);

        //reduce()方法 是聚合操作   与map和filter不同 它不再能够返回一个流 而是聚合成一个结果


        int[] ints = {1,2,3,4,5};
        int result = Arrays.stream(ints).reduce(1, (a,b)->a*b);
        System.out.println(result);


        //map\filter只进行转换操作 如果不进行操作 转换运算是不进行的
        //什么叫进行操作？ 归纳操作 输出
        //最典型的 List得到流 进行过滤 流里面是过滤了 List其实没变 我们想通过这种操作 得到一个新的list
        System.out.println(games);
        games = games.stream().filter(g->g.length()<4).collect(Collectors.toList());
        System.out.println("collect操作后的games是");
        System.out.println(games);



    }
}