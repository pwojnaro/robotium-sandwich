package com.appthwack.sandwich.views.classes;

import android.widget.CompoundButton;

import com.appthwack.sandwich.identifiers.AClass;
import com.appthwack.sandwich.views.interfaces.IACompoundButton;


@AClass(CompoundButton.class)
public abstract class ACompoundButton extends AButton implements IACompoundButton {

	
	@Override
	public boolean isChecked() {
		CompoundButton view = (CompoundButton) getAndWaitForView();
		return view.isChecked();
	}

}
