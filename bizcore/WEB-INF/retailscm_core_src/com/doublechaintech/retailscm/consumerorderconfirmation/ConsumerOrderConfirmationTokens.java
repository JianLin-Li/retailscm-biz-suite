
package com.doublechaintech.retailscm.consumerorderconfirmation;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class ConsumerOrderConfirmationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="consumerOrderConfirmation";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected ConsumerOrderConfirmationTokens(){
		//ensure not initialized outside the class
	}
<<<<<<< HEAD
=======
	public  static  ConsumerOrderConfirmationTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ConsumerOrderConfirmationTokens tokens = new ConsumerOrderConfirmationTokens(options);
		return tokens;
		
	}
	protected ConsumerOrderConfirmationTokens(Map<String,Object> options){
		this.options = options;
	}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	
	public ConsumerOrderConfirmationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ConsumerOrderConfirmationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ConsumerOrderConfirmationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ConsumerOrderConfirmationTokens start(){
		return new ConsumerOrderConfirmationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ConsumerOrderConfirmationTokens allTokens(){
		
		return start();
	
	}
	public static ConsumerOrderConfirmationTokens withoutListsTokens(){
		
		return start();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}
<<<<<<< HEAD
=======
	
	public ConsumerOrderConfirmationTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

	
	public  ConsumerOrderConfirmationTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

