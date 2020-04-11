package in.ramakuru.sescenti.ObjectClasses;

public class ReachOut {
    boolean isRead;
    String[] message;
    User primis;
    User tandem;
    String title;

    public ReachOut(boolean isRead, String[] message, User primis, User tandem, String title) {
        this.isRead = isRead;
        this.message = message;
        this.primis = primis;
        this.tandem = tandem;
        this.title = title;
    }
}
