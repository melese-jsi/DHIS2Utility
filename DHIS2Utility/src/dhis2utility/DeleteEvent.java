/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhis2utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author mtamiru
 */
public class DeleteEvent {
    
     public static void main(String [] args)
    {
        new DeleteEvent().deleteEvent();
    }
     
     private String getEventId(String line)
     {
         try {
             JSONObject obj = new JSONObject(line);
             JSONArray importSummaries = obj.getJSONObject("response").getJSONArray("importSummaries");
             return (importSummaries.getJSONObject(0)).getString("reference");
         } catch (JSONException ex) {
             Logger.getLogger(DeleteEvent.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     }
    
    private void deleteEvent()
    {
       //read json file line by line
        String usernamePassword="mtamiru:PSI@2018";
        String basicAuthPayload = "Basic "+ Base64.getEncoder().encodeToString(usernamePassword.getBytes());
        BufferedReader br =null;
         try{
            File file = new File("C:\\Users\\mtamiru\\Desktop\\PSI\\mulukp\\migration\\eventstodelete.txt");
            br = new BufferedReader(new FileReader(file));
            
            String line ="";
            while((line = br.readLine())!=null)
            {
                
                String eventId = getEventId(line);
                System.out.println(eventId);
                if(eventId==null)
                    continue;
               // System.out.println(array.getJSONObject(i));
                String urllink = "https://data.psi-mis.org/api/events/"+eventId;
                
                HttpClient client = HttpClientBuilder.create().build();
		HttpDelete post = new HttpDelete(urllink);
                post.setHeader("Authorization", basicAuthPayload);
               // StringEntity entity = new StringEntity(array.getJSONObject(i).toString());
               // post.setEntity(entity);
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
