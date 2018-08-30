package com.alimuzaffar.testproject.ui.login.model;

import com.alimuzaffar.testproject.BR;
import com.alimuzaffar.testproject.R;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

public class LoginFields extends BaseObservable {

    private String email;
    private String password;
    public ObservableField<Integer> emailError = new ObservableField<>();
    public ObservableField<Integer> passwordError = new ObservableField<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        // Notify that the valid property could have changed.
        notifyPropertyChanged(BR.valid);
    }

    @Bindable
    public boolean isValid() {
        boolean valid = isEmailValid(false);
        valid = isPasswordValid(false) && valid;
        return valid;
    }

    public boolean isEmailValid(boolean setMessage) {
        // Minimum a@b.c
        if (email != null && email.length() > 5) {
            int indexOfAt = email.indexOf("@");
            int indexOfDot = email.lastIndexOf(".");
            if (indexOfAt > 0 && indexOfDot > indexOfAt && indexOfDot < email.length() - 1) {
                emailError.set(null);
                return true;
            } else {
                if (setMessage)
                    emailError.set(R.string.error_format_invalid);
                return false;
            }
        }
        if (setMessage)
            emailError.set(R.string.error_too_short);
        return false;
    }

    public boolean isPasswordValid(boolean setMessage) {
        if (password != null && password.length() > 5) {
            passwordError.set(null);
            return true;
        } else {
            if (setMessage)
                passwordError.set(R.string.error_too_short);
            return false;
        }
    }
}
