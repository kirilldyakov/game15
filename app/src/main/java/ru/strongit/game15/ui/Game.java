package ru.strongit.game15.ui;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import ru.strongit.game15.R;

import static ru.strongit.game15.Game15App.getAppContext;

/**
 * Created by user on 03.10.17.
 */

public class Game extends FrameLayout {
    Context mContext = getAppContext();
    int lastCol = 4; //0,1,2,3
    int lastRow = 4;

    float dX, dY;

    OnTouchListener otListener;

    public Block block_1 = new Block(getAppContext(), 1);
    Block block_2 = new Block(mContext, 2);
    public Block block_3 = new Block(mContext, 3);
    Block block_4 = new Block(mContext, 4);
    Block block_5 = new Block(mContext, 5);
    Block block_6 = new Block(mContext, 6);
    public Block block_7 = new Block(mContext, 7);
    public Block block_8 = new Block(mContext, 8);
    Block block_9 = new Block(mContext, 9);
    Block block_10 = new Block(mContext, 10);
    Block block_11 = new Block(mContext, 11);
    public Block block_12 = new Block(mContext, 12);
    Block block_13 = new Block(mContext, 13);
    Block block_14 = new Block(mContext, 14);
    Block block_15 = new Block(mContext, 15);
    Block block_0 = new Block(mContext, 0);


    Block[][] field =
            {{block_1, block_2, block_3, block_4}
                    , {block_5, block_6, block_7, block_8}
                    , {block_9, block_10, block_11, block_12}
                    , {block_13, block_14, block_15, block_0}};

    OnMyEventListener listener;

    public Game(Context context) {
        super(context);
        initializeViews(context);
        this.mContext = context;

    }

    public Game(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
        this.mContext = context;

    }

    public Game(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeViews(context);
        this.mContext = context;

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.field_view, this);
    }

    public void init() {
        listener = new OnMyEventListener() {
            @Override
            public void onMoveDownEvent(Block block) {
                moveDown(getBlockRow(block), getBlockCol(block));
            }

            @Override
            public void onMoveUpEvent(Block block) {
                moveUp(getBlockRow(block), getBlockCol(block));
            }

            @Override
            public void onMoveLeftEvent(Block block) {
                moveLeft(getBlockRow(block), getBlockCol(block));
            }

            @Override
            public void onMoveRightEvent(Block block) {
                moveRight(getBlockRow(block), getBlockCol(block));
            }


        };

        block_1.setOnEventListener(listener);
        block_2.setOnEventListener(listener);
        block_3.setOnEventListener(listener);
        block_4.setOnEventListener(listener);
        block_5.setOnEventListener(listener);
        block_6.setOnEventListener(listener);
        block_7.setOnEventListener(listener);
        block_8.setOnEventListener(listener);
        block_9.setOnEventListener(listener);
        block_10.setOnEventListener(listener);
        block_11.setOnEventListener(listener);
        block_12.setOnEventListener(listener);
        block_13.setOnEventListener(listener);
        block_14.setOnEventListener(listener);
        block_15.setOnEventListener(listener);


        otListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                float x, y;
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        dX = view.getX();//- event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        x = dX;
                        y = event.getRawY() + dY;
                        view.animate()
                                //.x(event.getRawX() + dX)
                                .x(x)
                                .y(y)
                                .setDuration(0)
                                .start();
                        break;
                    case MotionEvent.ACTION_UP:
                        x = view.getX();
                        y = view.getY();
                        if (view.getY() > 250)
                            y = 400;
                        else
                            y = 50;
                        view.animate()
                                //.x(event.getRawX() + dX)
                                .x(x)
                                .y(y)
                                .setDuration(300)
                                .start();
                        break;
                    default:
                        return false;
                }
                return true;
            }

        };



        Game game = (Game)this;
        game.addView(block_1,200,200);
        block_1.setOnTouchListener(otListener);
    }

    int getBlockRow(Block block) {
        for (int i = 0; i < lastRow; i++) {
            for (int j = 0; j < lastCol; j++) {
                if (field[i][j] == block) return i;
            }

        }
        return 9;
    }

    int getBlockCol(Block block) {
        for (int i = 0; i < lastRow; i++) {
            for (int j = 0; j < lastCol; j++) {
                if (field[i][j] == block) return j;
            }

        }
        return 9;
    }

    Block get(int row, int col) {

        if (!valid(row, col)) return null;

        return field[row][col];
    }

    void set(int row, int col, Block value) {
        if (valid(row, col))
            field[row][col] = value;
    }

    private boolean valid(int x, int y) {
        if (x < 0)
            return false;

        if (x > field.length)
            return false;

        if (y < 0)
            return false;


        if (y > field[0].length)
            return false;

        return true;

    }

    boolean isMoveRightAble(int row, int col) {
        if (col < lastCol - 1)
            if (get(row, col + 1) == block_0)
                return true;
        return false;
    }

    boolean isMoveLeftAble(int row, int col) {
        if (col > 0)
            if (get(row, col - 1) == block_0)
                return true;
        return false;
    }

    boolean isMoveDownAble(int row, int col) {
        if (row < lastRow - 1)
            if (get(row + 1, col) == block_0)
                return true;
        return false;
    }

    boolean isMoveUpAble(int row, int col) {
        if (row > 0)
            if (get(row - 1, col) == block_0)
                return true;
        return false;
    }

    void moveRight(int row, int col) {
        if (isMoveRightAble(row, col)) {
            Block block = get(row, col);
            set(row, col + 1, block);
            block.setRow(row);
            block.setCol(col + 1);

            set(row, col, block_0);
        }
    }

    void moveLeft(int row, int col) {
        if (isMoveLeftAble(row, col)) {
            Block block = get(row, col);
            set(row, col - 1, block);
            block.setRow(row);
            block.setCol(col - 1);
            set(row, col, block_0);
        }
    }

    public void moveDown(int row, int col) {
        if (isMoveDownAble(row, col)) {
            Block block = get(row, col);
            set(row + 1, col, block);
            block.setRow(row + 1);
            block.setCol(col);
            set(row, col, block_0);
        }
    }

    void moveUp(int row, int col) {
        if (isMoveUpAble(row, col)) {
            Block block = get(row, col);
            set(row - 1, col, block);
            block.setRow(row - 1);
            block.setCol(col);
            set(row, col, block_0);
        }
    }

    void renewAbels(Block block) {
        block.setDownMoveAble(isMoveDownAble(block.getRow(), block.getCol()));
        block.setUpMoveAble(isMoveUpAble(block.getRow(), block.getCol()));
        block.setLeftMoveAble(isMoveLeftAble(block.getRow(), block.getCol()));
        block.setRightMoveAble(isMoveRightAble(block.getRow(), block.getCol()));
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < lastRow; i++) {
            for (int j = 0; j < lastCol; j++) {
                res = res + this.get(i, j).toString() + "|";
            }
            res = res + "\n";
        }
        return res;
    }
}
