public class Ticket {
    private String subject;
    private String description;
    private String contactEmail;

    public Ticket(String subject, String description, String contactEmail) {
        setDescription(description);
        setSubject(subject);
        setContactEmail(contactEmail);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.isEmpty())
            throw new IllegalArgumentException();
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty())
            throw new IllegalArgumentException();
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {

        if (contactEmail == null || contactEmail.isEmpty())
            throw new IllegalArgumentException();
        this.contactEmail = contactEmail;
    }
}
