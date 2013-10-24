package com.appthwack.sandwich.views.classes;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AClass;
import com.appthwack.sandwich.views.interfaces.IAAbsSpinner;

import android.view.KeyEvent;
import android.widget.AbsSpinner;



@AClass(AbsSpinner.class)
public class AAbsSpinner extends AAdapterView implements
		IAAbsSpinner {

	//Implementation based on Robotium by RenasR
	@Override
	public void selectItemAt(int line) {
		
		click();
		
		SandwichLog.d("Waiting for a spinner dialog to open");
		//can't assert on this, returns false
		SoloFactory.getSolo().waitForDialogToOpen(5000);
		

        try{
        	SoloFactory.getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
        }catch(SecurityException ignored){}

        boolean countingUp = true;
        if(line < 0){
                countingUp = false;
                line *= -1;
        }
        for(int i = 0; i < line; i++)
        {
                SoloFactory.getSolo().sleep(50);
                if(countingUp){
                        try{
                        	SoloFactory.getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN);
                        }catch(SecurityException ignored){}
                }else{
                        try{
                        	SoloFactory.getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_UP);
                        }catch(SecurityException ignored){}
                }
        }
        try{
        	SoloFactory.getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_ENTER);
        }catch(SecurityException ignored){}	
        
	}



	

}
