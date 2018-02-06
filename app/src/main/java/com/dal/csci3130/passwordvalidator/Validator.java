package com.dal.csci3130.passwordvalidator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Validator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validator);
    }

    public static boolean isValid(String input)
    {
        int passedRules = 0;
        int totalRules = 0;

        // Rule 1
        if (input.length() >= 8) {
            passedRules++;
            totalRules++;
        }
        else
            totalRules++;

        // Rule 2
        if (!input.toLowerCase().equals("password")) {
            passedRules++;
            totalRules++;
        }
        else
            totalRules++;

        // Rule 3
        // !@#$%^&*
        boolean specialFound = false;
        if (input.indexOf('!') > -1)
            specialFound = true;
        else if (input.indexOf('@') > -1)
            specialFound = true;
        else if (input.indexOf('#') > -1)
            specialFound = true;
        else if (input.indexOf('$') > -1)
            specialFound = true;
        else if (input.indexOf('%') > -1)
            specialFound = true;
        else if (input.indexOf('^') > -1)
            specialFound = true;
        else if (input.indexOf('&') > -1)
            specialFound = true;
        else if (input.indexOf('*') > -1)
            specialFound = true;
        if (specialFound)
        {
            totalRules ++;
            passedRules ++;
        }
        else
            totalRules ++;

        // Rule 4
        boolean numberFound = false;
        for (int i = 0; i < input.length(); i++)
        {
            if (Character.isDigit(input.charAt(i)))
                numberFound = true;
        }
        if (numberFound)
        {
            totalRules ++;
            passedRules ++;
        }
        else
            totalRules ++;

        // Rule 5
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        for (int i = 0; i < input.length(); i++)
        {
            if (Character.isLowerCase(input.charAt(i)))
                hasLowerCase = true;
            if (Character.isUpperCase(input.charAt(i)))
                hasUpperCase = true;
        }
        if (hasUpperCase && hasLowerCase)
        {
            totalRules ++;
            passedRules ++;
        }
        else
            totalRules ++;

        // Result
        if (totalRules == passedRules)
            return true;
        else
            return false;
    }
}
