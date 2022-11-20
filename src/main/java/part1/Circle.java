package part1;

public class Circle extends Ellipse{
    private double radius;

    public Circle() {
    }

    public Circle(double centerX, double centerY, String label, String colour, double radius) {
        super(centerX, centerY, label, colour, 1, 1);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //override setCoefX() and setCoefY() methods for circles
    @Override
    public void setCoefX(double coefX) {
        System.out.println("Method setCoefX() is not available for circles");
    }

    @Override
    public void setCoefY(double coefY) {
        System.out.println("Method setCoefY() is not available for circles");
    }

    @Override
    public String toString() {
        return super.toString()+"\n\t\tCircle:\t Radius : "+radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;

        Circle circle = (Circle) o;

        return (circle.getRadius() == getRadius());
    }
}
