package com.eden.finance.goldcat.record.reader;

import com.eden.finance.goldcat.record.entity.ImportRecord;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {

	private List<Handler> handlers = new ArrayList<>();

	private int pos = 0;

	public void addHandler(Handler handler){
		handlers.add(handler);
	}

	public void removeHandler(Handler handler){
		handlers.remove(handler);
	}

	public void doResolve(String[] line, ImportRecord importRecord) throws Exception{
		if(pos < handlers.size()){
			Handler handler = handlers.get(pos);
			pos++;
			handler.doResolve(this, line, importRecord);
		}
	}

	public void reset(){
		pos = 0;
	}

}
