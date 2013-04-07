package com.app;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.AdapterView.OnItemClickListener;
/**
 * activity
 * @author Administrator
 *
 */

public class GalleryMain extends Activity implements OnItemClickListener
{
	private ViewScroll detail;
	private ImageAdapter ia;
	private LinearLayout ll;
	private LinearLayout.LayoutParams parm;
	private Gallery g;	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		g = (Gallery) findViewById(R.id.myggg);
		ll = (LinearLayout) findViewById(R.id.twill);
		parm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
		ia = new ImageAdapter(this);
		detail = new ViewScroll(GalleryMain.this, ia.imgIds[0],g);	
		ll.addView(detail,parm);
		g.setAdapter(ia);
		g.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
	{
		ll.removeView(detail);
		detail = new ViewScroll(GalleryMain.this, ia.imgIds[arg2],g);	
		ll.addView(detail,parm);
	}
}
