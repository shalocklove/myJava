package RealThread;

public class Text3 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread[] t = new Thread[10];
		//控制线程数
		int i = 0;
		String url = "";
		boolean b = true;
		DaoAdd2 daoAdd2 = new DaoAdd2();
		Thread daoAdd = new Thread(daoAdd2);
		daoAdd.start();
		System.out.println("daoAdd开始");
		while(b){
			System.out.println(daoAdd2.getList().size());
			if(daoAdd2.getList().size() >= 10){
				for(i = 0; i <= 9; i++){
					synchronized(daoAdd2){
						url = daoAdd2.getList().get(0);
						System.out.println("删除" + url);
						daoAdd2.removeList(url);
					}
					t[i] = new Thread(new DaoSparit2(url), String.valueOf(i));
					t[i].start();
					System.out.println(t[i].getName() + "开始" + i);
					System.out.println(url);
					
					b = false;
				}
			}
		}
		b = true;
		while(b){
			for(i = 0; i < 10; i++){
				if(!t[i].isAlive()){
					if(daoAdd2.getList().size() > 0){
						synchronized(daoAdd2){
							url = daoAdd2.getList().get(0);
							System.out.println("删除" + url);
							daoAdd2.removeList(url);
						}
						t[i] = new Thread(new DaoSparit2(url), String.valueOf(i));
						t[i].start();
						System.out.println(t[i].getName() + "开始" + i);
						System.out.println(url);
					}
				}
			}
		}
	}

}
