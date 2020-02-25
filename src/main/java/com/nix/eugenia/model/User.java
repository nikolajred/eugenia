package com.nix.eugenia.model;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;

public class User {

    public Interval createRequest(int year, int month, int day, int startHour, int finishHour, int minut, int second){
        DateTimeZone timeZone = DateTimeZone.forID("Europe/Paris");
        DateTime start = new DateTime(year, month, day, startHour, minut, second, timeZone);
        DateTime end = new DateTime(year, month, day, finishHour, minut, second, timeZone);
        Interval interval = new Interval(start, end);
        return interval;
    }




}
