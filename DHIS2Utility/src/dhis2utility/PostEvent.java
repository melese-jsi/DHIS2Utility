/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhis2utility;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author mtamiru
 */
public class PostEvent {
    
    public static void main(String [] args)
    {
       new PostEvent().makeEventJson();
       // new PostEvent().prepareEvent();
    }
    
   
     private void prepareEvent()
     {
         //read csv file
         BufferedReader br =null;
         try{
            File file = new File("C:\\Users\\mtamiru\\Desktop\\PSI\\mulukp\\migration\\march_2.csv");
            br = new BufferedReader(new FileReader(file));
            String line;

            while((line = br.readLine())!=null)
            {
                String [] tokens = line.split(",");
                outputToken(tokens);
            }
            
         }
         catch(Exception ex)
         {
             ex.printStackTrace();
         }
         finally{
             try{
                 br.close();
             }
             catch(Exception ex)
             {
                 
             }
         }
     
     }
     
     private void makeEventJson()
     {
         //read csv file
         BufferedReader br =null;
         try{
            File file = new File("C:\\Users\\mtamiru\\Desktop\\PSI\\mulukp\\migration\\march2_final_2.csv");
            br = new BufferedReader(new FileReader(file));
            String line;
            JSONObject root = new JSONObject();
            JSONArray events = new JSONArray();
            root.put("events", events);
            while((line = br.readLine())!=null)
            {
                String [] tokens = line.split(",");
                JSONObject obj = new JSONObject();
                obj.put("program", "f8Wv7BBPmNG");
                obj.put("orgUnit", tokens[0]);
                obj.put("eventDate", tokens[1]);
                obj.put("status", "COMPLETED");
                obj.put("storedBy", "mtamiru");
                
                 //datavalues
                    JSONArray dataValues = new JSONArray();
                     createDataValueString(dataValues, "rHFHL897I4X", tokens[2]);//serial _number
                    createDataValueString(dataValues, "wY8wKFA1xF4", tokens[3]); //client_id
                    createDataValueString(dataValues, "Pmruq9iIgkk", tokens[4]); //type of visit
                          createDataValueString(dataValues, "HWj2FeSFY8Y", tokens[5]);// client age
                    createDataValueString(dataValues, "LIXhuwS6Leq", tokens[6]); //client sex
                          createDataValueString(dataValues, "Fl9yETy2FJR", tokens[7]); // target group

                    createDataValueString(dataValues, "vYyJpFVOBa4", tokens[8]);//ref voucher
                          createDataValueString(dataValues, "O9hHkhyoeN9", tokens[9]); // min sessions
                    createDataValueString(dataValues, "bOz25WY2VFv", tokens[10]); //approach
                          createDataValueString(dataValues, "K7u4icaMuDP", tokens[11]);//test type

                    createDataValueString(dataValues, "yQyTMgiPWbq", tokens[12]); //ever tested
                          createDataValueString(dataValues, "PshOspskO2z", tokens[13]); //last 12 months

                    createDataValueString(dataValues, "jobGbGX454G", tokens[14]);// pre-test counseling
                          createDataValueString(dataValues, "RhNTatn9mho", tokens[15]); //testing accepted
                    createDataValueString(dataValues, "RQ5V3cTd9mN", tokens[16]); //test modality
                          createDataValueString(dataValues, "zhf9ySNv9KX", tokens[17]);//hivst result

                    createDataValueString(dataValues, "zBDjHEhLH2i", tokens[18]); //test result1
                          createDataValueString(dataValues, "U8fGYlwGTcs", tokens[19]); //test result2

                    createDataValueString(dataValues, "b7ajMNGWixZ", tokens[20]); // test result 3
                          createDataValueString(dataValues, "nTEcd7lq5cj", tokens[21]); // final hiv rst

                            createDataValueString(dataValues, "WDtHxBwaIKu", tokens[22]);//couple
                                  createDataValueString(dataValues, "iGzyLImcWF8", tokens[23]);//recieved hiv tst results
                            createDataValueString(dataValues, "PpyNCxprMUZ", tokens[24]);//post test counseling
                                  createDataValueString(dataValues, "PFbj1OA9lAT", tokens[25]); //knew hiv positive status
                            createDataValueString(dataValues, "psZEu6yX32R", tokens[26]); //linkage
                                  createDataValueString(dataValues, "gC7ksgbTYOs", tokens[27]); //pre-art
                            createDataValueString(dataValues, "Rt2jB81DPBP", tokens[28]);// pre-art number
                                  createDataValueString(dataValues, "Zjf27wRHlSZ", tokens[29]);// date of art initiation
                            createDataValueString(dataValues, "tH36WlYnpG8", tokens[30]); //unique art number
                            createDataValueString(dataValues, "BeKOyyUt7Ii", tokens[31]);//recieving facility

                          createDataValueString(dataValues, "s2Fv4ByDs59", tokens[32]); // ulcer screening
                          createDataValueString(dataValues, "GTqOp9TI0LI", tokens[33]); //inguinal bubu
                          createDataValueString(dataValues, "TiXxS4U2m78", tokens[34]); //abdominal 
                          createDataValueString(dataValues, "aWDvIaDty9n", tokens[35]); //other sti
                          createDataValueString(dataValues, "coXa5mktGkU", tokens[36]); //scrotal swelling
                          createDataValueString(dataValues, "YUJZ1I8NqGT", tokens[37]);//urethral discharge
                          createDataValueString(dataValues, "lARi4wxepux", tokens[38]); //vaginal discharge
                          createDataValueString(dataValues, "cq8TCGnsivR", tokens[39]); //tret inguinal
                          createDataValueString(dataValues, "wVUm7aa4pAA", tokens[40]); //tret abdominal pain
                          createDataValueString(dataValues, "j5jgLaR6HMN", tokens[41]);//tret genital ulcer
                          createDataValueString(dataValues, "qttJ3uEVqyD", tokens[42]); //tret swelling
                          createDataValueString(dataValues, "yefdcqHwfB3", tokens[43]); // tret urethral discharge
                          createDataValueString(dataValues, "W3NspWWGF9h", tokens[44]); //tret vagianl discharge
                          createDataValueString(dataValues, "VLejhn11Eg3", tokens[45]); //other sti
                          createDataValueString(dataValues, "idV9jTukEqV", tokens[46]); //raised bp
                          createDataValueString(dataValues, "WZDPh0Q8p3b", tokens[47]); //peg test
                          createDataValueString(dataValues, "Pw4Q20L2Yb5", tokens[48]); //counseled for fp
                          createDataValueString(dataValues, "EZ0pVf4xTNt", tokens[49]); //fp history
                          createDataValueString(dataValues, "z0IL4cojTij", tokens[50]); //current fp method
                          createDataValueString(dataValues, "eHHEqacdvUe", tokens[51]); //hiv spcific counseling methods offred
                          createDataValueString(dataValues, "wtfIHtqh6h9", tokens[52]); // contraceptive provided
                          createDataValueString(dataValues, "VFneTin2hz9", tokens[53]); // Screened for TB symptoms
                          createDataValueString(dataValues, "NmZ2Z0CER6l", tokens[54]); // ET RH TRK - Result of TB symptom screening
                          createDataValueString(dataValues, "Moc8dLq5OmV", tokens[55]); //Condom demonstration
                          createDataValueString(dataValues, "GAyb9QNZyi1", tokens[56]); //No. of male condoms provided
                          createDataValueString(dataValues, "D1kAK7QrMQw", tokens[57]); //no. of female condoms provided
                          createDataValueString(dataValues, "Cgo2nqWnfgN", tokens[58]); //No. of water based lubricants
                          createDataValueString(dataValues, "I6OvCFXR0zD", tokens[59]); //screened for GBV
                          createDataValueString(dataValues, "Xdao9JHDYPO", tokens[60]); //physical GBV
                          createDataValueString(dataValues, "Z5Y8c2Mpdqc", tokens[61]); //sexual Assault GBV
                          createDataValueString(dataValues, "taaACTGJ6fk", tokens[62]); //emotional GBV
                          createDataValueString(dataValues, "FvJhk9YacyC", tokens[63]); //referral - ANC/PMTCT (ANP)
                          createDataValueString(dataValues, "JbgD2gxBNJe", tokens[64]); //referral - Chronic care (CCC pre-ART)
                          createDataValueString(dataValues, "yrwkHYFMYav", tokens[65]); //referral - Family planning (FPL)
                          createDataValueString(dataValues, "d5rcGnKOrx5", tokens[66]); //eferral - HIV testing and Counseling (HTC)
                          
                          createDataValueString(dataValues, "T0hqy1uSiB8", tokens[67]); //referral - Other (OTR)r GBV
                          createDataValueString(dataValues, "VLz4Mw4pVDK", tokens[68]); //referral - Post-exposure prophylaxis for GVB (PEP)V
                          createDataValueString(dataValues, "v4NiCbcJPhA", tokens[69]); //post test club
                          createDataValueString(dataValues, "FekyMpI2jm5", tokens[70]); // STI Diagnosis and Treatment (STI)
                          createDataValueString(dataValues, "eWp392XxeMS", tokens[71]); //sis (TBD)
                          createDataValueString(dataValues, "BxX6R35gZyO", tokens[72]); //TRK - Voucher number planning (FPL)
                          createDataValueString(dataValues, "dv6vwJLrDXp", tokens[73]); //referral - TB Treatment (TBT)onic care (CCC pre-ART)
                          obj.put("dataValues", dataValues);
                          events.put(obj);
            }
            
            System.out.println(root);
      
         }
         catch(Exception ex)
         {
             ex.printStackTrace();
         }
         finally{
             try{
                 br.close();
             }
             catch(Exception ex)
             {
                 
             }
         }
       
     }
     
     
     private void outputToken(String [] tokens)
     {
         //format min # of bhr sessions
        
         for(int i=0; i< tokens.length; i++)
         {  
             String token ="";
             switch(i)
             {
                 case 9:
                  token = yesNoFormat(tokens[9]); // minimum number of sessions
                  break;
                 case 12:
                   token = yesNoFormat(tokens[12]); // ever tested
                   break;
                 case 13:
                    token = yesNoFormat(tokens[13]); //last 12 months
                    break;
                 case 15:
                    token = yesNoFormat(tokens[15]);  //testing accepted
                    break;
                 case 17:
                     token = hvst(tokens[17]);
                     break;
                 case 18:
                     token = hvstresult(tokens[18]);
                     break;
                 case 19:
                     token = hvstresult(tokens[19]);
                     break;
                 case 20:
                     token = hvstresult(tokens[20]);
                     break;
                 case 21:
                     token = finalhvresult(tokens[21]);
                     break;
                 case 22:
                     token = coupleHivTestResult(tokens[22]);
                     break;
                 case 23:
                     token = yesNoFormat2(tokens[23]); // recieved hiv test result
                     break;
                 case 25:
                    token = yesNoFormat2(tokens[25]); // knew hiv positive status before
                    break;
                 case 46:
                    token = yesNoFormat2(tokens[46]); // raise bp
                    break;
                 case 49:
                    token = fpHistory(tokens[49]); //fp history
                    break;
                 case 53:
                    token = yesNoFormat2(tokens[53]); // screened for tb symptoms
                    break;
                 case 59:
                    token = yesNoFormat2(tokens[59]); // gbv
                    break;
                 default:
                     token = tokens[i];
                 
             }
            
             
            
             System.out.print(token+",");
         }
         System.out.println();
     }
     
