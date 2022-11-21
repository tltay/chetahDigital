package chetahDigitalTesting.testing1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * ReadJson object to read json file and convert it to Recipient object and store into a list.
 * @author litin
 *
 */
public class ReadJson {
	//JSON parser object to parse read file
	
	public static String fileLocation = "C:\\Users\\litin\\chetahDigital\\chetahDigital\\src\\main\\java\\data.json";
	public static String recipientFieldName = "recipients";
	public static String tagsFieldName = "tags";
	public static String recipientNameFieldName = "name";
	public static String idFieldName = "id";
	
	@SuppressWarnings("unchecked")
	public static List<Recipient> readJsonFile() {
	    JSONParser jsonParser = new JSONParser();
	    List<Recipient> recipients = new ArrayList<Recipient>();
	     
	    try (FileReader reader = new FileReader(fileLocation))
	    {
	        //Read JSON file
	        Object parseObject = jsonParser.parse(reader);
	
	        JSONObject recipientListObject = (JSONObject) parseObject;

	        //Get recipients
			JSONArray recipientArrays = (JSONArray) recipientListObject.get(recipientFieldName);
			//System.out.println("this is recipient object : " +  recipientArrays);
			
			recipientArrays.forEach( recipientObject -> recipients.add(parseRecipientObject( (JSONObject) recipientObject ) ));
	    } catch (FileNotFoundException e) {
	    	System.out.println(e);
	        e.printStackTrace();
	    } catch (IOException e) {
	    	System.out.println(e);
	        e.printStackTrace();
	    } catch (ParseException e) {
	    	System.out.println(e);
	        e.printStackTrace();
	    } catch(Exception e) {
	    	System.out.println(e);
	        e.printStackTrace();
	    }
	    
	    return recipients;
	}
	
	private static Recipient parseRecipientObject(JSONObject recipientObject) 
    {		
        //Get recipient tags
        JSONArray recipientTags = (JSONArray) recipientObject.get(tagsFieldName); 
        //Get recipient name
       String recipientName = (String) recipientObject.get(recipientNameFieldName);  
         
        //Get recipient id 
        long recipientId = (Long) recipientObject.get(idFieldName);   

        return new Recipient(recipientTags, recipientName, recipientId );
    }
}
