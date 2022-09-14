package com.company;



public class Parallelepiped extends Prism{
    Parallelepiped(Point3D[] p)
    {
        super(p);
        if (p.length != 8)
            throw new IllegalArgumentException("8 points required");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
