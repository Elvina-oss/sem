package com.company;

public class Polyline extends OpenFigure implements IPolyPoint
{
    private int n;
    private Point2D[] p;

    public Polyline(Point2D[] p)
    {
        this.n = p.length;
        this.p = p;
    }

    public int getN()
    {
        return this.n;
    }

    public Point2D[] getP()
    {
        return this.p;
    }

    public Point2D getP(int i)
    {
        return this.p[i];
    }

    public void setP(Point2D[] p)
    {
        this.p = p;
    }

    public void setP(Point2D p, int i)
    {
        this.p[i] = p;
    }

    public double length()
    {
        double l = 0;
        for(int i = 0; i < n - 1; i++)
        {
            l += new Segment(p[i], p[i + 1]).length();
        }
        return l;
    }


    public Polyline shift(Point2D a)
    {
        double[] x = new double[2];
        x[0] = a.getX(0);
        x[1] = a.getX(1);
        for(int i = 0; i < n; i++)
        {
            p[i].setX(p[i].getX(0) + x[0], 0);
            p[i].setX(p[i].getX(1) + x[1], 1);
        }
        return this;
    }

    public Polyline rot(double phi)
    {
        for(int i = 0; i < n; i++)
        {
            p[i].rot(phi);
        }
        return this;
    }


    public Polyline symAxis(int i)
    {
        for (int j = 0; j < n; j++)
            p[j].symAxis(i);
        return this;
    }

    public boolean cross(IShape i)
    {
        if (i instanceof Polyline)
        {
            for (int j = 0; j < this.getN() - 1; j++)
            {
                for (int k = 0; k < ((Polyline) i).getN() - 1; k++)
                {
                    Segment s = new Segment(new Point2D(this.getP(j).getX()), new Point2D(getP(j + 1).getX()));
                    if (s.cross_lines(s.getStart().getX(), s.getFinish().getX(),
                            ((Polyline) i).getP(k).getX(), ((Polyline) i).getP(k + 1).getX()))
                        return true;
                }
            }
            return false;
        }
        else {
            throw new ShapeException();
        }
    }

    public String toString()
    {
        String str;
        str = "Polyline\n{";
        for (int i = 0; i < n - 1; i++)
            str += p[i].toString() + ";";
        str += p[n - 1].toString();
        str += "}";
        return str;
    }
}
