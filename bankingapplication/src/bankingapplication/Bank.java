package bankingapplication;

import java.util.ArrayList;

public class Bank {
private String bankname;
private ArrayList<Branch> branches;
public Bank(String bankname) {
	this.bankname=bankname;
	this.branches=new ArrayList<Branch>();
}
public boolean addbranch(String branchname) {
	if(findbranch(branchname)==null) {
		this.branches.add(new Branch(branchname));
		return true;
	}
	return false;
}
public boolean addcustomer(String branchname,String customername,double initialamount) {
	Branch branch=findbranch(branchname);
	if(branchname!=null) {
		return branch.newcustomer(customername, initialamount);
	}
	return false;
}
public boolean customertranscation(String branchname,String customername,double amount ) {
	Branch branch=findbranch(branchname);
	if(branch!=null) {
		return branch.addtransaction(customername, amount);
	}
	return false;
}
private Branch findbranch(String branchname) {
	for(int i=0;i<this.branches.size();i++) {
		if(this.branches.get(i).equals(branchname)) {
			return this.branches.get(i);
		}
	}
	return null;
}
public boolean listcustomers(String branchname,boolean showtransactions) {
	Branch branch=new Branch(branchname);
	if(branch!=null) {
		System.out.println("list of customers for"+branch.getBranchname());
		ArrayList<Customer> customerlist=branch.getcustomers();
		for(int i=0;i<customerlist.size();i++) {
			Customer branchcustomer=customerlist.get(i);
			System.out.println("customers"+branchcustomer.getName());
			if(showtransactions) {
				System.out.println("transactions");
				ArrayList<Double> transactions =branchcustomer.gettransactions();
				for(int j=0;j<transactions.size();j++) {
					System.out.println(transactions.get(j));
				}
			}
			
		}
		return true;

	}
	return false;
	
}
}
