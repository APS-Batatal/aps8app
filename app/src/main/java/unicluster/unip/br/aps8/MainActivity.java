package unicluster.unip.br.aps8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import unicluster.unip.br.aps8.list.ListAdapter;
import unicluster.unip.br.aps8.list.SimpleList;
import unicluster.unip.br.aps8.tasks.TaskComplete;
import unicluster.unip.br.aps8.tasks.UpdateTask;
import unicluster.unip.br.aps8.views.LogActivity;

public class MainActivity extends AppCompatActivity implements TaskComplete {

	// VARIABLES
	private ArrayAdapter <String> adapter; // Array Adapter for list virw
	private ListView listLine; // Layout List View

	private UpdateTask asyncTask;
	// On Application start
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // Call super create
		setContentView(R.layout.activity_main); // Set active layout




		asyncTask = new UpdateTask(this); // Update the api by running the update task
		asyncTask.delegate = this;
		asyncTask.execute();

		listLine = (ListView) findViewById(R.id.line_List);

	}

	@Override
	public void onTaskCompleted(String result) {
		ArrayList<SimpleList> _list = new ArrayList<>();
		for (int i = 0; i< 10; i++){
			_list.add(new SimpleList(i,"Digo"));
		}
		ListAdapter _listAdapter = new ListAdapter(this.getApplicationContext(), _list);
		listLine = (ListView) findViewById(R.id.line_List);
		listLine.setAdapter(_listAdapter);
		listLine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putLong("id", id);
				intent.putExtras(bundle);
				intent.setClass(MainActivity.this, LogActivity.class);
				startActivity(intent);
			}
		});
	}
}
