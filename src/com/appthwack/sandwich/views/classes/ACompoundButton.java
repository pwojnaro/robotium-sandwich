package com.appthwack.sandwich.views.classes;

import android.widget.CompoundButton;

import com.appthwack.sandwich.identifiers.AElementByClass;
import com.appthwack.sandwich.views.interfaces.IACompoundButton;


@AElementByClass(CompoundButton.class)
public abstract class ACompoundButton extends AButton implements IACompoundButton {

	
	@Override
	public boolean isChecked() {
		CompoundButton view = (CompoundButton) getView();
		return view.isChecked();
	}

}
