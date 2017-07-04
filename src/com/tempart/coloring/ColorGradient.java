package com.tempart.coloring;

import java.awt.*;

public abstract class ColorGradient {
    /*
     * http://mathematica.stackexchange.com/questions/110924/how-to-recreate-the-gnuplot-color-scheme-afm-hot-in-mathematica
	 * https://astro.uni-bonn.de/~ithies/gnuplot/colortools/rgbformulae.gp
	 */

    float tempWidth;
    float tempMin;

    public void setTemperatures(float tempMax, float tempMin) {
        this.tempMin = tempMin;
        tempWidth = tempMax - tempMin;
    }

    abstract public Color getColor(float temp);
}
