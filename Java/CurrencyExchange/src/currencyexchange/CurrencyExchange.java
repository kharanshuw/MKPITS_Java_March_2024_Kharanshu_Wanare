package currencyexchange;

public class CurrencyExchange {
	public double RupeesToDoller(double rupees)
	{
		double result=0;
		if (rupees>0) {
			result=0.0120*rupees;
		}
		return result;
	}
	
	public double DollerToRupees(double doller)
	{
		double result=0;
		if (doller>0) {
			result=83.4749*doller;
		}
		return result;
	}
	
	public double RupeesToEuro(double rupees)
	{
		double result=0;
		if (rupees>0) {
			result=0.0112*rupees;
		}
		return result;
	}
	public double EuroToRupees(double euro)
	{
		double result=0;
		if (euro>0) {
			result=89.6410*euro;
		}
		return result;
	}
	
}
