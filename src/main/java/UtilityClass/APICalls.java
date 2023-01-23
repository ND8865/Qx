package UtilityClass;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;

import PageObjectClasses.MailBox;
import PageObjectClasses.SignIn_Admin_Pages;

public class APICalls {
	
	/**
	 * Method to call login API and extract the authentication token.
	 * @param username - String type parameter. The user name
	 * @param password - String type parameter. The password
	 * @return - String type return value. The authentication token.
	 */
	public static String apiLogin(String username, String password) {
		try {
			String clientId = Utility.getPropertiesFile("resources", "clientId").trim();
			String requestUrl = Utility.getPropertiesFile("resources", "requestUrl").trim();
			String redirectUrl = Utility.getPropertiesFile("resources", "redirectUrl").trim();
			URL url = new URL(requestUrl+"/login?response_type=code&client_id="+clientId+"&redirect_uri="+redirectUrl+"&scope=email+profile+openid+aws.cognito.signin.user.admin+https://api.stage.acqyrexchange-dev.com/gamer");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
                throw new RuntimeException("Failed : HTTP Error code Step 1 : "+ conn.getResponseCode());
            }
            String cookie1 = conn.getHeaderField("Set-Cookie");
            
            InputStreamReader content = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(content);
            String output;
            StringBuilder sb = new StringBuilder();
            while ((output = br.readLine()) != null) {
              sb.append(output);
            }
            Pattern pattern = Pattern.compile("name=\"_csrf\" value=\"(.*?)\"/>");
            Matcher matcher = pattern.matcher(sb);
            String csrf = "";
            if (matcher.find())
            {
                csrf = matcher.group(1);
            }
		
            
            String cognitoAsfData = Utility.getPropertiesFile("resources", "cognitoAsf").trim();
            String postParameters = "signInSubmitButton=Sign%20in&password="+password+"&_csrf="+csrf+"&cognitoAsfData="+cognitoAsfData+"&username="+username;
            byte[] postData = postParameters.getBytes( StandardCharsets.UTF_8 );
            int postDataLength = postData.length;
            url = new URL(requestUrl+"/login?scope=email%20profile%20openid%20aws.cognito.signin.user.admin%20https://api.stage.acqyrexchange-dev.com/gamer&response_type=code&redirect_uri="+redirectUrl+"&client_id="+clientId);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setInstanceFollowRedirects(false);
            conn.setDoOutput(true);
            conn.setRequestProperty("Cookie", cookie1);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataLength ));
            conn.setUseCaches(false);
            
            conn.connect();
			try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
				wr.write(postData);
			}
            
            if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
                throw new RuntimeException("Failed : HTTP Error code Step 2: "+ conn.getResponseCode());
            }
            
            List<String> cookies = conn.getHeaderFields().get("Set-Cookie");
         
            String code = "";
            String location = conn.getHeaderField("Location");
            
            code = location.substring(location.indexOf("=")+1);
            conn.disconnect();
            
            
            
            url = new URL(requestUrl+"/oauth2/token?code="+code+"&grant_type=authorization_code&client_id="+clientId+"&redirect_uri="+redirectUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setInstanceFollowRedirects(true);
            String cookieData = "";
            for (String cookie : cookies) {
            	if(cookie.split(";", 2)[0].split("=")[1].length()>5) 
            	{
            		cookieData = cookie.split(";", 2)[0] + "; " +cookieData ;
            	} 	 	  
            }
            cookieData = cookieData.substring(0, cookieData.length()-2);
            cookieData= cookieData.replace("\"", "");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            conn.setRequestProperty("Cookie", cookieData);
            if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
                throw new RuntimeException("Failed : HTTP Error code Step 3: "+ conn.getResponseCode());
            }
            
            content = new InputStreamReader(conn.getInputStream());
            br = new BufferedReader(content);
            String finalOutput = "";
            while ((output = br.readLine()) != null) {
                finalOutput = output;
            }
            JSONTokener tokener = new JSONTokener(finalOutput);
            JSONObject json = new JSONObject(tokener);
            
            String key = (String) json.get("access_token");
            
			return key;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : apiLogin " + e);
			return "";
		}
	}
	
	/**
	 * Method to get the name, description, description text and icon url from the admin api.
	 * @param auth - String type paramter. Authentication token by using login api.
	 * @return - ArrayList of array of Strings type with data.
	 */
	public static ArrayList<String[]> getTotalPublishedGamesInfoFromAdmin(String auth) {
		try {
			ArrayList<String[]> games = new ArrayList<String[]>();
			String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
			int page = 1;
			int count = 1;
			while(count <= page) {
				URL url = new URL(apiUrl+"/admin/games?perPage=10&page="+count);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Accept", "application/json");
	            conn.setRequestProperty("Authorization", "Bearer "+auth);
	            if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	                throw new RuntimeException("Failed : HTTP Error code Step 1: "+ conn.getResponseCode());
	            }
	            
	            InputStreamReader content = new InputStreamReader(conn.getInputStream());
	            BufferedReader br = new BufferedReader(content);
	            String output;
	            String finalOutput = "";
	            while ((output = br.readLine()) != null) {
	                finalOutput = output;
	            }
	            JSONTokener tokener = new JSONTokener(finalOutput);
	            JSONObject json = new JSONObject(tokener);
	            
	            String pages = json.getJSONObject("data").getJSONObject("meta").get("pages").toString();
	            page = Integer.parseInt(pages);
	            count++;
	            JSONArray ob= (JSONArray) json.getJSONObject("data").get("game_data");
	            
	            for(int i =0 ; i < ob.length(); i++) {
	            	tokener = new JSONTokener(ob.get(i).toString());
	            	json = new JSONObject(tokener);
	            	if((!json.get("approved_date").toString().equals("null")) && (json.get("status").toString().equals("3"))) {
	            		String data[] = new String[4];
	            		data[0] = json.get("name").toString();
	            		Document doc = Jsoup.parse(json.get("description").toString());
	            		data[1] = doc.getElementsByTag("p").text();
	            		data[2] = json.get("description_text").toString();
	            		data[3] = json.get("icon_url").toString();
	            		games.add(data);
	            	}
	            }
			}          
			return games;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : getTotalPublishedGamesInfoFromAdmin " + e);
			return null;
		}
	}
	
	/**
	 * Method to create a game as a partner and send for approval. 
	 * @param auth - String type parameter. Use {@link apiLogin} to get authentication token.
	 * @param gameName - String type parameter. 
	 * @param description - String type parameter.
	 * @param picUrl - String type parameter. Use {@link getTotalPublishedGamesInfoFromAdmin} with index 3 to get any image URL.
	 * @return - game id if sent for approval else blank string.
	 */
	public static String createGame(String auth, String gameName, String description, String picUrl, String downloadUrl) {
		try {
			JSONObject body = new JSONObject();
            body.put("name", gameName);
            body.put("icon_url", picUrl);
            body.put("description", "<p>"+description+"</p>");
            JSONArray array = new JSONArray();
            array.put(downloadUrl);
            body.put("download_urls",array);
            body.put("description_text", description);
            body.put("game_id", "");
            JSONArray array1 = new JSONArray();
            body.put("game_assets", array1);
            String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
            URL url = new URL(apiUrl+"/partner/games");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer "+auth);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(body.toString());
            wr.close();
           
            if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
                throw new RuntimeException("Failed : HTTP Error code Step 1: "+ conn.getResponseCode());
            }
            InputStreamReader content = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(content);
            String finalOutput = "";
            String output;
            while ((output = br.readLine()) != null) {
                finalOutput = output;
            }
            JSONTokener tokener = new JSONTokener(finalOutput);
            JSONObject json = new JSONObject(tokener);
			String id = json.getJSONObject("data").get("game_id").toString();
            
			body = new JSONObject();
            body.put("name", gameName);
            body.put("icon_url", picUrl);
            body.put("description", "<p>"+description+"</p>");
            array = new JSONArray();
            array.put(downloadUrl);
            body.put("download_urls",array);
            body.put("description_text", description);
            body.put("game_id", id);
            body.put("status", "2");
            array1 = new JSONArray();
            body.put("game_assets", array1);
            url = new URL(apiUrl+"/partner/games");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Authorization", "Bearer "+auth);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(body.toString());
            wr.close();
           
            if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
                throw new RuntimeException("Failed : HTTP Error code Step 2: "+ conn.getResponseCode());
            }
            return id;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : createGame " + e);
			return "";
		}
	}
	
	/**
	 * Method to approve the game as an Admin.
	 * @param authToken - String type parameter. Use {@link apiLogin} to get authentication token.
	 * @param gameId - String type parameter. The game id. Use {@link createGame} to get the recently created game id.
	 * @return - true if approved.
	 */
	public static boolean approveGame(String authToken, String gameId) {
		try {
			String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
			URL url = new URL(apiUrl+"/admin/games/"+gameId);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer "+authToken);
            conn.setRequestProperty("Content-Type", "application/json");
            if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
                throw new RuntimeException("Failed : HTTP Error code Step 1: "+ conn.getResponseCode());
            }
            
            InputStreamReader content = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(content);
            String finalOutput = "";
            String output;
            while ((output = br.readLine()) != null) {
                finalOutput = output;
            }
            
            JSONTokener tokener = new JSONTokener(finalOutput);
            JSONObject json = new JSONObject(tokener);
            
            String partnerId = json.getJSONObject("data").getString("partner_id").toString();
            
            
            JSONObject body = new JSONObject();
            body.put("gameId", gameId);
            body.put("partnerId", partnerId);
            body.put("status", "3");
            JSONArray array1 = new JSONArray();
            body.put("game_assets", array1);
            url = new URL(apiUrl+"/admin/partner-games/status");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Authorization", "Bearer "+authToken);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(body.toString());
            wr.close();
           
            if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
                throw new RuntimeException("Failed : HTTP Error code Step 2: "+ conn.getResponseCode());
            }
            return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : approveGame " + e);
			return false;
		}
	}
	
	/**
	 * Method to get the offer id, name, description text, partner name, game name, start date and end date from the gamer API for offers.
	 * @param auth - String type parameter. Authentication token by using login api.
	 * @return - ArrayList of array of Strings type with data.
	 */
	public static ArrayList<String[]> getTotalOffersListFromGamer(String auth) {
		try {
			ArrayList<String[]> offers = new ArrayList<String[]>();
			String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
			URL url = new URL(apiUrl+"/gamer/offers?games=all");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer "+auth);
            if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
                throw new RuntimeException("Failed : HTTP Error code Step 1: "+ conn.getResponseCode());
            }
            
            InputStreamReader content = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(content);
            String output;
            String finalOutput = "";
            while ((output = br.readLine()) != null) {
                finalOutput = output;
            }
            JSONTokener tokener = new JSONTokener(finalOutput);
            JSONObject json = new JSONObject(tokener);
            
            JSONArray ob= (JSONArray) json.get("data");
            
            for(int i =0 ; i < ob.length(); i++) {
            	tokener = new JSONTokener(ob.get(i).toString());
            	json = new JSONObject(tokener);
            	String data[] = new String[6];
        		data[0] = json.get("offerId").toString();
        		data[1] = json.get("offerName").toString();
        		data[2] = json.get("offerDescription").toString();
        		String stDate = json.get("startDate").toString().substring(0, 11);
        		String endDate = json.get("endDate").toString().substring(0, 11);
        		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        		SimpleDateFormat format2 = new SimpleDateFormat("dd MMMM yyyy");
        		Date d = format1.parse(stDate);
        		data[3] = format2.format(d);
        		d = format1.parse(endDate);
        		data[4] = format2.format(d);
        		data[5] = json.get("gameName").toString();
        		offers.add(data);
            }
			return offers;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : getTotalOffersListFromAdmin " + e);
			return null;
		}
	}
	
	/**
	 * Method to get the name, description text, achievement name, achievement description text, reward value, game name, start date and end date of an offer.
	 * @param auth - String type parameter. Authentication token by using login api.
	 * @param offerId - String type parameter. The offer id for which the details are needed.
	 * @return - ArrayList of array of Strings type with data.
	 */
	public static String[] getOfferDetails(String auth, String offerId) {
		try {
			String offerDetails[] = new String[8];
			String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
			URL url = new URL(apiUrl+"/offers/"+offerId);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer "+auth);
            if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
                throw new RuntimeException("Failed : HTTP Error code Step 1: "+ conn.getResponseCode());
            }
            
            InputStreamReader content = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(content);
            String output;
            String finalOutput = "";
            while ((output = br.readLine()) != null) {
                finalOutput = output;
            }
            JSONTokener tokener = new JSONTokener(finalOutput);
            JSONObject json = new JSONObject(tokener);
            
            offerDetails[0] = json.getJSONObject("data").get("name").toString();
            offerDetails[1] = json.getJSONObject("data").get("description_text").toString();
            JSONArray ob = json.getJSONObject("data").getJSONArray("OfferAchievements");
            JSONTokener tokener1 = new JSONTokener(ob.get(0).toString());
            JSONObject json1 = new JSONObject(tokener1);
            offerDetails[2] = json1.get("name").toString();
            offerDetails[3] = json1.get("description_text").toString();
            offerDetails[4] = json.getJSONObject("data").getJSONObject("OfferReward").get("reward_value").toString();
            offerDetails[5] = json.getJSONObject("data").getJSONObject("OfferSchedule").getJSONObject("Game").get("name").toString();
            String stDate = json.getJSONObject("data").getJSONObject("OfferSchedule").get("start_date").toString();
            String endDate = json.getJSONObject("data").getJSONObject("OfferSchedule").get("end_date").toString();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    		SimpleDateFormat format2 = new SimpleDateFormat("dd MMMM yyyy");
    		Date d = format1.parse(stDate);
            offerDetails[6] = format2.format(d);
            d = format1.parse(endDate);
            offerDetails[7] = format2.format(d); 
            
			return offerDetails;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : getOfferDetails " + e);
			return null;
		}
	}
	
	/**
	 * Method to get transaction id of the latest transaction.
	 * @param auth - String type parameter. Authentication token by using login api.
	 * @return ArrayList of array of Strings type with data.
	 */
	public static String redeemRequest(String auth) {
		try {
            String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
            URL url = new URL(apiUrl+"/admin/redeem/tx?sortOrder=ASC&perPage=10&page=1&sortBy=createdAt");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer "+auth);
            if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
                throw new RuntimeException("Failed : HTTP Error code Step 1: "+ conn.getResponseCode());
            }
            
            InputStreamReader content = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(content);
            String output;
            String finalOutput = "";
            while ((output = br.readLine()) != null) {
                finalOutput = output;
            }
            JSONTokener tokener = new JSONTokener(finalOutput);
            JSONObject json = new JSONObject(tokener);
            
            JSONArray obj = json.getJSONArray("redeemTransactionsList");
            JSONTokener tokener1 = new JSONTokener(obj.get(0).toString());
            JSONObject json1 = new JSONObject(tokener1);
            //String redeemRequestID = json1.get("redeemRequestId").toString();
            String transactionID = json1.get("transactionId").toString();
            
			return transactionID;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : redeemRequest " + e);
			return null;
		}
	}
	/**
	 * Method to reject the requested redeem request.
	 * @param auth - String type parameter. Authentication token by using login api.
	 * @param transactionID - String type parameter . Taking from another api.
	 * @return true - if rejected successfully.
	 */
	public static boolean rejectRedeemRequest(String auth, String transactionID, String rejectReason) {
		try {
			JSONObject body = new JSONObject();
			body = new JSONObject();
            body.put("transactionId", transactionID);
            body.put("isAccepted", false);
            body.put("rejectionReason", rejectReason);
            String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
            URL url = new URL(apiUrl+"/admin/redeem/tx/"+transactionID);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Authorization", "Bearer "+auth);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(body.toString());
            wr.close();
           
            if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
               throw new RuntimeException("Failed : HTTP Error code Step 1: "+ conn.getResponseCode());
            }
           
            return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : rejectRedeemRequest " + e);
			return false;
		}
	}
	
	/**
	 * Method to sign up as a gamer and fill information.
	 * @param username
	 * @param email
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public static boolean prepareGamerAccount(String username, String email, String password, String firstName, String lastName) {
		try {
			String clientId = Utility.getPropertiesFile("resources", "clientId").trim();
			String requestUrl = Utility.getPropertiesFile("resources", "requestUrl").trim();
			String redirectUrl = Utility.getPropertiesFile("resources", "redirectUrl").trim();
			URL url = new URL(requestUrl+"/login?response_type=code&client_id="+clientId+"&redirect_uri="+redirectUrl+"&scope=email+profile+openid+aws.cognito.signin.user.admin+https://api.stage.acqyrexchange-dev.com/gamer");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	            throw new RuntimeException("Failed : HTTP Error code Step 1 : "+ conn.getResponseCode());
	        }
	        String cookie1 = conn.getHeaderField("Set-Cookie");
	        
	        InputStreamReader content = new InputStreamReader(conn.getInputStream());
	        BufferedReader br = new BufferedReader(content);
	        String output;
	        StringBuilder sb = new StringBuilder();
	        while ((output = br.readLine()) != null) {
	          sb.append(output);
	        }
	        Pattern pattern = Pattern.compile("name=\"_csrf\" value=\"(.*?)\"/>");
	        Matcher matcher = pattern.matcher(sb);
	        String csrf = "";
	        if (matcher.find())
	        {
	            csrf = matcher.group(1);
	        }
	        
	        String cognitoAsfData = Utility.getPropertiesFile("resources", "cognitoAsf").trim();
	        String postParameters = "_csrf="+csrf+"&username="+username+"&requiredAttributes%5Bemail%5D="+email+"&password="+password;
	        byte[] postData = postParameters.getBytes( StandardCharsets.UTF_8 );
	        int postDataLength = postData.length;
	        url = new URL(requestUrl+"/signup?response_type=code&client_id="+clientId+"&redirect_uri="+redirectUrl+"&scope=email+profile+openid+aws.cognito.signin.user.admin+https%3A%2F%2Fapi.stage.acqyrexchange-dev.com%2Fgamer");
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setInstanceFollowRedirects(false);
	        conn.setDoOutput(true);
	        conn.setRequestProperty("Cookie", cookie1);
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
	        conn.setRequestProperty("charset", "utf-8");
	        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength ));
	        conn.setUseCaches(false);
	        
	        conn.connect();
			try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
				wr.write(postData);
			}
	        
	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	            throw new RuntimeException("Failed : HTTP Error code Step 2: "+ conn.getResponseCode());
	        }
	        cookie1 = conn.getHeaderField("Set-Cookie");
	        
	        content = new InputStreamReader(conn.getInputStream());
	        br = new BufferedReader(content);
	        sb = new StringBuilder();
	        while ((output = br.readLine()) != null) {
	          sb.append(output);
	        }
	        pattern = Pattern.compile("name=\"sub\" value=\"(.*?)\"/>");
	        matcher = pattern.matcher(sb);
	        String sub = "";
	        if (matcher.find())
	        {
	            sub = matcher.group(1);
	        }
	        
	        Thread.sleep(5000);
	        MailBox code = new MailBox();
	        String verificationCode = code.getEmailData(email, "body > em", 2);
	        
	        postParameters = "_csrf="+csrf+"&username="+username+"&deliveryMedium=EMAIL&sub="+sub+"&cognitoAsfData="+cognitoAsfData+"&code="+verificationCode+"&confirm=";
	        postData = postParameters.getBytes( StandardCharsets.UTF_8 );
	        postDataLength = postData.length;
	        url = new URL(requestUrl+"/confirm?response_type=code&client_id="+clientId+"&redirect_uri="+redirectUrl+"&scope=email+profile+openid+aws.cognito.signin.user.admin+https%3A%2F%2Fapi.stage.acqyrexchange-dev.com%2Fgamer");
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setInstanceFollowRedirects(false);
	        conn.setDoOutput(true);
	        conn.setRequestProperty("Cookie", cookie1);
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
	        conn.setRequestProperty("charset", "utf-8");
	        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength ));
	        conn.setUseCaches(false);
	        
	        conn.connect();
			try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
				wr.write(postData);
			}
	        
	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	            throw new RuntimeException("Failed : HTTP Error code Step 3: "+ conn.getResponseCode());
	        }
	        
	        Thread.sleep(5000);
	        String auth = APICalls.apiLogin(username, password);
	        
	        String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
	        
	        String body = "{\"name\":\""+username+"\",\"email\":\""+email+"\",\"acQyrCashBalance\":\"0\",\"membershipLevel\":\"1\",\"redemptionAccountName\":\"\"}";
	        url = new URL(apiUrl+"/gamer");
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setDoOutput(true);
	        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	        wr.writeBytes(body);
	        wr.close();
	        
	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	            throw new RuntimeException("Failed : HTTP Error code Step 4: "+ conn.getResponseCode());
	        }
	        
	        
	        body = "{\"first_name\":\""+firstName+"\",\"last_name\":\""+lastName+"\",\"email\":\""+email+"\",\"phone\":\"\",\"membershipLevel\":\"1\",\"privacyAgreedTo\":true,\"tAndCAgreedTo\":true,\"profile_image\":\"\"}";
	        url = new URL(apiUrl+"/gamer");
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("PUT");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setDoOutput(true);
	        wr = new DataOutputStream(conn.getOutputStream());
	        wr.writeBytes(body);
	        wr.close();
	       
	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	            throw new RuntimeException("Failed : HTTP Error code Step 5: "+ conn.getResponseCode());
	        }
	        
	        apiUrl = Utility.getPropertiesFile("resources", "gamerServerUrl").trim();
	        String gameId = Utility.getPropertiesFile("resources", "gameId").trim();
			
			JSONObject body1 = new JSONObject();
			body1 = new JSONObject();
	        body1.put("username", username);
	        body1.put("password", password);
			String url1 = apiUrl+"/signup";
			HttpURLConnection connection = (HttpURLConnection) new URL(url1).openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
	        wr = new DataOutputStream(connection.getOutputStream());
	        wr.writeBytes(body1.toString());
	        wr.close();
	       
	        if (!(100 <= connection.getResponseCode() && connection.getResponseCode() <= 399)) {
	           throw new RuntimeException("Failed : HTTP Error code Step 6: "+ connection.getResponseCode());
	        }
	        
	        url1 = apiUrl+"/gamer?QxAuth="+auth+"&gameId="+gameId;
			connection = (HttpURLConnection) new URL(url1).openConnection();
			String encoded = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));  
			connection.setRequestMethod("POST");
			connection.setRequestProperty( "Accept", "application/json" );
			connection.setRequestProperty("Authorization", "Basic "+encoded);
			connection.connect();
			
			if (!(100 <= connection.getResponseCode() && connection.getResponseCode() <= 399)) {
	            throw new RuntimeException("Failed : HTTP Error code Step 7: "+ connection.getResponseCode());
	         }
			
			
			url1 = apiUrl+"/gamer/assets?gameId="+gameId+"&assetName=Asset1&amountToAdd=10000";
	        connection = (HttpURLConnection) new URL(url1).openConnection();
	        encoded = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));
	        connection.setRequestMethod("PUT");
	        connection.setRequestProperty( "Accept", "application/json" );
			connection.setRequestProperty("Authorization", "Basic "+encoded);
			connection.connect();
			
			if (!(100 <= connection.getResponseCode() && connection.getResponseCode() <= 399)) {
	            throw new RuntimeException("Failed : HTTP Error code Step 8: "+ connection.getResponseCode());
	         }
			
			apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
	        
		       
	        url = new URL(apiUrl+"/assets/"+gameId);
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        conn.setRequestProperty("Content-Type", "application/json");
	        
	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	            throw new RuntimeException("Failed : HTTP Error code Step 9: "+ conn.getResponseCode());
	        }
	        
	        content = new InputStreamReader(conn.getInputStream());
	        br = new BufferedReader(content);
	       
	        String finalOutput = "";
	        while ((output = br.readLine()) != null) {
	            finalOutput = output;
	        }
	        JSONTokener tokener = new JSONTokener(finalOutput);
	        JSONObject json = new JSONObject(tokener);
	        
	        JSONArray obj = json.getJSONArray("data");
	        JSONTokener tokener1 = new JSONTokener(obj.get(0).toString());
	        JSONObject json1 = new JSONObject(tokener1);
	        JSONArray obj1 = json1.getJSONArray("assets");
	        JSONTokener tokener2 = new JSONTokener(obj1.get(0).toString());
	        JSONObject json2 = new JSONObject(tokener2);
	        
	        
	        String assestId = json2.get("assetId").toString();
	        
	        
	        body = "{\"assetId\":\""+assestId+"\",\"quantity\":10000,\"unitPriceQxPoints\":2,\"gameId\":\""+gameId+"\",\"gameName\":\"Asset1\",\"iconUrl\":\"\",\"unitPriceLocalCurrency\":0.02,\"name\":\"Asset1\"}";
	        
	        url = new URL(apiUrl+"/functional/ExchangeAsset");
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setDoOutput(true);
	        wr = new DataOutputStream(conn.getOutputStream());
	        wr.writeBytes(body);
	        wr.close();
	        
	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	            throw new RuntimeException("Failed : HTTP Error code Step 4: "+ conn.getResponseCode());
	        }
			
			connection.disconnect();
	        
			return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : prepareGamerAccount " + e);
			return false;
		}
	}
	
	public static boolean prepareAdminAccount(String masterAdminUsername, String masterAdminPassword, String fullName, String username, String email, String password, WebDriver driver) {
		try {
			String auth = APICalls.apiLogin(masterAdminUsername, masterAdminPassword);
	        
	        String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
	        
	        String body = "{\"full_name\":\""+fullName+"\",\"username\":\""+username+"\",\"email\":\""+email+"\",\"isActive\":true,\"admin_permissions\":[1,3,5,7,9,2,4,6,8]}";
	        URL url = new URL(apiUrl+"/admin");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setDoOutput(true);
	        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	        wr.writeBytes(body);
	        wr.close();
	        
	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	            throw new RuntimeException("Failed : HTTP Error code Step 4: "+ conn.getResponseCode());
	        }
	       
	        Thread.sleep(5000);
	        MailBox code = new MailBox();
	        String verificationText = code.getEmailData(email, "body", 2, 1);
			String arr[] = verificationText.split(" ");
			String passwordEmail = arr[8];
			passwordEmail = passwordEmail.substring(0,(passwordEmail.length())-1);
			
			SignIn_Admin_Pages ob = new SignIn_Admin_Pages(driver);
			boolean flag = ob.signInChangePassword(username, passwordEmail, password);
			flag = flag && ob.SignOutADMIN();
			flag = flag && ob.signInWithCodeVerification(username, password);
			
			Thread.sleep(5000);
			String verificationCode = code.getEmailData(email, "body > em", 2);
			
			flag = flag && ob.verifyCode(verificationCode);
			Thread.sleep(5000);
			driver.quit();
			return flag;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : prepareAdminAccount " + e);
			return false;
		}
	}
	
	public static boolean preparePartnerAccountAfterSignup(String partnerEmail, String partnerUsername, String partnerPassword, String adminUsername, String adminPassword) {
		try {
			
			String auth = APICalls.apiLogin(partnerUsername, partnerPassword);
			
			JSONObject body = new JSONObject();
	        body.put("agreed_to_terms", true);
	        body.put("authorized_signature_name", "Automation");
	        body.put("authorized_signature_title", "Automation");
	        body.put("business_location_add1","97 Madison Avenue");
	        body.put("business_location_add2", "");
	        body.put("business_location_city", "Island Park");
	        body.put("business_location_country", "United States");
	        body.put("business_location_state", "New York");
	        body.put("business_location_zip_code", "11558");
	        body.put("category_id", "0");
	        body.put("country_code", "US");
	        body.put("dba", "");
	        body.put("email", partnerEmail);
	        body.put("game_growth", "50");
	        body.put("gamer_growth", "50");
	        body.put("icon_url", Utility.getPropertiesFile("resources", "iconUrl").trim());
	        body.put("join_reason", "0");
	        body.put("legal_entity_name", "Automation Legal "+Utility.getPropertiesFile("testDataVariables", "signUpUserCount"));
	        body.put("no_games_estimates", "10");
	        body.put("no_games_estimates_across", "1");
	        body.put("partner_id", "");
	        body.put("primary_alternative_phone", "");
	        body.put("primary_email", partnerEmail);
	        body.put("primary_name", "Automation");
	        body.put("primary_phone", "(999) 935-5784");
	        body.put("primary_title", "Automation");
	        body.put("sec_alternative_phone", "");
	        body.put("sec_email", partnerEmail);
	        body.put("sec_name", "Automation");
	        body.put("sec_phone", "(999) 935-5784");
	        body.put("sec_title", "Automation");
	        body.put("software_development_ability", "0");
	        body.put("state_code", "NY");
	        body.put("suggested_changes", "");
	        body.put("username", partnerEmail);

	        String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
	        URL url = new URL(apiUrl+"/partner");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setDoOutput(true);
	        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	        wr.writeBytes(body.toString());
	        wr.close();

	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	        	throw new RuntimeException("Failed : HTTP Error code Step 1: "+ conn.getResponseCode());
	        }

	        auth = APICalls.apiLogin(adminUsername, adminPassword);

	        apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();

	        url = new URL(apiUrl+"/admin/partners?searchKey="+partnerEmail+"&sortOrder=ASC&perPage=30");
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	        	throw new RuntimeException("Failed : HTTP Error code Step 2: "+ conn.getResponseCode());
	        }

	        InputStreamReader content = new InputStreamReader(conn.getInputStream());
	        BufferedReader br = new BufferedReader(content);
	        String output;
	        String finalOutput = "";
	        while ((output = br.readLine()) != null) {
	        	finalOutput = output;
	        }
	        JSONTokener tokener = new JSONTokener(finalOutput);
	        JSONObject json = new JSONObject(tokener);

	        JSONArray ob= (JSONArray) json.getJSONObject("data").get("partner_data");

	        tokener = new JSONTokener(ob.get(0).toString());
	        json = new JSONObject(tokener);
	        String partner_id = json.getString("partner_id");

	        body = new JSONObject();
	        body.put("partnerId", partner_id);
	        url = new URL(apiUrl+"/admin/partners/approve");
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("PUT");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setDoOutput(true);
	        wr = new DataOutputStream(conn.getOutputStream());
	        wr.writeBytes(body.toString());
	        wr.close();

	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	        	throw new RuntimeException("Failed : HTTP Error code Step 3: "+ conn.getResponseCode());
	        }

	        return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : preparePartnerAccountAfterSignup " + e);
			return false;
		}
	}
	
	public static boolean rejectPartnerAccountAfterSignup(String partnerEmail, String partnerUsername, String partnerPassword, String adminUsername, String adminPassword) {
		try {
			
			String auth = APICalls.apiLogin(partnerUsername, partnerPassword);
			
			JSONObject body = new JSONObject();
	        body.put("agreed_to_terms", true);
	        body.put("authorized_signature_name", "Automation");
	        body.put("authorized_signature_title", "Automation");
	        body.put("business_location_add1","97 Madison Avenue");
	        body.put("business_location_add2", "");
	        body.put("business_location_city", "Island Park");
	        body.put("business_location_country", "United States");
	        body.put("business_location_state", "New York");
	        body.put("business_location_zip_code", "11558");
	        body.put("category_id", "0");
	        body.put("country_code", "US");
	        body.put("dba", "");
	        body.put("email", partnerEmail);
	        body.put("game_growth", "50");
	        body.put("gamer_growth", "50");
	        body.put("icon_url", Utility.getPropertiesFile("resources", "iconUrl").trim());
	        body.put("join_reason", "0");
	        body.put("legal_entity_name", "Automation Legal "+Utility.getPropertiesFile("testDataVariables", "signUpUserCount"));
	        body.put("no_games_estimates", "10");
	        body.put("no_games_estimates_across", "1");
	        body.put("partner_id", "");
	        body.put("primary_alternative_phone", "");
	        body.put("primary_email", partnerEmail);
	        body.put("primary_name", "Automation");
	        body.put("primary_phone", "(999) 935-5784");
	        body.put("primary_title", "Automation");
	        body.put("sec_alternative_phone", "");
	        body.put("sec_email", partnerEmail);
	        body.put("sec_name", "Automation");
	        body.put("sec_phone", "(999) 935-5784");
	        body.put("sec_title", "Automation");
	        body.put("software_development_ability", "0");
	        body.put("state_code", "NY");
	        body.put("suggested_changes", "");
	        body.put("username", partnerEmail);

	        String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
	        URL url = new URL(apiUrl+"/partner");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setDoOutput(true);
	        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	        wr.writeBytes(body.toString());
	        wr.close();

	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	        	throw new RuntimeException("Failed : HTTP Error code Step 1: "+ conn.getResponseCode());
	        }

	        auth = APICalls.apiLogin(adminUsername, adminPassword);

	        apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();

	        url = new URL(apiUrl+"/admin/partners?searchKey="+partnerEmail+"&sortOrder=ASC&perPage=30");
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	        	throw new RuntimeException("Failed : HTTP Error code Step 2: "+ conn.getResponseCode());
	        }

	        InputStreamReader content = new InputStreamReader(conn.getInputStream());
	        BufferedReader br = new BufferedReader(content);
	        String output;
	        String finalOutput = "";
	        while ((output = br.readLine()) != null) {
	        	finalOutput = output;
	        }
	        JSONTokener tokener = new JSONTokener(finalOutput);
	        JSONObject json = new JSONObject(tokener);

	        JSONArray ob= (JSONArray) json.getJSONObject("data").get("partner_data");

	        tokener = new JSONTokener(ob.get(0).toString());
	        json = new JSONObject(tokener);
	        String partner_id = json.getString("partner_id");

	        body = new JSONObject();
	        body.put("partnerId", partner_id);
	        body.put("reason_for_rejection", "Automation testing");
	        url = new URL(apiUrl+"/admin/partners/reject");
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("PUT");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setDoOutput(true);
	        wr = new DataOutputStream(conn.getOutputStream());
	        wr.writeBytes(body.toString());
	        wr.close();

	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	        	throw new RuntimeException("Failed : HTTP Error code Step 3: "+ conn.getResponseCode());
	        }

	        return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : preparePartnerAccountAfterSignup " + e);
			return false;
		}
	}
	
	public static boolean preparePendingPartnerAccountAfterSignup(String partnerEmail, String partnerUsername, String partnerPassword) {
		try {
			
			String auth = APICalls.apiLogin(partnerUsername, partnerPassword);
			
			JSONObject body = new JSONObject();
	        body.put("agreed_to_terms", true);
	        body.put("authorized_signature_name", "Automation");
	        body.put("authorized_signature_title", "Automation");
	        body.put("business_location_add1","97 Madison Avenue");
	        body.put("business_location_add2", "");
	        body.put("business_location_city", "Island Park");
	        body.put("business_location_country", "United States");
	        body.put("business_location_state", "New York");
	        body.put("business_location_zip_code", "11558");
	        body.put("category_id", "0");
	        body.put("country_code", "US");
	        body.put("dba", "");
	        body.put("email", partnerEmail);
	        body.put("game_growth", "50");
	        body.put("gamer_growth", "50");
	        body.put("icon_url", Utility.getPropertiesFile("resources", "iconUrl").trim());
	        body.put("join_reason", "0");
	        body.put("legal_entity_name", "Automation Legal "+Utility.getPropertiesFile("testDataVariables", "signUpUserCount"));
	        body.put("no_games_estimates", "10");
	        body.put("no_games_estimates_across", "1");
	        body.put("partner_id", "");
	        body.put("primary_alternative_phone", "");
	        body.put("primary_email", partnerEmail);
	        body.put("primary_name", "Automation");
	        body.put("primary_phone", "(999) 935-5784");
	        body.put("primary_title", "Automation");
	        body.put("sec_alternative_phone", "");
	        body.put("sec_email", partnerEmail);
	        body.put("sec_name", "Automation");
	        body.put("sec_phone", "(999) 935-5784");
	        body.put("sec_title", "Automation");
	        body.put("software_development_ability", "0");
	        body.put("state_code", "NY");
	        body.put("suggested_changes", "");
	        body.put("username", partnerEmail);

	        String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
	        URL url = new URL(apiUrl+"/partner");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setDoOutput(true);
	        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	        wr.writeBytes(body.toString());
	        wr.close();

	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	        	throw new RuntimeException("Failed : HTTP Error code Step 1: "+ conn.getResponseCode());
	        }
	        return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : preparePendingPartnerAccountAfterSignup " + e);
			return false;
		}
	}
	
	public static boolean enableDisablePartner(String partnerEmail, String adminUsername, String adminPassword, boolean isEnable) {
		try {
			 	String auth = APICalls.apiLogin(adminUsername, adminPassword);

		        String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();

		        URL url = new URL(apiUrl+"/admin/partners?searchKey="+partnerEmail+"&sortOrder=ASC&perPage=30");
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Accept", "application/json");
		        conn.setRequestProperty("Authorization", "Bearer "+auth);
		        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
		        	throw new RuntimeException("Failed : HTTP Error code Step 2: "+ conn.getResponseCode());
		        }

		        InputStreamReader content = new InputStreamReader(conn.getInputStream());
		        BufferedReader br = new BufferedReader(content);
		        String output;
		        String finalOutput = "";
		        while ((output = br.readLine()) != null) {
		        	finalOutput = output;
		        }
		        JSONTokener tokener = new JSONTokener(finalOutput);
		        JSONObject json = new JSONObject(tokener);

		        JSONArray ob= (JSONArray) json.getJSONObject("data").get("partner_data");

		        tokener = new JSONTokener(ob.get(0).toString());
		        json = new JSONObject(tokener);
		        String partner_id = json.getString("partner_id");
		        JSONObject body = new JSONObject();
		        body = new JSONObject();
		        body.put("partnerId", partner_id);
		        body.put("is_active", isEnable);
		        url = new URL(apiUrl+"/admin/partners/status");
		        conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("PUT");
		        conn.setRequestProperty("Authorization", "Bearer "+auth);
		        conn.setRequestProperty("Content-Type", "application/json");
		        conn.setDoOutput(true);
		        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		        wr.writeBytes(body.toString());
		        wr.close();

		        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
		        	throw new RuntimeException("Failed : HTTP Error code Step 3: "+ conn.getResponseCode());
		        }

		        return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : enableDisablePartner " + e);
			return false;
		}
	}
	
	public static boolean addGamePartner(String partnerUsername, String partnerPassword, String gameName) {
		try {
			String auth = APICalls.apiLogin(partnerUsername, partnerPassword);
	        
	        String apiUrl = Utility.getPropertiesFile("resources", "apiUrl").trim();
	        String pic = Utility.getPropertiesFile("resources", "iconUrl").trim();
	        
	        String body = "{\"name\":\""+gameName+"\",\"icon_url\":\""+pic+"\",\"description\":\"descrp\",\"download_urls\":[\"https://www.google.com\"],\"description_text\":\"descrp\",\"game_id\":\"\",\"game_assets\":[]}";
	        URL url = new URL(apiUrl+"/partner/games");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "Bearer "+auth);
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setDoOutput(true);
	        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	        wr.writeBytes(body);
	        wr.close();
	        
	        if (!(100 <= conn.getResponseCode() && conn.getResponseCode() <= 399)) {
	            throw new RuntimeException("Failed : HTTP Error code Step 3: "+ conn.getResponseCode());
	        }

		        return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Class : APICalls - Method : addGamePartner " + e);
			return false;
		}
	}

}
