# Calculator
This is my first Android project a simple Calculator as a requirement from Funix University which I was learning at the time 

The project is a simple as it sound : an calculator 

## Version Detail
- The project was made by Android Studio 3.1.3
- The Compiled SDK was API 27: Android 8.1 Oreo
- Buid Tool Version 28.0.2
- min SDK: 17

## How to install
- If you own an Android OS phone , then you can come to [google app store](https://play.google.com/store/apps/details?id=vn.edu.funix.assigment1.mycalculatorconstraint) to install: 
- If you want to see the source code then open your android studio and use _new_ -> _Project From Version Control_ -> _Git_ and paste _https://github.com/JimmyYouhei/Calculator.git_

## Features
Aside fron a normal calculator can do there are serverall features
-	complex calculator that can make many calcultion at once eg: 4 + 2 * -√2 / 2 * 5% - 8.15. You get the idea and without limit
-	the * and / will be calculated before + and - (that is why Arraylist was used)
-	the calculation will be accurate as Big Decimal was used not normal double eg: just try 0.012 + 0.012+ 0.012
-	Can use special operator: % , √ , +/- and will append to the main screen smartly 
-	Handle Exception square root of negative eg: √-2;
-	Smart handle special case eg: 10+ = 10 or 10/ = 10
## Possible Issue
- The calculator can make complex calcuation so I try to test it with my best ability but for super complex calculation there may be bugs
-	I did not pay much attention in my Math class during high school because of personal issues. So there may be arithmetic exception that is not known for me and not handled

## Side Note
-	The project design takes me a few days to come up a design for the whole project which is original. And if similar to other design is purely coincidence
-	The project is quite complex, but I have commented on the code. Please read the comment on the code for more information
-	The new constraint layout for android is very easy to use and can design the interface with just drag and drop. Moreover, to use Android Studio Xml knowledge is required but only minimal as it is quite similar to others 
-	All of Java 8 features can be incorporate into Android 
-	For accurate calculation Big Decimal class is a must
-	Agile Development work well for projects like this  


