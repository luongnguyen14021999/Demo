package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends framework1.GameScreen {
    int a = 0;
    int b = 1;
    int c = 2;
    int d = c;
    BufferedImage red;
    BufferedImage green;
    Circle circle;
    Circle circle0;
    public Main() {
        super(600, 600);

        try {
            red = ImageIO.read(new File("red.png"));
            green = ImageIO.read(new File("green.png"));

        } catch (IOException e) {
        }
        circle = new Circle(275, 0, 50, 50);
        circle0 = new Circle(0, 285, 30, 30);
        BeginGame();
    }

    public void resetGame() {
        circle.setPos(275, 550);
        circle.setVt(0);
        circle0.setPos(570, 285);
        circle0.setVt(0);
    }

    @Override
    public void GAME_UPDATE(long time) {
        if(d == b) {
            circle.updateY(time);
            circle0.updateX(time);
        }
            if (circle.getPosY() + circle.getH() >= 600 || circle0.getPosX() + circle0.getW() >= 600)
            {
                resetGame();
                if(d == a)
                {
                    circle = new Circle(275, 0, 50, 50);
                    circle0 = new Circle(0, 285, 30, 30);
                }
            }



    }

    @Override
    public void GAME_PAINT(Graphics2D g2)
    {
        g2.setColor(Color.cyan);
        g2.fillRect(0, 0, 275, 285);
        g2.setColor(Color.cyan);
        g2.fillRect(325, 0, 275, 285);
        g2.setColor(Color.cyan);
        g2.fillRect(0, 315, 275, 285);
        g2.setColor(Color.cyan);
        g2.fillRect(325, 315, 275, 285);
        g2.drawImage(red, (int) circle.getPosX(), (int) circle.getPosY(), null);
        g2.drawImage(green, (int) circle0.getPosX(), (int) circle0.getPosY(), null);

    }

    @Override
    public void KEY_ACTION(KeyEvent e, int Event) {
        if (Event == KEY_PRESSED) {
           if(d == c)
           {
               d = b;
           } else if(d == b)
           {
               d = a;
           } else if(d == a)
           {
               d = b;
           }
        }
    }
    public static void main (String[]args){
        Main main = new Main();
    }
}
