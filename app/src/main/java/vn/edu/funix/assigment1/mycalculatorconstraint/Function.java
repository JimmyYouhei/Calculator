/*
 * MIT Liecense
 *
 * Copyright (c) 2019. Jimmy Youhei(Quan Nguyen)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
