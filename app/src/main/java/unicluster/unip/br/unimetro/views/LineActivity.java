package unicluster.unip.br.unimetro.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import unicluster.unip.br.unimetro.R;
import unicluster.unip.br.unimetro.list.ListAdapter;
import unicluster.unip.br.unimetro.list.SimpleList;
import unicluster.unip.br.unimetro.models.Line;
import unicluster.unip.br.unimetro.models.Log;
import unicluster.unip.br.unimetro.tasks.StatusTask;
import unicluster.unip.br.unimetro.tasks.TaskComplete;

public class LineActivity extends AppCompatActivity implements TaskComplete {

	private ListView lineList;
	private ListAdapter listAdapter;
	private StatusTask statusTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_line);

		lineList = (ListView) findViewById(R.id.line_list);

		statusTask = new StatusTask(this, this);
		statusTask.execute();

	}

	@Override
	public void onTaskCompleted(String result) {

		ArrayList<SimpleList> _list = new ArrayList<>();

		try {
			JSONArray data = new JSONArray(result);
			for (int i=0; i< data.length(); i ++) {
				JSONObject obj = data.getJSONObject(i);

				Line line = new Line(obj.getJSONObject("line"));
				Log log = new Log(line, obj.getJSONObject("log"));

				_list.add(new SimpleList(line.getNumber(),line.getName(), log.getStatus(), line.getColorId()));
			}
			listAdapter = new ListAdapter(this.getApplicationContext(), _list);
			lineList.setAdapter(listAdapter);
			lineList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
					Intent intent = new Intent();
					Bundle bundle = new Bundle();
					bundle.putLong("id", id);
					intent.putExtras(bundle);
					intent.setClass(LineActivity.this, LogActivity.class);
					startActivity(intent);
				}
			});

			ProgressBar progress = (ProgressBar) findViewById(R.id.line_progress);
			progress.setVisibility(View.INVISIBLE);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
