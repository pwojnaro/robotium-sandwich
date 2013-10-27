package com.appthwack.sandwich.views.classes;

import android.widget.CompoundButton;

import com.appthwack.sandwich.identifiers.AClass;
import com.appthwack.sandwich.views.interfaces.IACompoundButton;


// TODO: Auto-generated Javadoc
/**
 * The Class ACompoundButton.
 */
@AClass(CompoundButton.class)
public abstract class ACompoundButton extends AButton implements IACompoundButton {

	
	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IACompoundButton#isChecked()
	 */
	@Override
	public boolean isChecked() {
		CompoundButton view = (CompoundButton) getAndWaitForView();
		return view.isChecked();
	}

}
