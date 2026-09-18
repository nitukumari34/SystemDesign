package org.example.ChainOfResponsibilty;

  class PurchaseRequest{
      private  double amount;
//      setter
      PurchaseRequest(double amount){
          this.amount=amount;
      }

      //getter
      public double getAmount() {
          return amount;
      }
  }
//abstract  class->approver
  abstract  class  Approver{
      //child can access
    protected  Approver nextApprover;

    //setter
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
    public  abstract  void processRequest(PurchaseRequest request);

}
class  Manager extends  Approver{

    @Override
    public void processRequest(PurchaseRequest request) {
         if(request.getAmount()<=10000){
             System.out.println("Manager approve the Purchased :" + request.getAmount());
         }
        else if(nextApprover!=null){
             System.out.println("Manager cannot approve ,passing requests to  ");
             nextApprover.processRequest(request);
         }
        else{
             System.out.println("None of the approves can handle the request  ");
         }
    }
}
class  Director extends  Approver{
    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount()<=30000){
            System.out.println("Director approve the Purchased : " + request.getAmount());
        }
        else if(nextApprover!=null){
            System.out.println("Director cannot approve ,passing requests to  ");
            nextApprover.processRequest(request);
        }
        else{
            System.out.println("None of the approves can handle the request  ");
        }
    }
}
//iske bad koi aur upper level ka approver nhi h
class  VicePresident extends  Approver{
    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount()<=50000){
            System.out.println("VicePresident approve the Purchased :" + request.getAmount());
        }
        else {
            System.out.println("VicePresident cannot approve ,passing requests to  ");

        }

    }
}
public class Main {
    public static void main(String[] args) {
        //initialise
        Manager manager=new Manager();
        Director director=new Director();
        VicePresident vicePresident=new VicePresident();
        //setup the chain of responsibility
        manager.setNextApprover(director);
        director.setNextApprover(vicePresident);
        //request
        PurchaseRequest request1=new PurchaseRequest(30000);
      PurchaseRequest request2=new PurchaseRequest(4000);
        PurchaseRequest request3=new PurchaseRequest(0);
      PurchaseRequest request4=new PurchaseRequest(70000);

//      process request
             manager.processRequest(request1);
             manager.processRequest(request2);
             manager.processRequest(request3);
             manager.processRequest(request4);

    }
}
