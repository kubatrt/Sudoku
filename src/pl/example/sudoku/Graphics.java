package pl.example.sudoku;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.graphics.*;
import android.graphics.Path.Direction;

// Example graphics class, doesnt work
public class Graphics extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new GraphicsView(this));
	}
	
	// defined inside
	static public class GraphicsView extends View {
	
		private Path 	circle;
		private Paint 	cPaint;
		private Paint 	tPaint;
		private static final String QUOTE = "Be or not to be, this is a question.";
		
		public GraphicsView(Context context) {
			super(context);
			circle = new Path();
			cPaint = new Paint();
			tPaint = new Paint();
			circle.addCircle(150, 150, 100, Direction.CW);
			cPaint.setColor(Color.BLUE);
			tPaint.setColor(Color.RED);
			setBackgroundResource(R.drawable.background);
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			// drawing
			canvas.drawPath(circle, cPaint);
			canvas.drawTextOnPath(QUOTE, circle, 0, 20, tPaint);
		}
	}
}
