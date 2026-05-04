public class UPI implements Payment {

    String upiID;

    

    public UPI(String id) {
        this.upiID = id;
    }

    @Override
    public void pay(){
        System.out.println("Paying using Upi with card" + upiID);
    }
    
}
