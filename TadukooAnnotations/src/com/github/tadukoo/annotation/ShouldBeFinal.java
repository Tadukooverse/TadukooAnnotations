package com.github.tadukoo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Annotation to mark a class field or method that it should be changed 
 * to "final" in the future.
 * 
 * @author Logan Ferree (Tadukoo)
 * @version Pre-Alpha
 */
@Documented
@Inherited
@Retention(CLASS)
@Target({FIELD, METHOD})
public @interface ShouldBeFinal{
	
}
