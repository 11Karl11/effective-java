package chapter22;

/**
 * @author karl xie
 * Created on 2024-04-24 16:52
 */
// Marker annotation type declaration

import java.lang.annotation.*;

/**
 * Indicates that the annotated method is a test method.
 * Use only on parameterless static methods.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}