/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author ADMIN
 */
public class ViewConfig {

    public static int MAP_NUMBER_ROW = 12;
    public static int MAP_NUMBER_COLUM = 12;
    public static int MAP_CELL_SIZE = 60;
    public static int MAP_OFFSET_Y = 35;
    public static int MAP_OFFSET_X = 13;

    public static ViewLocation calculateViewLocation(int x, int y) {
        return (new ViewLocation(MAP_OFFSET_X + x * MAP_CELL_SIZE, MAP_OFFSET_Y + y * MAP_CELL_SIZE));
    }

    public static ViewLocation calculatemidViewLocation(int x, int y) {
        return (new ViewLocation(MAP_OFFSET_X + x * MAP_CELL_SIZE, MAP_OFFSET_Y + y * MAP_CELL_SIZE));
    }

    public static ViewLocation covertpixeltocelrow(int x, int y) {
        ViewLocation result = null;

        x = (x - MAP_OFFSET_X) / MAP_CELL_SIZE;

        y = (y - MAP_OFFSET_Y) / MAP_CELL_SIZE;
        result = new ViewLocation(x, y);
        return (result);
    }

    //convert tu pixel sang o    
}
