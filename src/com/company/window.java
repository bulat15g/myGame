package com.company;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class window extends JFrame {
private myContentpers content=new myContentpers();
    public static Integer buffer;
    window(int width,int height) {
        this.setTitle("Hi");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(50, 50, 50+width, 50+height);
        this.setVisible(true);
        this.setResizable(false);
        this.addKeyListener(new MyKey());
        this.getContentPane().add(content);
    }


    private class MyKey implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

            if(e.getKeyCode()==87)content.mymove(0,-20);
            if(e.getKeyCode()==65)content.mymove(-20,0);
            if(e.getKeyCode()==83)content.mymove(0,20);
            if(e.getKeyCode()==68)content.mymove(20,0);
            System.out.println(buffer+"____buffer+keypressed"+e.getKeyCode());

            if(buffer!=null&&buffer!=e.getExtendedKeyCode()){
                System.out.println("double key pressed");
                if(e.getKeyCode()==87)content.mymove(0,-20);
                if(e.getKeyCode()==65)content.mymove(-20,0);
                if(e.getKeyCode()==83)content.mymove(0,20);
                if(e.getKeyCode()==68)content.mymove(20,0);
                //THIS NOT WORKING
            }

            /**
             *
             68____buffer+keypressed87
             double key pressed
             87____buffer+keypressed87
             */
            if(buffer==null)buffer=e.getExtendedKeyCode();



        }


        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode()==27)System.exit(0);

            if(buffer!=null&&e.getKeyCode()==buffer) {
                buffer = null;
                System.out.println(e.getKeyCode());
            }
        }

    }

}



