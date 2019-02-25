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
