package factory;

interface ShapeFactory {
      Shape makeCricle();
      Shape makeSquare();
      Shape makeShape(String shape);
}
class ShapeFactoryImpl implements ShapeFactory{

    @Override
    public Shape makeCricle() {
        return new Circle();
    }

    @Override
    public Shape makeSquare() {
        return new Square();
    }

    @Override
    public Shape makeShape(String shape) {
        if(shape.equalsIgnoreCase("circle")){
            return new Circle();
        }else if(shape.equalsIgnoreCase("square")){
            return new Square();
        }else throw new IllegalArgumentException("No such shape :"+ shape);
    }
}