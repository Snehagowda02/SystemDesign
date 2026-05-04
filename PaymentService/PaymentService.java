import java.util.HashMap;
public class PaymentService {
    // storing + make payment

    HashMap<String, Payment> paymentMethods;
    // Payment as Data type

    public PaymentService() {
        paymentMethods = new HashMap<>();
    }
    public void addPaymentMethod(String name, Payment pm){
        paymentMethods.put(name, pm);
      
    }

    public void makePayment(String name){
        Payment pm = paymentMethods.get(name);
        System.out.println("pm" + pm);
        pm.pay();
    }

    
    
}
