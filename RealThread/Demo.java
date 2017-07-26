package RealThread;

import java.io.IOException;
import java.util.List;

import util.Sparit;

public class Demo implements Runnable {
	
	public List list;
	String url = "";
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Sparit sparit = new Sparit();
		try {
			sparit.Connection("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Demo(List list){
		this.list = list;
		this.list.add("sadasd");
	}

}
