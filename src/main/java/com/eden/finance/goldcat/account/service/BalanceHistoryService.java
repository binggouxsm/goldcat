package com.eden.finance.goldcat.account.service;

import cn.hutool.core.date.DateUtil;
import com.eden.finance.goldcat.account.entity.Account;
import com.eden.finance.goldcat.account.entity.BalanceHistory;
import com.eden.finance.goldcat.account.mapper.AccountMapper;
import com.eden.finance.goldcat.account.mapper.BalanceHistoryMapper;
import com.eden.finance.goldcat.record.entity.ImportRecord;
import com.eden.finance.goldcat.record.entity.Record;
import com.eden.finance.goldcat.record.mapper.RecordMapper;
import com.eden.finance.goldcat.system.entity.enums.TypeCode;
import com.eden.finance.goldcat.util.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 余额历史 服务类
 * </p>
 *
 * @author xsm
 * @since 2021-03-30
 */
@Service
public class BalanceHistoryService {

	@Autowired
	private BalanceHistoryMapper balanceHistoryMapper;

	@Autowired
	private RecordMapper recordMapper;

	@Autowired
	private AccountMapper accountMapper;

	public void recalBalanceHistory(Integer accountId, String yearMonth){

		LocalDateTime[] period = DateUtils.getMonthPeriod(yearMonth);
		LocalDateTime startDate = period[0];
		LocalDateTime endDate = period[1];
		LocalDate tmp = startDate.toLocalDate();
		LocalDate tmpEnd = endDate.toLocalDate();

		LocalDate now = LocalDate.now();

		Map<String,Object> map = new HashMap<>();
		map.put("accountId",accountId);
		map.put("startDate",startDate);
		map.put("endDate",endDate);

		BalanceHistory lastHist = balanceHistoryMapper.selectOne(new BalanceHistory().setAccountId(accountId).setHisdate(startDate.minusDays(1).toLocalDate()));

		List<BalanceHistory> histories = balanceHistoryMapper.queryMonth(map);
		int histIndex = 0;

		List<BalanceHistory> result = new ArrayList<>();

		List<Record> records = recordMapper.queryPeriod(map);
		int recordIndex = 0;

		Account account = accountMapper.selectByPrimaryKey(accountId);


		BigDecimal monthIn = new BigDecimal(0);
		BigDecimal monthOut = new BigDecimal(0);
		BigDecimal monthTransfer = new BigDecimal(0);

		while(tmp.compareTo(tmpEnd) <= 0 && tmp.compareTo(now) <=0){
			BigDecimal dayIn = new BigDecimal(0);
			BigDecimal dayOut = new BigDecimal(0);
			BigDecimal dayTransfer = new BigDecimal(0);

			while(recordIndex < records.size() && tmp.isEqual(records.get(recordIndex).getHappenTime().toLocalDate())){
				dayIn = (TypeCode.IN.getValue().equals(records.get(recordIndex).getRecordType())) ?
						dayIn.add(records.get(recordIndex).getAmount()) : dayIn;
				dayOut = (TypeCode.OUT.getValue().equals(records.get(recordIndex).getRecordType())) ?
						dayOut.add(records.get(recordIndex).getAmount()) : dayOut;
				dayTransfer = (TypeCode.TRANSFER.getValue().equals(records.get(recordIndex).getRecordType())) ?
						dayTransfer.add(records.get(recordIndex).getAmount()) : dayTransfer;
				recordIndex++;
			}

			monthIn = monthIn.add(dayIn);
			monthOut = monthOut.add(dayOut);
			monthTransfer = monthTransfer.add(dayTransfer);

			BalanceHistory nowHist = null;
			if(histIndex<histories.size() && tmp.isEqual(histories.get(histIndex).getHisdate())){
				nowHist = histories.get(histIndex);
				histIndex++;
			}else{
				nowHist = new BalanceHistory();
				nowHist.setAccountId(accountId);
				nowHist.setHisdate(tmp);
				nowHist.setCurrency(account.getCurrency());
			}


			if(lastHist != null){
				nowHist.setBeforeBalance(lastHist.getBalance());
			}else {
				nowHist.setBeforeBalance(BigDecimal.ZERO);
			}

			nowHist.setDayIn(dayIn);
			nowHist.setDayOut(dayOut);
			nowHist.setDayTransfer(dayTransfer);

			nowHist.setMonthIn(monthIn);
			nowHist.setMonthOut(monthOut);
			nowHist.setMonthTransfer(monthTransfer);

			nowHist.setBalance(nowHist.getBeforeBalance().add(dayIn).subtract(dayOut).add(dayTransfer));

			if(now.isEqual(tmp)){
				account.setBalance(nowHist.getBalance());
				account.setMonthIn(nowHist.getMonthIn());
				account.setMonthOut(nowHist.getMonthOut());
				account.setMonthTransfer(nowHist.getMonthTransfer());

				accountMapper.updateByPrimaryKeySelective(account);
			}

			result.add(nowHist);
			tmp = tmp.plusDays(1);
			lastHist = nowHist;
		}

		balanceHistoryMapper.batchInsert(result);
	}
}


