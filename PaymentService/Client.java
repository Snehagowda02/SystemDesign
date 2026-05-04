public class Client {
    public static void main(String[] args) {
        PaymentService pay = new PaymentService();

        pay.addPaymentMethod("sne", new DebitCard("sneDebitcard", "1234454"));
        pay.makePayment("sne");
        pay.addPaymentMethod("upi", new UPI("2135435"));
        pay.makePayment("upi");
        // pay.makePayment("hiou");

    }
    
}
