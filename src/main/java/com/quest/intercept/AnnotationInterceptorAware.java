package com.quest.intercept;

import java.lang.annotation.Annotation;

/**
 * Created by Quest on 2017/8/31.
 */
public interface AnnotationInterceptorAware {
    /**
     * Annotation的注入方法
     *
     * @param annotation
     */
    void setAnnotation(Annotation annotation);
}
