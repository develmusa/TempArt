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

    public TemperatureImage(String outputPath, String inputPath, ColorMap color, Rectangle inputDataDimensions, Rectangle outputPictureDimensions, String regex){
        this.outputPath = outputPath;
        this.dataSet = new DataSet(inputPath);
        this.color = color;
        this.pictureColor = new ColorGradientFactory().getColorGradient(color);
        this.inputDataDimensions = inputDataDimensions;
        this.outputPictureDimensions = outputPictureDimensions;
        this.regex = regex;
    }

    public String getOutputPath() {
        return outputPath;
    }


    public DataSet getDataSet() {
        return dataSet;
    }

    public Rectangle getInputDataDimensions() {
        return inputDataDimensions;
    }

    public Rectangle getOutputPictureDimensions() {
        return outputPictureDimensions;
    }

    public ColorGradient getPictureColor() {
        return pictureColor;
    }
    public String getRegex() {
        return regex;
    }


    public ColorMap getColor() {
        return color;
    }
}


