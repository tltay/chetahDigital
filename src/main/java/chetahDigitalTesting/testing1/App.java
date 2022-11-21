package chetahDigitalTesting.testing1;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * Main java class
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Recipient> recipientsList = ReadJson.readJsonFile();        
   
        // A method to print all recipient obtained from the data.json
        // RecipientSorterHelper.printRecipientList(recipientsList);
     
        HashMap<List<String>, List<String>> sortedRecipientMap = RecipientSorterHelper.getAllTagUniques(recipientsList);
        
        RecipientSorterHelper.printSortedRecipient(sortedRecipientMap);
    }
}