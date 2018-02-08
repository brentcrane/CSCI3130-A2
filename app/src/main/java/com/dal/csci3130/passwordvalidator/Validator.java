package com.dal.csci3130.passwordvalidator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Brent on 2018-02-06.
 * This is the main class for my application.
 * The app reads a password into a text box,
 * and upon the press of a button, is checked
 * to determine whether it is a valid password,
 * according to the rules made in the isValid
 * method below.
 */

public class Validator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validator);

        changeText();
    }

    // Read a password as input, check if it is valid,
    // and display the result to the user.
    private void changeText()
    {
        final TextView outputText = findViewById(R.id.outputText);
        Button button = findViewById(R.id.button);
        final TextView inputText = findViewById(R.id.inputText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                boolean validPasword = isValid(inputText.getText().toString());
                if (validPasword)
                    outputText.setText("Password is valid!");
                else
                    outputText.setText("Password is invalid.");

            }
        });

    }

    // Ensure that the password is valid, and return true or
    // false based on the result.
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
