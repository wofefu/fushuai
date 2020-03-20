package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 这个小项目中 标注了此注解的类  都是需要容器帮我们创建的类
 * 类比于SpringMVC中的@Controller @Service  ..@Component
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Important {
}
