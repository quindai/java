package teste;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Date;

import org.json.simple.JSONObject;

public class SendJSON {
	JSONObject obj = new JSONObject();
	
	public SendJSON() {
		int i = 0;
		while(i++ < 10)
		try {
			URL url = new URL("http://localhost:5000/api/v1/sensors");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0");
			conn.setRequestProperty("Accept-Language", "pt-br");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			conn.setDoOutput(true);
			/*obj.put("nodeID", "2");
			obj.put("sensirion_temp", "343434");
			String dados = obj.toString();
			*/
			Date date =new Date();
			date.setTime(System.currentTimeMillis());
			String dados = String.format("nodeID=%s&sensirion_temp=%s&city=%s", 323, 343456,"Maceió");
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			//CharsetEncoder
			wr.write(dados.getBytes("UTF-8"));
			wr.flush();
			wr.close();
			//resposta do servidor
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			Thread.sleep(1000);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SendJSON();
	}
}
