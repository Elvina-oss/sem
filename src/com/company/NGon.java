package com.company;

public class NGon implements IShape, IPolyPoint
{
    protected int n;
    protected Point2D[] p;

    public NGon(Point2D[] p)
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
        s = Math.abs(s) / 2.0;
        return s;
    }

    public double length()
    {
        double l = 0;
        for(int i = 0; i < n - 1; i++)
        {
            l += new Segment(p[i], p[i + 1]).length();
        }
        l += new Segment(p[0], p[n-1]).length();
        return l;
    }

    public NGon shift(Point2D a)
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

    public NGon rot(double phi)
    {
        for(int i = 0; i < n; i++)
        {
            p[i].rot(phi);
        }
        return this;
    }

    public NGon symAxis(int i)
    {
        for (int j = 0; j < n; j++)
            p[j].symAxis(i);
        return this;
    }

    public boolean cross(IShape i)
    {
        if (i instanceof NGon)
        {
            for(int j = 0; j < this.getN() - 1; j++)
            {
                for (int k = 0; k < ((NGon) i).getN() - 1; k++)
                {
                    Segment s = new Segment(new Point2D(this.getP(j).getX()), new Point2D(getP(j + 1).getX()));
                    if (s.cross_lines(s.getStart().getX(), s.getFinish().getX(),
                            ((NGon) i).getP(k).getX(), ((NGon) i).getP(k + 1).getX()))
                        return true;
                }
                Segment s = new Segment(new Point2D(this.getP(j).getX()), new Point2D(getP(j + 1).getX()));
                if (s.cross_lines(s.getStart().getX(), s.getFinish().getX(),
                        ((NGon) i).getP(0).getX(), ((NGon) i).getP(((NGon) i).getN() -1 ).getX()))
                    return true;
            }
            for (int k = 0; k < ((NGon) i).getN() - 1; k++)
            {
                Segment s = new Segment(new Point2D(this.getP(0).getX()), new Point2D(getP(this.getN() - 1).getX()));
                if (s.cross_lines(s.getStart().getX(), s.getFinish().getX(),
                        ((NGon) i).getP(k).getX(), ((NGon) i).getP(k + 1).getX()))
                    return true;
            }
            return false;
        }
       throw new ShapeException();
    }

    public String toString()
    {
        String str;
        str = "NGon\n{";
        for (int i = 0; i < n - 1; i++)
            str += p[i].toString() + ";";
        str += p[n - 1].toString();
        str += "}";
        return str;
    }
}
