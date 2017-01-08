package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.company.myContent.persX;

public class window extends JFrame {
private myContent content=new myContent();

    window(int width,int height) {
        this.setTitle("Hi");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(50, 50, 50+width, 50+height);
        this.setVisible(true);
        this.addKeyListener(new MyKey());
        this.getContentPane().add(content);
    }


    private class MyKey implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

            if(e.getKeyCode()==87){

                move(20,0);//up!
            }
            if(e.getKeyCode()==65)move(20,0);//left!
            if(e.getKeyCode()==83)move(20,0);//down!
            if(e.getKeyCode()==68)move(20,0);//right!

        }


        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode()==27)System.exit(0);

        }

    }

}



