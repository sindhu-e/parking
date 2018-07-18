package customannotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author sindhuja edupuganti
 * This class is used as annotation to initialize CSV filepath for each test method
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvFileParameters {
    String path();
    String encoding() default "UTF-8";
}
