package PageObjectClasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MailBox {
	
		
	/**
	 * Method to get either the verification URL or the text from the email body. 
	 * @param email - String type parameter. The email.
	 * @param cssSelector - String type parameter. The CSS selector to select the element on the mail body page.
	 * @param data - Integer type parameter. 1 = verification link, 2 = Text data 
	 * @return - String type return value with either URL or the text data. Blank string if no data found or any exception occurs.
	 */
	public String getEmailData(String email, String cssSelector, int data) {
		try {
			String breakEmail[] = email.split("@"); 
			URL url = new URL("https://www.1secmail.com/api/v1/?action=getMessages&login="+breakEmail[0]+"&domain="+breakEmail[1]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "+ conn.getResponseCode());
            }
            InputStreamReader content = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(content);
            String output;
            String finalOutput = "";
            while ((output = br.readLine()) != null) {
                finalOutput = output;
            }
            JSONTokener tokener = new JSONTokener(finalOutput.substring(1, finalOutput.length()-1));
            JSONObject json = new JSONObject(tokener);
            url = new URL("https://www.1secmail.com/api/v1/?action=readMessage&login="+breakEmail[0]+"&domain="+breakEmail[1]+"&id="+json.get("id"));
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code after id retrieval: "+ conn.getResponseCode());
            }
            content = new InputStreamReader(conn.getInputStream());
            br = new BufferedReader(content);
            finalOutput = "";
            while ((output = br.readLine()) != null) {
                finalOutput = output;
            }
            conn.disconnect();
            tokener = new JSONTokener(finalOutput);
            json = new JSONObject(tokener);
            Document doc = Jsoup.parse((String) json.get("htmlBody"));
            Elements element = doc.select(cssSelector);
            if(data == 1) {
            	return element.attr("href");
            }
            else {
            	return element.text();
            }
		}
		catch(Exception e) {
			return "";
		}
	}
	/**
	 * Method to get either the verification URL or the text from the email body. 
	 * @param email - String type parameter. The email.
	 * @param cssSelector - String type parameter. The CSS selector to select the element on the mail body page.
	 * @param data - Integer type parameter. 1 = verification link, 2 = Text data 
	 * @return - String type return value with either URL or the text data. Blank string if no data found or any exception occurs.
	 */
	public String getEmailData(String email, String cssSelector, int data , int emailNo) {
		try {
			String breakEmail[] = email.split("@"); 
			URL url = new URL("https://www.1secmail.com/api/v1/?action=getMessages&login="+breakEmail[0]+"&domain="+breakEmail[1]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "+ conn.getResponseCode());
            }
            InputStreamReader content = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(content);
            String output;
            String finalOutput = "";
            while ((output = br.readLine()) != null) {
                finalOutput = output;
            }
            JSONArray array = new JSONArray(finalOutput);
            JSONTokener tokener = new JSONTokener(array.get(emailNo).toString());
            JSONObject json = new JSONObject(tokener);
            url = new URL("https://www.1secmail.com/api/v1/?action=readMessage&login="+breakEmail[0]+"&domain="+breakEmail[1]+"&id="+json.get("id"));
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code after id retrieval: "+ conn.getResponseCode());
            }
            content = new InputStreamReader(conn.getInputStream());
            br = new BufferedReader(content);
            finalOutput = "";
            while ((output = br.readLine()) != null) {
                finalOutput = output;
            }
            conn.disconnect();
            tokener = new JSONTokener(finalOutput);
            json = new JSONObject(tokener);
            Document doc = Jsoup.parse((String) json.get("htmlBody"));
            Elements element = doc.select(cssSelector);
            if(data == 1) {
            	return element.attr("href");
            }
            else {
            	return element.text();
            }
		}
		catch(Exception e) {
			return "";
		}
	}



}
