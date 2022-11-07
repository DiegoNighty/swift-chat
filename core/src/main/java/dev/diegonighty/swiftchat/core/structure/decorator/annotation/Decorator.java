package dev.diegonighty.swiftchat.core.structure.decorator.annotation;

import dev.diegonighty.swiftchat.core.structure.decorator.DecoratorPriority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Decorator {

    DecoratorPriority priority() default DecoratorPriority.NORMAL;

}
