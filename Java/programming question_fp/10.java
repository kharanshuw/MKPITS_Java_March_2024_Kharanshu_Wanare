public class DaysToYMD {

  public static void main(String[] args) {
    int days = 730;

    int years = days / 365;
    int remainingDays = days % 365;

    int months = remainingDays / 30;
    days = remainingDays % 30;

    System.out.println(days + " days is equal to:");
    System.out.println(years + " years");
    System.out.println(months + " months");
    System.out.println(days + " days");
  }
}
