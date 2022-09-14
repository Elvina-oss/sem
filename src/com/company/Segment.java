package com.company;

import static java.lang.Math.*;

public class Segment extends OpenFigure
{
    private Point2D start;
    private Point2D finish;
    public Segment(Point2D s, Point2D f)
    {
        start = s;
        finish = f;
    }
    public Point2D getStart()
    {
        return start;
    }
    public void setStart(Point2D a)
    {
        start = a;
    }
    public Point2D getFinish()
    {
        return finish;
    }
    public void setFinish(Point2D a)
    {
        finish = a;
    }
    public double length()
    {
        Point2D s;
        Point2D f;
        s = this.getStart();
        f = this.getFinish();
        return Math.pow(Math.pow(s.getX(0) - f.getX(0), 2) + Math.pow(s.getX(1) - f.getX(1), 2), 0.5);
    }
    public Segment shift(Point2D a)
    {
        double[] s = new double[2];
        double[] f = new double[2];
        s[0] = this.getStart().getX(0) + a.getX(0);
        s[1] = this.getStart().getX(1) + a.getX(1);
        f[0] = this.getFinish().getX(0) + a.getX(0);
        f[1] = this.getFinish().getX(1) + a.getX(1);
        this.setStart(new Point2D(s));
        this.setFinish(new Point2D(f));
        return this;
    }
    public Segment rot(double phi)
    {
        this.start.rot(phi);
        this.finish.rot(phi);
        return this;
    }
    public Segment symAxis(int i)
    {
        this.start.symAxis(i);
        this.finish.symAxis(i);
        return this;
    }

    private boolean value_between(double l, double r,double x) {
        double eps = 0.001;
        if (min(l, r) <= x + eps && x <= max(l, r) + eps)
            return true;
        return false;
    }

    private boolean bound_box(double a, double b, double c, double d)
    {
        double eps = 0.001;
        if (a > b)
        {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        if (c > d)
        {
            c = c + d;
            d = c - d;
            c = c - d;
        }
        if (max(a, c) <= min(b, d) + eps)
            return true;
        return false;
    }


    public   boolean cross_lines(double[] a1,double[] b1,double[] c1,double[] d1) {
        double[] a = a1.clone();
        double[] b = b1.clone();
        double[] c = c1.clone();
        double[] d = d1.clone();
        if  (!bound_box (a[0], b[0], c[0], d[0]) ||  !bound_box(a[1], b[1], c[1], d[1]))
            return false;

        double eps = 0.001;
        double line1_x = b[0] - a[0];
        double line1_y = a[1] - b[1];
        double line1_c = -line1_y * a[0] - line1_x * a[1];
        double z = sqrt(pow(line1_y, 2) + pow(line1_x,2));
        if (abs(z) > eps) {
            line1_x /= z;
            line1_y /= z;
            line1_c /= z;
        }
        double line2_x = d[0] - c[0];
        double line2_y = c[1] - d[1];
        double line2_c = -line2_y * c[0] - line2_x * c[1];
        z = sqrt(pow(line2_y, 2) + pow(line2_x,2));
        if (abs(z) > eps) {
            line2_x /= z;
            line2_y /= z;
            line2_c /= z;
        }
        double zn = line1_y * line2_x - line1_x * line2_y;
        double line1_dist_c = line1_y * c[0] + line1_x * c[1] + line1_c;
        double line2_dist_a = line2_y * a[0] + line2_x * a[1] + line2_c;
        if (abs(zn) < eps) {
            if (abs(line1_dist_c) > eps || abs(line2_dist_a) > eps)
                return false;
            return true;
        }

        double x = -(line1_c * line2_x - line1_x * line2_c) / zn;
        double y = -(line1_y * line2_c - line1_c * line2_y) / zn;
        if (value_between(a[0], b[0], x)
            && value_between (a[1], b[1], y)
            && value_between (c[0], d[0], x)
            && value_between (c[1], d[1], y))
            return true;
        return false;
    }



    public boolean cross(IShape i)
    {
        if (i instanceof Segment)
            return cross_lines(this.getStart().getX(), this.getFinish().getX(),
                    ((Segment) i).getStart().getX(), ((Segment) i).getFinish().getX());
       else
           throw new ShapeException();
    }



    public double getSlope()
    {
        return (finish.getX(1) - start.getX(1)) / (finish.getX(0) - start.getX(0));
    }


    @Override
    public String toString()
    {
        String str;
        str = "Segment\n[";
        str += start.toString() + ";" + start.toString();
        str += "]";
        return str;
    }
}
