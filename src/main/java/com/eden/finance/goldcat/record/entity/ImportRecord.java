package com.eden.finance.goldcat.record.entity;

import com.eden.finance.goldcat.record.entity.Record;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Accessors(chain = true)
public class ImportRecord {

	private Integer accountId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private List<Record> records = new ArrayList<>();

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
		for(Record record: records){
			record.setAccountId(accountId);
		}
	}
}