     private String coupleHivTestResult(String value)
     {
         if(value != null && !value.isEmpty())
         {
             if(value.equalsIgnoreCase("N/A"))
                 return "";
             else if(value.startsWith("CC"))
                 return "CC - Couple concordant";
             else if(value.startsWith("CD"))
                 return "CD - Couple discordant";
            
         }
         return "";
     }
     
     private String finalhvresult(String value)
     {
         if(value != null && !value.isEmpty())
         {
             if(value.startsWith("N") || value.startsWith("n"))
                 return "Negative";
             else if(value.startsWith("P") || value.startsWith("p"))
                 return "Positive";
            
         }
         return "";
     }
     
     private String hvstresult(String value)
     {
          if(value != null && !value.isEmpty())
         {
             if(value.startsWith("NR"))
                 return "NR - Not Reactive";
             else if(value.startsWith("R"))
                 return "R – Reactive";
             return value;
         }
          return value;
     }
     
     private String hvst(String value)
     {
         
         if(value != null && !value.isEmpty())
         {
             if(value.equals("N/A"))
                 return "";
             else if(value.equalsIgnoreCase("Negative"))
                 return "Negative";
             else if(value.equalsIgnoreCase("Positive"))
                 return "Positive";
            return value;
         }
        return value;
     }
     
