package com.rccode.constant;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class AppConstant {
    public static final String EXIT_COMMAND = "exit";
    public static long OFFSET_TIME = 1629005400000L; //15th August 2021 IST
    public static long SLOT_INTERVAL = 3600000; //1 Hour
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    public static final DecimalFormat DF2 = new DecimalFormat("#.##");
}
