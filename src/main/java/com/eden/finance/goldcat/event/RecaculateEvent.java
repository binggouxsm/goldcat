package com.eden.finance.goldcat.event;

import com.eden.finance.goldcat.record.entity.ImportRecord;
import com.eden.msutils.boot.event.BaseEvent;

public class RecaculateEvent extends BaseEvent<ImportRecord> {

	public RecaculateEvent(Object source, ImportRecord data) {
		super(source, data);
	}
}
