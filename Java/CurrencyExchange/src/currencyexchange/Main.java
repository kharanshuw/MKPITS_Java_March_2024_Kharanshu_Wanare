package currencyexchange;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CurrencyExchange currencyExchange=new CurrencyExchange();
		Scanner scanner=new Scanner(System.in);
		System.out.println("welcome to currency exchange");
		System.out.println("enter your choice from given below");
		System.out.println("1.rupees to doller \n 2.doller to rupees \n 3.euro to rupees \n  ");
		int key=0;
		key=scanner.nextInt();
		double result=0.0;
		double currency = 0.0;
		switch (key) {
		case 1: {
			System.out.println("enter rupees");
			currency=scanner.nextDouble();
			result=currencyExchange.RupeesToDoller(currency);
			System.out.println("rupees in doller is "+result);
			break;
		}
		case 2:
		{
			System.out.println("enter doller");
			currency=scanner.nextDouble();
			result=currencyExchange.DollerToRupees(currency);
			System.out.println("doller to rupees is "+result);
			break;
		}
		case 3 :
		{
			System.out.println("enter euro");
			currency=scanner.nextDouble();
			result=currencyExchange.EuroToRupees(currency);
			System.out.println("euro to rupees is "+result);
			break;
		}
		case 4 :
		{
			System.out.println("enter rupees");
			currency=scanner.nextDouble();
			result=currencyExchange.RupeesToEuro(currency);
			System.out.println("ruppes to euro is "+result);
			break;
		}
		default:
			System.out.println("wrong option ");
			break;
		}
	}

}
