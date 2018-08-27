package com.alimuzaffar.testproject;

import com.alimuzaffar.testproject.ui.login.LoginViewModel;
import com.alimuzaffar.testproject.ui.login.model.LoginForm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void fields_isCorrect() {
        LoginViewModel vm = new LoginViewModel();
        vm.init();
        LoginForm form = vm.getForm();
        form.getFields().setEmail("Hello@world.com");
        form.getFields().setPassword("123456");
        assertTrue("Form is not valid", form.isValid());
    }

    @Test
    public void email_isShort() {
        LoginViewModel vm = new LoginViewModel();
        vm.init();
        LoginForm form = vm.getForm();
        form.getFields().setEmail("a@b.c");
        form.getFields().setPassword("123456");
        assertTrue("Email should be invalid", !form.isEmailValid(true));
        assertTrue("Password should be valid", form.isPasswordValid(false));
        assertTrue("Form is valid, email should be invalid", !form.isValid());
        assertEquals("Error message should be \"Too short\" not " + form.getEmailError(), "Too short", form.getEmailError());
    }

    @Test
    public void email_isWrongFormat() {
        LoginViewModel vm = new LoginViewModel();
        vm.init();
        LoginForm form = vm.getForm();
        form.getFields().setEmail("aaa@baac");
        form.getFields().setPassword("123456");
        assertTrue("Email should be invalid", !form.isEmailValid(true));
        assertTrue("Password should be valid", form.isPasswordValid(false));
        assertTrue("Form is invalid, email should be invalid", !form.isValid());
        assertEquals("Error message should be \"Format is invalid\" not " + form.getEmailError(), "Format is invalid", form.getEmailError());
    }

    @Test
    public void password_isShort() {
        LoginViewModel vm = new LoginViewModel();
        vm.init();
        LoginForm form = vm.getForm();
        form.getFields().setEmail("a@b.cc");
        form.getFields().setPassword("1234");
        assertTrue("Email should be valid", form.isEmailValid(false));
        assertTrue("Password should be invalid", !form.isPasswordValid(true));
        assertTrue("Form is invalid, password should be invalid", !form.isValid());
        assertEquals("Error message should be \"Too short\" not " + form.getPasswordError(), "Too short", form.getPasswordError());
    }

}