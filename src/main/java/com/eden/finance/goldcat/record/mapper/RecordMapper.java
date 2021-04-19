package com.eden.finance.goldcat.record.mapper;

import com.eden.finance.goldcat.record.entity.ImportRecord;
import com.eden.finance.goldcat.record.entity.Record;
import tk.mybatis.mapper.common.Mapper;

/**
 * <p>
 * 记账记录 Mapper 接口
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
public interface RecordMapper extends Mapper<Record> {

	void clearRecord(ImportRecord importRecord);

}
