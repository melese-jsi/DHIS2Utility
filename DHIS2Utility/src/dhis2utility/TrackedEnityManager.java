/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhis2utility;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author mtamiru
 */
public class TrackedEnityManager {
    private void makeJson()
    {
        
        try {
            JSONObject entity = new JSONObject();
            entity.put("trackedEntityType", "");
            entity.put("orgUnit", "");
            JSONArray attributes = new JSONArray();
            entity.put("attributes", attributes);
            createAttribute(attributes,"qlhf96qPEZJ", "");//navigator id
            createAttribute(attributes,"fNz7uikLq4D", ""); //girls individual id
            createAttribute(attributes, "zHeBqnmM2sK","");// got
            createAttribute(attributes, "QTuk8AflWW6", ""); //health post
            createAttribute(attributes, "LoGHwYUQZ9y",""); //full name
            createAttribute(attributes, "JM9qqwDihBV",""); //age
            
            
            

           
        } catch (JSONException ex) {
            Logger.getLogger(TrackedEnityManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void createAttribute(JSONArray attributes, String attrId, String value)
     {
         try{
                JSONObject attr = new JSONObject();
                attr.put("attribute", attrId);
                attr.put("value", value);
                attributes.put(attr);
            }
         catch(Exception ex)
         {
             System.out.println("couldnt put attr in json "+ attrId);
             ex.printStackTrace();
         }
        
     }
}
