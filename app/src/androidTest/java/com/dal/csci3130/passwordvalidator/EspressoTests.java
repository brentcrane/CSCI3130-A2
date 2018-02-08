package com.dal.csci3130.passwordvalidator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;

/**
 * Created by Brent on 2018-02-07.
 *
 * This class contains the required tests using Espresso
 * to ensure that the UI works as it is meant to.
 *
 * I made reference to the Android documentation to find
 * out how to make use of Espresso, as well as various
 * forum posts.
 */

@RunWith(AndroidJUnit4.class)
public class EspressoTests {

    @Rule
    public ActivityTestRule<Validator> activityRule = new ActivityTestRule<>(Validator.class);

    @Test
    public void testApp ()
    {
        Espresso.onView(ViewMatchers.withId(R.id.inputText)).perform(typeText("MyPassword!1"));
        closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(click());
    }
}
