package ru.strongit.game15;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by user on 03.10.17.
 */

public class Block extends LinearLayout{

    private static OnMyEventListener onEventListener;

    public void setOnEventListener(OnMyEventListener listener) {

        onEventListener = listener;

    }

    private int Number;

    private int Row;
    private int Col;

    private boolean DownMoveAble = false;

    private boolean UpMoveAble = false;

    private boolean RightMoveAble = false;

    private boolean LeftMoveAble = false;

    public Block(Context context, int number) {
        super(context);
        Number = number;
    }

    public Block(Context context, int number, int row, int col) {
        super(context);

        Number = number;
        Row = row;
        Col = col;
    }

    public int getNumber() {
        return Number;
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        Row = row;
    }

    public int getCol() {
        return Col;
    }

    public void setCol(int col) {
        Col = col;
    }

    public String toString(){
        String number = String.valueOf(getNumber());
        if (number.length()==1) number=" "+number;
        return number;
    }

    public void moveDown(){
        if (onEventListener != null)
            onEventListener.onMoveDownEvent(this);
    }

    public void moveUp(){
        if (onEventListener != null)
            onEventListener.onMoveUpEvent(this);
    }

    public void moveRight(){
        if (onEventListener != null)
            onEventListener.onMoveRightEvent(this);
    }

    public void moveLeft(){
        if (onEventListener != null)
            onEventListener.onMoveLeftEvent(this);
    }

    public boolean isDownMoveAble() {
        return DownMoveAble;
    }

    public boolean isUpMoveAble() {
        return UpMoveAble;
    }

    public boolean isRightMoveAble() {
        return RightMoveAble;
    }

    public boolean isLeftMoveAble() {
        return LeftMoveAble;
    }

    public void setDownMoveAble(boolean downMoveAble) {
        DownMoveAble = downMoveAble;
    }

    public void setUpMoveAble(boolean upMoveAble) {
        UpMoveAble = upMoveAble;
    }

    public void setRightMoveAble(boolean rightMoveAble) {
        RightMoveAble = rightMoveAble;
    }

    public void setLeftMoveAble(boolean leftMoveAble) {
        LeftMoveAble = leftMoveAble;
    }
}
