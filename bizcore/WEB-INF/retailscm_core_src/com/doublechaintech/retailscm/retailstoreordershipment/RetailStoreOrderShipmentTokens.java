
package com.doublechaintech.retailscm.retailstoreordershipment;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class RetailStoreOrderShipmentTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreOrderShipment";
	
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
	protected RetailStoreOrderShipmentTokens(){
		//ensure not initialized outside the class
	}
<<<<<<< HEAD
=======
	public  static  RetailStoreOrderShipmentTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RetailStoreOrderShipmentTokens tokens = new RetailStoreOrderShipmentTokens(options);
		return tokens;
		
	}
	protected RetailStoreOrderShipmentTokens(Map<String,Object> options){
		this.options = options;
	}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	
	public RetailStoreOrderShipmentTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RetailStoreOrderShipmentTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RetailStoreOrderShipmentTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RetailStoreOrderShipmentTokens start(){
		return new RetailStoreOrderShipmentTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RetailStoreOrderShipmentTokens allTokens(){
		
		return start()
			.withRetailStoreOrderList();
	
	}
	public static RetailStoreOrderShipmentTokens withoutListsTokens(){
		
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
	
	public RetailStoreOrderShipmentTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

	protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	public String getRetailStoreOrderList(){
		return RETAIL_STORE_ORDER_LIST;
	}
	public RetailStoreOrderShipmentTokens withRetailStoreOrderList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST);
		return this;
	}
	public RetailStoreOrderShipmentTokens analyzeRetailStoreOrderList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreOrderListEnabled(){		
		
<<<<<<< HEAD
		return checkOptions(this.options(), RETAIL_STORE_ORDER_LIST+".anaylze");
=======
		if(checkOptions(this.options(), RETAIL_STORE_ORDER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
	}
	public RetailStoreOrderShipmentTokens extractMoreFromRetailStoreOrderList(String idsSeperatedWithComma){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int retailStoreOrderListSortCounter = 0;
	public RetailStoreOrderShipmentTokens sortRetailStoreOrderListWith(String field, String descOrAsc){		
		addSortMoreOptions(RETAIL_STORE_ORDER_LIST,retailStoreOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreOrderListSearchCounter = 0;
	public RetailStoreOrderShipmentTokens searchRetailStoreOrderListWith(String field, String verb, String value){		
		addSearchMoreOptions(RETAIL_STORE_ORDER_LIST,retailStoreOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	public RetailStoreOrderShipmentTokens searchAllTextOfRetailStoreOrderList(String verb, String value){	
		String field = "id|title|currentStatus";
		addSearchMoreOptions(RETAIL_STORE_ORDER_LIST,retailStoreOrderListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RetailStoreOrderShipmentTokens rowsPerPageOfRetailStoreOrderList(int rowsPerPage){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreOrderShipmentTokens currentPageNumberOfRetailStoreOrderList(int currentPageNumber){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreOrderShipmentTokens retainColumnsOfRetailStoreOrderList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreOrderShipmentTokens excludeColumnsOfRetailStoreOrderList(String[] columns){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  RetailStoreOrderShipmentTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfRetailStoreOrderList(verb, value);	
		return this;
	}
}

