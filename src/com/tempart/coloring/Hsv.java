package com.tempart.coloring;

import java.awt.*;


public class Hsv extends ColorGradient {


    @Override
    public Color getColor(float temp) {
        float colorTemp = (temp - super.tempMin) /  tempWidth;
        return Color.getHSBColor(colorTemp, 1, 1);
    }
}
