package unicluster.unip.br.aps8.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import unicluster.unip.br.aps8.R;
import unicluster.unip.br.aps8.tasks.TaskComplete;
import unicluster.unip.br.aps8.tasks.UpdateTask;

public class SplashActivity extends AppCompatActivity implements TaskComplete {

	private UpdateTask updateTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_splash);


		updateTask = new UpdateTask(this, this);
		updateTask.execute();
	}

	@Override
	public void onTaskCompleted(String result) {
		Intent intent = new Intent();
		intent.setClass(SplashActivity.this, LineActivity.class);
		startActivity(intent);
	}
}
