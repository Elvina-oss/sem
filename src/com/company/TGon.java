package com.company;

public class TGon extends NGon
{
    TGon(Point2D[] p)
    {
        super(p);
        if (p.length != 3)
            throw new IllegalArgumentException("3 points required");
    }

    @Override
    public double square()
    {
        double per;
        double a, b, c;

        per = this.length() / 2;
        a = new Segment(p[0], p[1]).length();
        b = new Segment(p[1], p[2]).length();
        c = new Segment(p[2], p[0]).length();
        return Math.pow(per * (per-a) * (per-b) * (per-c), 0.5);
    }

    @Override
    public String toString()
    {
        String str;
        str = "TGon\n{";
        for (int i = 0; i < n - 1; i++)
            str += p[i].toString() + ";";
        str += p[n - 1].toString();
        str += "}";
        return str;
    }
}
