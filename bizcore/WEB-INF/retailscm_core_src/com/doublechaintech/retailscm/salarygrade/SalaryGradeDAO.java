
package com.doublechaintech.retailscm.salarygrade;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;

import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface SalaryGradeDAO extends BaseDAO{

	public SmartList<SalaryGrade> loadAll();
	public SalaryGrade load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SalaryGrade> salaryGradeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SalaryGrade present(SalaryGrade salaryGrade,Map<String,Object> options) throws Exception;
	public SalaryGrade clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SalaryGrade save(SalaryGrade salaryGrade,Map<String,Object> options);
	public SmartList<SalaryGrade> saveSalaryGradeList(SmartList<SalaryGrade> salaryGradeList,Map<String,Object> options);
	public SmartList<SalaryGrade> removeSalaryGradeList(SmartList<SalaryGrade> salaryGradeList,Map<String,Object> options);
	public SmartList<SalaryGrade> findSalaryGradeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSalaryGradeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSalaryGradeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String salaryGradeId, int version) throws Exception;
	public SalaryGrade disconnectFromAll(String salaryGradeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO();
		
	
 	public SmartList<SalaryGrade> requestCandidateSalaryGradeForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SalaryGrade> requestCandidateSalaryGradeForEmployeeSalarySheet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SalaryGrade planToRemoveEmployeeList(SalaryGrade salaryGrade, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect SalaryGrade with company in Employee
	public SalaryGrade planToRemoveEmployeeListWithCompany(SalaryGrade salaryGrade, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String salaryGradeId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect SalaryGrade with department in Employee
	public SalaryGrade planToRemoveEmployeeListWithDepartment(SalaryGrade salaryGrade, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String salaryGradeId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect SalaryGrade with occupation in Employee
	public SalaryGrade planToRemoveEmployeeListWithOccupation(SalaryGrade salaryGrade, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String salaryGradeId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect SalaryGrade with responsible_for in Employee
	public SalaryGrade planToRemoveEmployeeListWithResponsibleFor(SalaryGrade salaryGrade, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String salaryGradeId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect SalaryGrade with job_application in Employee
	public SalaryGrade planToRemoveEmployeeListWithJobApplication(SalaryGrade salaryGrade, String jobApplicationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithJobApplication(String salaryGradeId, String jobApplicationId, Map<String,Object> options)throws Exception;
	
	//disconnect SalaryGrade with profession_interview in Employee
	public SalaryGrade planToRemoveEmployeeListWithProfessionInterview(SalaryGrade salaryGrade, String professionInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithProfessionInterview(String salaryGradeId, String professionInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect SalaryGrade with hr_interview in Employee
	public SalaryGrade planToRemoveEmployeeListWithHrInterview(SalaryGrade salaryGrade, String hrInterviewId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithHrInterview(String salaryGradeId, String hrInterviewId, Map<String,Object> options)throws Exception;
	
	//disconnect SalaryGrade with offer_approval in Employee
	public SalaryGrade planToRemoveEmployeeListWithOfferApproval(SalaryGrade salaryGrade, String offerApprovalId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferApproval(String salaryGradeId, String offerApprovalId, Map<String,Object> options)throws Exception;
	
	//disconnect SalaryGrade with offer_acceptance in Employee
	public SalaryGrade planToRemoveEmployeeListWithOfferAcceptance(SalaryGrade salaryGrade, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOfferAcceptance(String salaryGradeId, String offerAcceptanceId, Map<String,Object> options)throws Exception;
	
	//disconnect SalaryGrade with employee_boarding in Employee
	public SalaryGrade planToRemoveEmployeeListWithEmployeeBoarding(SalaryGrade salaryGrade, String employeeBoardingId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithEmployeeBoarding(String salaryGradeId, String employeeBoardingId, Map<String,Object> options)throws Exception;
	
	//disconnect SalaryGrade with termination in Employee
	public SalaryGrade planToRemoveEmployeeListWithTermination(SalaryGrade salaryGrade, String terminationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithTermination(String salaryGradeId, String terminationId, Map<String,Object> options)throws Exception;
	
	public SalaryGrade planToRemoveEmployeeSalarySheetList(SalaryGrade salaryGrade, String employeeSalarySheetIds[], Map<String,Object> options)throws Exception;


	//disconnect SalaryGrade with employee in EmployeeSalarySheet
	public SalaryGrade planToRemoveEmployeeSalarySheetListWithEmployee(SalaryGrade salaryGrade, String employeeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSalarySheetListWithEmployee(String salaryGradeId, String employeeId, Map<String,Object> options)throws Exception;
	
	//disconnect SalaryGrade with paying_off in EmployeeSalarySheet
	public SalaryGrade planToRemoveEmployeeSalarySheetListWithPayingOff(SalaryGrade salaryGrade, String payingOffId, Map<String,Object> options)throws Exception;
	public int countEmployeeSalarySheetListWithPayingOff(String salaryGradeId, String payingOffId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SalaryGrade> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<SalaryGrade> findSalaryGradeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countSalaryGradeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countSalaryGradeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<SalaryGrade> findSalaryGradeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeSalaryGradeByCompany(SmartList<SalaryGrade> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Employee的currentSalaryGrade的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<SalaryGrade> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeSalarySheet的currentSalaryGrade的EmployeeSalarySheetList
	public SmartList<EmployeeSalarySheet> loadOurEmployeeSalarySheetList(RetailscmUserContext userContext, List<SalaryGrade> us, Map<String,Object> options) throws Exception;
	
}


