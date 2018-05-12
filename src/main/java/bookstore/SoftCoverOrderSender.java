package bookstore;

public class SoftCoverOrderSender extends OrderSender {

    @Override
    public void makingOrder() {
        System.out.println("Make order to print the chosen book with soft cover.");
    }

    @Override
    public void sendingEmailToPrintery(String title) {
        System.out.println("The order of book: '" + title + "' with soft cover is sent to the printery.\n");
    }
}