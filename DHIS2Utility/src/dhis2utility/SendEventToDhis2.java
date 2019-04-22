/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhis2utility;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mtamiru
 */
public class SendEventToDhis2 {
    
    public static void main(String [] args)
    {
        new SendEventToDhis2().postEvent();
    }
    
    private void postEvent()
    {
       //read json file line by line
        String usernamePassword="mtamiru:PSI@2018";
        String basicAuthPayload = "Basic "+ Base64.getEncoder().encodeToString(usernamePassword.getBytes());
        BufferedReader br =null;
         try{
            File file = new File("C:\\Users\\mtamiru\\Desktop\\PSI\\mulukp\\migration\\march2_final_2.json");
            br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line ="";
            while((line = br.readLine())!=null)
            {
                sb.append(line);
                
            }
            JSONObject obj = new JSONObject(sb.toString());         
            JSONArray array = obj.getJSONArray("events");
            for(int i =0; i<array.length(); i++)
            { 
               // System.out.println(array.getJSONObject(i));
                String urllink = "https://data.psi-mis.org/api/events";
                
                HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(urllink);
                post.setHeader("Accept", "application/json");
                post.setHeader("Content-Type", "application/json");
                post.setHeader("Authorization", basicAuthPayload);
                StringEntity entity = new StringEntity(array.getJSONObject(i).toString());
                post.setEntity(entity);
                CloseableHttpResponse response = (CloseableHttpResponse) client.execute(post);
                 
                
                
                //HttpResponse response = client.execute(post);
                //System.out.println("response is "+ response.getStatusLine().getStatusCode());
                BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String resultLine = "";
		while ((resultLine = rd.readLine()) != null) {
			result.append(resultLine);
		
                }
//                if(result.toString().length() >0)
//                {
//                    JSONObject resultJson = new JSONObject(result.toString());
//                    StringBuilder output = new StringBuilder();
//                     output.append(resultJson.getString("httpStatus"));
//                     output.append(":");
//                     JSONObject 
//                     output.append(resultJson.getString(line))
//                }
                
		System.out.println(result.toString());
                
            }
           
            br.close();
         }
         catch(Exception ex)
         {
             ex.printStackTrace();
         }
        
    }
}
