package com.tempart.coloring;

import java.awt.*;

/**
 * Created by sikcd on 21.09.2016.
 */
public class Hot extends ColorGradient{



    @Override
    public Color getColor(float temp) {
        float normalizedTemperature = (temp - super.tempMin) /  tempWidth;
        Color color = new Color((float) Math.sqrt(normalizedTemperature), (float) Math.min(Math.max(Math.pow(normalizedTemperature,3.0),0),1), (float) Math.max(Math.sin(2*Math.PI*normalizedTemperature),0),1);
        return color;
    }
}
