package com.eden.finance.goldcat.record.reader;

import com.eden.finance.goldcat.record.entity.ImportRecord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class CSVRecordReader extends   AbstractRecordReader {

	@Override
	protected boolean check(File file) {
		return file.isFile() && file.exists() && file.getName().toLowerCase().endsWith(".csv");
	}

	@Override
	protected void readFile(File file, ImportRecord importRecord) {
		HandlerChain chain  = getChain();
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line;
			while ((line = reader.readLine()) !=null){
				String[] lineret = line.split(",");
				chain.reset();
				chain.doResolve(lineret, importRecord);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected abstract HandlerChain getChain();
}
