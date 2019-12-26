
package com.doublechaintech.retailscm.supplyorderconfirmation;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;


import com.doublechaintech.retailscm.Message;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;

import com.doublechaintech.retailscm.RetailscmUserContext;
//import com.doublechaintech.retailscm.BaseManagerImpl;
import com.doublechaintech.retailscm.RetailscmCheckerManager;
import com.doublechaintech.retailscm.CustomRetailscmCheckerManager;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;


import com.doublechaintech.retailscm.supplyorderapproval.SupplyOrderApproval;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.doublechaintech.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.doublechaintech.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.doublechaintech.retailscm.supplyordershipment.SupplyOrderShipment;






public class SupplyOrderConfirmationManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderConfirmationManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderConfirmation";
	@Override
	public SupplyOrderConfirmationDAO daoOf(RetailscmUserContext userContext) {
		return supplyOrderConfirmationDaoOf(userContext);
	}
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplyOrderConfirmationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderConfirmationManagerException(message);

	}
	
	

 	protected SupplyOrderConfirmation saveSupplyOrderConfirmation(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderConfirmationDAO().save(supplyOrderConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens);
 	}
 	
 	protected SupplyOrderConfirmation saveSupplyOrderConfirmationDetail(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation) throws Exception{	

 		
 		return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, allTokens());
 	}
 	
 	public SupplyOrderConfirmation loadSupplyOrderConfirmation(RetailscmUserContext userContext, String supplyOrderConfirmationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderConfirmationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderConfirmation, tokens);
 	}
 	
 	
 	 public SupplyOrderConfirmation searchSupplyOrderConfirmation(RetailscmUserContext userContext, String supplyOrderConfirmationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderConfirmationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderConfirmation, tokens);
 	}
 	
 	

 	protected SupplyOrderConfirmation present(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderConfirmation,tokens);
		
		
		SupplyOrderConfirmation  supplyOrderConfirmationToPresent = supplyOrderConfirmationDaoOf(userContext).present(supplyOrderConfirmation, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderConfirmationToPresent.collectRefercencesFromLists();
		supplyOrderConfirmationDaoOf(userContext).alias(entityListToNaming);
		
		return  supplyOrderConfirmationToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderConfirmation loadSupplyOrderConfirmationDetail(RetailscmUserContext userContext, String supplyOrderConfirmationId) throws Exception{	
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, allTokens());
 		return present(userContext,supplyOrderConfirmation, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplyOrderConfirmationId) throws Exception{	
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, viewTokens());
 		return present(userContext,supplyOrderConfirmation, allTokens());
		
 	}
 	protected SupplyOrderConfirmation saveSupplyOrderConfirmation(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object>tokens) throws Exception{	
 		return supplyOrderConfirmationDaoOf(userContext).save(supplyOrderConfirmation, tokens);
 	}
 	protected SupplyOrderConfirmation loadSupplyOrderConfirmation(RetailscmUserContext userContext, String supplyOrderConfirmationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderConfirmationManagerException.class);

 
 		return supplyOrderConfirmationDaoOf(userContext).load(supplyOrderConfirmationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderConfirmation, tokens);
		
		addAction(userContext, supplyOrderConfirmation, tokens,"@create","createSupplyOrderConfirmation","createSupplyOrderConfirmation/","main","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"@update","updateSupplyOrderConfirmation","updateSupplyOrderConfirmation/"+supplyOrderConfirmation.getId()+"/","main","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"@copy","cloneSupplyOrderConfirmation","cloneSupplyOrderConfirmation/"+supplyOrderConfirmation.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public SupplyOrderConfirmation createSupplyOrderConfirmation(RetailscmUserContext userContext, String who,Date confirmTime) throws Exception
	//public SupplyOrderConfirmation createSupplyOrderConfirmation(RetailscmUserContext userContext,String who, Date confirmTime) throws Exception
	{
		
		

		

		checkerOf(userContext).checkWhoOfSupplyOrderConfirmation(who);
		checkerOf(userContext).checkConfirmTimeOfSupplyOrderConfirmation(confirmTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);


		SupplyOrderConfirmation supplyOrderConfirmation=createNewSupplyOrderConfirmation();	

		supplyOrderConfirmation.setWho(who);
		supplyOrderConfirmation.setConfirmTime(confirmTime);

		supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderConfirmation);
		return supplyOrderConfirmation;

		
	}
	protected SupplyOrderConfirmation createNewSupplyOrderConfirmation() 
	{
		
		return new SupplyOrderConfirmation();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderConfirmation(RetailscmUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).checkVersionOfSupplyOrderConfirmation( supplyOrderConfirmationVersion);
		

		if(SupplyOrderConfirmation.WHO_PROPERTY.equals(property)){
			checkerOf(userContext).checkWhoOfSupplyOrderConfirmation(parseString(newValueExpr));
		}
		if(SupplyOrderConfirmation.CONFIRM_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkConfirmTimeOfSupplyOrderConfirmation(parseDate(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
		
	}
	
	
	
	public SupplyOrderConfirmation clone(RetailscmUserContext userContext, String fromSupplyOrderConfirmationId) throws Exception{
		
		return supplyOrderConfirmationDaoOf(userContext).clone(fromSupplyOrderConfirmationId, this.allTokens());
	}
	
	public SupplyOrderConfirmation internalSaveSupplyOrderConfirmation(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation) throws Exception 
	{
		return internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, allTokens());

	}
	public SupplyOrderConfirmation internalSaveSupplyOrderConfirmation(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplyOrderConfirmation){ 
			//will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderConfirmation.
			if (supplyOrderConfirmation.isChanged()){
			
			}
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, options);
			return supplyOrderConfirmation;
			
		}

	}
	
	public SupplyOrderConfirmation updateSupplyOrderConfirmation(RetailscmUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		if(supplyOrderConfirmation.getVersion() != supplyOrderConfirmationVersion){
			String message = "The target version("+supplyOrderConfirmation.getVersion()+") is not equals to version("+supplyOrderConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderConfirmation){ 
			//will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderConfirmation.
			
			supplyOrderConfirmation.changeProperty(property, newValueExpr);
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
		}

	}
	
	public SupplyOrderConfirmation updateSupplyOrderConfirmationProperty(RetailscmUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		if(supplyOrderConfirmation.getVersion() != supplyOrderConfirmationVersion){
			String message = "The target version("+supplyOrderConfirmation.getVersion()+") is not equals to version("+supplyOrderConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderConfirmation){ 
			//will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderConfirmation.
			
			supplyOrderConfirmation.changeProperty(property, newValueExpr);
			
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderConfirmationTokens tokens(){
		return SupplyOrderConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderConfirmationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderConfirmationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception{
			
		supplyOrderConfirmationDaoOf(userContext).delete(supplyOrderConfirmationId, supplyOrderConfirmationVersion);
	}
	
	public SupplyOrderConfirmation forgetByAll(RetailscmUserContext userContext, String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion);		
	}
	protected SupplyOrderConfirmation forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception{
			
		return supplyOrderConfirmationDaoOf(userContext).disconnectFromAll(supplyOrderConfirmationId, supplyOrderConfirmationVersion);
	}
	
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return supplyOrderConfirmationDaoOf(userContext).deleteAll();
	}


	//disconnect SupplyOrderConfirmation with consumer in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByConsumer(RetailscmUserContext userContext, String supplyOrderConfirmationId, String consumerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderListWithConsumer(supplyOrderConfirmation, consumerId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with approval in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByApproval(RetailscmUserContext userContext, String supplyOrderConfirmationId, String approvalId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderListWithApproval(supplyOrderConfirmation, approvalId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with processing in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByProcessing(RetailscmUserContext userContext, String supplyOrderConfirmationId, String processingId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderListWithProcessing(supplyOrderConfirmation, processingId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with shipment in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByShipment(RetailscmUserContext userContext, String supplyOrderConfirmationId, String shipmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderListWithShipment(supplyOrderConfirmation, shipmentId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with delivery in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByDelivery(RetailscmUserContext userContext, String supplyOrderConfirmationId, String deliveryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderListWithDelivery(supplyOrderConfirmation, deliveryId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with store in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByStore(RetailscmUserContext userContext, String supplyOrderConfirmationId, String storeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderListWithStore(supplyOrderConfirmation, storeId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with buyer in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByBuyer(RetailscmUserContext userContext, String supplyOrderConfirmationId, String buyerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithBuyer(supplyOrderConfirmation, buyerId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with seller in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderBySeller(RetailscmUserContext userContext, String supplyOrderConfirmationId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithSeller(supplyOrderConfirmation, sellerId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with approval in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByApproval(RetailscmUserContext userContext, String supplyOrderConfirmationId, String approvalId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithApproval(supplyOrderConfirmation, approvalId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with processing in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByProcessing(RetailscmUserContext userContext, String supplyOrderConfirmationId, String processingId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithProcessing(supplyOrderConfirmation, processingId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with picking in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByPicking(RetailscmUserContext userContext, String supplyOrderConfirmationId, String pickingId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithPicking(supplyOrderConfirmation, pickingId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with shipment in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByShipment(RetailscmUserContext userContext, String supplyOrderConfirmationId, String shipmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithShipment(supplyOrderConfirmation, shipmentId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with delivery in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByDelivery(RetailscmUserContext userContext, String supplyOrderConfirmationId, String deliveryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderListWithDelivery(supplyOrderConfirmation, deliveryId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);

		
		checkerOf(userContext).checkTitleOfConsumerOrder(title);
		
		checkerOf(userContext).checkConsumerIdOfConsumerOrder(consumerId);
		
		checkerOf(userContext).checkApprovalIdOfConsumerOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfConsumerOrder(processingId);
		
		checkerOf(userContext).checkShipmentIdOfConsumerOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfConsumerOrder(deliveryId);
		
		checkerOf(userContext).checkStoreIdOfConsumerOrder(storeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	
	}
	public  SupplyOrderConfirmation addConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderConfirmationId,title, consumerId, approvalId, processingId, shipmentId, deliveryId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, approvalId, processingId, shipmentId, deliveryId, storeId);
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.addConsumerOrder( consumerOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderConfirmationId,String id,String title,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfConsumerOrder(id);
		
		checkerOf(userContext).checkTitleOfConsumerOrder( title);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
		
	}
	public  SupplyOrderConfirmation updateConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderConfirmationId, String id,String title, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingConsumerOrderProperties(userContext,supplyOrderConfirmationId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderConfirmation supplyOrderConfirmationToUpdate = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		if(supplyOrderConfirmationToUpdate.getConsumerOrderList().isEmpty()){
			throw new SupplyOrderConfirmationManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}
		
		ConsumerOrder item = supplyOrderConfirmationToUpdate.getConsumerOrderList().first();
		
		item.updateTitle( title );

		
		//checkParamsForAddingConsumerOrder(userContext,supplyOrderConfirmationId,name, code, used,tokensExpr);
		SupplyOrderConfirmation supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmationToUpdate, tokens().withConsumerOrderList().done());
		synchronized(supplyOrderConfirmation){ 
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ConsumerOrder createConsumerOrder(RetailscmUserContext userContext, String title, String consumerId, String approvalId, String processingId, String shipmentId, String deliveryId, String storeId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStoreMember  consumer = new RetailStoreMember();
		consumer.setId(consumerId);		
		consumerOrder.setConsumer(consumer);		
		SupplyOrderApproval  approval = new SupplyOrderApproval();
		approval.setId(approvalId);		
		consumerOrder.setApproval(approval);		
		SupplyOrderProcessing  processing = new SupplyOrderProcessing();
		processing.setId(processingId);		
		consumerOrder.setProcessing(processing);		
		SupplyOrderShipment  shipment = new SupplyOrderShipment();
		shipment.setId(shipmentId);		
		consumerOrder.setShipment(shipment);		
		SupplyOrderDelivery  delivery = new SupplyOrderDelivery();
		delivery.setId(deliveryId);		
		consumerOrder.setDelivery(delivery);		
		RetailStore  store = new RetailStore();
		store.setId(storeId);		
		consumerOrder.setStore(store);		
		consumerOrder.setLastUpdateTime(userContext.now());
	
		
		return consumerOrder;
	
		
	}
	
	protected ConsumerOrder createIndexedConsumerOrder(String id, int version){

		ConsumerOrder consumerOrder = new ConsumerOrder();
		consumerOrder.setId(id);
		consumerOrder.setVersion(version);
		return consumerOrder;			
		
	}
	
	protected void checkParamsForRemovingConsumerOrderList(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception {
		
<<<<<<< HEAD
		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		for(String consumerOrderIdItem: consumerOrderIds){
			userContext.getChecker().checkIdOfConsumerOrder(consumerOrderIdItem);
=======
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		for(String consumerOrderIdItem: consumerOrderIds){
			checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderIdItem);
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
		
	}
	public  SupplyOrderConfirmation removeConsumerOrderList(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingConsumerOrderList(userContext, supplyOrderConfirmationId,  consumerOrderIds, tokensExpr);
			
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
			synchronized(supplyOrderConfirmation){ 
				//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderConfirmationDaoOf(userContext).planToRemoveConsumerOrderList(supplyOrderConfirmation, consumerOrderIds, allTokens());
				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderConfirmation.getConsumerOrderList());
				return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation( supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
	}
	public  SupplyOrderConfirmation removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderConfirmationId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.removeConsumerOrder( consumerOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation( supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
	}
	public  SupplyOrderConfirmation copyConsumerOrderFrom(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderConfirmationId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			consumerOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderConfirmation.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)supplyOrderConfirmation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
	}
	
	public  SupplyOrderConfirmation updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderConfirmationId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();
		
		
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, loadTokens);
		
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderConfirmation.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderConfirmation.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderConfirmationManagerException(consumerOrder+" is NOT FOUND" );
			}
			
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);

		
		checkerOf(userContext).checkBuyerIdOfSupplyOrder(buyerId);
		
		checkerOf(userContext).checkSellerIdOfSupplyOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfSupplyOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfSupplyOrder(totalAmount);
		
		checkerOf(userContext).checkApprovalIdOfSupplyOrder(approvalId);
		
		checkerOf(userContext).checkProcessingIdOfSupplyOrder(processingId);
		
		checkerOf(userContext).checkPickingIdOfSupplyOrder(pickingId);
		
		checkerOf(userContext).checkShipmentIdOfSupplyOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfSupplyOrder(deliveryId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	
	}
	public  SupplyOrderConfirmation addSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderConfirmationId,buyerId, sellerId, title, totalAmount, approvalId, processingId, pickingId, shipmentId, deliveryId,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount, approvalId, processingId, pickingId, shipmentId, deliveryId);
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.addSupplyOrder( supplyOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderConfirmationId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfSupplyOrder(id);
		
		checkerOf(userContext).checkTitleOfSupplyOrder( title);
		checkerOf(userContext).checkTotalAmountOfSupplyOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
		
	}
	public  SupplyOrderConfirmation updateSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderConfirmationId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSupplyOrderProperties(userContext,supplyOrderConfirmationId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderConfirmation supplyOrderConfirmationToUpdate = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		if(supplyOrderConfirmationToUpdate.getSupplyOrderList().isEmpty()){
			throw new SupplyOrderConfirmationManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}
		
		SupplyOrder item = supplyOrderConfirmationToUpdate.getSupplyOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingSupplyOrder(userContext,supplyOrderConfirmationId,name, code, used,tokensExpr);
		SupplyOrderConfirmation supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmationToUpdate, tokens().withSupplyOrderList().done());
		synchronized(supplyOrderConfirmation){ 
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected SupplyOrder createSupplyOrder(RetailscmUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount, String approvalId, String processingId, String pickingId, String shipmentId, String deliveryId) throws Exception{

		SupplyOrder supplyOrder = new SupplyOrder();
		
		
		RetailStoreCountryCenter  buyer = new RetailStoreCountryCenter();
		buyer.setId(buyerId);		
		supplyOrder.setBuyer(buyer);		
		GoodsSupplier  seller = new GoodsSupplier();
		seller.setId(sellerId);		
		supplyOrder.setSeller(seller);		
		supplyOrder.setTitle(title);		
		supplyOrder.setTotalAmount(totalAmount);		
		SupplyOrderApproval  approval = new SupplyOrderApproval();
		approval.setId(approvalId);		
		supplyOrder.setApproval(approval);		
		SupplyOrderProcessing  processing = new SupplyOrderProcessing();
		processing.setId(processingId);		
		supplyOrder.setProcessing(processing);		
		SupplyOrderPicking  picking = new SupplyOrderPicking();
		picking.setId(pickingId);		
		supplyOrder.setPicking(picking);		
		SupplyOrderShipment  shipment = new SupplyOrderShipment();
		shipment.setId(shipmentId);		
		supplyOrder.setShipment(shipment);		
		SupplyOrderDelivery  delivery = new SupplyOrderDelivery();
		delivery.setId(deliveryId);		
		supplyOrder.setDelivery(delivery);		
		supplyOrder.setLastUpdateTime(userContext.now());
	
		
		return supplyOrder;
	
		
	}
	
	protected SupplyOrder createIndexedSupplyOrder(String id, int version){

		SupplyOrder supplyOrder = new SupplyOrder();
		supplyOrder.setId(id);
		supplyOrder.setVersion(version);
		return supplyOrder;			
		
	}
	
	protected void checkParamsForRemovingSupplyOrderList(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception {
		
<<<<<<< HEAD
		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		for(String supplyOrderIdItem: supplyOrderIds){
			userContext.getChecker().checkIdOfSupplyOrder(supplyOrderIdItem);
=======
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		for(String supplyOrderIdItem: supplyOrderIds){
			checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderIdItem);
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
		
	}
	public  SupplyOrderConfirmation removeSupplyOrderList(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSupplyOrderList(userContext, supplyOrderConfirmationId,  supplyOrderIds, tokensExpr);
			
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
			synchronized(supplyOrderConfirmation){ 
				//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderConfirmationDaoOf(userContext).planToRemoveSupplyOrderList(supplyOrderConfirmation, supplyOrderIds, allTokens());
				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderConfirmation.getSupplyOrderList());
				return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation( supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
	}
	public  SupplyOrderConfirmation removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderConfirmationId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.removeSupplyOrder( supplyOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation( supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
	}
	public  SupplyOrderConfirmation copySupplyOrderFrom(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderConfirmationId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			supplyOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderConfirmation.copySupplyOrderFrom( supplyOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)supplyOrderConfirmation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfSupplyOrder(parseString(newValueExpr));
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			checkerOf(userContext).checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
	}
	
	public  SupplyOrderConfirmation updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderConfirmationId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();
		
		
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, loadTokens);
		
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderConfirmation.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderConfirmation.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderConfirmationManagerException(supplyOrder+" is NOT FOUND" );
			}
			
			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderConfirmation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


