package com.company;

public class Circle implements IShape
{
    private Point2D p;
    private double r;

    public Circle(Point2D p, double r)
    {
        this.p = p;
        this.r = r;
    }

    public Point2D getP()
    {
        return p;
    }

    public void setP(Point2D p)
    {
        this.p = p;
    }

    public double getR()
    {
        return r;
    }

    public void setR(double r)
    {
        this.r = r;
    }

    public double square()
    {
        return Math.PI * Math.pow(r, 2);
    }

    public double length()
    {
        return 2 * Math.PI * r;
    }

    public Circle shift(Point2D a)
    {
        p.add(a);
        return this;
    }

    public Circle rot(double phi)
    {
        p.rot(phi);
        return this;
    }

    public Circle symAxis(int i)
    {
        p.symAxis(i);
        return this;
    }

    public boolean cross(IShape i)
    {
        if (i instanceof Circle)
        {
            return new Segment(this.getP(), ((Circle) i).getP()).length() <= this.getR() + ((Circle) i).getR();
        }
        return false;
    }

    public String toString()
    {
        String str;
        str = "Circle\n(Center: ";
        str += p.toString();
        str += "; Radius: " + r + ")";
        return str;
    }
}
