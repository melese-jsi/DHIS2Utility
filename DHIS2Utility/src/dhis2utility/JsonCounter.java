/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhis2utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author mtamiru
 */
public class JsonCounter {
    public static void main(String [] args)
    {
        try {
            //read json file line by line
            String usernamePassword="mtamiru:PSI@2018";
            String basicAuthPayload = "Basic "+ Base64.getEncoder().encodeToString(usernamePassword.getBytes());
            BufferedReader br =null;
            
            File file = new File("C:\\Users\\mtamiru\\Desktop\\PSI\\march_1_final.json");
            br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line ="";
            while((line = br.readLine())!=null)
            {
                sb.append(line);
                
            }
            JSONObject obj = new JSONObject(sb.toString());         
            JSONArray array = obj.getJSONArray("events");
          System.out.println("#events "+ array.length());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsonCounter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JsonCounter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(JsonCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
