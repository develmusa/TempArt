package com.tempart;

import java.awt.*;

/**
 * Created by sikcd on 21.09.2016.
 */
public abstract class ColorGradient {
    /*
	 * http://mathematica.stackexchange.com/questions/110924/how-to-recreate-the-gnuplot-color-scheme-afm-hot-in-mathematica
	 * https://astro.uni-bonn.de/~ithies/gnuplot/colortools/rgbformulae.gp
	 */

    public float tempWidth;
    public float tempMin;

    public void setTemperaturs(float tempMax, float tempMin){
        this.tempMin = tempMin;
        tempWidth = tempMax - tempMin;
    }

    abstract Color getColor(float temp);
}
