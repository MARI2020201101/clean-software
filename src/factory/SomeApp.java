package factory;

import java.util.Set;

class SomeApp {
    private ShapeFactory shapeFactory;

    public SomeApp(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    public Set<Shape> createShape(){
        Shape circle = shapeFactory.makeCricle();
        Shape square = shapeFactory.makeSquare();
        return Set.of(circle, square);
    }
}
