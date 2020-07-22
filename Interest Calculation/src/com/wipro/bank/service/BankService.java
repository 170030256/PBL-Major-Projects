package com.wipro.bank.service;

import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;


public class BankService {
	 public boolean validateData(float principal, int tenure, int age, String gender){
		    try{
		      if(principal < 500)
		        throw new BankValidationException("Principal less than 500");//return false;
		      if(!(tenure ==5 || tenure==10))
		        throw new BankValidationException("Tenture should be either 5 or 10 years");
		      if( !(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")))
		        throw new BankValidationException("Gender should be either Male or Female");
		      if(age<1 || age > 100)
		        throw new BankValidationException("Age should be between 1 to 100");
		    } catch(BankValidationException bve){
		      return false;
		    }
		    return true;  
		    
		  }
		  
		  public void calculate(float principal,int tenure, int age, String gender){
		    boolean validateFlag = validateData(principal, tenure, age, gender);
		    System.out.println("Validate Flag is " + validateFlag);
		    System.out.println(principal);
		    System.out.println(tenure);
		    System.out.println(age);
		    System.out.println(gender);
		    if(validateFlag){
		      //Create RDAccount object
		      RDAccount rda = new RDAccount(tenure, principal);
		      rda.setInterest(age, gender);

		      float maturityInterest = rda.calculateInterest();
		      float totalPrincipleDeposited= rda.calculateAmountDeposited();
		      System.out.println(totalPrincipleDeposited);
		      System.out.println(maturityInterest);
		      System.out.println(rda.calculateMaturityAmount(totalPrincipleDeposited, maturityInterest));
		      
		    }
		  }

}
