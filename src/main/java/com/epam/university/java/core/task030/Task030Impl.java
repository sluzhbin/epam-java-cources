package com.epam.university.java.core.task030;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Task030Impl implements Task030 {

    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        if(dateStart == null || dateEnd == null) {
            throw new IllegalArgumentException();
        }
        Period period = Period.between(dateStart, dateEnd);
        return period.getDays();
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        LocalDate nextDate = dateStart.plusDays(daysToAdd);
        return nextDate;
    }

    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {
        Duration duration = Duration.between(instantStart, instantEnd);
        return duration.getSeconds();
    }

    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        return localDate.getDayOfWeek();
    }

    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        int dayOfWeek = localDate.getDayOfWeek().getValue();
        return localDate.plus(Period.ofDays(6 - dayOfWeek));
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        return LocalTime.parse(timeString, DateTimeFormatter.ofPattern("hh:mma"));
    }

}
