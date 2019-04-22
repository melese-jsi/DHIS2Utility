/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhis2utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

/**
 *
 * @author mtamiru
 */
public class XMLParser {
    
    public static void main(String [] args) throws Exception
    {
        File f = new File("C:\\Users\\mtamiru\\Desktop\\PSI\\mulukp\\javacode\\mulukp_target_impor_summary.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = factory.newDocumentBuilder();
        
        while((line = br.readLine())!=null)
        {
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(line));
            Document doc = db.parse(is);
            String result = doc.getElementsByTagName("description").item(0).getTextContent();
            //result+=":"+
            Element importCountNode =(Element)doc.getElementsByTagName("importCount").item(0);
            result+=":"+importCountNode.getAttribute("imported");
            result+=":"+importCountNode.getAttribute("ignored");
            result+=":"+doc.getElementsByTagName("status").item(0).getTextContent();
            System.out.println(result);
        }
        
        
        
    }
}
