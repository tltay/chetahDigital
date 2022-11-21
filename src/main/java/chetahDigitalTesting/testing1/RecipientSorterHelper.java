package chetahDigitalTesting.testing1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A helper class to sort recipient list into matching tags.
 * @author litin
 *
 */
public class RecipientSorterHelper {
	public RecipientSorterHelper() {
		
	}
	
	/*
	 * Each pair of names should only appear once in the list, the order does not matter.
	 * All tags are all lowercase and distict per user. 
	 * 
	 * This is a method that each name only appear once. The name will be removed after first match. 
	 */
	public static HashMap<List<String>, List<String>> getAllTagUniquesWithoutRecipient(List<Recipient> recipientsList) {
		HashMap<List<String>, List<String>> resultMap = new HashMap<List<String>, List<String>>();
		while(recipientsList.size() > 0) {
			Recipient firstRecipient = recipientsList.get(0);
			List<String> firstRecipientTags = firstRecipient.getTags();
			
			for(int j = 1; j < recipientsList.size(); j++ ) {
				Recipient secondRecipient = recipientsList.get(j);
				List<String> matchTags = firstRecipientTags.stream().filter(x -> secondRecipient.getTags().contains(x)).toList();
				if (matchTags.size() > 1) {
					List<String> mapKey = new ArrayList<String>();
					mapKey.add(firstRecipient.getRecipientName());					
					mapKey.add(secondRecipient.getRecipientName());
					resultMap.put(mapKey, matchTags); 
					
					recipientsList.remove(secondRecipient);
					break;
				}
			}	
			recipientsList.remove(firstRecipient);
		}
		
		return resultMap;
	}
	
	/*
	 * Each pair of names should only appear once in the list, the order does not matter.
	 * All tags are all lowercase and distict per user. 
	 * 
	 * Each recipient will compared with every recipient. All match results will be added to result map. 
	 * So one recipient could be match with more than 1 recipient. Similar tags combination may appear multiple times for different user combination. 
	 * 
	 * Possible outcome as below: there are 6 different combination for Elana Vega, Sylvia Norman and Colon Reynolds. 
	 * [Elena Vega, Sylvia Norman] - [buyer, clicker]
	 * [Sylvia Norman, Maura Hickman] - [buyer, clicker]
	 * [Elena Vega, Colon Reynolds] - [buyer, clicker]
	 * [Elena Vega, Maura Hickman] - [buyer, clicker]
	 * [Maura Hickman, Colon Reynolds] - [promo, buyer, clicker]
	 * [Sylvia Norman, Colon Reynolds] - [shopping, buyer, clicker]
	 */
	public static HashMap<List<String>, List<String>> getAllTagUniques(List<Recipient> recipientLists) {
		HashMap<List<String>, List<String>> resultMap = new HashMap<List<String>, List<String>>();
		for(int i = 0; i < recipientLists.size(); i++ ) {
			Recipient firstRecipient = recipientLists.get(i);
			List<String> firstRecipientTags = firstRecipient.getTags();
			
			for(int j = i + 1; j < recipientLists.size(); j++ ) {
				Recipient secondRecipient = recipientLists.get(j);
				List<String> matchTags = firstRecipientTags.stream().filter(x -> secondRecipient.getTags().contains(x)).toList();
				if (matchTags.size() > 1) {
					List<String> mapKey = new ArrayList<String>();
					mapKey.add(firstRecipient.getRecipientName());					
					mapKey.add(secondRecipient.getRecipientName());
					resultMap.put(mapKey, matchTags); 
				}
			}	
		}
		
		return resultMap;
	}
	
   
    /**
     * This is a method created to print the original recipient lists, mainly for testing purpose. 
     * @param recipientList
     * A list of recipient object obtained from json file. 
     */
	public static void printRecipientList(List<Recipient> recipientList) {
		System.out.println("Print recipient lists: -----------------------");
		for (Recipient recipient: recipientList ){
			System.out.println(recipient.toString());
		}
		System.out.println("-----------------------");
	}
	
	/**
	 * This is a method to print out recipient names - matching tags.
	 * @param resultMap
	 */
	public static void printSortedRecipient(HashMap<List<String>, List<String>> resultMap ) {
		for(Map.Entry<List<String>, List<String>> entry: resultMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue()) ;
		}
	}
}
