/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class Path {

    private Vector<Location> vectorlocation;
    public static Path inst;

    private void addLocation(int x, int y) {
        vectorlocation.add(new Location(x, y));
    }
    private Vector<Integer> DirectionVect;

    public Vector<Integer> getDirectionVect() {
        return DirectionVect;
    }

    private Path() {
        DirectionVect = new Vector<>();
        vectorlocation = new Vector<Location>();
        addLocation(0, 6);   //r,c
//        DirectionVect.add(1);
//        addLocation(1, 6);
//        DirectionVect.add(1);
//        for (int i = 6; i > 1; i--) {
//            addLocation(2, i);
//            if (i == 6) {
//                DirectionVect.add(1);
//            } else {
//                DirectionVect.add(2);
//            }
//        }
//        for (int i = 3; i <= 8; i++) {
//            addLocation(i, 2);
//            DirectionVect.add(1);
//        }
//        for (int i = 3; i <= 10; i++) {
//            addLocation(8, i);
//            DirectionVect.add(4);
//        }
//        for (int i = 9; i <= 11; i++) {
//            addLocation(i, 10);
//            DirectionVect.add(1);
//        }
//

        for (int i = 6; i >= 1; i--) {
            addLocation(1, i);
        }
        for (int i = 2; i <= 10; i++) {
            addLocation(i, 1);
        }
        //add hang 10
        for (int i = 2; i <= 7; i++) {
            addLocation(10, i);
        }
        //10 den 5 cua cot 7
        for (int i = 9; i >= 5; i--) {
            addLocation(i, 7);
        }
        //hang 5 cot 5,6
        addLocation(5, 6);
        addLocation(5, 5);
        // hang 6,7,8 cot 5
        for (int i = 6; i <= 8; i++) {
            addLocation(i, 5);
        }
        //cot 3,4 hang 8
        addLocation(8, 4);
        addLocation(8, 3);
        //hang 7 -> 3 cot 3
        for (int i = 7; i >= 3; i--) {
            addLocation(i, 3);
        }
        //hang 3 cot 3 -> 10
        for (int i = 4; i <= 10; i++) {
            addLocation(3, i);
        }
        // cot 10 hang 4 -> 11
        for (int i = 4; i <= 11; i++) {
            addLocation(i, 10);
        }
    }

    public static Path getInst() {
        if (inst == null) {
            inst = new Path();
        }
        return (inst);
    }

    public Vector<Location> getVector() {
        return (vectorlocation);
    }
}
