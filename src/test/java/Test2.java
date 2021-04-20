import cn.hutool.core.date.DatePattern;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

	public static void main(String[] args) {
		File file = new File("d://账单//微信支付账单(20210301-20210331).csv");

//		String filename = file.getName().toLowerCase();
//		System.out.println(filename);
//
//		System.out.println();

		String yearMonth ="2021-02"; //  终止时间：[2021-03-31 23:59:59]

		LocalDate date = LocalDate.parse(yearMonth+"-01", DatePattern.NORM_DATE_FORMATTER);

		LocalDateTime startDate = date.atStartOfDay();
		System.out.println(startDate.format(DatePattern.NORM_DATETIME_FORMATTER));

		LocalDate lastDate = date.with(TemporalAdjusters.lastDayOfMonth());

		LocalDateTime endDate = LocalDateTime.of(lastDate,LocalTime.MAX);
		System.out.println(endDate.format(DatePattern.NORM_DATETIME_FORMATTER));


//		RecordReader reader = new WeixinRecordReader();
//		List<Record> records = reader.getRecords(file);
//		for (Record record: records){
//			System.out.println(record);
//		}

	}
}
