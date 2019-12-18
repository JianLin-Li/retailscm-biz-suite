
package com.doublechaintech.retailscm.supplyorderprocessing;

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






public class SupplyOrderProcessingManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderProcessingManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderProcessing";
	@Override
	public SupplyOrderProcessingDAO daoOf(RetailscmUserContext userContext) {
		return supplyOrderProcessingDaoOf(userContext);
	}
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplyOrderProcessingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderProcessingManagerException(message);

	}
	
	

 	protected SupplyOrderProcessing saveSupplyOrderProcessing(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderProcessingDAO().save(supplyOrderProcessing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens);
 	}
 	
 	protected SupplyOrderProcessing saveSupplyOrderProcessingDetail(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing) throws Exception{	

 		
 		return saveSupplyOrderProcessing(userContext, supplyOrderProcessing, allTokens());
 	}
 	
 	public SupplyOrderProcessing loadSupplyOrderProcessing(RetailscmUserContext userContext, String supplyOrderProcessingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderProcessingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing( userContext, supplyOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderProcessing, tokens);
 	}
 	
 	
 	 public SupplyOrderProcessing searchSupplyOrderProcessing(RetailscmUserContext userContext, String supplyOrderProcessingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderProcessingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing( userContext, supplyOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderProcessing, tokens);
 	}
 	
 	

 	protected SupplyOrderProcessing present(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderProcessing,tokens);
		
		
		SupplyOrderProcessing  supplyOrderProcessingToPresent = supplyOrderProcessingDaoOf(userContext).present(supplyOrderProcessing, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderProcessingToPresent.collectRefercencesFromLists();
		supplyOrderProcessingDaoOf(userContext).alias(entityListToNaming);
		
		return  supplyOrderProcessingToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderProcessing loadSupplyOrderProcessingDetail(RetailscmUserContext userContext, String supplyOrderProcessingId) throws Exception{	
 		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing( userContext, supplyOrderProcessingId, allTokens());
 		return present(userContext,supplyOrderProcessing, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplyOrderProcessingId) throws Exception{	
 		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing( userContext, supplyOrderProcessingId, viewTokens());
 		return present(userContext,supplyOrderProcessing, allTokens());
		
 	}
 	protected SupplyOrderProcessing saveSupplyOrderProcessing(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String,Object>tokens) throws Exception{	
 		return supplyOrderProcessingDaoOf(userContext).save(supplyOrderProcessing, tokens);
 	}
 	protected SupplyOrderProcessing loadSupplyOrderProcessing(RetailscmUserContext userContext, String supplyOrderProcessingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderProcessingManagerException.class);

 
 		return supplyOrderProcessingDaoOf(userContext).load(supplyOrderProcessingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderProcessing, tokens);
		
		addAction(userContext, supplyOrderProcessing, tokens,"@create","createSupplyOrderProcessing","createSupplyOrderProcessing/","main","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"@update","updateSupplyOrderProcessing","updateSupplyOrderProcessing/"+supplyOrderProcessing.getId()+"/","main","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"@copy","cloneSupplyOrderProcessing","cloneSupplyOrderProcessing/"+supplyOrderProcessing.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderProcessing.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderProcessing.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderProcessing.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderProcessing.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderProcessing.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderProcessing.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderProcessing.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderProcessing.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public SupplyOrderProcessing createSupplyOrderProcessing(RetailscmUserContext userContext, String who,Date processTime) throws Exception
	//public SupplyOrderProcessing createSupplyOrderProcessing(RetailscmUserContext userContext,String who, Date processTime) throws Exception
	{
		
		

		

		checkerOf(userContext).checkWhoOfSupplyOrderProcessing(who);
		checkerOf(userContext).checkProcessTimeOfSupplyOrderProcessing(processTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);


		SupplyOrderProcessing supplyOrderProcessing=createNewSupplyOrderProcessing();	

		supplyOrderProcessing.setWho(who);
		supplyOrderProcessing.setProcessTime(processTime);

		supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderProcessing);
		return supplyOrderProcessing;

		
	}
	protected SupplyOrderProcessing createNewSupplyOrderProcessing() 
	{
		
		return new SupplyOrderProcessing();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderProcessing(RetailscmUserContext userContext,String supplyOrderProcessingId, int supplyOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		checkerOf(userContext).checkVersionOfSupplyOrderProcessing( supplyOrderProcessingVersion);
		

		if(SupplyOrderProcessing.WHO_PROPERTY.equals(property)){
			checkerOf(userContext).checkWhoOfSupplyOrderProcessing(parseString(newValueExpr));
		}
		if(SupplyOrderProcessing.PROCESS_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkProcessTimeOfSupplyOrderProcessing(parseDate(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
		
	}
	
	
	
	public SupplyOrderProcessing clone(RetailscmUserContext userContext, String fromSupplyOrderProcessingId) throws Exception{
		
		return supplyOrderProcessingDaoOf(userContext).clone(fromSupplyOrderProcessingId, this.allTokens());
	}
	
	public SupplyOrderProcessing internalSaveSupplyOrderProcessing(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing) throws Exception 
	{
		return internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing, allTokens());

	}
	public SupplyOrderProcessing internalSaveSupplyOrderProcessing(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplyOrderProcessing(userContext, supplyOrderProcessingId, supplyOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplyOrderProcessing){ 
			//will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderProcessing.
			if (supplyOrderProcessing.isChanged()){
			
			}
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, options);
			return supplyOrderProcessing;
			
		}

	}
	
	public SupplyOrderProcessing updateSupplyOrderProcessing(RetailscmUserContext userContext,String supplyOrderProcessingId, int supplyOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderProcessing(userContext, supplyOrderProcessingId, supplyOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		if(supplyOrderProcessing.getVersion() != supplyOrderProcessingVersion){
			String message = "The target version("+supplyOrderProcessing.getVersion()+") is not equals to version("+supplyOrderProcessingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderProcessing){ 
			//will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderProcessing.
			
			supplyOrderProcessing.changeProperty(property, newValueExpr);
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().done());
		}

	}
	
	public SupplyOrderProcessing updateSupplyOrderProcessingProperty(RetailscmUserContext userContext,String supplyOrderProcessingId, int supplyOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderProcessing(userContext, supplyOrderProcessingId, supplyOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		if(supplyOrderProcessing.getVersion() != supplyOrderProcessingVersion){
			String message = "The target version("+supplyOrderProcessing.getVersion()+") is not equals to version("+supplyOrderProcessingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderProcessing){ 
			//will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderProcessing.
			
			supplyOrderProcessing.changeProperty(property, newValueExpr);
			
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderProcessingTokens tokens(){
		return SupplyOrderProcessingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderProcessingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderProcessingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplyOrderProcessingId, int supplyOrderProcessingVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderProcessingId, supplyOrderProcessingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderProcessingId, int supplyOrderProcessingVersion) throws Exception{
			
		supplyOrderProcessingDaoOf(userContext).delete(supplyOrderProcessingId, supplyOrderProcessingVersion);
	}
	
	public SupplyOrderProcessing forgetByAll(RetailscmUserContext userContext, String supplyOrderProcessingId, int supplyOrderProcessingVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderProcessingId, supplyOrderProcessingVersion);		
	}
	protected SupplyOrderProcessing forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderProcessingId, int supplyOrderProcessingVersion) throws Exception{
			
		return supplyOrderProcessingDaoOf(userContext).disconnectFromAll(supplyOrderProcessingId, supplyOrderProcessingVersion);
	}
	
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderProcessingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return supplyOrderProcessingDaoOf(userContext).deleteAll();
	}


	//disconnect SupplyOrderProcessing with consumer in ConsumerOrder
	protected SupplyOrderProcessing breakWithConsumerOrderByConsumer(RetailscmUserContext userContext, String supplyOrderProcessingId, String consumerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveConsumerOrderListWithConsumer(supplyOrderProcessing, consumerId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with confirmation in ConsumerOrder
	protected SupplyOrderProcessing breakWithConsumerOrderByConfirmation(RetailscmUserContext userContext, String supplyOrderProcessingId, String confirmationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveConsumerOrderListWithConfirmation(supplyOrderProcessing, confirmationId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with approval in ConsumerOrder
	protected SupplyOrderProcessing breakWithConsumerOrderByApproval(RetailscmUserContext userContext, String supplyOrderProcessingId, String approvalId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveConsumerOrderListWithApproval(supplyOrderProcessing, approvalId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with shipment in ConsumerOrder
	protected SupplyOrderProcessing breakWithConsumerOrderByShipment(RetailscmUserContext userContext, String supplyOrderProcessingId, String shipmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveConsumerOrderListWithShipment(supplyOrderProcessing, shipmentId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with delivery in ConsumerOrder
	protected SupplyOrderProcessing breakWithConsumerOrderByDelivery(RetailscmUserContext userContext, String supplyOrderProcessingId, String deliveryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveConsumerOrderListWithDelivery(supplyOrderProcessing, deliveryId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with store in ConsumerOrder
	protected SupplyOrderProcessing breakWithConsumerOrderByStore(RetailscmUserContext userContext, String supplyOrderProcessingId, String storeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveConsumerOrderListWithStore(supplyOrderProcessing, storeId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with buyer in SupplyOrder
	protected SupplyOrderProcessing breakWithSupplyOrderByBuyer(RetailscmUserContext userContext, String supplyOrderProcessingId, String buyerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveSupplyOrderListWithBuyer(supplyOrderProcessing, buyerId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with seller in SupplyOrder
	protected SupplyOrderProcessing breakWithSupplyOrderBySeller(RetailscmUserContext userContext, String supplyOrderProcessingId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveSupplyOrderListWithSeller(supplyOrderProcessing, sellerId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with confirmation in SupplyOrder
	protected SupplyOrderProcessing breakWithSupplyOrderByConfirmation(RetailscmUserContext userContext, String supplyOrderProcessingId, String confirmationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveSupplyOrderListWithConfirmation(supplyOrderProcessing, confirmationId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with approval in SupplyOrder
	protected SupplyOrderProcessing breakWithSupplyOrderByApproval(RetailscmUserContext userContext, String supplyOrderProcessingId, String approvalId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveSupplyOrderListWithApproval(supplyOrderProcessing, approvalId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with picking in SupplyOrder
	protected SupplyOrderProcessing breakWithSupplyOrderByPicking(RetailscmUserContext userContext, String supplyOrderProcessingId, String pickingId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveSupplyOrderListWithPicking(supplyOrderProcessing, pickingId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with shipment in SupplyOrder
	protected SupplyOrderProcessing breakWithSupplyOrderByShipment(RetailscmUserContext userContext, String supplyOrderProcessingId, String shipmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveSupplyOrderListWithShipment(supplyOrderProcessing, shipmentId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with delivery in SupplyOrder
	protected SupplyOrderProcessing breakWithSupplyOrderByDelivery(RetailscmUserContext userContext, String supplyOrderProcessingId, String deliveryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderProcessingDaoOf(userContext).planToRemoveSupplyOrderListWithDelivery(supplyOrderProcessing, deliveryId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
				return supplyOrderProcessing;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String confirmationId, String approvalId, String shipmentId, String deliveryId, String storeId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);

		
		checkerOf(userContext).checkTitleOfConsumerOrder(title);
		
		checkerOf(userContext).checkConsumerIdOfConsumerOrder(consumerId);
		
		checkerOf(userContext).checkConfirmationIdOfConsumerOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfConsumerOrder(approvalId);
		
		checkerOf(userContext).checkShipmentIdOfConsumerOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfConsumerOrder(deliveryId);
		
		checkerOf(userContext).checkStoreIdOfConsumerOrder(storeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);

	
	}
	public  SupplyOrderProcessing addConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String confirmationId, String approvalId, String shipmentId, String deliveryId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderProcessingId,title, consumerId, confirmationId, approvalId, shipmentId, deliveryId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, confirmationId, approvalId, shipmentId, deliveryId, storeId);
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.addConsumerOrder( consumerOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderProcessingId,String id,String title,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		checkerOf(userContext).checkIdOfConsumerOrder(id);
		
		checkerOf(userContext).checkTitleOfConsumerOrder( title);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
		
	}
	public  SupplyOrderProcessing updateConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderProcessingId, String id,String title, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingConsumerOrderProperties(userContext,supplyOrderProcessingId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderProcessing supplyOrderProcessingToUpdate = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		if(supplyOrderProcessingToUpdate.getConsumerOrderList().isEmpty()){
			throw new SupplyOrderProcessingManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}
		
		ConsumerOrder item = supplyOrderProcessingToUpdate.getConsumerOrderList().first();
		
		item.updateTitle( title );

		
		//checkParamsForAddingConsumerOrder(userContext,supplyOrderProcessingId,name, code, used,tokensExpr);
		SupplyOrderProcessing supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessingToUpdate, tokens().withConsumerOrderList().done());
		synchronized(supplyOrderProcessing){ 
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ConsumerOrder createConsumerOrder(RetailscmUserContext userContext, String title, String consumerId, String confirmationId, String approvalId, String shipmentId, String deliveryId, String storeId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStoreMember  consumer = new RetailStoreMember();
		consumer.setId(consumerId);		
		consumerOrder.setConsumer(consumer);		
		SupplyOrderConfirmation  confirmation = new SupplyOrderConfirmation();
		confirmation.setId(confirmationId);		
		consumerOrder.setConfirmation(confirmation);		
		SupplyOrderApproval  approval = new SupplyOrderApproval();
		approval.setId(approvalId);		
		consumerOrder.setApproval(approval);		
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
	
	protected void checkParamsForRemovingConsumerOrderList(RetailscmUserContext userContext, String supplyOrderProcessingId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		for(String consumerOrderIdItem: consumerOrderIds){
			checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
		
	}
	public  SupplyOrderProcessing removeConsumerOrderList(RetailscmUserContext userContext, String supplyOrderProcessingId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingConsumerOrderList(userContext, supplyOrderProcessingId,  consumerOrderIds, tokensExpr);
			
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
			synchronized(supplyOrderProcessing){ 
				//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderProcessingDaoOf(userContext).planToRemoveConsumerOrderList(supplyOrderProcessing, consumerOrderIds, allTokens());
				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderProcessing.getConsumerOrderList());
				return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderProcessing( supplyOrderProcessingId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
	}
	public  SupplyOrderProcessing removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderProcessingId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.removeConsumerOrder( consumerOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderProcessing( supplyOrderProcessingId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
	}
	public  SupplyOrderProcessing copyConsumerOrderFrom(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderProcessingId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			consumerOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderProcessing.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)supplyOrderProcessing.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
	}
	
	public  SupplyOrderProcessing updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderProcessingId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();
		
		
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, loadTokens);
		
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderProcessing.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderProcessing.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderProcessingManagerException(consumerOrder+" is NOT FOUND" );
			}
			
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String pickingId, String shipmentId, String deliveryId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);

		
		checkerOf(userContext).checkBuyerIdOfSupplyOrder(buyerId);
		
		checkerOf(userContext).checkSellerIdOfSupplyOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfSupplyOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfSupplyOrder(totalAmount);
		
		checkerOf(userContext).checkConfirmationIdOfSupplyOrder(confirmationId);
		
		checkerOf(userContext).checkApprovalIdOfSupplyOrder(approvalId);
		
		checkerOf(userContext).checkPickingIdOfSupplyOrder(pickingId);
		
		checkerOf(userContext).checkShipmentIdOfSupplyOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfSupplyOrder(deliveryId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);

	
	}
	public  SupplyOrderProcessing addSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String pickingId, String shipmentId, String deliveryId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderProcessingId,buyerId, sellerId, title, totalAmount, confirmationId, approvalId, pickingId, shipmentId, deliveryId,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount, confirmationId, approvalId, pickingId, shipmentId, deliveryId);
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.addSupplyOrder( supplyOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderProcessingId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		checkerOf(userContext).checkIdOfSupplyOrder(id);
		
		checkerOf(userContext).checkTitleOfSupplyOrder( title);
		checkerOf(userContext).checkTotalAmountOfSupplyOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
		
	}
	public  SupplyOrderProcessing updateSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderProcessingId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSupplyOrderProperties(userContext,supplyOrderProcessingId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderProcessing supplyOrderProcessingToUpdate = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		if(supplyOrderProcessingToUpdate.getSupplyOrderList().isEmpty()){
			throw new SupplyOrderProcessingManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}
		
		SupplyOrder item = supplyOrderProcessingToUpdate.getSupplyOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingSupplyOrder(userContext,supplyOrderProcessingId,name, code, used,tokensExpr);
		SupplyOrderProcessing supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessingToUpdate, tokens().withSupplyOrderList().done());
		synchronized(supplyOrderProcessing){ 
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected SupplyOrder createSupplyOrder(RetailscmUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String approvalId, String pickingId, String shipmentId, String deliveryId) throws Exception{

		SupplyOrder supplyOrder = new SupplyOrder();
		
		
		RetailStoreCountryCenter  buyer = new RetailStoreCountryCenter();
		buyer.setId(buyerId);		
		supplyOrder.setBuyer(buyer);		
		GoodsSupplier  seller = new GoodsSupplier();
		seller.setId(sellerId);		
		supplyOrder.setSeller(seller);		
		supplyOrder.setTitle(title);		
		supplyOrder.setTotalAmount(totalAmount);		
		SupplyOrderConfirmation  confirmation = new SupplyOrderConfirmation();
		confirmation.setId(confirmationId);		
		supplyOrder.setConfirmation(confirmation);		
		SupplyOrderApproval  approval = new SupplyOrderApproval();
		approval.setId(approvalId);		
		supplyOrder.setApproval(approval);		
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
	
	protected void checkParamsForRemovingSupplyOrderList(RetailscmUserContext userContext, String supplyOrderProcessingId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		for(String supplyOrderIdItem: supplyOrderIds){
			checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
		
	}
	public  SupplyOrderProcessing removeSupplyOrderList(RetailscmUserContext userContext, String supplyOrderProcessingId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSupplyOrderList(userContext, supplyOrderProcessingId,  supplyOrderIds, tokensExpr);
			
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
			synchronized(supplyOrderProcessing){ 
				//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderProcessingDaoOf(userContext).planToRemoveSupplyOrderList(supplyOrderProcessing, supplyOrderIds, allTokens());
				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderProcessing.getSupplyOrderList());
				return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderProcessing( supplyOrderProcessingId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
	}
	public  SupplyOrderProcessing removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderProcessingId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.removeSupplyOrder( supplyOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderProcessing( supplyOrderProcessingId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
	}
	public  SupplyOrderProcessing copySupplyOrderFrom(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderProcessingId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			supplyOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderProcessing.copySupplyOrderFrom( supplyOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)supplyOrderProcessing.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfSupplyOrder(parseString(newValueExpr));
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			checkerOf(userContext).checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
	}
	
	public  SupplyOrderProcessing updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderProcessingId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();
		
		
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, loadTokens);
		
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderProcessing.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderProcessing.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderProcessingManagerException(supplyOrder+" is NOT FOUND" );
			}
			
			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderProcessing newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


