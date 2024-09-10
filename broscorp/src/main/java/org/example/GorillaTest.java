package org.example;

public class GorillaTest {
    public static void main(String[] args) {
        String[] passwords1 = {"PasswORD1", "20passWORD20", "PASS6word"};
        String checkString1 = "4dro6";
        // Приклад 2
        String[] passwords2 = {"theBestpassword", "myPassword#3"};
        String checkString2 = "1dro0";
        // Приклад 3
        String[] passwords3 = {"MyPassword2", "crazyPassword1#$%"};
        String checkString3 = "1%$#1";
        // Приклад 4
        String[] passwords4 = {"luckyPASSWORD#$$$, luckyDay666"};
        String checkString4 = "6pass7";
        System.out.println(findCorrectPassword(passwords1,checkString1));
        System.out.println(findCorrectPassword(passwords2,checkString2));

    }
    public static String findCorrectPassword(String[] passwords, String checkString) {
        if (checkString.length() < 4 || !Character.isDigit(checkString.charAt(0))) {
            return "";
        }

        int expectedUpperCaseCount = Character.getNumericValue(checkString.charAt(0));
        String expectedLast3CharsReversed = checkString.substring(1, 4);
        int expectedDigitSum = Integer.parseInt(checkString.substring(4));

        for (String password : passwords) {
            int actualUpperCaseCount = 0;
            String actualLast3CharsReversed = new StringBuilder(password.substring(password.length() - 3)).reverse().toString();
            int actualDigitSum = 0;
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    actualUpperCaseCount++;
                }
                if (Character.isDigit(c)) {
                    actualDigitSum += Character.getNumericValue(c);
                }
            }

            if (actualUpperCaseCount == expectedUpperCaseCount &&
                    actualLast3CharsReversed.equals(expectedLast3CharsReversed) &&
                    actualDigitSum == expectedDigitSum) {
                return password;
            }
        }

        return ""; // No matching password found
    }
}
