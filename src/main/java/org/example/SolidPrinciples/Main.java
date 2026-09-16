package org.example.SolidPrinciples;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Rectangle rect1=new Rectangle(2.3,3);
        Circle circle1=new Circle(3);
        List<Shape> shapeList=new ArrayList<>();
        shapeList.add(rect1);
        shapeList.add(circle1);
        AreaCalculator calculator=new AreaCalculator();

        double ans=calculator.getTotalArea(shapeList);
        System.out.println(ans);

    }
}
