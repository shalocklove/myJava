package Sparit;
import java.awt.BufferCapabilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FirstSpatit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://www.wipo.int/madrid/gazette/";
		String result = "";
		
		try {
			URL realUrl = new URL(url);
			//建立连接
//			URLConnection connection = realUrl.openConnection();
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line = in.readLine()) != null){
				result += line + "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}

}
