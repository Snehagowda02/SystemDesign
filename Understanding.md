Creational Design Pattern


1. Factory Design Pattern

It is just like make OS as interface implement it for apple, samsung
OS is factory -- achieves loose coupling
helps in extension
//
Create a OS object 
OS obj = new Android();

Recommended -- Create a OSFactory use switch to get user specific OS
use that OSFactory class in main and call it 
OSFactory obj = new OSFactory();
OS os = obj.getInstance("OPEN); // return OS
os.spec();

// this helps in not changing anything in client class(main class) , new OS can be implemented easily and just include the case in swithc in OSFactory 
/// this is Factory design patter 


2. BUILDER DESIGN PATTERN
<!-- we dont want to send all parameters -->
<!-- use this when you have multitple parameters -->
setting parameters for a class through constructor or getter and setter 

in every setter it returns this object
Phone p = new Phone("android", 5, 6,7,8,); // bad code

in setter need to mention
public class PhoneBuilder{
    public PhoneBuilder setOs(String s){
        this.os = s;
        return this; /// main return this
    }
    public Phone getPhone(){
        return new Phone(os, gsg,gsdfgr,gesrdft,gdrfg);
    }
}

/// in main 
Phone p = new PhoneBuilder.setOs("ANdorid).getPhone();


3. PROTOTYPE DESIGN PATTERN
second obj creation from first object
using cloning
Deep clone and shallow CLone



STRUCTURAL DESIGN PATTERN
1. ADAPTER Design Pattern
School {
    psvm(){
        Assignment aw = new Assignment();
        aw.writeAssignment("I'm writing assignemtn");
        
    }
}

/// 
public class Assignment {

    Private Pen p ;
   <!--getter setter  -->
   public void setP(Pen p){
    this.p = p;
   }

    public void writeAssignment(String s){
        p.write(s);
    }

}

/// 
public interface Pen{
    public void write(String s);
        // but we don't have pen
        // so we need use PiotPen
    
}
// 
public class adapter implements Pen{
    PilotPen pp = new PilotPen();
    public void wrie(String s){
        pp.mark(s);
    }

}

2. COMPOSITE DESIGN PATTERN
tree structure

interface Componenet {
    showPrice(); 
}
Leaf - end Node
Composite - List<Component>

Expected output to print all inside computer Component
Computer -- peri-- mouse: 100
            -- HDD -- ram : 400


***
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Components c = new Leaf("remote", 400);
        // c.show();
        Composite a = new Composite("compu");
        // a.show();
        a.addComp(c);
        a.show();
    }
    
}
// to represent common thing between Leaf and Composite

interface Components {

    void show();
    
}
class Leaf implements Components{
    int Price;
    String Name;
    Leaf(String Name, int Price){
        this.Name = Name;
        this.Price = Price;
    }
    @Override
    public void show(){
        System.out.println("name: "+ Name + " Price: "+ Price);
    }
    
}
class Composite implements Components{
    String name;
    List<Components> composite = new ArrayList<>();
    
    Composite(String s){
        this.name= s;
    }
    // adding the component 
    public void addComp(Components com){
        composite.add(com);
    }
    @Override 
    public void show(){
        System.out.println("Composite name: " + name);
        for(Components c: composite){
            c.show();
        }
        
    }
    
}
***
Composite can have many Composite inside it or can have Leaf also
Common thing between Leaf and Composite using interface
so show() methos is common among that 




