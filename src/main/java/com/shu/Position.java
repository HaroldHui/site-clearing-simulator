package com.shu;

public class Position {

    private Integer xDimension;
    private Integer yDimension;
    private Facing facing;

    public Position(Integer xDimension, Integer yDimension, Facing facing) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        this.facing = facing;
    }

    public Integer getxDimension() {
        return xDimension;
    }

    public void setxDimension(Integer xDimension) {
        this.xDimension = xDimension;
    }

    public Integer getyDimension() {
        return yDimension;
    }

    public void setyDimension(Integer yDimension) {
        this.yDimension = yDimension;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }
}
