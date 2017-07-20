package Sparit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MabbyFinal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://www.wipo.int/madrid/gazette/query.jsp";
		BufferedReader in = null;
		String result = "";
		try {
			URL realURL = new URL(url);
			URLConnection conn = realURL.openConnection();
			//设置请求
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0");
			conn.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
			conn.setRequestProperty("Referer", "http://www.wipo.int/madrid/gazette/");
			conn.setRequestProperty("Content-Length", "128");
			conn.setRequestProperty("Cookie", "__utma=99021848.476904503.1500524887.1500524887.1500524887.1; __utmb=99021848.2.10.1500524887; __utmc=99021848; __utmz=99021848.1500524887.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmt=1");
			conn.setRequestProperty("Connection", "keep-alive");
			 // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
         // 获取URLConnection对象对应的输出流
            PrintWriter out = new PrintWriter(conn.getOutputStream());
         // 发送请求参数
            out.print("action=query&lang=en&page=null&year=2017&issue=26&chapter=1&country=&irn=&holder=&brand=&type=ENN&start=0&rows=90&context=browse");
            // flush输出流的缓冲
            out.flush();
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while((line = in.readLine())!= null){
            	result += line;
            }
            System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
