package com.tempart;

/**
 * Created by samuel on 04.07.17.
 */
public class ColorGradientFactory {
    public ColorGradient getColorGradient(ColorMap colorMap){
        switch (colorMap) {
            case HOT:
                return new Hot();
            case AFMHOT:
                return  new AfmHot();
            case HSV:
                return new Hsv();
            case RAINBOW:
                return new Rainbow();
        }
        throw new UnsupportedOperationException("ColorMap not implemented");
    }
}
