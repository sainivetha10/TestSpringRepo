package bankingapplication;

public class Main {
public static void main(String[] args) {
	Bank bank=new Bank("indian overseas bank");
	bank.addbranch("vilandai");
	bank.addcustomer("vilandai", "nive", 129999);
	bank.addcustomer("vilandai", "sai", 4534);
	bank.addcustomer("vilandai", "sumisai", 45354364);
	bank.listcustomers("vilandai", false);

}
}
