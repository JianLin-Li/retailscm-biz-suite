
package com.doublechaintech.retailscm.consumerordershipment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


<<<<<<< HEAD


public interface ConsumerOrderShipmentDAO{
=======
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe


public interface ConsumerOrderShipmentDAO extends BaseDAO{

	public SmartList<ConsumerOrderShipment> loadAll();
	public ConsumerOrderShipment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ConsumerOrderShipment> consumerOrderShipmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ConsumerOrderShipment present(ConsumerOrderShipment consumerOrderShipment,Map<String,Object> options) throws Exception;
	public ConsumerOrderShipment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderShipment save(ConsumerOrderShipment consumerOrderShipment,Map<String,Object> options);
	public SmartList<ConsumerOrderShipment> saveConsumerOrderShipmentList(SmartList<ConsumerOrderShipment> consumerOrderShipmentList,Map<String,Object> options);
	public SmartList<ConsumerOrderShipment> removeConsumerOrderShipmentList(SmartList<ConsumerOrderShipment> consumerOrderShipmentList,Map<String,Object> options);
	public SmartList<ConsumerOrderShipment> findConsumerOrderShipmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countConsumerOrderShipmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countConsumerOrderShipmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String consumerOrderShipmentId, int version) throws Exception;
	public ConsumerOrderShipment disconnectFromAll(String consumerOrderShipmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ConsumerOrderShipment> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);

}


