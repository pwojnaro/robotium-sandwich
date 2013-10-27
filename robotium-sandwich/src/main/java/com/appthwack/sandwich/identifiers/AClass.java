package com.appthwack.sandwich.identifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import android.view.View;

// TODO: Auto-generated Javadoc
/**
 * The Interface AClass.
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AClass{
	
	/**
	 * Value.
	 *
	 * @return the class<? extends view>
	 */
	Class<? extends View> value();
}
