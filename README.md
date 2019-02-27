# Calculator
This is my first Android project: a simple Calculator app as a required by Funix University which I was learning at the time the app was being made

## Version Detail
-	The project was made by Android Studio 3.1.3
-	Target SDK: API 27 Android 8.1 Oreo
-	min SDK: API 17

## How to install
- -	If you own an Android OS phone, then you can come to [google app store](https://play.google.com/store/apps/details?id=vn.edu.funix.assigment1.mycalculatorconstraint) to install
-	If you want to see the source code then open your android studio and use  _new_ -> _Project From Version Control_ -> _Git_ and paste _https://github.com/JimmyYouhei/Calculator.git_

## How to use
A simple calculator as it is, I don’t think I have to explain more

## Features
-	complex calculator that can make many calculation at once eg: 4 + 2 * -√2 / 2 * 5% - 8.15. You get the idea and without limit
-	the * and / will be calculated before + and - (that is why ArrayList was used)
-	the calculation will be accurate as Big Decimal was used eg: just try 0.012 + 0.012+ 0.012
-	Can use special operator: % , √ , +/- and will append to the main screen smartly
-	Handle Exception square root of negative eg: √-2
-	Smart handle special cases eg: 10+ = 10 or 10/ = 10
## Possible Issue
-	The calculator can make complex calculation so I try to test it with my best ability but for super complex calculation there may be bugs
-	I did not pay much attention to my Math class during high school because of personal issues. So there may be arithmetic exceptions that is not known for me and not handled

## Side Note
-	The project design takes me a few days to come up with a design for the whole project which is original. And if it is similar to other design it is purely coincidence
-	The project is quite complex, but I have commented on the code. Please read the comment on the code for more information
-	The new constraint layout for android is very easy to use. And developers can design the interface with just drag and drop with only minimal XML knowledge
-	All of Java 8 features can be incorporate into Android
-	For accurate calculation, Big Decimal class is a must
-	Agile Development work well for projects like this


## License
Free Software that follows the MIT License. More detail can be seen [here](https://github.com/JimmyYouhei/Calculator/blob/master/LICENSE)



