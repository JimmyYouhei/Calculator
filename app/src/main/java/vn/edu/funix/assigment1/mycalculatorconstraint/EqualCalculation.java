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

import java.math.BigDecimal;
import java.util.ArrayList;

public class EqualCalculation {
    //variable to check whether there is / or *
    boolean haveMultiply = false;
    boolean haveDivide = false;


    /*
    the getter and setter I just make in case I will use it but in the end it is not used but too lazy to remove it
     */
    public boolean isHaveMultiply() {
        return haveMultiply;
    }

    public void setHaveMultiply(boolean haveMultiply) {
        this.haveMultiply = haveMultiply;
    }

    public boolean isHaveDivide() {
        return haveDivide;
    }

    public void setHaveDivide(boolean haveDivide) {
        this.haveDivide = haveDivide;
    }


    // Function to check *
    public void checkMultiply(ArrayList<String> operatorArraylist){
        if(operatorArraylist.contains("*")){
            this.haveMultiply = true;
        } else {
            this.haveMultiply = false;
        }
    }

    //Function to check /
    public void checkDivide(ArrayList<String> operatorArraylist){
        if(operatorArraylist.contains("/")){
            this.haveDivide = true;
        } else {
            this.haveDivide = false;
        }
    }

    // Main Function
    public double equalOperator(ArrayList<Double> numberArraylist, ArrayList<String>operatorArraylist) throws ArithmeticException{
        int operatorArraylistLength = operatorArraylist.size();
        double result =0;
        //if no operator but already stored number then the equal will return the only number
        if(operatorArraylistLength ==0 && numberArraylist.size()==1 ){
            result = numberArraylist.get(0);
        } else {
                // loop through all operator
            for (int i = 0; i < operatorArraylistLength; i++) {
                // check for / or *
                this.checkMultiply(operatorArraylist);
                this.checkDivide(operatorArraylist);
                // if no / or * then calculate the result as normal from left to right
                if(this.haveDivide == false && this.haveMultiply == false){
                    int numberArraylistLength = numberArraylist.size();
                    switch (operatorArraylist.get(0)){
                        case "+":
                            //normal condition use BigDecimal  for accurate result
                            if(numberArraylistLength>1){
                                BigDecimal firstNumber = new BigDecimal(Double.toString(numberArraylist.get(0)));
                                BigDecimal secondNumber = new BigDecimal(Double.toString(numberArraylist.get(1)));
                                BigDecimal sum = firstNumber.add(secondNumber);
                                result = Double.parseDouble(sum.toString());
                                numberArraylist.remove(0);
                                numberArraylist.set(0, result);
                                operatorArraylist.remove(0);
                            } else {
                                // if there is operator but no number to the right eg: 10+
                                result = numberArraylist.get(0)+0;
                                operatorArraylist.remove(0);
                            }

                            break;

                        case "-":
                            if(numberArraylistLength>1){
                                //normal condition use BigDecimal  for accurate result
                                BigDecimal firstNumber = new BigDecimal(Double.toString(numberArraylist.get(0)));
                                BigDecimal secondNumber = new BigDecimal(Double.toString(numberArraylist.get(1)));
                                BigDecimal minus = firstNumber.subtract(secondNumber);
                                result = Double.parseDouble(minus.toString());
                                numberArraylist.remove(0);
                                numberArraylist.set(0, result);
                                operatorArraylist.remove(0);
                            } else {
                                // if there is operator but no number to the right eg: 10-
                                result = numberArraylist.get(0)-0;
                                operatorArraylist.remove(0);
                            }
                            break;
                    }
                } else {
                    // if there is * or / so the * and / will make caculate first
                    int numberArraylistLength = numberArraylist.size();
                    for (int j = 0; j < operatorArraylistLength ; j++) {
                        switch (operatorArraylist.get(j)){
                            case"*":
                                if(j+1 < numberArraylistLength){
                                    //normal condition use BigDecimal  for accurate result
                                    BigDecimal firstNumber = new BigDecimal(Double.toString(numberArraylist.get(j)));
                                    BigDecimal secondNumber = new BigDecimal(Double.toString(numberArraylist.get(j+1)));
                                    BigDecimal multiply = firstNumber.multiply(secondNumber);
                                    result = Double.parseDouble(multiply.toString());
                                    numberArraylist.remove(j);
                                    numberArraylist.set(j,result);
                                    operatorArraylist.remove(j);
                                    // break out if loop after just 1 calculation to recheck whether there is / or *
                                    j = operatorArraylistLength;
                                } else{
                                    // if there is operator but no number to the right eg: 10*
                                    result = numberArraylist.get(j) *1;
                                    operatorArraylist.remove(j);
                                    j = operatorArraylistLength;
                                }
                                break;

                            case"/":
                                //normal condition use BigDecimal  for accurate result
                                if (j+1 <numberArraylistLength){
                                    // /0 throw Exception
                                    if (numberArraylist.get(j+1) ==0){
                                        throw new ArithmeticException("Error , divide to zero");

                                    } else {
                                        // normal
                                        BigDecimal firstNumber = new BigDecimal(Double.toString(numberArraylist.get(j)));
                                        BigDecimal secondNumber = new BigDecimal(Double.toString(numberArraylist.get(j+1)));
                                        BigDecimal divide = firstNumber.divide(secondNumber);
                                        result = Double.parseDouble(divide.toString());
                                        numberArraylist.remove(j);
                                        numberArraylist.set(j, result);
                                        operatorArraylist.remove(j);
                                        // break out if loop after just 1 calculation to recheck whether there is / or *
                                        j=operatorArraylistLength;
                                    }

                                } else {
                                    // if there is operator but no number to the right eg: 10/
                                    result = numberArraylist.get(j)/1;
                                    operatorArraylist.remove(j);
                                    j=operatorArraylistLength;
                                }
                                break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
