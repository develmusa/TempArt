package com.tempart;

import java.awt.*;

/**
 * Created by sikcd on 21.09.2016.
 */
public class Rainbow extends ColorGradient{


    @Override
    Color getColor(float temp) {
        float colorTemp = (temp - super.tempMin) /  tempWidth;
        Color color = new Color((float) Math.min(Math.max(Math.abs(colorTemp*2-0.5),0),1), (float) Math.min(Math.max(Math.sin(Math.PI*colorTemp),0),1), (float) Math.min(Math.max(Math.cos(0.5*Math.PI*colorTemp),0),1));
        return color;
    }
}
