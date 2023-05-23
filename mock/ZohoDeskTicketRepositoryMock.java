public class ZohoDeskTicketRepositoryMock implements TicketRepository {
    public boolean isSaved = false;

    @Override
    public void save(Ticket ticket) {
        // Simulate saving a ticket in Zoho Desk (Mock implementation)
        System.out.println("Mock Zoho Desk Ticket Repository: Saving ticket with subject " + ticket.getSubject());

        // Additional mock implementation logic
        isSaved = true;
    }

    public boolean isSaved() {
        return isSaved;
    }

}
