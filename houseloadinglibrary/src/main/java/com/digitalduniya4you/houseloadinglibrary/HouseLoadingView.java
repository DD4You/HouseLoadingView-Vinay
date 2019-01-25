package com.digitalduniya4you.houseloadinglibrary;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;


import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


public class HouseLoadingView extends DialogFragment
{
    public HouseLoadingView() {
    }
    Animation operatingAnim;

    Dialog mDialog;

    View circle;
    View house;

    String text;

    private boolean isClickCancelAble = true;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (mDialog == null) {
            mDialog = new Dialog(getActivity(), R.style.cart_dialog);
            mDialog.setContentView(R.layout.houseloading_main);
            mDialog.setCanceledOnTouchOutside(isClickCancelAble);
            mDialog.getWindow().setGravity(Gravity.CENTER);

            operatingAnim = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            operatingAnim.setRepeatCount(Animation.INFINITE);
            operatingAnim.setDuration(2500);

            LinearInterpolator lin = new LinearInterpolator();
            operatingAnim.setInterpolator(lin);


            View view = mDialog.getWindow().getDecorView();

            circle = view.findViewById(R.id.dd4you);
            house = view.findViewById(R.id.house);

            YoYo.with(Techniques.Bounce)
                    .duration(700)
                    .repeat(YoYo.INFINITE)
                    .playOn(house);

            operatingAnim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
        return mDialog;
    }

    @Override
    public void onResume() {
        super.onResume();
        circle.setAnimation(operatingAnim);
    }

    @Override
    public void onPause() {
        super.onPause();

        operatingAnim.reset();

        circle.clearAnimation();
    }

    public void setText(String str) {
        text = str;
    }

    public void setClickCancelAble(boolean bo){
        isClickCancelAble = bo;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        mDialog = null;
        System.gc();
    }
}
