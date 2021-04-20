package com.eden.finance.goldcat.util;

import cn.hutool.core.date.DatePattern;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateUtils {

	public static LocalDateTime[] getMonthPeriod(String yearMonth){
		LocalDate date = LocalDate.parse(yearMonth+"-01", DatePattern.NORM_DATE_FORMATTER);
		LocalDateTime startDate = date.atStartOfDay();
//		System.out.println(startDate.format(DatePattern.NORM_DATETIME_FORMATTER));

		LocalDate lastDate = date.with(TemporalAdjusters.lastDayOfMonth());
		LocalDateTime endDate = LocalDateTime.of(lastDate, LocalTime.MAX);
//		System.out.println(endDate.format(DatePattern.NORM_DATETIME_FORMATTER));
		return new LocalDateTime[]{startDate,endDate};
	}
}
