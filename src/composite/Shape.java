package composite;

import java.util.HashSet;
import java.util.Set;

//컴포지트 패턴 -> 일대다관계를 일대일 관계로 바꿀수있어 더욱 안정적이다.
//단, 모든 객체를 동일하게 다룰 수 있어야 한다.
interface Shape {
    void draw();
}
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square");
    }
}
class CompositeShape implements Shape{
    private Set<Shape> shapes = new HashSet<>();
    @Override
    public void draw() {
        for (Shape shape: shapes) {
            shape.draw();
        }
    }
    public void addShape(Shape shape){
        shapes.add(shape);
    }
}
