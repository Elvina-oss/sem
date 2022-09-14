package com.company;

public class Pyramid implements IFigure
{
    Point3D p0;
    int n;
    Point3D[] p;

    Pyramid(Point3D p0, Point3D[] p)
    {
        if (p.length < 3)
            throw new IllegalArgumentException("not enough points");
        this.p0 = p0;
        this.p = p;
        n = this.p.length;
    }

    Pyramid(Point3D[] p)
    {
        p0 = p[0];
        n = p.length - 1   ;
        this.p = new Point3D[n];
        System.arraycopy(p, 1, this.p, 0, this.n);
    }

    public int getN()
    {
        return n;
    }

    Point3D[] getP()
    {
        return p;
    }

    void setP(Point3D[] p)
    {
        this.p = p;
        n = p.length;
    }

    Point3D getP(int i)
    {
        if (i >= n || i < 0)
            throw new IllegalArgumentException("wrong number");
        return p[i];
    }

    void setP(Point3D p, int i)
    {
        if (i >= n || i < 0)
            throw new IllegalArgumentException("wrong number");
        this.p[i] = p;
    }

    static public double getArea(Point3D[] p) {
        double sum = 0;
        for (int i = 1; i < p.length - 1; i++) {
            Point3D p1 = Point3D.cross_prod(new Point3D(p[0].sub(p[i])), new Point3D(p[0].sub(p[i + 1])));
            sum += p1.abs() / 2;
        }
        return sum;
    }

    @Override
    public double square() {
        double sum = 0;
        sum += getArea(p);
        for (int i = 0; i < this.n - 1; i++) {
            Point3D p1 = Point3D.cross_prod(new Point3D(p0.sub(p[i])), new Point3D(p0.sub(p[i + 1])));
            sum += p1.abs() / 2;
        }
        Point3D p1 = Point3D.cross_prod(new Point3D(p0.sub(p[n - 1])), new Point3D(p0.sub(p[0])));
        sum += p1.abs() / 2;
        return sum;
    }

    static public double getHeight(Point3D[] p, Point3D p0) {
        double a = p[0].x[1] * (p[1].x[2] - p[2].x[2]) + p[1].x[1] * (p[2].x[2] - p[0].x[2]) + p[2].x[1] * (p[0].x[2] - p[1].x[2]);
        double b = p[0].x[2] * (p[1].x[0] - p[2].x[0]) + p[1].x[2] * (p[2].x[0] - p[0].x[0]) + p[2].x[2] * (p[0].x[0] - p[1].x[0]);
        double c = p[0].x[0] * (p[1].x[1] - p[2].x[1]) + p[1].x[0] * (p[2].x[1] - p[0].x[1]) + p[2].x[0] * (p[0].x[1] - p[1].x[1]);
        double d = -(p[0].x[0] * (p[1].x[1] * p[2].x[2] - p[2].x[1] * p[1].x[2]) +
                p[1].x[0] * (p[2].x[1] * p[0].x[2] - p[0].x[1] * p[2].x[2]) +
                p[2].x[0] * (p[0].x[1] * p[1].x[2] - p[1].x[1] * p[0].x[2]));
        return Math.abs(a*p0.x[0] + b*p0.x[1] + c*p0.x[2] + d)/Math.sqrt(Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2));
    }

    @Override
    public double volume() {
        return getArea(p) * getHeight(p, p0) / 3;
    }
    public String toString()
    {
        String  str;
        str = "p0: " + p0.toString()
                + "n: " + n + "\n";
        for (int i = 1; i < n; i++)
            str += "p[" + i + "]" + p[i].toString();
        return str;
    }
}
