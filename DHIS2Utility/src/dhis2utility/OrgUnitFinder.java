/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhis2utility;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mtamiru
 */
public class OrgUnitFinder {
    
    public static void main(String [] args) throws Exception
    {
        new OrgUnitFinder().sendGet();
    }
    
    private void postDatavalues () throws Exception
    {
        String usernamePassword="mtamiru:PSI@2018";
        String basicAuthPayload = "Basic "+ Base64.getEncoder().encodeToString(usernamePassword.getBytes());
        File file = new File("C:\\Users\\mtamiru\\Desktop\\mulukp_all_targets.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
      
        while((line = br.readLine())!=null)
        {
             String url = "https://data.psi-mis.org/api/dataValueSets?dataElementIdScheme=name&orgUnitIdScheme=name&dryRun=false&importStrategy=CREATE_AND_UPDATE";
     
             
               URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("POST");
        con.addRequestProperty("Authorization", basicAuthPayload);
        con.setRequestProperty("Content-Type", "application/csv");
       
        // Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(line);
		wr.flush();
		wr.close();

        //con.setRequestProperty("User-Agent",USER_AGENT);
        int responseCode = con.getResponseCode();
        //System.out.println("Response code: "+ responseCode);
       
        BufferedReader in = new BufferedReader(new 
          InputStreamReader(con.getInputStream()));
        
        String inputLine;
        StringBuffer response = new StringBuffer();
        
        while((inputLine = in.readLine())!=null)
        {
            response.append(inputLine);
        }
        System.out.println(response.toString());
        in.close();
       
        }
        
    }
    
    private void sendGet() throws Exception
    {
        String usernamePassword="mtamiru:PSI@2018";
        String basicAuthPayload = "Basic "+ Base64.getEncoder().encodeToString(usernamePassword.getBytes());
        File file = new File("C:\\Users\\mtamiru\\Desktop\\PSI\\mulukp\\migration\\march_orggg.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String orgUnit;
      
        while((orgUnit = br.readLine())!=null)
        {
             String url = "https://data.psi-mis.org/api/organisationUnits.json?filter=name:eq:"+ URLEncoder.encode(orgUnit);
     
             
               URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Authorization", basicAuthPayload);
        //con.setRequestProperty("User-Agent",USER_AGENT);
        int responseCode = con.getResponseCode();
        //System.out.println("Response code: "+ responseCode);
        Gson gson = new Gson();
        BufferedReader in = new BufferedReader(new 
          InputStreamReader(con.getInputStream()));
        
        String inputLine;
        StringBuffer response = new StringBuffer();
        
        while((inputLine = in.readLine())!=null)
        {
            response.append(inputLine);
        }
  
        JSONObject responseJson = new JSONObject(response.toString());
        JSONArray arry = responseJson.getJSONArray("organisationUnits"); 
        if(arry.length()==0)
        {
             System.out.println(orgUnit+":"+"nf"); //not found
        }
        else
        {
              JSONObject foundObj = arry.getJSONObject(0);
              System.out.println(orgUnit+":"+foundObj.getString("id"));
        }  
        
        //System.out.println("organizations units length: "+arry.size());
        in.close();
        //System.out.println(response.toString());
        }
        
       
      
        
       
    }
    
     private void getDataElementByName() throws Exception
    {
         String usernamePassword="mtamiru:PSI@2018";
        String basicAuthPayload = "Basic "+ Base64.getEncoder().encodeToString(usernamePassword.getBytes());
        File file = new File("C:\\Users\\mtamiru\\Desktop\\dts.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String dataElement;
      
        while((dataElement = br.readLine())!=null)
        {
             String url = "https://data.psi-mis.org/api/dataElements.json?filter=name:eq:"+ URLEncoder.encode(dataElement);
     
             
               URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Authorization", basicAuthPayload);
        //con.setRequestProperty("User-Agent",USER_AGENT);
        int responseCode = con.getResponseCode();
        //System.out.println("Response code: "+ responseCode);
        Gson gson = new Gson();
        BufferedReader in = new BufferedReader(new 
          InputStreamReader(con.getInputStream()));
        
        String inputLine;
        StringBuffer response = new StringBuffer();
        
        while((inputLine = in.readLine())!=null)
        {
            response.append(inputLine);
        }
        JsonParser parser = new JsonParser();
        JSONObject responseJson = new JSONObject(response.toString());
        JSONArray arry = responseJson.getJSONArray("dataElements"); 
        if(arry.length()==0)
        {
             System.out.println("nf:"+dataElement);
        }
        else
        {
              JSONObject foundObj = arry.getJSONObject(0);
              System.out.println(dataElement+":"+foundObj.getString("id"));
        }   
        
        //System.out.println("organizations units length: "+arry.size());
        in.close();
        //System.out.println(response.toString());
        }
        
       
      
        
       
    }
}
