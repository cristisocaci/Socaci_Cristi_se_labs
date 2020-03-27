package edu.tucn.lab5.ex2;

import edu.tucn.lab4.ex6.Rectangle;

interface Image {
    void display();
}

class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}

class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;
    private boolean rotated;

    public ProxyImage(String fileName, boolean rotated){
        this.fileName = fileName;
        this.rotated = rotated;
    }

    @Override
    public void display() {
        if(rotated){
            RotatedImage r = new RotatedImage(fileName);
            r.display();
        }
        else {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }
}

class RotatedImage implements Image{
    private RealImage realImage;
    private String fileName;

    public RotatedImage(String fileName) {
        this.fileName = fileName;
        this.realImage = new RealImage(fileName);
    }

    @Override
    public void display() {
        System.out.println("Display rotated: " + fileName);
    }
}