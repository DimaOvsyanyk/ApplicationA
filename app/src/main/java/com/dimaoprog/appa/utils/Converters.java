package com.dimaoprog.appa.utils;

import android.graphics.Color;

import static com.dimaoprog.appa.utils.Constants.STATUS_ERROR;
import static com.dimaoprog.appa.utils.Constants.STATUS_LOADED;
import static com.dimaoprog.appa.utils.Constants.STATUS_UNKNOWN;

public class Converters {

    public static String longToString(long value) {
        return value == 0 ? "" : String.valueOf(value);
    }

    public static String statusToString(int status) {
        switch (status) {
            case STATUS_LOADED:
                return "loaded";
            case STATUS_ERROR:
                return "error";
            case STATUS_UNKNOWN:
                return "unknown";
            default:
                return "";
        }
    }

    public static int statusToColor(int status) {
        switch (status) {
            case STATUS_LOADED:
                return Color.parseColor("#8070FC7F");
            case STATUS_ERROR:
                return Color.parseColor("#80F76B6B");
            case STATUS_UNKNOWN:
                return Color.parseColor("#80C4C4C4");
            default:
                return Color.parseColor("#FFFFFF");
        }
    }
}
