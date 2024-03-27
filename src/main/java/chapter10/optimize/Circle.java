package chapter10.optimize;

/**
 * @author karl xie
 */
class Circle extends Figure {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}