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

public class DaoSparit2 implements Runnable {
	private Sparit sparit = new Sparit();
	private String url = "";
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(url != ""){
			try {
				String s = sparit.sendGet(sparit.Connection(url));
				String patternOocd = "FILE_NO[\\S]*\" target=\"body\">";
				Pattern r = Pattern.compile(patternOocd);
				Matcher m = r.matcher(s);
				List<String> str = new ArrayList<String>();
				for(int i = 0; m.find(); i++){
					str.add(m.group());
				}
				for (String string2 : str) {
					System.out.println(Thread.currentThread().getName()+string2);
					inMysql(Thread.currentThread().getName() + string2.substring(8).split("&")[0]);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = "";
		}
	}
	public void setUrl(String url){
		this.url = url;
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
	public DaoSparit2(String url){
		setUrl(url);
	}
}