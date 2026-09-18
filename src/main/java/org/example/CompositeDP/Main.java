package org.example.CompositeDP;

import java.util.ArrayList;
import java.util.List;

interface  Employee{
    void showDetails();
}
//concrete class 1 -> developer
class  Developer implements  Employee{
    private  String name;
    private  String position;

    Developer(String name,String position){
        this.name=name;
        this.position=position;
    }

    @Override
    public void showDetails() {
        System.out.println("Developer :" + name + "Position : "+ position);
    }
}
//concrete class 1 -> developer
class  Manager implements  Employee{
    private  String name;
    List<Employee> team=new ArrayList<>();

    Manager(String name){
        this.name=name;
    }
    public  void addEmployeeToTeam(Employee emp){
        team.add(emp);

    }
    public  void removeEmployeeToTeam(Employee emp){
        team.remove(emp);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager :" + name);
        System.out.println("Team : ");
        for(Employee emp:team){
            emp.showDetails();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Developer dev1=new Developer("Nitu","MTS");
        Developer dev2=new Developer("Priyes","SDE-1");
        Developer dev3=new Developer("Aashish","AI AGENTIC");
        Manager manager=new Manager("Arjun");
        manager.addEmployeeToTeam(dev1);
//        manager.addEmployeeToTeam(dev2);
        manager.removeEmployeeToTeam(dev3);
        manager.addEmployeeToTeam(dev3);
        manager.showDetails();
    }
}
