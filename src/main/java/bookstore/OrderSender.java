package bookstore;

public abstract class OrderSender {


    public void makeOrder(String title){

        processStarting();
        processSuccess();
        makingOrder();
        sendingEmailToPrintery(title);

    }


    public void processStarting(){
        System.out.println("The process is starting...");
    }

    public void processSuccess(){
        System.out.println("Your order is made with success.");
    }

    public abstract void makingOrder();

    public abstract void sendingEmailToPrintery(String title);

}