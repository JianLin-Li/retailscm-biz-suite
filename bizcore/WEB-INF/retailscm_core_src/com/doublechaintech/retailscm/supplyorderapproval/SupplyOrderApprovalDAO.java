
package com.doublechaintech.retailscm.supplyorderapproval;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;


public interface SupplyOrderApprovalDAO extends BaseDAO{

	public SmartList<SupplyOrderApproval> loadAll();
	public SupplyOrderApproval load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrderApproval> supplyOrderApprovalList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrderApproval present(SupplyOrderApproval supplyOrderApproval,Map<String,Object> options) throws Exception;
	public SupplyOrderApproval clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderApproval save(SupplyOrderApproval supplyOrderApproval,Map<String,Object> options);
	public SmartList<SupplyOrderApproval> saveSupplyOrderApprovalList(SmartList<SupplyOrderApproval> supplyOrderApprovalList,Map<String,Object> options);
	public SmartList<SupplyOrderApproval> removeSupplyOrderApprovalList(SmartList<SupplyOrderApproval> supplyOrderApprovalList,Map<String,Object> options);
	public SmartList<SupplyOrderApproval> findSupplyOrderApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderApprovalWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderApprovalId, int version) throws Exception;
	public SupplyOrderApproval disconnectFromAll(String supplyOrderApprovalId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderDAO getConsumerOrderDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	
 	public SmartList<SupplyOrderApproval> requestCandidateSupplyOrderApprovalForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SupplyOrderApproval> requestCandidateSupplyOrderApprovalForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplyOrderApproval planToRemoveConsumerOrderList(SupplyOrderApproval supplyOrderApproval, String consumerOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderApproval with consumer in ConsumerOrder
	public SupplyOrderApproval planToRemoveConsumerOrderListWithConsumer(SupplyOrderApproval supplyOrderApproval, String consumerId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConsumer(String supplyOrderApprovalId, String consumerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with confirmation in ConsumerOrder
	public SupplyOrderApproval planToRemoveConsumerOrderListWithConfirmation(SupplyOrderApproval supplyOrderApproval, String confirmationId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConfirmation(String supplyOrderApprovalId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with processing in ConsumerOrder
	public SupplyOrderApproval planToRemoveConsumerOrderListWithProcessing(SupplyOrderApproval supplyOrderApproval, String processingId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithProcessing(String supplyOrderApprovalId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with shipment in ConsumerOrder
	public SupplyOrderApproval planToRemoveConsumerOrderListWithShipment(SupplyOrderApproval supplyOrderApproval, String shipmentId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithShipment(String supplyOrderApprovalId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with delivery in ConsumerOrder
	public SupplyOrderApproval planToRemoveConsumerOrderListWithDelivery(SupplyOrderApproval supplyOrderApproval, String deliveryId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithDelivery(String supplyOrderApprovalId, String deliveryId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with store in ConsumerOrder
	public SupplyOrderApproval planToRemoveConsumerOrderListWithStore(SupplyOrderApproval supplyOrderApproval, String storeId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithStore(String supplyOrderApprovalId, String storeId, Map<String,Object> options)throws Exception;
	
	public SupplyOrderApproval planToRemoveSupplyOrderList(SupplyOrderApproval supplyOrderApproval, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrderApproval with buyer in SupplyOrder
	public SupplyOrderApproval planToRemoveSupplyOrderListWithBuyer(SupplyOrderApproval supplyOrderApproval, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String supplyOrderApprovalId, String buyerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with seller in SupplyOrder
	public SupplyOrderApproval planToRemoveSupplyOrderListWithSeller(SupplyOrderApproval supplyOrderApproval, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String supplyOrderApprovalId, String sellerId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with confirmation in SupplyOrder
	public SupplyOrderApproval planToRemoveSupplyOrderListWithConfirmation(SupplyOrderApproval supplyOrderApproval, String confirmationId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithConfirmation(String supplyOrderApprovalId, String confirmationId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with processing in SupplyOrder
	public SupplyOrderApproval planToRemoveSupplyOrderListWithProcessing(SupplyOrderApproval supplyOrderApproval, String processingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithProcessing(String supplyOrderApprovalId, String processingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with picking in SupplyOrder
	public SupplyOrderApproval planToRemoveSupplyOrderListWithPicking(SupplyOrderApproval supplyOrderApproval, String pickingId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithPicking(String supplyOrderApprovalId, String pickingId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with shipment in SupplyOrder
	public SupplyOrderApproval planToRemoveSupplyOrderListWithShipment(SupplyOrderApproval supplyOrderApproval, String shipmentId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithShipment(String supplyOrderApprovalId, String shipmentId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrderApproval with delivery in SupplyOrder
	public SupplyOrderApproval planToRemoveSupplyOrderListWithDelivery(SupplyOrderApproval supplyOrderApproval, String deliveryId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithDelivery(String supplyOrderApprovalId, String deliveryId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplyOrderApproval> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);

	// 需要一个加载引用我的对象的enhance方法:ConsumerOrder的approval的ConsumerOrderList
	public SmartList<ConsumerOrder> loadOurConsumerOrderList(RetailscmUserContext userContext, List<SupplyOrderApproval> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrder的approval的SupplyOrderList
	public SmartList<SupplyOrder> loadOurSupplyOrderList(RetailscmUserContext userContext, List<SupplyOrderApproval> us, Map<String,Object> options) throws Exception;
	
}


