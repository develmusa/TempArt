package com.tempart.coloring;

import java.awt.*;

/**
 * Created by sikcd on 21.09.2016.
 */
public class Hsv extends ColorGradient {


    @Override
    public Color getColor(float temp) {
        float colorTemp = (temp - super.tempMin) /  tempWidth;
        return Color.getHSBColor(colorTemp, 1, 1);
    }
}
