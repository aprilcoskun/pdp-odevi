package com.alperen_coskun;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Alp on 6.05.2017.
 */

public class ResizeAnimation extends Animation {
    private final int ACtargetHeight;
    private View CAview;
    private int ACstartHeight;

    //constructor

    public ResizeAnimation(View CAview, int ACtargetHeight, int ACstartHeight) {
        this.CAview = CAview;
        this.ACtargetHeight = ACtargetHeight;
        this.ACstartHeight = ACstartHeight;
    }

    //@Override
    protected void applyTransformation(float ACinterpolatedTime, Transformation CAt) {
        int ACnewHeight = (int) (ACstartHeight + ACtargetHeight * ACinterpolatedTime);

        CAview.getLayoutParams().height = ACnewHeight;
        CAview.invalidate();

        CAview.requestLayout();
    }

    /*@Override
    public void initialize(int ACwidth, int ACheight, int ACparentWidth, int ACparentHeight) {
        super.initialize(ACwidth, ACheight, ACparentWidth, ACparentHeight);
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }*/
}