package com.fullcycle.admin.catalogo.infraestructure;

import com.fullcycle.admin.catalogo.application.UseCase;
import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Main {



    public static void main(String[] args) {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        OpenCV.loadShared();

        System.out.println("Hello world!");
        System.out.println(new UseCase().execute());
//open image url

        Mat image = loadImage("https://i.imgur.com/3ZQ3Z0M.jpg");
        System.out.println("Image loaded: " + image);
    }

    public static Mat loadImage(String imagePath) {


        Imgcodecs imageCodecs = new Imgcodecs();
        System.out.println("Loading image from: " + imagePath);
        System.out.println("Image loaded: " + imageCodecs.imread(imagePath));
        return imageCodecs.imread(imagePath);
    }
}