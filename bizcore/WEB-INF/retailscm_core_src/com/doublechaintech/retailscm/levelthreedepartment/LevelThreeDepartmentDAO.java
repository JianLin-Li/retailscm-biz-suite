
package com.doublechaintech.retailscm.levelthreedepartment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface LevelThreeDepartmentDAO extends BaseDAO{

	public SmartList<LevelThreeDepartment> loadAll();
	public LevelThreeDepartment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LevelThreeDepartment> levelThreeDepartmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public LevelThreeDepartment present(LevelThreeDepartment levelThreeDepartment,Map<String,Object> options) throws Exception;
	public LevelThreeDepartment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelThreeDepartment save(LevelThreeDepartment levelThreeDepartment,Map<String,Object> options);
	public SmartList<LevelThreeDepartment> saveLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList,Map<String,Object> options);
	public SmartList<LevelThreeDepartment> removeLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList,Map<String,Object> options);
	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLevelThreeDepartmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLevelThreeDepartmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String levelThreeDepartmentId, int version) throws Exception;
	public LevelThreeDepartment disconnectFromAll(String levelThreeDepartmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<LevelThreeDepartment> requestCandidateLevelThreeDepartmentForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LevelThreeDepartment planToRemoveEmployeeList(LevelThreeDepartment levelThreeDepartment, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect LevelThreeDepartment with company in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithCompany(LevelThreeDepartment levelThreeDepartment, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String levelThreeDepartmentId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with occupation in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithOccupation(LevelThreeDepartment levelThreeDepartment, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String levelThreeDepartmentId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with responsible_for in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithResponsibleFor(LevelThreeDepartment levelThreeDepartment, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String levelThreeDepartmentId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with current_salary_grade in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithCurrentSalaryGrade(LevelThreeDepartment levelThreeDepartment, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String levelThreeDepartmentId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with job_application in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithJobApplication(LevelThreeDepartment levelThreeDepartment, String jobApplicationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithJobApplication(String levelThreeDepartmentId, String jobApplicationId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with profession_interview in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithProfessionInterview(LevelThreeDepartment levelThreeDepartment, String professionInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithProfessionInterview(String levelThreeDepartmentId, String professionInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with hr_interview in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithHrInterview(LevelThreeDepartment levelThreeDepartment, String hrInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithHrInterview(String levelThreeDepartmentId, String hrInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with offer_approval in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithOfferApproval(LevelThreeDepartment levelThreeDepartment, String offerApprovalId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferApproval(String levelThreeDepartmentId, String offerApprovalId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with offer_acceptance in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithOfferAcceptance(LevelThreeDepartment levelThreeDepartment, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferAcceptance(String levelThreeDepartmentId, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with employee_boarding in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithEmployeeBoarding(LevelThreeDepartment levelThreeDepartment, String employeeBoardingId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithEmployeeBoarding(String levelThreeDepartmentId, String employeeBoardingId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with termination in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithTermination(LevelThreeDepartment levelThreeDepartment, String terminationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithTermination(String levelThreeDepartmentId, String terminationId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<LevelThreeDepartment> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId, Map<String,Object> options);
 	public int countLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId, Map<String,Object> options);
 	public Map<String, Integer> countLevelThreeDepartmentByBelongsToIds(String[] ids, Map<String,Object> options);
 	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId, int start, int count, Map<String,Object> options);
 	public void analyzeLevelThreeDepartmentByBelongsTo(SmartList<LevelThreeDepartment> resultList, String levelTwoDepartmentId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Employee的department的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<LevelThreeDepartment> us, Map<String,Object> options) throws Exception;
	
}


