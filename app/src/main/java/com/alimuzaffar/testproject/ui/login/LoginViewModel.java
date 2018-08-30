package com.alimuzaffar.testproject.ui.login;

import android.view.View;
import android.widget.EditText;

import com.alimuzaffar.testproject.ui.login.model.LoginFields;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private LoginFields login;
    private View.OnFocusChangeListener onFocusEmail;
    private View.OnFocusChangeListener onFocusPassword;
    private MutableLiveData<LoginFields> buttonClick = new MutableLiveData<>();

    void init() {
        login = new LoginFields();
        onFocusEmail =  new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText().length() > 0 && !focused) {
                    login.isEmailValid(true);
                }
            }
        };

        onFocusPassword = new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean focused) {
                EditText et = (EditText) view;
                if (et.getText().length() > 0 && !focused) {
                    login.isPasswordValid(true);
                }
            }
        };
    }

    public LoginFields getLogin() {
        return login;
    }

    public View.OnFocusChangeListener getEmailOnFocusChangeListener() {
        return onFocusEmail;
    }

    public View.OnFocusChangeListener getPasswordOnFocusChangeListener() {
        return onFocusPassword;
    }

    public void onButtonClick() {
        if (login.isValid()) {
            buttonClick.setValue(login);
        }
    }

    public MutableLiveData<LoginFields> getButtonClick() {
        return buttonClick;
    }

    @BindingAdapter("error")
    public static void setError(EditText editText, Object strOrResId) {
        if (strOrResId instanceof Integer) {
            editText.setError(editText.getContext().getString((Integer) strOrResId));
        } else {
            editText.setError((String) strOrResId);
        }

    }

    @BindingAdapter("onFocus")
    public static void bindFocusChange(EditText editText, View.OnFocusChangeListener onFocusChangeListener) {
        if (editText.getOnFocusChangeListener() == null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }
}
