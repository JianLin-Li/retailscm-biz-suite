
package com.doublechaintech.retailscm.termination;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface TerminationManager extends BaseManager{

		

	public Termination createTermination(RetailscmUserContext userContext, String reasonId,String typeId,String comment) throws Exception;	
	public Termination updateTermination(RetailscmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Termination loadTermination(RetailscmUserContext userContext, String terminationId, String [] tokensExpr) throws Exception;
	public Termination internalSaveTermination(RetailscmUserContext userContext, Termination termination) throws Exception;
	public Termination internalSaveTermination(RetailscmUserContext userContext, Termination termination,Map<String,Object>option) throws Exception;
	
	public Termination transferToAnotherReason(RetailscmUserContext userContext, String terminationId, String anotherReasonId)  throws Exception;
 	public Termination transferToAnotherType(RetailscmUserContext userContext, String terminationId, String anotherTypeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String terminationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, Termination newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String terminationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId ,String [] tokensExpr)  throws Exception;
	
	public  Termination addEmployee(RetailscmUserContext userContext, String terminationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String jobApplicationId, String professionInterviewId, String hrInterviewId, String offerApprovalId, String offerAcceptanceId, String employeeBoardingId , String [] tokensExpr)  throws Exception;
	public  Termination removeEmployee(RetailscmUserContext userContext, String terminationId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  Termination updateEmployee(RetailscmUserContext userContext, String terminationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


