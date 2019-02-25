package vn.edu.funix.assigment1.mycalculatorconstraint;

import android.view.View;
import android.widget.Button;

// Some Function for code reuse
public class Function {
    //Get String of button
    public static String getButtonString(View v){
        Button thisButton = (Button) v;
        String buttonString = thisButton.getText().toString();
        return buttonString;
    }

    // due to specical operator String (√ , % and +/- have different String to append to main screen so special function to them)
    public static String getMainScreenText(View v){
        Button thisButton = (Button) v;
        String buttonString = thisButton.getText().toString();
        switch (buttonString){
            case"%":
                return "%(";

            case"√":
                return "√(";

            case"+/-":
                return "-(";

            default:
                return "";
        }
    }
}
