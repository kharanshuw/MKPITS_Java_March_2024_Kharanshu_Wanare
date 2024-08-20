package taxSystem;

public class Maharashtra extends CentralTax implements StateTax{

	@Override
	public double taxCalculate(double amount) {
		return amount*0.5;
	}

	
	
}
