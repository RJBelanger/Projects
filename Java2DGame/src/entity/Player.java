package entity;

import main.GameConsole;
import main.KeyHandler;


import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GameConsole gp;
    KeyHandler keyH;

    public Player(GameConsole gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    //gets called 60 times per secound
    public void update() {

        if(keyH.upPress == true || keyH.downPress == true || keyH.leftPress == true || keyH.rightPress == true){

            if(keyH.upPress == true){
                direction = "up";
                y -= speed;
            }
            else if(keyH.downPress == true){
                direction = "down";
                y += speed;
            }
            else if(keyH.leftPress == true){
                direction = "left";
                x -= speed;
            }
            else if(keyH.rightPress == true){
                direction = "right";
                x += speed;
            }
            //player image changes between the first and second image every 12 frames
            charCounter++;
            if(charCounter > 12) {
                if(charNumber == 1){
                    charNumber = 2;
                }
                else if(charNumber == 2) {
                    charNumber = 1;
                }
                charCounter = 0;
            }

        }



    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        switch (direction){
            case "up":
                if(charNumber == 1) {
                    image = up1;
                }
                if(charNumber == 2){
                    image = up2;
                }
                break;
            case "down":
                if(charNumber == 1) {
                    image = down1;
                }
                if(charNumber == 2){
                    image = down2;
                }
                break;
            case "left":
                if(charNumber == 1) {
                    image = left1;
                }
                if(charNumber == 2){
                    image = left2;
                }
                break;
            case "right":
                if(charNumber == 1) {
                    image = right1;
                }
                if(charNumber == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }
}
