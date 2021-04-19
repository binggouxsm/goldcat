package com.eden.finance.goldcat.event;

import com.eden.finance.goldcat.record.entity.ImportRecord;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class AccountEventListener {

	@EventListener({RecaculateEvent.class})
	public void onEvent(RecaculateEvent event){
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMM");

		ImportRecord record = event.getData();
		String yearMonth = record.getStartDate().format(df);

		





	}
}
