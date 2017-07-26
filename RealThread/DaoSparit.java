package RealThread;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.net.URLConnection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import util.SQL;
import util.Sparit;

public class DaoSparit implements Runnable {
	private Sparit sparit = new Sparit();
	private List<String> url= new ArrayList<String>();
	private Iterator<String> iter = null;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (iter.hasNext()) {
			String string = "";
			string = iter.next();
			try {
				System.out.println(string);
				List<String> s = result(string);
				for (String string2 : s) {
					System.out.println(Thread.currentThread().getName()+string2);
					inMysql(Thread.currentThread().getName() + string2.substring(8).split("&")[0]);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + url.size());
		
	}
	public DaoSparit(){}
	public DaoSparit(List<String> url) {
		// TODO Auto-generated constructor stub
		this.url = url;
		iter = url.iterator();
	}
	public void setUrl(List<String> url){
		this.url = url;
	}
	public List<String> result(String url) throws IOException{
		URLConnection conn = sparit.Connection(url);
		String s = sparit.sendGet(conn, "UTF-8");
		String patternOocd = "FILE_NO[\\S]*\" target=\"body\">";
//		System.out.println(s);
		Pattern r = Pattern.compile(patternOocd);
		Matcher m = r.matcher(s);
		List<String> str = new ArrayList<String>();
		for(int i = 0; m.find(); i++){
			str.add(m.group());
		}
		return str;
	}
	private void inMysql(String s){
		SQL sql = new SQL();
		String sq = "insert into url (url) values ('"+ s +"')";
		Statement sta = sql.addJDBC("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8", "root", "sherlock");
		sql.change(sq, sta);
		try {
			sql.closeChange();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
