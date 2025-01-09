package JavaTrick;

public class validateInteger {

    private static final String ROUND_IS_INTEGER_ANNOUNCEMENT = "asdf";

    private void isValidationIntegerRoundCount(String inputRoundCount) {
        for (int i = 0; i < inputRoundCount.length(); i++) {
            if (!Character.isDigit(inputRoundCount.charAt(i))) {
                System.out.println(ROUND_IS_INTEGER_ANNOUNCEMENT);
            }
            if (inputRoundCount.charAt(i) < 1) {
                System.out.println(ROUND_IS_INTEGER_ANNOUNCEMENT);
            }
        }
    }
}
