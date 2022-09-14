package com.company;

import static java.lang.Math.abs;

public class Trapeze extends QGon{
    Trapeze(Point2D[] p)
    {
        super(p);
        double[] s = {new Segment(p[0], p[1]).getSlope(), new Segment(p[1], p[2]).getSlope(),
                new Segment(p[2], p[3]).getSlope(), new Segment(p[3], p[0]).getSlope()};
        if ((new Segment(p[0], p[1]).getSlope() - new Segment(p[2], p[3]).getSlope()) >= 1e-10 &&
                (new Segment(p[1], p[2]).getSlope() - new Segment(p[3], p[0]).getSlope()) >= 1e-10)
            throw new IllegalArgumentException("this is not trapeze");
    }

    @Override
    public double square()
    {
        double  s;

        s = 0;
        for(int i = 0; i < n -1; i++)
        {
            s += p[i].getX(0) * p[i + 1].getX(1);
            s -= p[i + 1].getX(0) * p[i].getX(1);
        }
        s += p[n - 1].getX(0) * p[0].getX(1);
        s -= p[0].getX(0) * p[n - 1].getX(1);
        s = abs(s) / 2;
        return s;
    }

    @Override
    public String toString()
    {
        String str;
        str = "Trapeze\n{";
        for (int i = 0; i < n - 1; i++)
            str += p[i].toString() + ";";
        str += p[n - 1].toString();
        str += "}";
        return str;
    }
}
