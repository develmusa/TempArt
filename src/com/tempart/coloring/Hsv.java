package com.tempart.coloring;

import java.awt.*;


class Hsv extends ColorGradient {


    @Override
    public Color getColor(float temp) {
        float colorTemp = (temp - super.tempMin) / tempWidth;
        return Color.getHSBColor(colorTemp, 1, 1);
    }
}
