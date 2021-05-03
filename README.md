I wrote all the code here by myself! I promise.

*******************************
answer to theoretical question:
 if we wish to add multiplication ability, we will need to add the following things:
 1. in the SimpleCalculator class, we will need to add a method called "insert_mult", which will
    check the current screen of the calculator and will add to it's output the X sign if possible.
 2. in the same class, we'll need to change the logic of the method "insertEquals" to support 
    multiplication logic.
 3. in the xml file "activity_main.xml" we'll have to define a new TextView for a new button
 4. in MainActivity.java we'll need to set a setOnClickListener for the multiplication button.
 5. after adding this new button, we will want to add tests that checks the functionality of the 
    button. in the file SimpleCalculatorImplTest we can check the logic; in AppFlowTest we can
    check the app flow with the new button involved; and in MainActivityTest we can check that
    the Activity can really does listen to the new button.
  