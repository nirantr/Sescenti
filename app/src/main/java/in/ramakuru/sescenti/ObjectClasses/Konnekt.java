package in.ramakuru.sescenti.ObjectClasses;

public class Konnekt {
    public User user1;
    public User user2;
    public int strength;

    public Konnekt() {
        // Default constructor required for calls to DataSnapshot.getValue(Comment.class)
    }

    public Konnekt(User user1,User user2, int strength) {
        this.user1 = user1;
        this.user2 = user2;
        this.strength = strength;
    }
}

