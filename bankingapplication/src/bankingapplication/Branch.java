package bankingapplication;

import java.util.ArrayList;


public class Branch {
private String branchname;
private ArrayList<Customer> customers;
public Branch(String branchname) {
	this.branchname=branchname;
	this.customers=new ArrayList<Customer>();
}
public String getBranchname() {
	return branchname;
}
public ArrayList<Customer> getcustomers(){
	return customers;
}
public boolean newcustomer(String customername,double initialamount) {
	if(findcustomer(customername)==null) {
		this.customers.add(new Customer(customername, initialamount));
		return true;
	}
	else {
		return false;
	}
}
public boolean addtransaction(String customername,double amount) {
	Customer existingcustomer=findcustomer(customername);
	if(findcustomer(customername)!=null) {
		existingcustomer.addtransaction(amount);
		return true;
	}
	else {
		return false;
	}
}
private Customer findcustomer(String customername) {
	for(int i=0;i<this.customers.size();i++) {
		if(this.customers.get(i).equals(customername)) {
			return this.customers.get(i);
		}
	}
	return null;
}
}
