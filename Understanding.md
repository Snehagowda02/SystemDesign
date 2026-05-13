*** Creational Design Pattern ***
1. Factory Design Pattern
2. BUILDER DESIGN PATTERN
3. PROTOTYPE DESIGN PATTERN
4. SINGLETON DESIGN PATTERN

*** STRUCTURAL DESIGN PATTERN ***
1. ADAPTER Design Pattern
2. COMPOSITE DESIGN PATTERN
3. DECORATOR DESIGN PATTERN

*** BEHAVIOURAL DESIGN PATTERN ***
1. Strategy design pattern:
2. OBSERVER DESIGN PATTERN


*** Creational Design Pattern ***
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
constructor normal 
in setter need to mention
public class PhoneBuilder{
    // take all variables from Phone
    // take all setters to it 

    public PhoneBuilder setOs(String s){
        this.os = s;
        return this; /// main return this
    }
    public PhoneBuilder setRam(int ram){
        this.ram = ram;
        return this;
    }
    public Phone getPhone(){
        return new Phone(os, gsg,gsdfgr,gesrdft,gdrfg);
    }
}

/// in main 
Phone p = new PhoneBuilder.setOs("ANdorid").getPhone();

// PhoneBuilder creates new Phone Object , SO it takes default parameters (null)
example


class Main {
    public static void main(String[] args) {
        Product m = new Product.Builder("mmilk").build();
        System.out.println(m);
        
    }
}
class Product{
    private String name;
    private int price;
    private Product(Builder b){
        this.name = b.name;
        this.price = b.price;
    }
    
    public static class Builder{
        private String name;
        private int price;
        public Builder(String name){
            this.name = name;
        }
       // setter only for optional fields
        public Builder setPrice(int p){
            this.price= p;
            return this;
        }
        
        public Product build(){
            return new Product(this);
        }
    }
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}

3. PROTOTYPE DESIGN PATTERN
second obj creation from first object
using cloning
Deep clone and shallow Clone
shallow clone - uses refernce(so same object)
deep clone- copy the existing obj to new obj

implement Cloneable(marker interface)


4. SINGLETON DESIGN PATTERN
// use any one synchronized


class Main {
    public static void main(String[] args) {
        B.getInstance().display();
    }
}

class B{
    private static B obj;
    private B(){
    }
    public synchronized static B getInstance(){
        synchronized(B.class){
            if(obj == null){
                obj = new B();
            }
        }
        return obj;
    }
    public void display(){
        System.out.println("brower is set");
    }
}




*** STRUCTURAL DESIGN PATTERN ***

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
    public void wrtie(String s){
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


3. DECORATOR DESIGN PATTERN
example is coffee decorator in starbucks

***
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        // System.out.println("Start small. Ship something.");
        
        Coffee c = new SimpleCoffee();
        c.getDescrp();
        System.out.println(c.getCost());
          
        Coffee a = new MilkDeco(c);
        a.getDescrp();
        System.out.println(a.getCost());
        
        
    }
}

interface Coffee{
    public int getCost();
    public void getDescrp();
}
class SimpleCoffee implements Coffee {
    
    @Override
    public int getCost(){
        return 5;
    }
    @Override
    public void getDescrp(){
        System.out.println("this is the simple cofee with cost" + this.getCost());
    }
    
}

abstract class CoffeeDeco implements Coffee {
    protected Coffee cof;
    
    public CoffeeDeco(Coffee co){
        this.cof = co;
    }
    
    
    @Override
    public int getCost(){
        return cof.getCost();
    }
    @Override
    public void getDescrp(){
        System.out.println("this is the simple cofee with cost" + cof.getCost());
    }
}

class MilkDeco extends CoffeeDeco {
    
    public MilkDeco(Coffee cof){
        super(cof);
    }
    @Override
    public int getCost(){
        return super.getCost() + 15;
    }
    
    @Override
    public void getDescrp(){
        super.getDescrp();
        System.out.println("milk added with extra cose" + this.getCost());
    }
}
***


*** BEHAVIOURAL DESIGN PATTERN ***

1. Strategy design pattern:
changes behaviour/algorigthm
    Strategy pattern is used when:

        behavior/algorithm can change
        multiple ways exist to perform same action
        choose behavior at runtime

2. OBSERVER DESIGN PATTERN
notification()
Subscribers are observers 
you'll subscribe, then if channel post something , you'll get notified

a behavioral pattern that defines a one-to-many relationship between objects. When the state of one object (the Subject) changes, all its dependents (Observers) are notified and updated automatically


