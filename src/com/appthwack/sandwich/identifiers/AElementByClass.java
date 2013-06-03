package com.appthwack.sandwich.identifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import android.view.View;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AElementByClass{
	Class<? extends View> value();
}
