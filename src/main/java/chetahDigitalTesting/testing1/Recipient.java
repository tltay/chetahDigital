package chetahDigitalTesting.testing1;

import java.util.ArrayList;

/**
 * A recipient object.
 * @author liting
 *
 */
public class Recipient {
	private ArrayList<String> tags;
	private String recipientName;
	private long id;
	
	public ArrayList<String> getTags() {
		return tags;
	}
	
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	
	public String getRecipientName() {
		return recipientName;
	}
	
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Recipient() {
		
	}
	
	public Recipient(ArrayList<String> tags, String recipientName, long id ) {
		 setTags(tags) ;
		 setRecipientName( recipientName);
		 setId( id);
	}

	@Override
	public String toString() {
		return "Recipient [tags=" + tags + ", recipientName=" + recipientName + ", id=" + id + "]";
	}
	
	
	
}
