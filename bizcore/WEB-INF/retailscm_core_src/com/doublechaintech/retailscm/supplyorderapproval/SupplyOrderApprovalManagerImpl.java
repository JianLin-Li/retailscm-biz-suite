
package com.doublechaintech.retailscm.supplyorderapproval;

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






public class SupplyOrderApprovalManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderApprovalManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderApproval";
	@Override
	public SupplyOrderApprovalDAO daoOf(RetailscmUserContext userContext) {
		return supplyOrderApprovalDaoOf(userContext);
	}
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplyOrderApprovalManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderApprovalManagerException(message);

	}
	
	

 	protected SupplyOrderApproval saveSupplyOrderApproval(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderApprovalDAO().save(supplyOrderApproval, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens);
 	}
 	
 	protected SupplyOrderApproval saveSupplyOrderApprovalDetail(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval) throws Exception{	

 		
 		return saveSupplyOrderApproval(userContext, supplyOrderApproval, allTokens());
 	}
 	
 	public SupplyOrderApproval loadSupplyOrderApproval(RetailscmUserContext userContext, String supplyOrderApprovalId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderApprovalManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderApproval, tokens);
 	}
 	
 	
 	 public SupplyOrderApproval searchSupplyOrderApproval(RetailscmUserContext userContext, String supplyOrderApprovalId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderApprovalManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderApproval, tokens);
 	}
 	
 	

 	protected SupplyOrderApproval present(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderApproval,tokens);
		
		
		SupplyOrderApproval  supplyOrderApprovalToPresent = supplyOrderApprovalDaoOf(userContext).present(supplyOrderApproval, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderApprovalToPresent.collectRefercencesFromLists();
		supplyOrderApprovalDaoOf(userContext).alias(entityListToNaming);
		
		return  supplyOrderApprovalToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderApproval loadSupplyOrderApprovalDetail(RetailscmUserContext userContext, String supplyOrderApprovalId) throws Exception{	
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, allTokens());
 		return present(userContext,supplyOrderApproval, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplyOrderApprovalId) throws Exception{	
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, viewTokens());
 		return present(userContext,supplyOrderApproval, allTokens());
		
 	}
 	protected SupplyOrderApproval saveSupplyOrderApproval(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String,Object>tokens) throws Exception{	
 		return supplyOrderApprovalDaoOf(userContext).save(supplyOrderApproval, tokens);
 	}
 	protected SupplyOrderApproval loadSupplyOrderApproval(RetailscmUserContext userContext, String supplyOrderApprovalId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderApprovalManagerException.class);

 
 		return supplyOrderApprovalDaoOf(userContext).load(supplyOrderApprovalId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderApproval, tokens);
		
		addAction(userContext, supplyOrderApproval, tokens,"@create","createSupplyOrderApproval","createSupplyOrderApproval/","main","primary");
		addAction(userContext, supplyOrderApproval, tokens,"@update","updateSupplyOrderApproval","updateSupplyOrderApproval/"+supplyOrderApproval.getId()+"/","main","primary");
		addAction(userContext, supplyOrderApproval, tokens,"@copy","cloneSupplyOrderApproval","cloneSupplyOrderApproval/"+supplyOrderApproval.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public SupplyOrderApproval createSupplyOrderApproval(RetailscmUserContext userContext, String who,Date approveTime) throws Exception
	//public SupplyOrderApproval createSupplyOrderApproval(RetailscmUserContext userContext,String who, Date approveTime) throws Exception
	{
		
		

		

		checkerOf(userContext).checkWhoOfSupplyOrderApproval(who);
		checkerOf(userContext).checkApproveTimeOfSupplyOrderApproval(approveTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);


		SupplyOrderApproval supplyOrderApproval=createNewSupplyOrderApproval();	

		supplyOrderApproval.setWho(who);
		supplyOrderApproval.setApproveTime(approveTime);

		supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderApproval);
		return supplyOrderApproval;

		
	}
	protected SupplyOrderApproval createNewSupplyOrderApproval() 
	{
		
		return new SupplyOrderApproval();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderApproval(RetailscmUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).checkVersionOfSupplyOrderApproval( supplyOrderApprovalVersion);
		

		if(SupplyOrderApproval.WHO_PROPERTY.equals(property)){
			checkerOf(userContext).checkWhoOfSupplyOrderApproval(parseString(newValueExpr));
		}
		if(SupplyOrderApproval.APPROVE_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkApproveTimeOfSupplyOrderApproval(parseDate(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
		
	}
	
	
	
	public SupplyOrderApproval clone(RetailscmUserContext userContext, String fromSupplyOrderApprovalId) throws Exception{
		
		return supplyOrderApprovalDaoOf(userContext).clone(fromSupplyOrderApprovalId, this.allTokens());
	}
	
	public SupplyOrderApproval internalSaveSupplyOrderApproval(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval) throws Exception 
	{
		return internalSaveSupplyOrderApproval(userContext, supplyOrderApproval, allTokens());

	}
	public SupplyOrderApproval internalSaveSupplyOrderApproval(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplyOrderApproval(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplyOrderApproval){ 
			//will be good when the supplyOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderApproval.
			if (supplyOrderApproval.isChanged()){
			
			}
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, options);
			return supplyOrderApproval;
			
		}

	}
	
	public SupplyOrderApproval updateSupplyOrderApproval(RetailscmUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderApproval(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		if(supplyOrderApproval.getVersion() != supplyOrderApprovalVersion){
			String message = "The target version("+supplyOrderApproval.getVersion()+") is not equals to version("+supplyOrderApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderApproval){ 
			//will be good when the supplyOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderApproval.
			
			supplyOrderApproval.changeProperty(property, newValueExpr);
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
		}

	}
	
	public SupplyOrderApproval updateSupplyOrderApprovalProperty(RetailscmUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderApproval(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		if(supplyOrderApproval.getVersion() != supplyOrderApprovalVersion){
			String message = "The target version("+supplyOrderApproval.getVersion()+") is not equals to version("+supplyOrderApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderApproval){ 
			//will be good when the supplyOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderApproval.
			
			supplyOrderApproval.changeProperty(property, newValueExpr);
			
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderApprovalTokens tokens(){
		return SupplyOrderApprovalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderApprovalTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderApprovalTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception{
			
		supplyOrderApprovalDaoOf(userContext).delete(supplyOrderApprovalId, supplyOrderApprovalVersion);
	}
	
	public SupplyOrderApproval forgetByAll(RetailscmUserContext userContext, String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion);		
	}
	protected SupplyOrderApproval forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception{
			
		return supplyOrderApprovalDaoOf(userContext).disconnectFromAll(supplyOrderApprovalId, supplyOrderApprovalVersion);
	}
	
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderApprovalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return supplyOrderApprovalDaoOf(userContext).deleteAll();
	}


	//disconnect SupplyOrderApproval with consumer in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByConsumer(RetailscmUserContext userContext, String supplyOrderApprovalId, String consumerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderListWithConsumer(supplyOrderApproval, consumerId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with confirmation in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByConfirmation(RetailscmUserContext userContext, String supplyOrderApprovalId, String confirmationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderListWithConfirmation(supplyOrderApproval, confirmationId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with processing in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByProcessing(RetailscmUserContext userContext, String supplyOrderApprovalId, String processingId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderListWithProcessing(supplyOrderApproval, processingId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with shipment in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByShipment(RetailscmUserContext userContext, String supplyOrderApprovalId, String shipmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderListWithShipment(supplyOrderApproval, shipmentId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with delivery in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByDelivery(RetailscmUserContext userContext, String supplyOrderApprovalId, String deliveryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderListWithDelivery(supplyOrderApproval, deliveryId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with store in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByStore(RetailscmUserContext userContext, String supplyOrderApprovalId, String storeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderListWithStore(supplyOrderApproval, storeId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with buyer in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByBuyer(RetailscmUserContext userContext, String supplyOrderApprovalId, String buyerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithBuyer(supplyOrderApproval, buyerId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with seller in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderBySeller(RetailscmUserContext userContext, String supplyOrderApprovalId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithSeller(supplyOrderApproval, sellerId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with confirmation in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByConfirmation(RetailscmUserContext userContext, String supplyOrderApprovalId, String confirmationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithConfirmation(supplyOrderApproval, confirmationId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with processing in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByProcessing(RetailscmUserContext userContext, String supplyOrderApprovalId, String processingId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithProcessing(supplyOrderApproval, processingId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with picking in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByPicking(RetailscmUserContext userContext, String supplyOrderApprovalId, String pickingId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithPicking(supplyOrderApproval, pickingId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with shipment in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByShipment(RetailscmUserContext userContext, String supplyOrderApprovalId, String shipmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithShipment(supplyOrderApproval, shipmentId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with delivery in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByDelivery(RetailscmUserContext userContext, String supplyOrderApprovalId, String deliveryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderListWithDelivery(supplyOrderApproval, deliveryId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String confirmationId, String processingId, String shipmentId, String deliveryId, String storeId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);

		
		checkerOf(userContext).checkTitleOfConsumerOrder(title);
		
		checkerOf(userContext).checkConsumerIdOfConsumerOrder(consumerId);
		
		checkerOf(userContext).checkConfirmationIdOfConsumerOrder(confirmationId);
		
		checkerOf(userContext).checkProcessingIdOfConsumerOrder(processingId);
		
		checkerOf(userContext).checkShipmentIdOfConsumerOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfConsumerOrder(deliveryId);
		
		checkerOf(userContext).checkStoreIdOfConsumerOrder(storeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	
	}
	public  SupplyOrderApproval addConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String confirmationId, String processingId, String shipmentId, String deliveryId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderApprovalId,title, consumerId, confirmationId, processingId, shipmentId, deliveryId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, confirmationId, processingId, shipmentId, deliveryId, storeId);
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.addConsumerOrder( consumerOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderApprovalId,String id,String title,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfConsumerOrder(id);
		
		checkerOf(userContext).checkTitleOfConsumerOrder( title);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
		
	}
	public  SupplyOrderApproval updateConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderApprovalId, String id,String title, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingConsumerOrderProperties(userContext,supplyOrderApprovalId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderApproval supplyOrderApprovalToUpdate = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		if(supplyOrderApprovalToUpdate.getConsumerOrderList().isEmpty()){
			throw new SupplyOrderApprovalManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}
		
		ConsumerOrder item = supplyOrderApprovalToUpdate.getConsumerOrderList().first();
		
		item.updateTitle( title );

		
		//checkParamsForAddingConsumerOrder(userContext,supplyOrderApprovalId,name, code, used,tokensExpr);
		SupplyOrderApproval supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApprovalToUpdate, tokens().withConsumerOrderList().done());
		synchronized(supplyOrderApproval){ 
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ConsumerOrder createConsumerOrder(RetailscmUserContext userContext, String title, String consumerId, String confirmationId, String processingId, String shipmentId, String deliveryId, String storeId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStoreMember  consumer = new RetailStoreMember();
		consumer.setId(consumerId);		
		consumerOrder.setConsumer(consumer);		
		SupplyOrderConfirmation  confirmation = new SupplyOrderConfirmation();
		confirmation.setId(confirmationId);		
		consumerOrder.setConfirmation(confirmation);		
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
	
	protected void checkParamsForRemovingConsumerOrderList(RetailscmUserContext userContext, String supplyOrderApprovalId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		for(String consumerOrderIdItem: consumerOrderIds){
			checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
		
	}
	public  SupplyOrderApproval removeConsumerOrderList(RetailscmUserContext userContext, String supplyOrderApprovalId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingConsumerOrderList(userContext, supplyOrderApprovalId,  consumerOrderIds, tokensExpr);
			
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
			synchronized(supplyOrderApproval){ 
				//Will be good when the supplyOrderApproval loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderApprovalDaoOf(userContext).planToRemoveConsumerOrderList(supplyOrderApproval, consumerOrderIds, allTokens());
				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderApproval.getConsumerOrderList());
				return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval( supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
	}
	public  SupplyOrderApproval removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderApprovalId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.removeConsumerOrder( consumerOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval( supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
	}
	public  SupplyOrderApproval copyConsumerOrderFrom(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderApprovalId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			consumerOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderApproval.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)supplyOrderApproval.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
	}
	
	public  SupplyOrderApproval updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderApprovalId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();
		
		
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, loadTokens);
		
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderApproval.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderApproval.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderApprovalManagerException(consumerOrder+" is NOT FOUND" );
			}
			
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);

		
		checkerOf(userContext).checkBuyerIdOfSupplyOrder(buyerId);
		
		checkerOf(userContext).checkSellerIdOfSupplyOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfSupplyOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfSupplyOrder(totalAmount);
		
		checkerOf(userContext).checkConfirmationIdOfSupplyOrder(confirmationId);
		
		checkerOf(userContext).checkProcessingIdOfSupplyOrder(processingId);
		
		checkerOf(userContext).checkPickingIdOfSupplyOrder(pickingId);
		
		checkerOf(userContext).checkShipmentIdOfSupplyOrder(shipmentId);
		
		checkerOf(userContext).checkDeliveryIdOfSupplyOrder(deliveryId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	
	}
	public  SupplyOrderApproval addSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderApprovalId,buyerId, sellerId, title, totalAmount, confirmationId, processingId, pickingId, shipmentId, deliveryId,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount, confirmationId, processingId, pickingId, shipmentId, deliveryId);
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.addSupplyOrder( supplyOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderApprovalId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfSupplyOrder(id);
		
		checkerOf(userContext).checkTitleOfSupplyOrder( title);
		checkerOf(userContext).checkTotalAmountOfSupplyOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
		
	}
	public  SupplyOrderApproval updateSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderApprovalId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSupplyOrderProperties(userContext,supplyOrderApprovalId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderApproval supplyOrderApprovalToUpdate = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		if(supplyOrderApprovalToUpdate.getSupplyOrderList().isEmpty()){
			throw new SupplyOrderApprovalManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}
		
		SupplyOrder item = supplyOrderApprovalToUpdate.getSupplyOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingSupplyOrder(userContext,supplyOrderApprovalId,name, code, used,tokensExpr);
		SupplyOrderApproval supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApprovalToUpdate, tokens().withSupplyOrderList().done());
		synchronized(supplyOrderApproval){ 
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected SupplyOrder createSupplyOrder(RetailscmUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount, String confirmationId, String processingId, String pickingId, String shipmentId, String deliveryId) throws Exception{

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
	
	protected void checkParamsForRemovingSupplyOrderList(RetailscmUserContext userContext, String supplyOrderApprovalId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		for(String supplyOrderIdItem: supplyOrderIds){
			checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
		
	}
	public  SupplyOrderApproval removeSupplyOrderList(RetailscmUserContext userContext, String supplyOrderApprovalId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSupplyOrderList(userContext, supplyOrderApprovalId,  supplyOrderIds, tokensExpr);
			
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
			synchronized(supplyOrderApproval){ 
				//Will be good when the supplyOrderApproval loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplyOrderApprovalDaoOf(userContext).planToRemoveSupplyOrderList(supplyOrderApproval, supplyOrderIds, allTokens());
				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderApproval.getSupplyOrderList());
				return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval( supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
	}
	public  SupplyOrderApproval removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderApprovalId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.removeSupplyOrder( supplyOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplyOrderApproval( supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
	}
	public  SupplyOrderApproval copySupplyOrderFrom(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderApprovalId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			supplyOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderApproval.copySupplyOrderFrom( supplyOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)supplyOrderApproval.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfSupplyOrder(parseString(newValueExpr));
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			checkerOf(userContext).checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
	}
	
	public  SupplyOrderApproval updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderApprovalId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();
		
		
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, loadTokens);
		
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderApproval.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderApproval.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderApprovalManagerException(supplyOrder+" is NOT FOUND" );
			}
			
			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderApproval newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


