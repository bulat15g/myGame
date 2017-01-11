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
    int Xtimes= Main.osx / 50;
    int Ytimes= Main.osy / 50;

    otherObjects(){
        initiate();


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
    }

    void initiate(){
        try {
            image1 = ImageIO.read(new File("metal.png"));
            image2 = ImageIO.read(new File("clad.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("cant find image");
        }

    }
}