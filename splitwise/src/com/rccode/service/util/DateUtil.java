package com.rccode.service.util;

import com.rccode.constant.AppConstant;

import java.text.ParseException;
import java.util.Date;

public class DateUtil {

    public static Date getCurrentDate() {
        return new Date();
    }

    public static long getStartSlot(String dateTimeStr) throws ParseException {
        Date date  = AppConstant.DATE_FORMAT.parse(dateTimeStr);
        return ((date.getTime() - AppConstant.OFFSET_TIME) / AppConstant.SLOT_INTERVAL);
    }

    public static long getEndSlot(String dateTimeStr) throws ParseException {
        Date date  = AppConstant.DATE_FORMAT.parse(dateTimeStr);
        return ((date.getTime() - 1 - AppConstant.OFFSET_TIME) / AppConstant.SLOT_INTERVAL);
    }

    public static String getSlotStartDateTime(long slot) {
        long startTime = slot * AppConstant.SLOT_INTERVAL + AppConstant.OFFSET_TIME;
        Date date = new Date(startTime);
        return AppConstant.DATE_FORMAT.format(date);
    }

    public static String getSlotEndDateTime(long slot) {
        return getSlotStartDateTime(slot + 1);
    }

}
