package com.tempart;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by sikcd on 21.09.2016.
 */
public class TemperaturPicture {
    private final String inputPath;
    private final int inputSizeY = 365;
    private final int inputSizeX = 288;
    private final int outputSizeY = 9490;
    private final int outputSizeX = 9504;
    private final String outputPath;
    private final ColorGradient pictureColor;


    public TemperaturPicture(String outputPath, String inputPath, ColorGradient pictureColorGradient) {
        this.outputPath = outputPath;
        this.inputPath = inputPath;
        this.pictureColor = pictureColorGradient;
    }

    public void drawImage() throws IOException, ParseException {
        TempReader tempReader = new TempReader(inputPath);
        tempReader.readFile();
        Queue<Double> temperatures = scaleImage(tempReader.getTemeratures());
        pictureColor.setTemperaturs((float)tempReader.getHighestTemp(), (float)tempReader.getLowestTemp());
        BufferedImage img = new BufferedImage(outputSizeX, outputSizeY, BufferedImage.TYPE_INT_ARGB );
        for(int y = 0; y < outputSizeY; y++) {
            if(y % (outputSizeY/inputSizeY) == 0){
                for (int x = 0; x < outputSizeX; x++) {
                    img.setRGB(x, y, pictureColor.getColor((float) temperatures.poll().doubleValue()).getRGB());
                }

            } else {
                    for (int x = 0; x < outputSizeX; x++) {
                        img.setRGB(x, y, img.getRGB(x, y - 1));
                }
            }

        }
        File outputFile = new File(outputPath);
        ImageIO.write(img, "PNG", outputFile);
        System.out.println("Write file: " + outputPath);
    }

    public Queue<Double> scaleImage(Queue<Double> temperatures){
        Queue<Double> temperaturesScaled = new LinkedList<>();
        double previousTemperatur = 0;
        while (!temperatures.isEmpty()){
            previousTemperatur = temperatures.poll();
            if (temperatures.isEmpty()){
                temperaturesScaled.add(previousTemperatur);
            } else {
                double x1 = 0;
                double y1 = previousTemperatur;
                double x2 = 32;
                double y2 = temperatures.peek();
                double slope = (y2 - y1) / (x2 - x1);
                temperaturesScaled.add(previousTemperatur);
                for (int x = 1; x < (outputSizeX / inputSizeX); x++){
                   // System.out.println(slope * x + y1);
                    temperaturesScaled.add(slope * x + y1);
                }
            }
        }
        return temperaturesScaled;

    }
}