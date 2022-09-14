package com.company;

import java.awt.*;

public class Point3D extends Point{
    public Point3D()
    {
        super(3);
    }
    public Point3D(double[] x)
    {
        super(3, x);
        if (x.length != 3)
            throw new IllegalArgumentException("double[3]");
    }

    public Point3D(Point p)
    {
        super(3, p.x);
    }

    public static Point3D cross_prod(Point3D p1, Point3D p2)
    {
        Point3D p = new Point3D();
        p.setX(p1.getX(1) * p2.getX(2) - p1.getX(2) * p2.getX(1), 0);
        p.setX(p1.getX(2) * p2.getX(0) - p1.getX(0) * p2.getX(2), 1);
        p.setX(p1.getX(0) * p2.getX(1) - p1.getX(1) * p2.getX(0), 2);
        return p;
    }

    public Point3D cross_prod(Point3D p)
    {
        double[] a = new double[3];
        a[0] = this.getX(1) * p.getX(2) - this.getX(2) * p.getX(1);
        a[1] = this.getX(2) * p.getX(0) - this.getX(0) * p.getX(2);
        a[2] = this.getX(0) * p.getX(1) - this.getX(1) * p.getX(0);
        this.setX(a[0], 0);
        this.setX(a[1], 1);
        this.setX(a[2], 2);
        return this;
    }

    public static double mix_prod(Point3D p1, Point3D p2, Point3D p3)
    {
        return p1.getX(0) * p2.getX(1) * p3.getX(2) +
                p1.getX(1) * p2.getX(2) * p3.getX(0) +
                p1.getX(2) * p2.getX(0) * p3.getX(1) -
                p1.getX(2) * p2.getX(1) * p3.getX(0) -
                p1.getX(0) * p2.getX(2) * p3.getX(1) -
                p1.getX(1) * p2.getX(0) * p3.getX(2);
    }

    public double mix_prod(Point3D p1, Point3D p2)
    {
        return this.getX(0) * p1.getX(1) * p2.getX(2) +
                this.getX(1) * p1.getX(2) * p2.getX(0) +
                this.getX(2) * p1.getX(0) * p2.getX(1) -
                this.getX(2) * p1.getX(1) * p2.getX(0) -
                this.getX(0) * p1.getX(2) * p2.getX(1) -
                this.getX(1) * p1.getX(0) * p2.getX(2);
    }

}
