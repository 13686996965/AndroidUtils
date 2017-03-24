package com.hds.androidutils.utils;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

/**
 * 常用单位转换的辅助类
 * @author zfgx
 *
 */
public class DensityUtils
{
	private DensityUtils()
	{
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	/**
	 * dp转px
	 * 
	 * @param context
	 * @return
	 */
	public static int dp2px(Context context, float dpVal)
	{
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				dpVal, context.getResources().getDisplayMetrics());
	}

	/**
	 * sp转px
	 * 
	 * @param context
	 * @return
	 */
	public static int sp2px(Context context, float spVal)
	{
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
				spVal, context.getResources().getDisplayMetrics());
	}

	/**
	 * px转dp
	 * 
	 * @param context
	 * @param pxVal
	 * @return
	 */
	public static float px2dp(Context context, float pxVal)
	{
		final float scale = context.getResources().getDisplayMetrics().density;
		return (pxVal / scale);
	}

	/**
	 * px转sp
	 * 
	 * @param pxVal
	 * @return
	 */
	public static float px2sp(Context context, float pxVal)
	{
		return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
	}


	/** 屏幕宽度 */
	public static int screenWidth(Context context){
		DisplayMetrics dm = getDisplayMetrics(context);
		int width = dm.widthPixels;// 屏幕宽度（像素）
//		int height= dm.heightPixels; // 屏幕高度（像素）
		float density = dm.density;//屏幕密度（0.75 / 1.0 / 1.5）
//		int densityDpi = dm.densityDpi;//屏幕密度dpi（120 / 160 / 240）
		//屏幕宽度算法:屏幕宽度（像素）/屏幕密度
		return  (int) (width/density);//屏幕宽度(dp)
	}

	/** 屏幕宽度 */
	public static int screenHeight(Context context){
		DisplayMetrics dm = getDisplayMetrics(context);
		int width = dm.widthPixels;// 屏幕宽度（像素）
		int height= dm.heightPixels; // 屏幕高度（像素）
		float density = dm.density;//屏幕密度（0.75 / 1.0 / 1.5）
		//屏幕宽度算法:屏幕宽度（像素）/屏幕密度
//		return  (int) (width/density);//屏幕宽度(dp)
		return  (int)(height/density);//屏幕高度(dp)
	}

	/** 屏幕宽度 */
	public static int densityDpi(Context context){
		DisplayMetrics dm = getDisplayMetrics(context);
//		int width = dm.widthPixels;// 屏幕宽度（像素）
//		int height= dm.heightPixels; // 屏幕高度（像素）
//		float density = dm.density;//屏幕密度（0.75 / 1.0 / 1.5）
		return dm.densityDpi;//屏幕密度dpi（120 / 160 / 240）
		//屏幕宽度算法:屏幕宽度（像素）/屏幕密度
//		return  (int) (width/density);//屏幕宽度(dp)
//		return  (int)(height/density);//屏幕高度(dp)
	}

	@NonNull
	private static DisplayMetrics getDisplayMetrics(Context context) {
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(dm);
		return dm;
	}


}
