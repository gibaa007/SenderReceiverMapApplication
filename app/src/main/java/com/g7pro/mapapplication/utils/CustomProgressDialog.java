package com.g7pro.mapapplication.utils;////  Created by Gibin  on 26/08/2015.
//
//package com.g7pro.utils;
//
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.view.animation.RotateAnimation;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.g7pro.R;
//
//
//public class CustomProgressDialog extends ProgressDialog {
//
//    ImageView iv_animation;
//    TextView tv_text;
//    private Animation animation;
//    private int[] imageArray;
//    private int currentIndex;
//    private int startIndex;
//    private int endIndex;
////	public static ProgressDialog ctor(Context context) {
////		CustomProgressDialog dialog = new CustomProgressDialog(context);
////
////		/*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
////		     // only for gingerbread and newer versions
////		}*/
////		dialog.setIndeterminate(true);
////		dialog.setCancelable(false);
////		dialog.setCanceledOnTouchOutside(false);
////		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
////
////		return dialog;
////	}
//
//    public CustomProgressDialog(Context context) {
//        //super(context);
//        super(context, R.style.MyProgress);
//    }
//    @Override
//    public void setCancelable(boolean flag) {
//        super.setCancelable(flag);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.view_custom_progress_dialogue);
//        iv_animation = (ImageView) findViewById(R.id.iv_animation);
//        tv_text = (TextView) findViewById(R.id.tv_text);
//        //animate.setBackgroundResource(R.drawable.custom_animation);
//        animation = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        animation.setRepeatCount(Animation.INFINITE);
//        animation.setDuration(500);
//        setCancelable(false);
//        setCanceledOnTouchOutside(false);
//        imageArray = new int[5];
//        imageArray[0] = R.drawable.eden_leaf;
//        imageArray[1] = R.drawable.eden_leaf;
//        imageArray[2] = R.drawable.eden_leaf;
//        imageArray[3] = R.drawable.eden_leaf;
//        imageArray[4] = R.drawable.eden_leaf;
//        startIndex = 0;
//        endIndex = 4;
//        nextImage();
//    }
//
//
//    public void nextImage(){
//        iv_animation.setImageResource(imageArray[currentIndex]);
//        Animation rotateimage = AnimationUtils.loadAnimation(getContext(), R.anim.custom_anim);
//        iv_animation.startAnimation(rotateimage);
//        currentIndex++;
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if(currentIndex>endIndex){
//                    currentIndex--;
//                    previousImage();
//                }else{
//                    nextImage();
//                }
//
//            }
//        },1000); // here 1000(1 second) interval to change from current  to next image
//
//    }
//    public void previousImage(){
//        iv_animation.setImageResource(imageArray[currentIndex]);
//        Animation rotateimage = AnimationUtils.loadAnimation(getContext(), R.anim.custom_anim);
//        iv_animation.startAnimation(rotateimage);
//        currentIndex--;
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if(currentIndex<startIndex){
//                    currentIndex++;
//                    nextImage();
//                }else{
//                    previousImage(); // here 1000(1 second) interval to change from current  to previous image
//                }
//            }
//        },1000);
//
//    }
//    public void show(String text) {
//        super.show();
//        if (!text.isEmpty()) {
//            tv_text.setText(text);
//        }
//
////		iv_animation.setImageResource(R.drawable.loader);
//        iv_animation.startAnimation(animation);
//    }
//
//    public void showSuccess(String text) {
//        animation.cancel();
//        dismiss();
//        //iv_animation.getAnimation().cancel();
//        //	tv_text.setText(text);
//        //iv_animation.setImageResource(R.drawable.ic_tick);
//        // 3 seconds delay
//        /*new Handler().postDelayed(new Runnable() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//			dismiss();
//			}
//		}, 1000);*/
//
//    }
//
//    @Override
//    public void dismiss() {
//        super.dismiss();
//    }
//}
