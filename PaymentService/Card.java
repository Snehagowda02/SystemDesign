
abstract public class Card implements Payment{
    private String CardNo;
    private String userName;
    public Card(String cardNo, String name){
        this.CardNo = cardNo;
        this.userName= name;
    }
    public String getCardNo(){
        return CardNo;
    }

    public String getUser(){
        return userName;
    }



    
}