package com.company;

public class Prism implements IFigure{
    protected int n;
    protected Point3D[] p1;
    protected Point3D[] p2;

    public Prism(Point3D[] p1, Point3D[] p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        n = p1.length;
        if (p1.length != p2.length)
            throw new IllegalArgumentException("p1 and p2 must have the same length");
    }

    public Prism(Point3D[] p)
    {
        n = p.length / 2;
        p1 = new Point3D[n];
        p2 = new Point3D[n];
        for (int i = 0; i < n; i ++)
        {
            p1[i] = p[i];
            p2[i] = p[i + n];
        }
    }

    public int getN()
    {
        return n;
    }

    public Point3D[] getP()
    {
        Point3D[] p = new Point3D[n];
        for(int i = 0; i < n; i++)
        {
            p[i] = p1[i];
            p[i + n] = p2[i];
        }
        return p;
    }

    public void setP(Point3D[] p)
    {
        for (int i = 0; i < n; i ++)
        {
            p1[i] = p[i];
            p2[i] = p[i + n];
        }
    }
    public Point3D getP(int i)
    {
        if (i < n)
            return p1[i];
        return p2[i - n];
    }

    public void setP(Point3D p, int i)
    {
        if (i < n)
            p1[i] = p;
        else
            p2[i - n] = p;
    }
    @Override
    public double square() {
        double sum = 0;
        sum += Pyramid.getArea(p1);
        sum += Pyramid.getArea(p2);
        for (int i = 0; i < n - 1; i++) {
            sum += Pyramid.getArea(new Point3D[] {p1[i], p1[i + 1], p2[i], p2[i + 1]});
        }
        sum += Pyramid.getArea(new Point3D[] {p1[n - 1], p1[0], p2[n - 1], p2[0]});
        return sum;
    }

    @Override
    public double volume() {
        return Pyramid.getArea(p1) * Pyramid.getHeight(p1, p2[0]);
    }
    @Override
    public String toString()
    {
        String str;
        str = "n = " + n + "\nТочки нижнего основания:\n";
        for (int i = 0; i < n / 2; i++)
            str += "p1[" + i +"]:" + p1[i].toString();
        str = "n = " + n + "\nТочки верхего основания:\n";
        for (int i = 0; i < n / 2; i++)
            str += "p2[" + i +"]:" + p2[i].toString();
        return str;
    }
}