package org.fundamental.exception;

public class CustomFormatTest {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) throws CustomFormatException {
        if (userId == null) {
            throw new CustomFormatException("Must have ID String.");
        } else if (userId.length() < 8 || userId.length() > 20) {
            throw new CustomFormatException(
                "ID must be at least 8 characters and less than 20 characters.");
        }
        this.userId = userId;
    }

    public static void main(String[] args) {
        CustomFormatTest test = new CustomFormatTest();

        String userId = null;
        try {
            test.setUserId(userId);
        } catch (CustomFormatException e) {
            System.out.println(e.getMessage());
        }

        userId = "aaaaaa";
        try {
            test.setUserId(userId);
        } catch (CustomFormatException e) {
            System.out.println(e.getMessage());
        }
    }

}
