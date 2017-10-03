package ru.strongit.game15;

public interface OnMyEventListener {

    void onMoveDownEvent(Block block);
    void onMoveUpEvent(Block block);
    void onMoveLeftEvent(Block block);
    void onMoveRightEvent(Block block);

}