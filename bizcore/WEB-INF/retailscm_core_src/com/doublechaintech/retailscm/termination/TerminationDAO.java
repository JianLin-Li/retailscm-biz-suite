
package com.doublechaintech.retailscm.termination;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;

import com.doublechaintech.retailscm.terminationtype.TerminationTypeDAO;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface TerminationDAO extends BaseDAO{

	public SmartList<Termination> loadAll();
	public Termination load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Termination> terminationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Termination present(Termination termination,Map<String,Object> options) throws Exception;
	public Termination clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Termination save(Termination termination,Map<String,Object> options);
	public SmartList<Termination> saveTerminationList(SmartList<Termination> terminationList,Map<String,Object> options);
	public SmartList<Termination> removeTerminationList(SmartList<Termination> terminationList,Map<String,Object> options);
	public SmartList<Termination> findTerminationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTerminationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTerminationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String terminationId, int version) throws Exception;
	public Termination disconnectFromAll(String terminationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<Termination> requestCandidateTerminationForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Termination planToRemoveEmployeeList(Termination termination, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect Termination with company in Employee
	public Termination planToRemoveEmployeeListWithCompany(Termination termination, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String terminationId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with department in Employee
	public Termination planToRemoveEmployeeListWithDepartment(Termination termination, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String terminationId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with occupation in Employee
	public Termination planToRemoveEmployeeListWithOccupation(Termination termination, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String terminationId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with responsible_for in Employee
	public Termination planToRemoveEmployeeListWithResponsibleFor(Termination termination, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String terminationId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with current_salary_grade in Employee
	public Termination planToRemoveEmployeeListWithCurrentSalaryGrade(Termination termination, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String terminationId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with job_application in Employee
	public Termination planToRemoveEmployeeListWithJobApplication(Termination termination, String jobApplicationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithJobApplication(String terminationId, String jobApplicationId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with profession_interview in Employee
	public Termination planToRemoveEmployeeListWithProfessionInterview(Termination termination, String professionInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithProfessionInterview(String terminationId, String professionInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with hr_interview in Employee
	public Termination planToRemoveEmployeeListWithHrInterview(Termination termination, String hrInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithHrInterview(String terminationId, String hrInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with offer_approval in Employee
	public Termination planToRemoveEmployeeListWithOfferApproval(Termination termination, String offerApprovalId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferApproval(String terminationId, String offerApprovalId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with offer_acceptance in Employee
	public Termination planToRemoveEmployeeListWithOfferAcceptance(Termination termination, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferAcceptance(String terminationId, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with employee_boarding in Employee
	public Termination planToRemoveEmployeeListWithEmployeeBoarding(Termination termination, String employeeBoardingId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithEmployeeBoarding(String terminationId, String employeeBoardingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Termination> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<Termination> findTerminationByReason(String terminationReasonId, Map<String,Object> options);
 	public int countTerminationByReason(String terminationReasonId, Map<String,Object> options);
 	public Map<String, Integer> countTerminationByReasonIds(String[] ids, Map<String,Object> options);
 	public SmartList<Termination> findTerminationByReason(String terminationReasonId, int start, int count, Map<String,Object> options);
 	public void analyzeTerminationByReason(SmartList<Termination> resultList, String terminationReasonId, Map<String,Object> options);

 
  
 	public SmartList<Termination> findTerminationByType(String terminationTypeId, Map<String,Object> options);
 	public int countTerminationByType(String terminationTypeId, Map<String,Object> options);
 	public Map<String, Integer> countTerminationByTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<Termination> findTerminationByType(String terminationTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeTerminationByType(SmartList<Termination> resultList, String terminationTypeId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Employee的termination的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<Termination> us, Map<String,Object> options) throws Exception;
	
}


