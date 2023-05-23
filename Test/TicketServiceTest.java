import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

public class TicketServiceTest {

    @Test
    public void ticketService_givenValidParam_verifyTheInitialization() {
        //given
        TicketRepository mockRepository = new ZohoDeskTicketRepositoryMock();
        NotificationService mockNotification = new EmailNotificationServiceMock();

        //when
        TicketService ticketService = new TicketService(mockRepository, mockNotification);

        //then
        assertEquals(mockRepository, ticketService.getTicketRepository());
        assertEquals(mockNotification, ticketService.getNotificationService());
    }

    @Test
    public void createTicket_givenValidParamToCreateTicket_verifyTheTicketCreation() {
        //given
        ZohoDeskTicketRepositoryMock mockRepository = new ZohoDeskTicketRepositoryMock();
        EmailNotificationServiceMock mockNotification = new EmailNotificationServiceMock();
        TicketService ticketService = new TicketService(mockRepository, mockNotification);      //using mock repo and notification

        //when
        ticketService.createTicket("An employee has joined", "New Ticket Created", "newjoiner@gamil.com");

        //then
        assertTrue(mockRepository.isSaved);                               //Will check the method interaction
        assertTrue(mockNotification.isSent());
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void createTicket_givenNullAndEmptySubjectParams_ThrowIllegalArgumentException(String subject) {
        //given
        TicketRepository mockRepository = new ZohoDeskTicketRepositoryMock();
        NotificationService mockNotification = new EmailNotificationServiceMock();
        TicketService ticketService = new TicketService(mockRepository, mockNotification);

        //when

        //then
        assertThrows(IllegalArgumentException.class,()->ticketService.createTicket(subject,"Description","abc@gamil.com"));
    }
    @ParameterizedTest
    @NullAndEmptySource
    public void createTicket_givenNullAndEmptyDescriptionParams_ThrowIllegalArgumentException(String description) {
        //given
        TicketRepository mockRepository = new ZohoDeskTicketRepositoryMock();
        NotificationService mockNotification = new EmailNotificationServiceMock();
        TicketService ticketService = new TicketService(mockRepository, mockNotification);

        //when

        //then
        assertThrows(IllegalArgumentException.class,()->ticketService.createTicket("subject",description,"abc@gamil.com"));
    }
    @ParameterizedTest
    @NullAndEmptySource
    public void createTicket_givenNullAndEmptyEmailParams_ThrowIllegalArgumentException(String contactEmail) {
        //given
        TicketRepository mockRepository = new ZohoDeskTicketRepositoryMock();
        NotificationService mockNotification = new EmailNotificationServiceMock();
        TicketService ticketService = new TicketService(mockRepository, mockNotification);

        //when

        //then
        assertThrows(IllegalArgumentException.class,()->ticketService.createTicket("subject","Description",contactEmail));
    }
}
