package com.example.oromil.boilerppate.utils;

import android.widget.EditText;

public class StringUtils {
    public static String getStringFromEditText(EditText editText){
        return editText.getText().toString();
    }
}
