package ThreadSparit;

import java.io.IOException;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.SQL;
import util.Sparit;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sparit sparit = new Sparit();
		String parameter = "action=query&lang=en&page=null&year=2017&issue=27&chapter=1&country=&irn=&holder=&brand=&type=ENN&start=0&rows=4&context=browse";
		String url = "http://www.wipo.int/madrid/gazette/query.jsp";
		Map<String, String> map = new HashMap<String, String>();
		map.put("Host", "www.wipo.int");
		map.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0");
		map.put("Accept", "application/json, text/javascript, */*; q=0.01");
		map.put("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		map.put("Accept-Encoding", "gzip, deflate");
		map.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		map.put("X-Requested-With", "XMLHttpRequest");
		map.put("Refere", "http://www.wipo.int/madrid/gazette/");
		map.put("Content-Length", "128");
		map.put("Cookie", "__utma=99021848.476904503.1500524887.1500865193.1500881182.6; __utmz=99021848.1500524887.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmc=99021848; __utmb=99021848.2.10.1500881182; __utmt=1");
		map.put("Connection", "keep-alive");
		try {
			URLConnection conn = sparit.Connection(url, map);
			String result = sparit.sendPost(conn, parameter);
			JSONObject jsonObject = JSONObject.fromObject(result);
			System.out.println(jsonObject);
			JSONArray jsonArray = (JSONArray) jsonObject.get("docs");
			System.out.println(jsonArray.get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQL sql = new SQL();
		String str = "insert into demo1 (Mark, IRN, Origin, Holder, Transacition, Gazette)values('?','?','?','?','?','?')" ;
		String s = MessageFormat.format(str, "sad", " ", " "," "," "," ");
		Connection con = (Connection) sql.connection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8","root","sherlock");
		sql.change(s, con);
		sql.closeChange();
	}
	

}
