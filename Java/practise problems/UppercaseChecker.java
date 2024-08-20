public class UppercaseChecker {

    public static boolean isUppercaseValid(String str) {
        if (str.isEmpty()) {
            return false; // Empty string is not a valid case
        }

        boolean allUpper = str.equals(str.toUpperCase()); // Check if all uppercase
        boolean allLower = str.equals(str.toLowerCase()); // Check if all lowercase
        boolean firstUpper = Character.isUpperCase(str.charAt(0)) && str.substring(1).equals(str.substring(1).toLowerCase()); // Check if only first uppercase

        return allUpper || allLower || firstUpper;
    }

    public static void main(String[] args) {
        String str1 = "IXAMBEE";
        String str2 = "ixambee";
        String str3 = "Ixambee";
        String str4 = "iXaMbee";

        System.out.println(str1 + " - " + isUppercaseValid(str1)); // Output: IXAMBEE - true
        System.out.println(str2 + " - " + isUppercaseValid(str2)); // Output: ixambee - true
        System.out.println(str3 + " - " + isUppercaseValid(str3)); // Output: Ixambee - true
        System.out.println(str4 + " - " + isUppercaseValid(str4)); // Output: iXaMbee - false
    }
}
