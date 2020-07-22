package com.wipro.ccbill.entity;
import java.util.Date;
import com.wipro.ccbill.exception.InputValidationException;
public class CreditCardBill {
	
		  private String creditCardNo;
		  private String customerId;
		  private Date billDate;
		  private Transaction monthTransactions[];
		  public CreditCardBill () 
		  {
		    super();
		  }
		  public CreditCardBill (String creditCardNo, String customerId, Date billDate, Transaction monthTransactions[])
		  {
		    this.creditCardNo=creditCardNo;
		    this.customerId=customerId;
		    this.billDate=billDate;
		    this.monthTransactions=monthTransactions;
		  }
		  public double getTotalAmount(String transactionType)
		  {
		    double total=0;
		    for(int i=0;i<monthTransactions.length;i++)
		    {
		      if(monthTransactions[i].getTransactionType().equals(transactionType))
		      {
		        //System.out.println(monthTransactions[i].getTransactionType()+"  hi   "+transactionType);
		        total +=monthTransactions[i].getTransactionAmount(); 
		      }
		      if(transactionType!="DB"&& transactionType!="CR")
		      {
		        return 0;
		      }
		    }
		    return total;
		  }
		  public double calculateBillAmount()
		  {
		    try {
		    if(validateData().equals("valid"))
		    {
		      if (monthTransactions.length>0)
		      {
		        double db =getTotalAmount("DB");
		        //System.out.println(db);
		        double cr =getTotalAmount("CR");
		        //System.out.println("cr "+cr);
		        double outstanding_amount =db-cr;
		        double Interest_calculated = (outstanding_amount * (19.9/100) / 12);
		        return outstanding_amount+Interest_calculated;
		      }
		      else
		      {
		        return 0.0;
		      }
		    }
		    else
		    {
		      return 0.0;
		    }
		    }
		    catch(InputValidationException e)
		    {
		      e.toString();
		    }
		    return 0;
		  }
		  public String validateData() throws InputValidationException
		  {
		    if(creditCardNo!=null && creditCardNo.length()==16 && customerId!=null && customerId.length()>=6)
		    {
		      return "valid";
		    }
		    else
		    {
		      throw new InputValidationException();
		    }
		    
		  }
	}

		  
	

	   