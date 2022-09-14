package com.company;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
//        //TEST
//
//        int n = 8;
//
//        List<IShape> list = new ArrayList<IShape>();
//
//        double[] x_circle = {1, 1};
//        Circle circle = new Circle(new Point2D(x_circle), 1);
//        list.add((IShape) circle);
//
//        double[] x_s_1 = {0, 2};
//        double[] x_s_2 = {1, 1};
//        Segment segment= new Segment(new Point2D(x_s_1), new Point2D(x_s_2));
//        list.add((IShape) segment);
//
//        double[] x_p_1 = {0, 3};
//        double[] x_p_2 = {2, 1};
//        double[] x_p_3 = {1,1};
//        Point2D[] p = {new Point2D(x_p_1), new Point2D(x_p_2), new Point2D(x_p_3)};
//        Polyline polyline = new Polyline(p);
//        list.add((IShape) polyline);
//
//        double[] x_n_1 = {1, 1};
//        double[] x_n_2 = {2, 3};
//        double[] x_n_3 = {4,6};
//        double[] x_n_4 = {3,0};
//        double[] x_n_5 = {1,0};
//        Point2D[] ng = {new Point2D(x_n_1), new Point2D(x_n_2), new Point2D(x_n_3), new Point2D(x_n_4), new Point2D(x_n_5)};
//        NGon ngon = new NGon(ng);
//        list.add((IShape) ngon);
//
//        double[] x_t_1 = {1, 5};
//        double[] x_t_2 = {2, 10};
//        double[] x_t_3 = {3,8};
//        Point2D[] p1 = {new Point2D(x_t_1), new Point2D(x_t_2), new Point2D(x_t_3)};
//        TGon tgon = new TGon(p1);
//        list.add((IShape) tgon);
//
//        double[] x_q_1 = {5, 7};
//        double[] x_q_2 = {9, 8};
//        double[] x_q_3 = {10,3};
//        double[] x_q_4 = {2, 2};
//        Point2D[] p2 = {new Point2D(x_q_1), new Point2D(x_q_2), new Point2D(x_q_3), new Point2D(x_q_4)};
//        QGon qgon = new QGon(p2);
//        list.add((IShape) qgon);
//
//        double[] x_r_1 = {0, 4};
//        double[] x_r_2 = {8, 10};
//        double[] x_r_3 = {11,6};
//        double[] x_r_4 = {3, 0};
//        Point2D[] rec = {new Point2D(x_r_1), new Point2D(x_r_2), new Point2D(x_r_3), new Point2D(x_r_4)};
//        Rectangle rectangle = new Rectangle(rec);
//        list.add((IShape) rectangle);
//
//        double[] x_tr_1 = {-1, 4};
//        double[] x_tr_2 = {1, 10};
//        double[] x_tr_3 = {5,9};
//        double[] x_tr_4 = {2, 0};
//        Point2D[] trap = {new Point2D(x_tr_1), new Point2D(x_tr_2), new Point2D(x_tr_3), new Point2D(x_tr_4)};
//        Trapeze trapeze = new Trapeze(trap);
//        list.add((IShape) trapeze);
//
//
//
//
//        double s = 0, l = 0;
//        for(int i = 0; i < list.size(); i++)
//        {
//            s += list.get(i).square();
//            l += list.get(i).length();
//        }
//        System.out.println("TEST\nСуммарная площадь фигур: " + s + "\nСуммарная длина фигур: "
//                + l + "\nСредняя площадь фигур: " + s / list.size());
//
//        //TEST1
//
//        List<IShape> list2 = new ArrayList<IShape>();
//
//        double[] x_circle2 = {0, 2};
//        double[] c_shift = {3, 3};
//        Circle circle2 = new Circle(new Point2D(x_circle2), 2);
//        list2.add((IShape) circle2);
//        if (circle2.cross((IShape) circle))
//            System.out.println("TEST1\nCircle пересекаются");
//        else
//            System.out.println("Circle не пересекаются");
//        circle2.shift(new Point2D(c_shift));
//        System.out.println(circle2.toString());
//        if (circle2.cross((IShape) circle))
//            System.out.println("TEST1\nCircle пересекаются");
//        else
//            System.out.println("Circle не пересекаются");
//
//        double[] s_1 = {0, 1};
//        double[] s_2 = {2, 3};
//        Segment segment2 = new Segment(new Point2D(s_1), new Point2D(s_2));
//        list2.add((IShape) segment2);
//        if (segment2.cross((IShape) segment))
//            System.out.println("Segment пересекаются");
//        else
//            System.out.println("Segment не пересекаются");
//        segment2.rot(1);
//        System.out.println(segment2.toString());
//        if (segment2.cross((IShape) segment))
//            System.out.println("Segment пересекаются");
//        else
//            System.out.println("Segment не пересекаются");
//
//        double[] p_1 = {0, 1};
//        double[] p_2 = {-1, 2};
//        double[] p_3 = {2,3};
//        double[] p_4 = {1,0};
//        Point2D[] pp2 = {new Point2D(p_1), new Point2D(p_2), new Point2D(p_3), new Point2D(p_4)};
//        Polyline polyline2 = new Polyline(pp2);
//        list2.add((IShape) polyline2);
//        if (polyline2.cross((IShape) polyline))
//            System.out.println("Polyline пересекаются");
//        else
//            System.out.println("Polyline не пересекаются");
//        polyline2.symAxis(0);
//        System.out.println(polyline2.toString());
//        if (polyline2.cross((IShape) polyline))
//            System.out.println("Polyline пересекаются");
//        else
//            System.out.println("Polyline не пересекаются");
//
//        double[] n_1 = {5, 2};
//        double[] n_2 = {8, 3};
//        double[] n_3 = {9, 1};
//        double[] n_4 = {8,-2};
//        double[] n_5 = {6,-2};
//        double[] n_6 = {5, -1};
//        double[] n_shift = {-2, 1};
//        Point2D[] ng2 = {new Point2D(n_1), new Point2D(n_2), new Point2D(n_3), new Point2D(n_4),
//                new Point2D(n_5), new Point2D(n_6)};
//        NGon ngon2 = new NGon(ng2);
//        list2.add((IShape) ngon2);
//        if (ngon2.cross((IShape) ngon))
//            System.out.println("NGon пересекаются");
//        else
//            System.out.println("NGon не пересекаются");
//        ngon2.shift(new Point2D(n_shift));
//        System.out.println(ngon2.toString());
//        if (ngon2.cross((IShape) ngon))
//            System.out.println("NGon пересекаются");
//        else
//            System.out.println("NGon не пересекаются");
//
//        double[] t_1 = {1, 2};
//        double[] t_2 = {5, 1};
//        double[] t_3 = {5,5};
//        Point2D[] pp3 = {new Point2D(t_1), new Point2D(t_2), new Point2D(t_3)};
//        TGon tgon2 = new TGon(pp3);
//        list2.add((IShape) tgon2);
//        if (tgon2.cross((IShape) tgon))
//            System.out.println("TGon пересекаются");
//        else
//            System.out.println("TGon не пересекаются");
//        tgon2.rot(0.6);
//        System.out.println(tgon.toString());
//        if (tgon2.cross((IShape) tgon))
//            System.out.println("TGon пересекаются");
//        else
//            System.out.println("TGon не пересекаются");
//
//        double[] q_1 = {-1, 8};
//        double[] q_2 = {2, 6};
//        double[] q_3 = {-2,3};
//        double[] q_4 = {-4, 5};
//        Point2D[] pp4 = {new Point2D(q_1), new Point2D(q_2), new Point2D(q_3), new Point2D(q_4)};
//        QGon qgon2 = new QGon(pp4);
//        list2.add((IShape) qgon2);
//        if (qgon2.cross((IShape) qgon))
//            System.out.println("QGon пересекаются");
//        else
//            System.out.println("QGon не пересекаются");
//        qgon2.symAxis(1);
//        System.out.println(qgon2.toString());
//        if (qgon2.cross((IShape) qgon))
//            System.out.println("QGon пересекаются");
//        else
//            System.out.println("QGon не пересекаются");
//
//        double[] r_1 = {2, 10};
//        double[] r_2 = {6, 9};
//        double[] r_3 = {5, 5};
//        double[] r_4 = {1, 6};
//        double[] r_shift = {3, -2};
//        Point2D[] rec2 = {new Point2D(r_1), new Point2D(r_2), new Point2D(r_3), new Point2D(r_4)};
//        Rectangle rectangle2 = new Rectangle(rec2);
//        list2.add((IShape) rectangle2);
//        if (rectangle2.cross((IShape) rectangle))
//            System.out.println("Rectangle пересекаются");
//        else
//            System.out.println("Rectangle не пересекаются");
//        rectangle2.shift(new Point2D(r_shift));
//        System.out.println(rectangle2.toString());
//        if (rectangle2.cross((IShape) rectangle))
//            System.out.println("Rectangle пересекаются");
//        else
//            System.out.println("Rectangle не пересекаются");
//
//        double[] tr_1 = {6, 0};
//        double[] tr_2 = {4, 3};
//        double[] tr_3 = {6,6};
//        double[] tr_4 = {9, 1.5};
//        Point2D[] trap2 = {new Point2D(tr_1), new Point2D(tr_2), new Point2D(tr_3), new Point2D(tr_4)};
//        Trapeze trapeze2 = new Trapeze(trap2);
//        list2.add((IShape) trapeze2);
//        if (trapeze2.cross((IShape) trapeze))
//            System.out.println("Trapeze пересекаются");
//        else
//            System.out.println("Trapeze не пересекаются");
//        trapeze2.rot(1.9);
//        System.out.println(qgon2.toString());
//        if (trapeze2.cross((IShape) trapeze))
//            System.out.println("Trapeze пересекаются");
//        else
//            System.out.println("Trapeze не пересекаются");
//
//        //TEST2
//
//        System.out.println("TEST2");
//        List<IFigure> list3 = new ArrayList<IFigure>();
//
//        double[] px1 = {1, 3, 5};
//        double[] px2 = {0, 1, 0};
//        double[] px3 = {2, 3, 4};
//        double[] px4 = {2, 3, 3};
//        double[] px5 = {1, 2, 1};
//        Point3D[] pyr = {new Point3D(px1), new Point3D(px2), new Point3D(px3),
//                new Point3D(px4), new Point3D(px5)};
//        Pyramid pyramid = new Pyramid(pyr);
//        list3.add((IFigure) pyramid);
//
//        double[] bx = {1, 1, 1};
//        Ball ball = new Ball(new Point3D(bx), 2);
//        list3.add((IFigure) ball);
//
//        double[] prx1 = {0, 0, 1};
//        double[] prx2 = {2, 3, 2};
//        double[] prx3 = {3, 4, 1};
//        double[] prx4 = {1, 1, 2};
//        double[] prx5 = {3, 4, 3};
//        double[] prx6 = {4, 5, 2};
//        Point3D[] pr = {new Point3D(prx1), new Point3D(prx2), new Point3D(prx3),
//                new Point3D(prx4), new Point3D(prx5), new Point3D(prx6)};
//        Prism prism = new Prism(pr);
//        list3.add((IFigure) prism);
//
//        double[] pax1 = {1, 2, 0};
//        double[] pax2 = {3, 3, 1};
//        double[] pax3 = {5, 3, 3};
//        double[] pax4 = {3, 2, 2};
//        double[] pax5 = {2, 3, 1};
//        double[] pax6 = {4, 4, 2};
//        double[] pax7 = {6, 4, 4};
//        double[] pax8 = {4, 3, 3};
//        Point3D[] pa = {new Point3D(pax1), new Point3D(pax2), new Point3D(pax3),
//                new Point3D(pax4), new Point3D(pax5), new Point3D(pax6), new Point3D(pax7), new Point3D(pax8)};
//        Parallelepiped parallelepiped = new Parallelepiped(pa);
//        list3.add((IFigure) parallelepiped);
//
//        double sq = 0, v = 0;
//        for(int i = 0; i < list3.size(); i++)
//        {
//            System.out.println("Figure " + i);
//            System.out.println(list3.get(i).square());
//            System.out.println(list3.get(i).volume());
//            sq += list3.get(i).square();
//            v += list3.get(i).volume();
//        }
//        System.out.println("Суммарный объем фигур: " + v + "\nСуммарная площадь фигур: "
//                + sq + "\nСредний объем фигур: " + v / list3.size());

        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D();
        Point2D p3 = new Point2D();
        Point2D p4 = new Point2D();
        Point2D[] p = {p1, p2, p3, p4};
        Polyline n = new Polyline(p);
        Segment s = new Segment(p1, p2);
        System.out.println(s.toString());
    }
}
