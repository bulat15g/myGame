package com.company;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import com.sun.xml.internal.fastinfoset.util.CharArrayString;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class myContentpers extends JPanel{
    public Timer timerDraw,timerUpdate;
    private BufferedImage image1;
    private otherObjects myotherObjects=new otherObjects();
    public static Integer persX=300,persY=300;
    public Double money=0.0;
    public String messageattop;

    /**
     * инициализация таймеров и координат клада
     */
    public myContentpers(){
        initiate();
        myotherObjects.xyTreasure(persX,persY);
    }

    /**
     * движение через проверку возможности движения а так же обработка денег
     * @param x перемещение по х
     * @param y по у
     */
    public void mymove(int x,int y){
        if(myotherObjects.pers_canmoovie(persX,persY,x,y)) {
            persX += x;
            persY += y;
            if(myotherObjects.xyTreasure(persX,persY)){
//                System.out.println(money);
                if(money==0.0)money++;
                else{
                    money*=1.1;
                };
            }

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

    //ну рисование
    public void paint(Graphics g){
        g.clearRect(0,0,getWidth(),getHeight());
        myotherObjects.paint(g);
        g.drawImage(image1,persX,persY,null);
        g.setColor(Color.RED);
            messageattop="money:="+money+"                 ";
            g.drawChars(messageattop.toCharArray(),0,10,20,20);
        g.setColor(Color.BLACK);
    }

    public void initiate(){
        messageattop="money:="+money+"                 ";

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
