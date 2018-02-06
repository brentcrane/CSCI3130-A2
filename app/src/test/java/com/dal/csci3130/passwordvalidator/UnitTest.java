package com.dal.csci3130.passwordvalidator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Brent on 2018-02-06.
 */

public class UnitTest {
    @Test
    public void passwordTooShort () throws Exception
    {
        assertFalse(Validator.isValid("One1!"));
    }
    @Test
    public void passwordIsPassword () throws Exception
    {
        assertFalse(Validator.isValid("password"));
    }
    @Test
    public void passwordIsPasswordCased () throws Exception
    {
        assertFalse(Validator.isValid("pAsSwOrD"));
    }
    @Test
    public void passwordHasNoNumbers () throws Exception
    {
        assertFalse(Validator.isValid("TheChosenOne!"));
    }
    @Test
    public void passwordHasNoSpecial () throws Exception
    {
        assertFalse(Validator.isValid("TheChosen1"));
    }
    @Test
    public void passwordNoLowerCase () throws Exception
    {
        assertFalse(Validator.isValid("CHOSEN!ONE1"));
    }
    @Test
    public void passwordNoUpperCase () throws Exception
    {
        assertFalse(Validator.isValid("chosen!one1"));
    }
    @Test
    public void passwordValid () throws Exception
    {
        assertTrue(Validator.isValid("TheChosenOne!1"));
    }

}
