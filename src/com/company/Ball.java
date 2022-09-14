package com.company;

public class Ball implements IFigure
{
    private Point3D p;
    private double r;

    public Ball(Point3D p, double r)
    {
        this.p = p;
        this.r = r;
    }

    public Point3D getP()
    {
        return p;
    }

    public void setP(Point3D p)
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
        return 4 * Math.PI * Math.pow(r, 2);
    }

    public double volume()
    {
        return 4 * Math.PI * Math.pow(r, 3) / 3;
    }

}
