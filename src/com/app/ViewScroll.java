package com.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ImageView.ScaleType;

/**
 *  
 * @author Administrator
 *
 */
@SuppressWarnings("deprecation")
public class ViewScroll extends AbsoluteLayout
{
	private int screenW;	 
	private int screenH;	 
	private int imgW;		 
	private int imgH;		 
	private TouchView tv;

	public ViewScroll(Context context,int resId,View topView)
	{
		super(context);
		screenW = ((Activity)context).getWindowManager().getDefaultDisplay().getWidth();
		screenH = ((Activity)context).getWindowManager().getDefaultDisplay().getHeight()-(topView==null?190:topView.getBottom()+50);
		tv = new TouchView(context,screenW,screenH);
        tv.setImageResource(resId);
        Bitmap img = BitmapFactory.decodeResource(context.getResources(), resId);
        imgW = img.getWidth();
        imgH = img.getHeight();
        int layout_w = imgW>screenW?screenW:imgW; 
        int layout_h = imgH>screenH?screenH:imgH;  
        if(layout_w==screenW||layout_h==screenH)
        	tv.setScaleType(ScaleType.FIT_XY);
        tv.setLayoutParams(new AbsoluteLayout.LayoutParams(layout_w,layout_h , layout_w==screenW?0:(screenW-layout_w)/2, layout_h==screenH?0:(screenH-layout_h)/2));
        this.addView(tv);
	}

	
}
