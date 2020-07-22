package com.wipro.eb.entity;

public class Commerical extends Connection{
	float[] slabs=new float[]{(float) 5.2,(float) 6.8,(float) 8.3};
	 public Commerical (int currentReading, int previousReading,float slabs[]){
	  this.currentReading = currentReading;
	  this.previousReading = previousReading;
	  this.slabs = slabs;
	  
	 }
	 
	 public float computeBill(){
	  int n = currentReading-previousReading;
	  float billAmount = 0;
	  double elcDuty=0;
	  if(n<=50){
	   billAmount =  (float) (n*5.2);
	  }
	  else if(n<=100){
	   billAmount = (float) Math.abs(((50*5.2)+((n-50)*6.8)));
	  }
	  else{
	  billAmount = (float) Math.abs(((50*5.2)+(50*6.8)+((n-100)*8.3)));
	  }
	  if(billAmount >= 10000){
	   elcDuty = billAmount*0.09; 
	  }
	  else if (billAmount >=5000){
	   elcDuty = billAmount*0.06;
	  }
	  else{
	   elcDuty = billAmount*0.02;
	  }
	  return  (float) (billAmount+elcDuty);
	  
	  
	  
	 }


}
