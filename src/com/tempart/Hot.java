package com.tempart;

import java.awt.*;

/**
 * Created by sikcd on 21.09.2016.
 */
public class Hot extends ColorGradient{



    @Override
    Color getColor(float temp) {
        float colorTemp = (temp - super.tempMin) /  tempWidth;
        Color color = new Color((float) Math.sqrt(colorTemp), (float) Math.min(Math.max(Math.pow(colorTemp,3.0),0),1), (float) Math.max(Math.sin(2*Math.PI*colorTemp),0),1);
        return color;
    }
}
