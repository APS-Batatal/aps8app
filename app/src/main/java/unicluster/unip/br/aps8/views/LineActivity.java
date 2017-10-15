package unicluster.unip.br.aps8.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import unicluster.unip.br.aps8.R;
import unicluster.unip.br.aps8.list.ListAdapter;
import unicluster.unip.br.aps8.list.SimpleList;
import unicluster.unip.br.aps8.tasks.StatusTask;
import unicluster.unip.br.aps8.tasks.TaskComplete;

public class LineActivity extends AppCompatActivity implements TaskComplete {

	private ListView lineList;
	private ListAdapter listAdapter;
	private StatusTask statusTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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

				JSONObject line = obj.getJSONObject("line");
				JSONObject log = obj.getJSONObject("log");

				_list.add(new SimpleList(line.getInt("number"),line.getString("name"), log.getString("status")));
			}
			listAdapter = new ListAdapter(this.getApplicationContext(), _list);
			lineList.setAdapter(listAdapter);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
