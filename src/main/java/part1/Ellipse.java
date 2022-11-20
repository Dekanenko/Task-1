package part1;

public class Ellipse extends Shape{
    private double coefX = 1;
    private double coefY = 1;

    public Ellipse() {
    }

    public Ellipse(double centerX, double centerY, String label, String colour, double coefX, double coefY) {
        super(centerX, centerY, label, colour);
        this.coefX = coefX;
        this.coefY = coefY;
    }

    public double getCoefX() {
        return coefX;
    }

    public double getCoefY() {
        return coefY;
    }

    public void setCoefX(double coefX) {
        this.coefX = coefX;
    }

    public void setCoefY(double coefY) {
        this.coefY = coefY;
    }

    @Override
    public String toString() {
        return super.toString()+"\n\tEllipse:\tcoef X : "+coefX+"\tcoef Y : "+coefY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse)) return false;
        if (!super.equals(o)) return false;

        Ellipse ellipse = (Ellipse) o;

        if (ellipse.getCoefX() != getCoefX()) return false;
        return (ellipse.getCoefY() == getCoefY());
    }

}
