package com.appthwack.sandwich.identifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// TODO: Auto-generated Javadoc
/**
 * The Interface AIdName.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AIdName {
	
	/**
	 * Value.
	 *
	 * @return the string
	 */
	String value();
}
