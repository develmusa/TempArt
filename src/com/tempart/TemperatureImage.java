package com.tempart;

import com.tempart.coloring.ColorGradient;
import com.tempart.coloring.ColorGradientFactory;
import com.tempart.coloring.ColorMap;
import com.tempart.datahandling.DataSet;

import java.awt.*;

class TemperatureImage {
    private final String outputPath;
    private final Rectangle inputDataDimensions;
    private final Rectangle outputPictureDimensions;
    private final ColorGradient pictureColor;
    private final DataSet dataSet;
    private final String regex;

    private final ColorMap color;

    TemperatureImage(String outputPath, String inputPath, ColorMap color, Rectangle inputDataDimensions, Rectangle outputPictureDimensions, String regex) {
        this.outputPath = outputPath;
        this.dataSet = new DataSet(inputPath);
        this.color = color;
        this.pictureColor = new ColorGradientFactory().getColorGradient(color);
        this.inputDataDimensions = inputDataDimensions;
        this.outputPictureDimensions = outputPictureDimensions;
        this.regex = regex;
    }

    String getOutputPath() {
        return outputPath;
    }


    DataSet getDataSet() {
        return dataSet;
    }

    Rectangle getInputDataDimensions() {
        return inputDataDimensions;
    }

    Rectangle getOutputPictureDimensions() {
        return outputPictureDimensions;
    }

    ColorGradient getPictureColor() {
        return pictureColor;
    }

    String getRegex() {
        return regex;
    }


    ColorMap getColor() {
        return color;
    }
}


