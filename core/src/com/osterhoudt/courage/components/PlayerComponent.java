package com.osterhoudt.courage.components;

import com.badlogic.ashley.core.Component;

public class PlayerComponent implements Component {
    public static final int STATE_WEST = 0;
    public static final int STATE_EAST = 1;
    public static final int STATE_NORTH = 2;
    public static final int STATE_SOUTH = 3;
    public static final int STATE_NORTHWEST = 4;
    public static final int STATE_NORTHEAST = 5;
    public static final int STATE_SOUTHWEST = 6;
    public static final int STATE_SOUTHEAST = 7;
    public static final int STATE_IDLE = 8;
    public static final int STATE_HIT = 9;
}