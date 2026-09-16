package org.example.SolidPrinciples;

import java.util.List;

public class AreaCalculator {
    public  double getTotalArea(List<Shape> shapes){
        double totalArea=0.0;
        for (Shape shape:shapes){
          totalArea+=shape.area();

        }
        return  totalArea;
    }
}
