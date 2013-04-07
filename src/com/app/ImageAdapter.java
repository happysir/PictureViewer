package com.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
/**
 * 
 * @author Administrator
 *
 */
public class ImageAdapter extends BaseAdapter
{
	 
	public int[] imgIds = {R.drawable.jpg,R.drawable.pic};
	
	private Context context;
	
	public ImageAdapter(Context context)
	{
		this.context = context;		
	}
	
	@Override
	public int getCount()
	{
		return imgIds.length;
	}

	@Override
	public Object getItem(int position)
	{
		return null;
	}

	@Override
	public long getItemId(int position)
	{
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ImageView img = new ImageViewImp(context);
		img.setImageResource(imgIds[position]);
		img.setScaleType(ScaleType.CENTER);
		img.setLayoutParams(new Gallery.LayoutParams(155,150));
		return img;
	}

}
