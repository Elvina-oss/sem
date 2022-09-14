package com.company;

public class Point2D extends Point {

    public Point2D()
    {
        super(2);
    }
    public Point2D(double[] x)
    {
        super(2, x);
        if (x.length != 2)
            throw new IllegalArgumentException("double[2] required");
    }
    public Point2D(Point p)
    {
        super(2, p.x);
    }
    public static Point2D rot (Point2D p, double phi)
    {
        Point2D c = new Point2D();
        c.setX(p.getX(0) * Math.cos(phi) - p.getX(1) * Math.sin(phi), 0);
        c.setX(p.getX(0) * Math.sin(phi) + p.getX(1) * Math.cos(phi), 1);
        return c;
    }
    public Point2D rot (double phi)
    {
        double[] x = new double[2];
        x[0] = this.getX(0) * Math.cos(phi) - this.getX(1) * Math.sin(phi);
        x[1] = this.getX(0) * Math.sin(phi) + this.getX(1) * Math.cos(phi);
        this.setX(x);
        return this;
    }
}
