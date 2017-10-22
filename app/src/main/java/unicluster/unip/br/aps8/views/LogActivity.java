package unicluster.unip.br.aps8.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import unicluster.unip.br.aps8.R;
import unicluster.unip.br.aps8.list.ListAdapter;
import unicluster.unip.br.aps8.tasks.StatusTask;
import unicluster.unip.br.aps8.tasks.TaskComplete;

public class LogActivity extends AppCompatActivity implements TaskComplete {

	private int id;
	private ListAdapter listAdapter;
	private StatusTask statusTask;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		id = (int) (long) bundle.getLong("id");
		setContentView(R.layout.activity_log);

		statusTask = new StatusTask(this, this, id);
		statusTask.execute();

	}

	@Override
	public void onTaskCompleted(String result) {

	}
}
