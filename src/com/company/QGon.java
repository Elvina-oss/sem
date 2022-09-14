package com.company;

public class QGon extends NGon{
    QGon(Point2D[] p)
    {
        super(p);
        if (p.length != 4)
            throw new IllegalArgumentException("4 points required");
    }

    public double square()
    {
        Segment d1 = new Segment(p[0], p[2]); //d1 = {start, finish} start = {x0, x1} finish = {x0, x1}
        Segment d2 = new Segment(p[1], p[3]); //vector1 = d1 finish.x - start.x
        double sin;
        double[] v1 = new double [2], v2 = new double[2];

        v1[0] = d1.getFinish().getX(0) -d1.getStart().getX(0);
        v1[1] = d1.getFinish().getX(1) -d1.getStart().getX(1);
        v2[0] = d2.getFinish().getX(0) -d2.getStart().getX(0);
        v2[1] = d2.getFinish().getX(1) -d2.getStart().getX(1);

        sin = Math.pow(1 - Math.pow((v1[0] * v2[0] + v1[1] * v2[1]) / (d1.length() * d2.length()), 2), 0.5);
        return d1.length() * d2.length() * sin / 2;
    }

    @Override
    public String toString()
    {
        String str;
        str = "QGon\n{";
        for (int i = 0; i < n - 1; i++)
            str += p[i].toString() + ";";
        str += p[n - 1].toString();
        str += "}";
        return str;
    }
}
