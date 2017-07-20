package Intact;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONObject;

public class Reptile {
	private URL Url;
	private String resulr = "";//输出结果
	private String parameter;//参数
	private JSONObject json;
	private BufferedReader in;
	
	public JSONObject getJson(String url, String parameter){
		try {
			Url = new URL(url);
			//建立连接
			URLConnection conn = Url.openConnection();
			//设置请求
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0");
			conn.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
			conn.setRequestProperty("Referer", "http://www.wipo.int/madrid/gazette/");
			conn.setRequestProperty("Content-Length", "168");
			conn.setRequestProperty("Cookie", "__utma=99021848.476904503.1500524887.1500524887.1500524887.2; __utmc=99021848; __utmz=99021848.1500524887.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmb=99021848.9.10.1500524887; __utmt=1");
			conn.setRequestProperty("Connection", "keep-alive");
			// 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
			//获取URLConnection对象对应的输出流
            PrintWriter out = new PrintWriter(conn.getOutputStream());
            //发送请求参数
            out.print(parameter);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line = in.readLine()) != null){
            	resulr += line;
            }
        	System.out.println(resulr);
            json = JSONObject.fromObject(resulr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
}
