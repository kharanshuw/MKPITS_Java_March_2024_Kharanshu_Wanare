public class TimeConversion {

    public static void main(String[] args) {
        String time = "12:01:00AM"; // Example time
        String militaryTime = convertToMilitaryTime(time);
        System.out.println(militaryTime);
    }

    public static String convertToMilitaryTime(String time) {
        String[] timeParts = time.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        String minutes = timeParts[1];
        String seconds = timeParts[2].substring(0, 2); // Extract only seconds
        String period = timeParts[2].substring(2); // Extract AM/PM

        if (period.equals("PM") && hour != 12) {
            hour += 12; // Add 12 for hours in PM except 12PM which is already 12:00
        } else if (period.equals("AM") && hour == 12) {
            hour = 0; // Convert 12AM to 00:00
        }
		String result=hour.tostring():minutes:seconds;
        return result;
    }
}
