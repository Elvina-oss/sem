package com.company;

public class Rectangle extends QGon{
    Rectangle(Point2D[] p)
    {
        super(p);
        if (Point.mult(p[3].sub(p[0]), p[1].sub(p[0])) >= 1e-10 ||
                Point.mult(p[0].sub(p[1]), p[2].sub(p[1])) >= 1e-10 ||
                Point.mult(p[1].sub(p[2]), p[3].sub(p[2])) >= 1e-10 ||
                Point.mult(p[2].sub(p[3]), p[0].sub(p[3])) >= 1e-10)
            throw new IllegalArgumentException("this is not rectangle");
    }

    @Override
    public double square()
    {
        Segment a = new Segment(p[0], p[1]);
        Segment b = new Segment(p[1], p[2]);
        return a.length() * b.length();
    }

    @Override
    public String toString()
    {
        String str;
        str = "Rectangle\n{";
        for (int i = 0; i < n - 1; i++)
            str += p[i].toString() + ";";
        str += p[n - 1].toString();
        str += "}";
        return str;
    }
}
