package com.tempart.coloring;

import java.awt.*;

class AfmHot extends ColorGradient {

    @Override
    public Color getColor(float temp) {
        float colorTemp = (temp - super.tempMin) / tempWidth;
        return new Color(Math.min(2 * colorTemp, 1), Math.min(Math.max((float) (2 * colorTemp - 0.5), 0), 1), Math.max(2 * colorTemp - 1, 0));
    }

}
