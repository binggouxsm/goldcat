package com.eden.finance.goldcat.record.service;

import com.eden.finance.goldcat.account.entity.Account;
import com.eden.finance.goldcat.account.mapper.AccountMapper;
import com.eden.finance.goldcat.event.RecaculateEvent;
import com.eden.finance.goldcat.record.entity.ImportRecord;
import com.eden.finance.goldcat.record.entity.Record;
import com.eden.finance.goldcat.record.mapper.RecordMapper;
import com.eden.finance.goldcat.record.reader.RecordReader;
import com.eden.finance.goldcat.record.reader.RecordReaderRegistry;
import com.eden.finance.goldcat.system.service.FileInfoService;
import com.eden.msutils.core.exception.BizException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Map;

/**
 * <p>
 * 记账记录 服务类
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@Service
public class RecordService {

	@Autowired
	private RecordMapper recordMapper;

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private FileInfoService fileInfoService;

	@Autowired
	private RecordReaderRegistry registry;

	@Autowired
	private ApplicationEventPublisher publisher;

	public void importRecord(Map<String, String> map) throws Throwable {
		File file = fileInfoService.getFile(map.get("fileId"));
		Account account = accountMapper.selectByPrimaryKey(map.get("accountId"));

		if(account== null || !account.getValidflag()){
			throw new BizException("该账户不存在");
		}

		RecordReader recordReader = registry.getReader(map.get("fileName"), account.getName());
		if(recordReader == null){
			throw new BizException("找不到对应格式的导入器");
		}

		ImportRecord records =  recordReader.getRecords(file);
		records.setAccountId(account.getAccountId());
		recordMapper.clearRecord(records);

		for (Record record: records.getRecords()){
			recordMapper.insertSelective(record);
		}

		records.setRecords(null);
		publisher.publishEvent(new RecaculateEvent("前端导入",records));

	}
}


