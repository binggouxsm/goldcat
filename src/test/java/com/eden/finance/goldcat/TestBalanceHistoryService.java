package com.eden.finance.goldcat;

import com.eden.finance.goldcat.account.service.BalanceHistoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBalanceHistoryService {

	@Autowired
	private BalanceHistoryService balanceHistoryService;

	@Test
	public void testRecal(){
		balanceHistoryService.recalBalanceHistory(1,"2021-03");
	}

}
