package bensoussan.iss;

import java.io.IOException;

import javax.swing.JList;

public class ISSOverheadRequestThread extends Thread{

	public ISSOverheadRequestThread(JList<String> list, String address){
		try {
			String[] times = getTimes(address);
			timeslist.setListData(times);
		} catch (IOException io) {
		}
	}
	
}
