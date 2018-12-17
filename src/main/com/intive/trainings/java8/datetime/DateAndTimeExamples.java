package com.intive.trainings.java8.datetime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class DataAndTimeExamples {

    public static void main(String[] args) {
        //
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        int day = gregorianCalendar.get(Calendar.DAY_OF_WEEK);

        //
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
    }

}