
//Design to include both Factory Design and Strategy Design Pattern
// Strategy -- chooosing algo, composite, runtime , we can define what client needs
// Factory is about creating a new object
class Main2 {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        PaymentStrategy st = Factory.getPayment("UPI");
        PaymentService p = new PaymentService(st);
        p.makePayment(234345.456);
    }
}

interface PaymentStrategy{
    public void pay(double amount);
}

class UPI implements PaymentStrategy{
    @Override
    public void pay(double amount ){
        System.out.println("UPI" + "amount" + amount);
    }
}
class CreditCard implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("CreditCard" + "amount" + amount);
    }
}

class Factory {
    private PaymentStrategy payment;
    public static PaymentStrategy getPayment(String type){
        switch(type){
        case "UPI" : return new UPI();
        case "Card" : return new CreditCard();
        default:  throw new IllegalArgumentException();
        }
    }
}


class PaymentService {
    private PaymentStrategy payment;
    public PaymentService(PaymentStrategy p){
        this.payment = p;
    }
    public void makePayment(double amt){
        payment.pay(amt);
    }
}
