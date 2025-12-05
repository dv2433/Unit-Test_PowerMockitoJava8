package org.example;


public class UserService {

    public static String getSystemToken() {
        return "REAL_TOKEN";
    }

    // 2️⃣ Final Method (Cannot be mocked without PowerMockito – old Mockito)
    public final String finalCalculation() {
        return "FINAL_RESULT";
    }

    // 3️⃣ Private Method (Mockito cannot mock private methods)
    private String generateSecretKey() {
        return "SECRET_KEY";
    }

    // Public method that calls the private method
    public String processPayment() {
        String key = generateSecretKey();
        return "Processed using key = " + key;
    }

    // 4️⃣ Constructor Call (Cannot be mocked without PowerMockito)
    public String callEmailSender() {
        EmailSender sender = new EmailSender();  // requires mocking
        return sender.sendEmail();
    }
}
