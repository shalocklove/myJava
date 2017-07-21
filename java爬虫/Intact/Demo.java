package Intact;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Demo {

	public static void main(String[] args) {
		Reptile reptile = new Reptile();
		JSONObject json = reptile.getJson("http://www.wipo.int/madrid/gazette/query.jsp", "action=query&lang=en&page=null&year=2017&issue=26&chapter=1&country=BX&origin=on&interested=on&designated=on&irn=&holder=&brand=&type=ENN&start=0&rows=10&context=browse");
		JSONArray docs = (JSONArray) json.get("docs");
		System.out.println(docs);
		JSONObject j;
		System.out.println(docs.size());
		List<Bean> l = new ArrayList<Bean>();
		
		for (int i = 0; i < docs.size(); i++) {
			Bean e = new Bean();
			j = docs.getJSONObject(i);
			System.out.println(j.get("irn"));
			e.setGazette(j.get("year") + "/" + j.get("issue"));
			e.setHolder((String)j.get("holder"));
			e.setIRN((String)j.get("irn"));
			e.setMark("http://www.wipo.int/madrid/gazette/" + j.get("image"));
			e.setOrigin((String)j.get("oocd"));
			e.setTransacition("Registration");
			l.add(e);
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "sherlock");
			Statement stmt = (Statement) con.createStatement();
			for (Bean bean : l) {
				stmt.executeUpdate("insert into demo1 (Mark, IRN, Origin, Holder, Transacition, Gazette)"+
				"values('"+bean.getMark()+"','"+bean.getIRN()+"','"+bean.getOrigin()+"','"+bean.getHolder()+"','"+bean.getTransacition()+"','"+bean.getGazette()+"')");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}
		System.out.println(l.size());
	}

}
