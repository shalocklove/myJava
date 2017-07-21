package NewSparit721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = null;
		try {
			String result = "";
			URL url = new URL("https://search.ipaustralia.gov.au/trademarks/search/view/1848981?s=6c6e34c5-22aa-4487-813d-6911f12122f0");
			URLConnection conn = url.openConnection();
			conn.connect();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line = in.readLine()) != null){
				result += line + "\n";
//				System.out.println(line);
			}
			String s = "src=\"https://(.*)\"";
			String s2 = "i aria-hidden=\"true\"\nclass=\"status pending\">\n&#9679;\n</i>\n(.*)\n</dd>";
			Map<String, String> m = new HashMap<String, String>();
			m.put("img", s);
			m.put("status", s2);
			for(Map.Entry<String, String> st : m.entrySet()){
				Pattern r = Pattern.compile(st.getValue());
				Matcher a = r.matcher(result);
			
				while(a.find())
				System.out.println(st.getKey() + ":" + a.group().substring(5, a.group().length() - 1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			in.close();
		}
	}

}
