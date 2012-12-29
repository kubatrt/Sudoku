package pl.example.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu; 
import android.view.MenuInflater; 
import android.view.MenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

public class Sudoku extends Activity implements OnClickListener 
{
	private static final String TAG = "Sudoku";
	
	@Override
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.main);
		
		//Setup click listeners for all the buttons 
		View continueButton=findViewById(R.id.continue_button);
		continueButton.setOnClickListener(this);
	
    	View newButton=findViewById(R.id.newgame_button); 
		newButton.setOnClickListener(this); 
		
		View aboutButton=findViewById(R.id.about_button); 
		aboutButton.setOnClickListener(this); 
		
		View settingsButton=findViewById(R.id.settings_button); 
		settingsButton.setOnClickListener(this);
		
		View exitButton=findViewById(R.id.exit_button); 
		exitButton.setOnClickListener(this);	
	}
	
	public void onClick(View v) { 
		Music.playClick(this);
		switch(v.getId()) { 
		case R.id.about_button: 
			startActivity(new Intent(this,About.class)); 
			break; 
		case R.id.exit_button:
			finish();
			System.exit(0);
			break;
		case R.id.settings_button:
			startActivity(new Intent(this,Prefs.class)); 
			break;
		case R.id.newgame_button:
			openNewGameDialog();
			//startActivity(new Intent(this, Graphics.class));
			break;
		case R.id.continue_button:
			startGame(Game.DIFFICULTY_CONTINUE);
	    //More buttons go here(if any)... 
	  } 
	}
	
	@Override public boolean onCreateOptionsMenu(Menu menu) { 
	  super.onCreateOptionsMenu(menu); 
	  MenuInflater inflater=getMenuInflater(); 
	  inflater.inflate(R.menu.menu,menu); 
	  return true; 
	}
	
	@Override public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch(item.getItemId()) { 
			case R.id.settings: 
				startActivity(new Intent(this,Prefs.class)); 
				return true; 
		  //More items go here(ifany)... 
		} 
	    return false;
	}
	
	private void openNewGameDialog() {
		new AlertDialog.Builder(this).setTitle(R.string.new_game_title).setItems(
			R.array.difficulty, 
			new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialoginterface, int i) { 
					startGame(i); 
				}
			}).show();
	}

	private void startGame(int i) {
		Log.d(TAG, "clicked on " + i);
		Intent intent = new Intent(Sudoku.this, Game.class);
		intent.putExtra(Game.KEY_DIFFICULTY, i);
		startActivity(intent);
	}
	
	@Override 
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
}


