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

import java.util.ArrayList;

//Function to calculate special operator (√ , % and -) and a number and can calculate multi special operator
public class SpecialOperator {

    public static double specialOperator (double number , ArrayList<String> specialArraylist) throws ArithmeticException {
        double result =number;
        int specialArraylistLength = specialArraylist.size();
        for (int i = specialArraylistLength-1; i >= 0; i--)
            switch (specialArraylist.get(i)) {
                case "-(":
                    result = result * -1;
                    break;

                case "√(":
                    result = Math.sqrt(result);
                    break;

                case "%(":
                    result = result / 100;
                    break;
            }
        specialArraylist.clear();
        if (Double.isNaN(result)){
            throw new ArithmeticException("Error square root of negative");
        }
        return result;
    }
}
