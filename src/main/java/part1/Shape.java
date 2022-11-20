package part1;

//work with 2D shapes
public class Shape {
    private double centerX;
    private double centerY;
    private String label;
    private String colour;

    public Shape() {
    }

    public Shape(double centerX, double centerY, String label, String colour) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.label = label;
        this.colour = colour;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public String getLabel() {
        return label;
    }

    public String getColour() {
        return colour;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Shape:\tlabel : "+label+"\tcenter X : "+centerX+"\tcenter Y : "+centerY+"\tcolour : "+colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;

        if(shape.getCenterX() != getCenterX()) return false;
        if(shape.getCenterY() != getCenterY()) return false;
        if (!getLabel().equals(shape.getLabel())) return false;
        return getColour().equals(shape.getColour());
    }
}
