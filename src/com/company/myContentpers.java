package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class myContentpers extends JPanel{
    public Timer timerDraw,timerUpdate;
    private BufferedImage image1;
    private otherObjects myotherObjects=new otherObjects();
    public static Integer persX=300,persY=300;

    public myContentpers(){
        initiate();




    }

    public void mymove(int x,int y){
        if(myotherObjects.pers_canmoovie(persX,persY,x,y)) {
            persX += x;
            persY += y;
        }

        if(timerUpdate!=null) {
            if (timerUpdate.isRunning()) timerUpdate.stop();
        }
        timerUpdate = new Timer(1, new ActionListener(){
            public void actionPerformed(ActionEvent e ) {

            }
        });
        timerUpdate.start();
    }

    private void xyTreasure(){

    }


    public void paint(Graphics g){

        g.clearRect(0,0,getWidth(),getHeight());
        myotherObjects.paint(g);
        g.drawImage(image1,persX,persY,null);

    }

    public void initiate(){
        try {
            image1 = ImageIO.read(new File("pers.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("cant find image");
        }
        timerDraw=new Timer(10, new ActionListener(){
            public void actionPerformed(ActionEvent e ) {
                repaint();
            }
        });
        timerDraw.start();
    }

}
