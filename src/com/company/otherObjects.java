package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.*;
import java.util.Random;

import static java.lang.Math.abs;

public class otherObjects {
    public BufferedImage image1,image2,image3;
    int Xtimes= Main.osx / 50;
    int Ytimes= Main.osy / 50;
    Integer randomX=0,randomY=0,radiuscon=30;

    otherObjects(){
        initiate();
    }

    public boolean xyTreasure(int x,int y) {
        if((abs(x-randomX*50)<radiuscon)&&(abs(y-randomY*50)<radiuscon)){
            randomX = (int) (Math.random() * 10000) % Xtimes;
            //System.out.println(randomX);
            randomY = (int) (Math.random() * 10000) % Ytimes;
            //System.out.println(randomY);
            return true;
        }
        return false;
    }

    public boolean pers_canmoovie(int x, int y,int dx,int dy){
        boolean retur=false;
        if( (x+dx>=0) && (x+dx<=50*(Xtimes)) )
            if( (y+dy>=0) && (y+dy<50*(Ytimes)) ) {
                retur=true;
                return retur;
            }
        return retur;
    }

    public void paint(Graphics g){
        for (int i=0;i<=Xtimes;i++){
            for (int j=0;j<=Ytimes;j++){
                g.drawImage(image1,50*i,50*j,null);
            }
        }
        g.drawImage(image2,50*randomX,50*randomY,null);
    }

    void initiate(){
        try {
            image3 = ImageIO.read(new File("wolf.png"));
            image1 = ImageIO.read(new File("metal.png"));
            image2 = ImageIO.read(new File("clad.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("cant find image");
        }

    }
}