package com.tempart;

import java.awt.*;

/**
 * Created by samuel on 04.07.17.
 */
public class TemperatureImage {
    private final String inputPath;
    private final String outputPath;
    private final Rectangle inputDataDimensions;
    private final Rectangle outputPictureDimensions;
    private final ColorGradient pictureColor;

    public TemperatureImage(String outputPath, String inputPath, ColorMap color, Rectangle inputDataDimensions, Rectangle outputPictureDimensions){
        this.outputPath = outputPath;
        this.inputPath = inputPath;
        this.pictureColor = new ColorGradientFactory().getColorGradient(color);
        this.inputDataDimensions = inputDataDimensions;
        this.outputPictureDimensions = outputPictureDimensions;
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
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


}


