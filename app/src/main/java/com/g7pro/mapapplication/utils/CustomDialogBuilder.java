package com.g7pro.mapapplication.utils;//
//
//package com.g7pro.utils;
//
//import android.app.AlertDialog;
//import android.app.AlertDialog.Builder;
//import android.content.Context;
//import android.content.DialogInterface.OnClickListener;
//import android.graphics.Color;
//import android.graphics.drawable.Drawable;
//import android.text.Html;
//import android.view.View;
//import android.widget.Button;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.g7pro.R;
//
//
//public class CustomDialogBuilder extends Builder{
//
//	/** The custom_body layout */
//	private View mDialogView;
//
//	/** optional dialog title layout */
//	private TextView mTitle;
//	/** optional alert dialog coverImageURL */
//	public ImageView mIcon;
//	/** optional message displayed below title if title exists*/
//	private TextView mMessage;
//	/** The colored holo divider. You can set its color with the setDividerColor method */
//	private View mDivider;
//	private LinearLayout mheader;
//	public Button btn_signup;
//	//private Button mnagativer;
//
//    private TextView txt_terms;
//    public CustomDialogBuilder(final Context context) {
//        super(context);
//
//        mDialogView = View.inflate(context, R.layout.custom_exclusive_dialog_layout, null);
//        setView(mDialogView);
//
//        mTitle = (TextView) mDialogView.findViewById(R.id.alertTitle);
//        mMessage = (TextView) mDialogView.findViewById(R.id.message);
//        mIcon = (ImageView) mDialogView.findViewById(R.id.icon);
//        mDivider = mDialogView.findViewById(R.id.titleDivider);
//        mheader =(LinearLayout) mDialogView.findViewById(R.id.title_template);
//        btn_signup= (Button) mDialogView.findViewById(R.id.btn_signup);
//        txt_terms = (TextView) mDialogView.findViewById(R.id.txt_terms);
//        String text = "<font color=#000>By clicking <b>Sign Up</b> you are agreeing to the</font> <font color=#ffcc00>Terms of use </font><font color=#000>and</font><font color=#ffcc00> Privacy Policy</font>.";
//
//       // String text = "<font color=#000000>By Clicking <b>Sign up</b>, you agreeing to the</font> <font color=#ffcc00>Terms of use </font>  <font color=#000>and</font><font color=#ffcc00> Privacy Policy</font>.";
//        txt_terms.setText(Html.fromHtml(text));
////        CommonActions.clickify(txt_terms, "Terms of use",
////                new ClickSpan.OnClickListener() {
////                    @Override
////                    public void onClick() {
////                        context.startActivity(new Intent(context,
////                                Terms_ConditionsActivity.class));
////                    }
////                });
////        CommonActions.clickify(txt_terms, "Privacy Policy",
////                new ClickSpan.OnClickListener() {
////                    @Override
////                    public void onClick() {
////                        context. startActivity(new Intent(context,
////                                Privacy_PolicyActivity.class));
////                    }
////                });
//
//	}
//
//    /**
//     * Use this method to color the divider between the title and content.
//     * Will not display if no title is set.
//     *
//     * @param colorString for passing "#ffffff"
//     */
//    public CustomDialogBuilder setDividerColor(String colorString) {
//    	mDivider.setBackgroundColor(Color.parseColor(colorString));
//    	return this;
//    }
//    public CustomDialogBuilder setDividerVisibility(int visibility) {
//    	mDivider.setVisibility(visibility);
//    	return this;
//    }
//    @Override
//    public CustomDialogBuilder setTitle(CharSequence text) {
//        mTitle.setText(text);
//        return this;
//    }
//
//
//    public CustomDialogBuilder setButtonTitle(String text) {
//        btn_signup.setText(text);
//        return this;
//    }
//
//
//    public CustomDialogBuilder setTitleColor(int color) {
//    	mTitle.setTextColor(color);
//    	return this;
//    }
//    public CustomDialogBuilder setHeaderColor(int color) {
//    	mheader.setBackgroundColor(color);
//    	return this;
//    }
//
//    @Override
//    public CustomDialogBuilder setMessage(int textResId) {
//        mMessage.setText(textResId);
//        return this;
//    }
//
//    @Override
//    public CustomDialogBuilder setMessage(CharSequence text) {
//        mMessage.setText(text);
//        return this;
//    }
//
//    @Override
//    public CustomDialogBuilder setIcon(int drawableResId) {
//        mIcon.setImageResource(drawableResId);
//        return this;
//    }
//
//    @Override
//    public CustomDialogBuilder setIcon(Drawable icon) {
//        mIcon.setImageDrawable(icon);
//        return this;
//    }
//    @Override
//    public Builder setAdapter(ListAdapter adapter, OnClickListener listener) {
//    	// TODO Auto-generated method stub
//    	ListView lv=new ListView(getContext());
//    	lv.setAdapter(adapter);
//    //	lv.setOnClickListener((android.view.View.OnClickListener) listener);
//    	((FrameLayout)mDialogView.findViewById(R.id.customPanel)).addView(lv);
//    	return this;
//    	//return super.setAdapter(null, listener);
//    }
//
//    /**
//     * This allows you to specify a custom layout for the area below the title divider bar
//     * in the dialog. As an example you can look at example_ip_address_layout.xml and how
//     * I added it in TestDialogActivity.java
//     *
//     * @param resId  of the layout you would like to add
//     * @param context
//     */
//    public CustomDialogBuilder setCustomView(int resId, Context context) {
//    	View customView = View.inflate(context, resId, null);
//    	((FrameLayout)mDialogView.findViewById(R.id.customPanel)).addView(customView);
//    	return this;
//    }
//
//    @Override
//    public AlertDialog show() {
//    	if (mTitle.getText().equals("")) mDialogView.findViewById(R.id.topPanel).setVisibility(View.GONE);
//    	return super.show();
//    }
//
//}
