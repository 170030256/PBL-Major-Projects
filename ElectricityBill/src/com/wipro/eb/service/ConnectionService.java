package com.wipro.eb.service;


	import com.wipro.eb.entity.Commerical;
	import com.wipro.eb.entity.Connection;
	import com.wipro.eb.entity.Domestic;
	import com.wipro.eb.exception.InvalidConnectionException;
	import com.wipro.eb.exception.InvalidReadingException;
	public class ConnectionService {
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException{
		  if(currentReading<previousReading || currentReading< 0 || previousReading < 0){
		   
		   throw new InvalidReadingException();
		  }
		  if(!type.equals("Domestic")&&!type.equals("Commercial")){
		   throw new InvalidConnectionException();
		  }
		  return true;
		  
	}
		 
		 public float calculateBillAmt(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException {
		  try{
		   if(validate(currentReading,previousReading,type)){
		    Connection c;
		    if(type.equals("Domestic")){
		     c = new Domestic(currentReading, previousReading, null);
		     
		    }
		    else{
		     c = new Commerical(currentReading, previousReading, null);
		    }
		    return c.computeBill();   
		   }
		   
		  }
		  catch(InvalidReadingException e){
		   return -1;
		  }
		  catch(InvalidConnectionException e){
		   return -2;
		  }
		  
		  return previousReading;
		  
		 }
		 
		 public String generateBill(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException{
		  if(calculateBillAmt(currentReading, previousReading, type)==-1){
		   return "Incorrect Reading";
		  }
		  else if(calculateBillAmt(currentReading, previousReading, type)==-2){
		   return "Invalid ConnectionType";
		  }
		  return "Amount to be paid:"+calculateBillAmt(currentReading, previousReading, type);
		  
		 }


}
