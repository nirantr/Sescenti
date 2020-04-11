package in.ramakuru.sescenti.ObjectClasses;

public class Forward {
    int count;
    User fromUser;
    boolean isDead;
    boolean isFirst;
    boolean isForwarded;
    boolean isLast;
    Forward prevForward;
    ReachOut reachOut;
    User toUser;


    public Forward() {
        }

    public Forward(int count, User fromUser, boolean isDead, boolean isFirst, boolean isForwarded, boolean isLast, Forward prevForward, ReachOut reachOut, User toUser) {
        this.count = count;
        this.fromUser = fromUser;
        this.isDead = isDead;
        this.isFirst = isFirst;
        this.isForwarded = isForwarded;
        this.isLast = isLast;
        this.prevForward = prevForward;
        this.reachOut = reachOut;
        this.toUser = toUser;
    }
}
