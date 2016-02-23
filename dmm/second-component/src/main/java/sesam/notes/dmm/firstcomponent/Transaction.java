package sesam.notes.dmm.firstcomponent;

public class Transaction {

    private User user;

    public boolean isAdult() {
        return user.getAge() > 17;
    }
}
