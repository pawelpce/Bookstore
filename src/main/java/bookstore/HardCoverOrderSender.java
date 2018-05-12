package bookstore;

public class HardCoverOrderSender extends OrderSender {

    @Override
    public void makingOrder() {
        System.out.println("Make order to print the chosen book with hard cover.");
    }

    @Override
    public void sendingEmailToPrintery(String title) {
        System.out.println("The order of book: '" + title + "' with hard cover is sent to the printery.\n");
    }
}