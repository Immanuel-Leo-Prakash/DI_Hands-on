public class UserApp {
    public static void main(String[] args) {
        // Simulating Zoho Desk integration
        TicketRepository zohoDeskRepository = new ZohoDeskTicketRepository();
        NotificationService emailNotificationService = new EmailNotificationService();
        TicketService zohoDeskTicketService = new TicketService(zohoDeskRepository, emailNotificationService);
        zohoDeskTicketService.createTicket("Issue 123", "This is a test ticket", "john@example.com");
    }
}
