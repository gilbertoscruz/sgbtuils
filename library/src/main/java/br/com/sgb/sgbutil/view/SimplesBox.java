/**
 * @project: MeusGastos
 * @user: Gilberto Sanches Cruz
 * @date: 05/09/2012
 * @hour: 21:57:42
 */
package br.com.sgb.sgbutil.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author egilcru
 * 
 */
public class SimplesBox extends TextView {

	private float scale = getContext().getResources().getDisplayMetrics().density;
	private Paint paint;

	/**
	 * @param context
	 * @param attrs
	 */
	public SimplesBox(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFocusable(true);
		init();
	}

	private void init() {
		paint = new Paint();
		paint.setColor(Color.BLUE);
		paint.setStrokeWidth(1);
		paint.setStyle(Paint.Style.STROKE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		paint.setAntiAlias(true);
		paint.setColor(getCurrentTextColor());
		paint.setStyle(Paint.Style.FILL);
		paint.setStrokeWidth(4.5f);
		canvas.drawRect(02, 02, getWidth() - getPaddingRight() - 1.0F
				* this.scale - 2, getHeight() - getPaddingBottom() - 2.0F
				* this.scale - 2, paint);
	}

}
