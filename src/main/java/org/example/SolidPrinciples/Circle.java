package org.example.SolidPrinciples;

public class Circle implements Shape {
  private  double radius;
  Circle(double radius){
      this.radius=radius;
  }
    @Override
    public double area() {
        return  3.14*radius*radius;
    }
}
