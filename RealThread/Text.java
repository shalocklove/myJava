package RealThread;

import java.lang.management.ManagementFactory;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import RealThread.Demo;
import util.SQL;
import util.Sparit;

public class Text {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();

		DaoAdd daoAdd = new DaoAdd(list);
		Thread t = new Thread(daoAdd);
		t.start();
		
		//为什么不行
		DaoSparit daoSparit = new DaoSparit(list);
		boolean b = true;
		while(b){
			System.out.println("开始进程sdasd");
			if(list.size() >= 10){
//				t.sleep(1);
				synchronized(t){
					t.wait();//等待url列表生成
				}
//				System.out.println("开始进程");
				if(list.size() <= 10){
					b = false;
					System.out.println("b = false");
					
				}
				Thread t1 = new Thread(new DaoSparit(list.subList(0, 3)), "t1");
				Thread t2 = new Thread(new DaoSparit(list.subList(4, 6)), "t2");
				Thread t3 = new Thread(new DaoSparit(list.subList(7, 9)), "t3");
				System.out.println("开始启动1");
				t1.start();
				System.out.println("开始启动2");
				t2.start();
				System.out.println("开始启动3");
				t3.start();
				list.remove(list.subList(0, 9));
				synchronized(t){
					System.out.println("t.notify();");
					t.notify();
				}
			}
			System.out.println("main"+":"+list.size());
		}
	}

}
