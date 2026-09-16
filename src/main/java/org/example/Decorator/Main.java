package org.example.Decorator;
//decorator
interface  Coffee{
    String getDescription();
    double cost();
}

//concrete class deriving base class coffee
class  SimpleCoffee implements  Coffee{

    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public double cost() {
        return 100;
    }
}
// latte
class  latte implements  Coffee{

    @Override
    public String getDescription() {
        return "latte coffee";
    }

    @Override
    public double cost() {
        return 200;
    }
}
//decorator class
abstract class   CoffeeDecorator implements Coffee {
    //protected means derived class can also access it
//    every coffee is initializing with older coffee
    protected   Coffee decoratedCoffee ;
    CoffeeDecorator(Coffee coffee){
         this.decoratedCoffee=coffee;
    }
   public String getDescription(){
        return  decoratedCoffee.getDescription();
   }
   public  double cost(){
     return  decoratedCoffee.cost();

  }


}

class   Milk extends  CoffeeDecorator{

   public Milk(Coffee coffee) {
        super(coffee);
    }
    public  String getDescription(){
       return decoratedCoffee.getDescription() + ", with Milk";
    }
    public  double cost(){
       return  decoratedCoffee.cost()+ 100;

    }
}
class  Sugar extends  CoffeeDecorator{

    Sugar(Coffee coffee) {
        super(coffee);
    }
    public  String getDescription(){
        return decoratedCoffee.getDescription() + ", with sugar";
    }
    public  double cost(){
        return  decoratedCoffee.cost()+ 20;

    }
}
//CLIENT CODE
public class Main {
    public static void main(String[] args) {
        //base setup
       Coffee myCoffee=new SimpleCoffee();
        System.out.println(myCoffee.getDescription() + " " +  myCoffee.cost());
       //decorator
        myCoffee=new Milk(myCoffee);
        System.out.println(myCoffee.getDescription() + " " + myCoffee.cost());

        myCoffee=new Sugar(myCoffee);
        System.out.println(myCoffee.getDescription() + " " + myCoffee.cost());


    }
}
