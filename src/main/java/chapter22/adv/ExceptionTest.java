package chapter22.adv;

import java.lang.annotation.Repeatable;

/**
 * @Repeatable 注解用于标识 ExceptionTest 注解可以重复使用。它接受一个容器注解类作为参数，用于存储重复的注解实例。
 *
 * ExceptionTest 注解定义了一个 value() 方法，用于指定期望抛出的异常类型。
 *
 * ExceptionTestContainer 注解用作 ExceptionTest 注解的容器注解。它使用 @Retention(RetentionPolicy.RUNTIME) 指定注解的保留策略为运行时，
 * 并使用 @Target(ElementType.METHOD) 指定注解只能应用于方法上。
 *
 * ExceptionTestContainer 注解定义了一个 value() 方法，返回一个 ExceptionTest 注解数组，用于存储重复的 ExceptionTest 注解实例。
 *
 * 这样设计的目的是允许在同一个方法上多次使用 @ExceptionTest 注解，每次指定不同的期望异常类型。通过使用 @Repeatable 和容器注解，可以方便地处理重复的注解实例。
 * @author karl xie
 */
// Repeatable annotation type
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {
    Class<? extends Exception> value();
}