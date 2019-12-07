package com.company;



public class Circle extends framework1.Objects {

    private float vt = 0;
    public Circle (int x, int y, int w, int h)
    {
        super(x,y,w,h);
    }
    public void updateY(long time)
    {
       vt += 0.01;
       this.setPosY(this.getPosY() + vt);
    }
    public void updateX(long time)
    {
        vt += 0.01;
        this.setPosX(this.getPosX() + vt);
    }
    public void setVt(int n)
    {
        this.vt = n;
    }


}
