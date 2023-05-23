public class TicketService {
    private TicketRepository ticketRepository;
    private NotificationService notificationService;

    // Constructor-based dependency injection
    public TicketService(TicketRepository ticketRepository, NotificationService notificationService) {
        this.ticketRepository = ticketRepository;
        this.notificationService = notificationService;
    }

    public void createTicket(String subject, String description, String contactEmail) {

        Ticket ticket = new Ticket(subject, description, contactEmail);
        ticketRepository.save(ticket);
        notificationService.sendNotification("Ticket created: " + ticket.getSubject());
    }

    public TicketRepository getTicketRepository() {
        return ticketRepository;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
}
