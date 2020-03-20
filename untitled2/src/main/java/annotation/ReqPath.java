package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 所有标有此注解的方法 意味着它能处理某种http请求
 *
 * 这个注解 应该是有属性表明 它能处理什么路径的请求
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReqPath {

    String value();
}
