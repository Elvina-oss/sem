package com.company;

public class Point {
    protected int dim;
    protected double[] x;

    public Point (int dim)
    {
        if (dim <= 0)
            throw new IllegalArgumentException("wrong dim");
        this.dim = dim;
        x = new double[dim];
    }

    public Point (int dim, double[] x)
    {
        if (dim != x.length)
            throw new IllegalArgumentException("wrong dim");
        this.dim = dim;
        this.x = x;
    }

    public int getDim()
    {
        return this.dim;
    }

    public double[] getX()
    {
        return x;
    }

    public double getX(int i)
    {
        return x[i];
    }
    public void setX(double[] x)
    {
        this.x = x;
    }
    public void setX(double x, int i)
    {
        if (i >= dim || i < 0)
            throw new IllegalArgumentException("wrong number");
        this.x[i] = x;
    }
    public double abs()
    {
        double a;
        a = 0;
        for (int i = 0; i < dim; i++)
            a += Math.pow(x[i], 2);
        return Math.pow(a, 0.5);
    }
    public static Point add(Point a, Point b)
    {
        if (a.dim != b.dim)
            throw new IllegalArgumentException("same length required");
        Point c = new Point(a.getDim());
        for(int i = 0; i < a.getDim(); i++)
            c.setX(a.getX(i) + b.getX(i), i);
        return c;
    }

    public Point add(Point b)
    {
        if (dim != b.dim)
            throw new IllegalArgumentException("same length required");
        for (int i = 0; i < this.dim; i++)
            this.x[i] += b.getX(i);
        return this;
    }

    public static Point sub(Point a, Point b)
    {
        if (a.dim != b.dim)
            throw new IllegalArgumentException("same length required");
        Point с = new Point(a.dim);
        for (int i = 0; i < a.dim; i++)
            с.x[i] = a.x[i] - b.x[i];
        return с;
    }

    public Point sub(Point b)
    {
        if (dim != b.dim)
            throw new IllegalArgumentException("same length required");
        return sub(this, b);
    }

    public static Point mult(Point a, double r)
    {
        Point c = new Point(a.getDim());
        for(int i = 0; i < a.getDim(); i++)
            c.setX(a.getX(i) * r, i);
        return c;
    }

    public Point mult(double r)
    {
        for(int i = 0; i < dim; i++)
            this.x[i] *= r;
        return this;
    }

    public static double mult(Point a, Point b)
    {
        if (a.dim != b.dim)
            throw new IllegalArgumentException("same length required");
        double mult;
        mult = a.x[0] * b.x[0];
        for(int i = 1; i < a.getDim(); i++)
            mult += a.getX(i) * b.getX(i);
        return mult;
    }

    public double mult(Point a)
    {
        if (a.dim != dim)
            throw new IllegalArgumentException("wrong number");
        double mult;
        mult = a.x[0] * this.x[0];
        for(int i = 1; i < dim; i++)
            mult += a.x[i] * this.x[i];
        return mult;
    }

    public static Point symAxis(Point a, int i)
    {
        if (i >= a.dim || i < 0)
            throw new IllegalArgumentException("wrong number");
        Point c = new Point(a.getDim());
        for(int j = 0; j < a.getDim(); j++)
        {
            if (i != j)
                c.x[j] = - a.x[j];
            else
                c.x[j] = a.x[j];
        }
        return c;
    }

    public Point symAxis(int i)
    {
        if (i >= dim || i < 0)
            throw new IllegalArgumentException("wrong number");
        for(int j = 0; j < dim; j++)
            if (i != j)
                this.x[j] *= -1;
        return this;
    }

    @Override
    public String toString()
    {
        String str;
        str = "(";
        for(int i = 0; i < dim - 1; i++)
            str += x[i] + ", ";
        str += x[dim - 1] + ")";
        return str;
    }
}
