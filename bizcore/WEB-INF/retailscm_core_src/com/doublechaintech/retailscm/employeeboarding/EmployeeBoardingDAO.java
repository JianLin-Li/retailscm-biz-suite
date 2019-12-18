
package com.doublechaintech.retailscm.employeeboarding;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface EmployeeBoardingDAO extends BaseDAO{

	public SmartList<EmployeeBoarding> loadAll();
	public EmployeeBoarding load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeBoarding> employeeBoardingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EmployeeBoarding present(EmployeeBoarding employeeBoarding,Map<String,Object> options) throws Exception;
	public EmployeeBoarding clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeBoarding save(EmployeeBoarding employeeBoarding,Map<String,Object> options);
	public SmartList<EmployeeBoarding> saveEmployeeBoardingList(SmartList<EmployeeBoarding> employeeBoardingList,Map<String,Object> options);
	public SmartList<EmployeeBoarding> removeEmployeeBoardingList(SmartList<EmployeeBoarding> employeeBoardingList,Map<String,Object> options);
	public SmartList<EmployeeBoarding> findEmployeeBoardingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeBoardingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeBoardingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeBoardingId, int version) throws Exception;
	public EmployeeBoarding disconnectFromAll(String employeeBoardingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<EmployeeBoarding> requestCandidateEmployeeBoardingForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public EmployeeBoarding planToRemoveEmployeeList(EmployeeBoarding employeeBoarding, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect EmployeeBoarding with company in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithCompany(EmployeeBoarding employeeBoarding, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String employeeBoardingId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with department in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithDepartment(EmployeeBoarding employeeBoarding, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String employeeBoardingId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with occupation in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithOccupation(EmployeeBoarding employeeBoarding, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String employeeBoardingId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with responsible_for in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithResponsibleFor(EmployeeBoarding employeeBoarding, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String employeeBoardingId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with current_salary_grade in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithCurrentSalaryGrade(EmployeeBoarding employeeBoarding, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String employeeBoardingId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with job_application in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithJobApplication(EmployeeBoarding employeeBoarding, String jobApplicationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithJobApplication(String employeeBoardingId, String jobApplicationId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with profession_interview in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithProfessionInterview(EmployeeBoarding employeeBoarding, String professionInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithProfessionInterview(String employeeBoardingId, String professionInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with hr_interview in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithHrInterview(EmployeeBoarding employeeBoarding, String hrInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithHrInterview(String employeeBoardingId, String hrInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with offer_approval in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithOfferApproval(EmployeeBoarding employeeBoarding, String offerApprovalId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferApproval(String employeeBoardingId, String offerApprovalId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with offer_acceptance in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithOfferAcceptance(EmployeeBoarding employeeBoarding, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferAcceptance(String employeeBoardingId, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with termination in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithTermination(EmployeeBoarding employeeBoarding, String terminationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithTermination(String employeeBoardingId, String terminationId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<EmployeeBoarding> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);

	// 需要一个加载引用我的对象的enhance方法:Employee的employeeBoarding的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<EmployeeBoarding> us, Map<String,Object> options) throws Exception;
	
}


