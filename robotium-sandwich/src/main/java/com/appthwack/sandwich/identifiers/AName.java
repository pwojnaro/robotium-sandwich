/**
 * 
 */
package com.appthwack.sandwich.identifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface AName.
 *
 * @author pwojnaro
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AName {
	
	/**
	 * Value.
	 *
	 * @return the string
	 */
	String value();
}
