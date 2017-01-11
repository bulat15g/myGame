package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class otherObjects {
    public Boolean canbeTapped=false;
    public Boolean canbeEated=false;
    public BufferedImage image1,image2;

    otherObjects(){
        initiate();


    }

    public void paint(Graphics g){
        g.drawImage(image1,400,400,null);
    }

    void initiate(){
        try {
            image1 = ImageIO.read(new File("metal.png"));
//            image2 = ImageIO.read(new File(""));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("cant find image");
        }

    }
}