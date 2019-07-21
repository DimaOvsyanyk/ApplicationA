package com.dimaoprog.appa.utils;

import android.net.Uri;

public class Constants {

    public static final String REG_EXP_IMAGE_URL = "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|jpeg|gif|png|JPG|JPEG|GIF|PNG)";

    public static final int STATUS_LOADED = 1;
    public static final int STATUS_ERROR = 2;
    public static final int STATUS_UNKNOWN = 3;

    public static final String URL_PICKED = "com.dimaoprog.action.URL_PICKED";

    public static final String OPEN_START = "openStart";

    public static final String AUTHORITY = "com.dimaoprog.appa.data";
    public static final String DATABASE_TABLE_NAME = "image_link";
    public static final String DATABASE_NAME = "imagesDatabase";
    public static final Uri URI_IMAGE = Uri.parse("content://" + AUTHORITY + "/" + DATABASE_TABLE_NAME);
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_URL = "url";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_OPEN_TIME = "open_time";

}
