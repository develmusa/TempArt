package com.tempart.coloring;

import java.awt.*;

/**
 * Created by sikcd on 21.09.2016.
 */
public class AfmHot extends ColorGradient {

    @Override
    public Color getColor(float temp) {
        float colorTemp = (temp - super.tempMin) /  tempWidth;
        Color color = new Color(Math.min(2*colorTemp,1), Math.min(Math.max((float)(2*colorTemp-0.5),0),1), Math.max(2*colorTemp-1,0));
        return color;
    }

}
