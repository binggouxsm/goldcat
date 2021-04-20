package com.eden.finance.goldcat.event;

import cn.hutool.core.date.DatePattern;
import com.eden.finance.goldcat.account.service.BalanceHistoryService;
import com.eden.finance.goldcat.record.entity.ImportRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class AccountEventListener {

	@Autowired
	private BalanceHistoryService balanceHistoryService;

	@EventListener({RecaculateEvent.class})
	public void onEvent(RecaculateEvent event){
		ImportRecord record = event.getData();

		LocalDate startDate = record.getStartDate().toLocalDate();
		LocalDate endDate = record.getEndDate().toLocalDate();

		while (startDate.isBefore(endDate)){
			balanceHistoryService.recalBalanceHistory(record.getAccountId(), startDate.format(DatePattern.NORM_MONTH_FORMATTER));
			startDate = startDate.plusMonths(1);
		}
	}
}
