package entity;

import java.awt.image.BufferedImage;

public class Entity {
    //parent class for characters like monsters and npcs
    public int x,y;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int charCounter = 0;
    public int charNumber = 1;
}
