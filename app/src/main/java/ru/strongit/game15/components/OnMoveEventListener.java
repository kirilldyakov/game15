package ru.strongit.game15.components;

public interface OnMoveEventListener {

    void onMoveDownEvent(Block block);

    void onMoveUpEvent(Block block);

    void onMoveLeftEvent(Block block);

    void onMoveRightEvent(Block block);

}