     private String fpHistory(String value)
     {
         if(value !=null && !value.isEmpty())
         {
             if(value.equals("N - Never"))  //formatting n-newver by new user
                   return "N - New User";
            
            return value;     
         }
         return value; //it is either c-con , d-dis ...
     }
     
    
     
     private String yesNoFormat(String value)
     {
         if(value !=null && !value.isEmpty())
         {
             if(value.equals("-1"))
                 return "true";
             else if(value.equals("0"))
                 return "false";
         }
         return value;
     }
     
     private String yesNoFormat2(String value) // additional 
     {
         if(value !=null && !value.isEmpty())
         {
            if(value.equals("-1") || value.equals("Yes"))
                 return "true";
             else if(value.equals("0") || value.equals("No"))
                 return "false"; 
            return value;
         }
         return value;
     }
     
     private String formatbhrSessions(String value)
     {
         if(value !=null && !value.isEmpty())
         {
             if(value.equals("-1"))
                 return "true";
             else if(value.equals(0))
                 return "false";
         }
         return value;
     }
     


     
     private void createDataValueString(JSONArray dataValues, String dataEltId, String value)
     {
         try{
                JSONObject dataValue = new JSONObject();
                dataValue.put("dataElement", dataEltId);
                dataValue.put("value", value);
                dataValues.put(dataValue);
            }
         catch(Exception ex)
         {
             System.out.println("couldnt put dataelement in json "+ dataEltId);
           ex.printStackTrace();
         }
        
     }
     
     

    
    
}
