package dev.diegonighty.swiftchat.core.annotation;

import java.lang.annotation.Annotation;
import java.util.function.Function;

public class Annotations {

    public static <A extends Annotation, T> T extractOrDefault(A annotation, Function<A, T> extractor, T defaultValue) {
        return annotation == null ? defaultValue : extractor.apply(annotation);
    }

}
