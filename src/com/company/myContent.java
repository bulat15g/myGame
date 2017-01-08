package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class myContent extends JPanel{
    public Timer timerDraw,timerUpdate;
    private BufferedImage image1;
    public static Integer persX=0,persY=0;

    public myContent(){

        initiate();

        timerDraw=new Timer(1, new ActionListener(){
            public void actionPerformed(ActionEvent e ) {
                repaint();
            }
        });
        timerDraw.start();

        timerUpdate = new Timer(800, new ActionListener(){
            public void actionPerformed(ActionEvent e ) {

                move(20,20);

            }
        });
        timerUpdate.start();
    }

    public void move(int x,int y){
        persX+=x;
        persY+=y;
    }




    public void paint(Graphics g){

        g.clearRect(0,0,getWidth(),getHeight());
        g.fillOval(100,100,50,40);


        g.drawImage(image1,300+persX,300+persY,null);





    }

    public void initiate(){
        try {
            image1 = ImageIO.read(new File("pers.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("cant find image");
        }
    }

}
