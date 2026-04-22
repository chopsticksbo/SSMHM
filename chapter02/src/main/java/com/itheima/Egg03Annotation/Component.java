package com.itheima.Egg03Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//标注注解的注解
@Target(value = {ElementType.TYPE, ElementType.FIELD})

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    String value() default "";
    String name() default "";
    String[] names() default {};
}
