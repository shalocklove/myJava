package Intact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonObject;

import net.sf.json.JSONObject;

public class DemoString {

	public static void main(String[] args) {
		//试用正则表达式
		// TODO Auto-generated method stub
		Reptile reptile = new Reptile();
		JSONObject json = reptile.getJson("http://www.wipo.int/madrid/gazette/query.jsp", "action=query&lang=en&page=null&year=2017&issue=26&chapter=1&country=BX&origin=on&interested=on&designated=on&irn=&holder=&brand=&type=ENN&start=0&rows=10&context=browse");
		String s = json.toString();
		System.out.println(s);
		String patternOocd = "oocd\":\"(\\w){0,}";
		Pattern r = Pattern.compile(patternOocd);
		Matcher m = r.matcher(s);
		
		System.out.println(patternOocd);
		while(m.find())
			System.out.println(m.group().substring(7));//I love Python
			
	}

}
