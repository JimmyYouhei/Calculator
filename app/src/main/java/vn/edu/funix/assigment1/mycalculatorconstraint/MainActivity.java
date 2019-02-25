package vn.edu.funix.assigment1.mycalculatorconstraint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //variable for the main screen
    private TextView mainScreen;

    // varibale to hold temporary number before parse to double
    private String temporaryStorage = "" ;

    // Arraylist to hold numbers
    private ArrayList<Double> numberArraylist = new ArrayList<>();

    //Arraylist to hold operator
    private ArrayList<String> operatorArraylist = new ArrayList<>();

    // initialize from EqualCalculator class
    private EqualCalculation calculate = new EqualCalculation();

    //Arraylist to hold special operator
    private ArrayList<String> specialOperatorArraylist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //tye main screen to its id
            mainScreen = (TextView) findViewById(R.id.mainScreen);

            //tye button to its id
            Button button0 = (Button) findViewById(R.id.button0);
            Button button1 = (Button) findViewById(R.id.button1);
            Button button2 = (Button) findViewById(R.id.button2);
            Button button3 = (Button) findViewById(R.id.button3);
            Button button4 = (Button) findViewById(R.id.button4);
            Button button5 = (Button) findViewById(R.id.button5);
            Button button6 = (Button) findViewById(R.id.button6);
            Button button7 = (Button) findViewById(R.id.button7);
            Button button8 = (Button) findViewById(R.id.button8);
            Button button9 = (Button) findViewById(R.id.button9);
            Button dot = (Button) findViewById(R.id.buttonDot);

            Button divide = (Button) findViewById(R.id.buttonDivide);
            Button multiply = (Button) findViewById(R.id.buttonMultiply);
            Button minus = (Button) findViewById(R.id.buttonMinus);
            Button plus = (Button) findViewById(R.id.buttonPlus);
            Button clear = (Button) findViewById(R.id.buttonClear);
            Button percentage = (Button) findViewById(R.id.buttonPercent);
            Button squareRoot = (Button) findViewById(R.id.buttonSquare);
            Button negPos = (Button) findViewById(R.id.buttonPosiNeg);
            Button equal = (Button) findViewById(R.id.buttonEqual);

            //Onclick listener for number button
            final View.OnClickListener numberListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //append string to mainscreen
                    mainScreen.append(Function.getButtonString(v));
                    //store string to temporageStorage to build number
                    temporaryStorage += Function.getButtonString(v) ;
                }
            };

            //assign to number button
            button0.setOnClickListener(numberListener);
            button1.setOnClickListener(numberListener);
            button2.setOnClickListener(numberListener);
            button3.setOnClickListener(numberListener);
            button4.setOnClickListener(numberListener);
            button5.setOnClickListener(numberListener);
            button6.setOnClickListener(numberListener);
            button7.setOnClickListener(numberListener);
            button8.setOnClickListener(numberListener);
            button9.setOnClickListener(numberListener);

            //onclick listener for dot button
            View.OnClickListener dotListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // if already press dot or have not any number so will do nothing else just like number
                    if(temporaryStorage.contains(".")){

                    } else if (temporaryStorage.equals("")){

                    } else {
                        mainScreen.append(Function.getButtonString(v));
                        temporaryStorage+= Function.getButtonString(v);
                    }
                }
            };
            // assign to dot listener
            dot.setOnClickListener(dotListener);

            //Operator listener
            View.OnClickListener operatorListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    if there is no number do nothing to avoid duplicate
                    if there is a number and have special operator(% - or √)
                    then calculate special operator with the number first then store into numberArraylist as permanent number
                    if no special operator store the temporary as permanent in the numberArraylist
                    the operator will be store in the operatorArraylist and append operator string to main screen
                     */
                    try {
                        if (temporaryStorage.equals("")){

                        } else if (specialOperatorArraylist.size()>0){
                            numberArraylist.add(SpecialOperator.specialOperator(Double.parseDouble(temporaryStorage),
                                    specialOperatorArraylist));
                            mainScreen.append(Function.getButtonString(v));
                            operatorArraylist.add(Function.getButtonString(v));
                            temporaryStorage ="";
                        } else {
                            numberArraylist.add(Double.parseDouble(temporaryStorage));
                            mainScreen.append(Function.getButtonString(v));
                            operatorArraylist.add(Function.getButtonString(v));
                            temporaryStorage="";
                        }
                    } catch (ArithmeticException e) {
                        // handle Exception: √ of negative
                        mainScreen.setText(e.getMessage().toString());
                    }
                }
            };

            //assign listener
            plus.setOnClickListener(operatorListener);
            minus.setOnClickListener(operatorListener);
            multiply.setOnClickListener(operatorListener);
            divide.setOnClickListener(operatorListener);

            //  make the listener for the equal button
            View.OnClickListener equalListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*
                    if there is number and special operator (√ , % and -)
                    will calculate the number and special operator first then store as permanent number in the numberArraylist
                    if there is only number without special operator then store it as permanent number in the numberArraylist

                    after that use the EqualCalculation (see more in the class) to calculate clear all numberArraylistt
                    store the result as temporary in case user want to make more calculation and append result string to main screen;
                     */
                    try {
                        if (!temporaryStorage.equals("") && specialOperatorArraylist.size()>0){
                            numberArraylist.add(SpecialOperator.specialOperator(Double.parseDouble(temporaryStorage),
                                    specialOperatorArraylist));
                        }else if (!temporaryStorage.equals("")){
                            numberArraylist.add(Double.parseDouble(temporaryStorage));
                        }
                        double result = 0;
                        result = calculate.equalOperator(numberArraylist , operatorArraylist);
                        numberArraylist.clear();
                        temporaryStorage=String.valueOf(result);
                        mainScreen.setText(String.valueOf(result));
                    } catch (ArithmeticException e) {
                        // Handle / 0 and √of negative Exception
                        mainScreen.setText(e.getMessage().toString());
                    }
                }
            };

            // assign the listener
            equal.setOnClickListener(equalListener);

            // Clear button listener make everything like the start
            View.OnClickListener clearListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    temporaryStorage="";
                    numberArraylist.clear();
                    operatorArraylist.clear();
                    specialOperatorArraylist.clear();
                    mainScreen.setText("");
                    calculate = new EqualCalculation();

                }
            };

            // assgin the clearListener
            clear.setOnClickListener(clearListener);

            // listener for √ , % and -
            View.OnClickListener specialOperator = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //store what current on main screen
                    String whatOnMainScreen = mainScreen.getText().toString();
                    /*
                    if there is already number in the temporary storage then append the special operator string before it on main screen
                    if not the  only append the special operator string
                    then add the special operator to specialOperatorArraylist for later calculation
                     */
                    if(!temporaryStorage.equals("")){
                        mainScreen.setText(whatOnMainScreen.substring(0,
                                whatOnMainScreen.length()-temporaryStorage.length()));
                        mainScreen.append(Function.getMainScreenText(v)+temporaryStorage);
                        specialOperatorArraylist.add(Function.getMainScreenText(v));
                    } else {
                        mainScreen.append(Function.getMainScreenText(v));
                        specialOperatorArraylist.add(Function.getMainScreenText(v));
                    }

                }
            };

            // assign listener
            negPos.setOnClickListener(specialOperator);
            percentage.setOnClickListener(specialOperator);
            squareRoot.setOnClickListener(specialOperator);

    }
}
