package com.tempart.coloring;

import java.awt.*;

public class Rainbow extends ColorGradient{


    @Override
    public Color getColor(float temp) {
        float colorTemp = (temp - super.tempMin) /  tempWidth;
        Color color = new Color((float) Math.min(Math.max(Math.abs(colorTemp*2-0.5),0),1), (float) Math.min(Math.max(Math.sin(Math.PI*colorTemp),0),1), (float) Math.min(Math.max(Math.cos(0.5*Math.PI*colorTemp),0),1));
        return color;
    }
}
