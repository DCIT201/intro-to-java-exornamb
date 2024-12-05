/*
* A program to convert temperature from one Celsius to Fahrenheit and vice versa
*/

import java.util.*;
public class TemperatureConverter {
    public static void main(String[] args) {

        System.out.println("Welcome the TEMPERATURE CONVERTER program!!!");
        System.out.println("");

        Scanner input = new Scanner(System.in); // Creating a new object scanner

        System.out.println("I can convert from Celsius to Fahrenheit(ctf) or Fahrenheit to Celsius(ftc). ");
        System.out.println("");
        System.out.println("For Celsius to Fahrenheit choose 1.");
        System.out.println("For Fahrenheit to Celsius choose 2");
        System.out.println("");
        System.out.println("PRECAUTIONS: Enter the conversion type without the number first.");
        System.out.println("");
        int choiceOfConversion;



        do{// To check whether the choice of conversion is valid
            System.out.println("Choose the conversion type: ");
            choiceOfConversion = input.nextInt();// to take in integer values
        }while(!ConversionChecker(choiceOfConversion));

        //A condition to decide on what function to be used.
        switch (choiceOfConversion) {

            case 1 :
                double actualValue = ValidateValue(-273.15);// This is to make sure the correct extreme value is placed and the messages appear when needed
                System.out.print(actualValue + " in celsius is " + CelsiusToFahrenheit(actualValue) + " fahrenheit.");
                break;
            case 2 :
                actualValue = ValidateValue(-459.67);
                System.out.print( actualValue + " in fahrenheit is " + FahrenheitToCelsius( actualValue) + " celsius.");
                break;
        }
        input.close();

    }

    //A function to return the Fahrenheit value
    public static double CelsiusToFahrenheit(double celsius) {//F = (C × 9/5) + 32

        return Math.floor(((celsius * (double)9 / 5) + 32) * 100 ) /100;
    }


    //A function to return the Celsius value
    public static double FahrenheitToCelsius(double fahrenheit) {// C = (F - 32) × 5/9

        return Math.floor(((fahrenheit - 32) * (double)5 / 9) * 100 ) /100;
    }

    public static boolean ConversionChecker(int choice){//To check whether the choice of conversion is what is required.
        return choice == 1 || choice == 2;
    }

    public static double InputValue(){// To input the value to be validated and converted.
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
        
    }
    
    public static double ValidateValue(double value1){// To remove redundancy and output the sentences
        double value = 0;
        int count = 0;
        String temperature = (value1 == -273.15) ? "celsius" : "fahrenheit";// To use the right word at the right time.

        do{ // To check whether the choice of conversion is valid i.e. no extreme values especially in Celsius or Fahrenheit.

                System.out.println("PRECAUTIONS: The temperature for " + temperature + " should not be less that " + value1);
                System.out.println("Enter a valid value for conversion: ");
                value =InputValue();
                count++;
                if(count > 0 && value < value1){
                    System.out.println("The value is less than " + value1 + " in " + temperature);
                }

        }while(value < value1);


        return value;//Return the decimal input needed for the Conversion of the numbers
    }
    
}