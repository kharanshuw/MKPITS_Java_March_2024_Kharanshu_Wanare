/*
Given a string S representing the record of workers entering and leaving the rest area, where E represents entering and L represents leaving the rest area. For each worker, one chair is required. The task is to find the minimum number of chairs required so that there is no shortage of chairs at any given time.
ixam Bcc
Prepare 50% Finte
Input: EEELLE
Output :3
*/

public class MinChairsRequired {

    public static int findMinChairs(String record) {
        int maxChairs = 0;
        int currentChairs = 0;

        for (char ch : record.toCharArray()) {
            if (ch == 'E') {
                currentChairs++; // Increase chairs for entering worker
            } else {
                currentChairs--; // Decrease chairs for leaving worker
            }
            maxChairs = Math.max(maxChairs, currentChairs); // Track the maximum number of chairs used at any point
        }

        return maxChairs;
    }

    public static void main(String[] args) {
        String record1 = "EEELLE";
        String record2 = "EL";

        System.out.println("Minimum chairs for " + record1 + ": " + findMinChairs(record1)); // Output: Minimum chairs for EEELLE: 3
        System.out.println("Minimum chairs for " + record2 + ": " + findMinChairs(record2)); // Output: Minimum chairs for EL: 1
    }
}
