public class EmailNotificationServiceMock implements NotificationService {

    private boolean isSent = false;

    @Override
    public void sendNotification(String message) {
        // Simulate sending an email notification (Mock implementation)
        System.out.println("Mock Email Notification Service: Sending email notification - " + message);

        // Additional mock implementation logic
        isSent = true;
    }

    public boolean isSent() {
        return isSent;
    }

}
