package unicluster.unip.br.aps8.views;

import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;

import unicluster.unip.br.aps8.R;
import unicluster.unip.br.aps8.list.ListAdapter;
import unicluster.unip.br.aps8.list.SimpleList;
import unicluster.unip.br.aps8.models.Line;
import unicluster.unip.br.aps8.models.Log;
import unicluster.unip.br.aps8.tasks.LogTask;
import unicluster.unip.br.aps8.tasks.StatusTask;
import unicluster.unip.br.aps8.tasks.TaskComplete;

public class LogActivity extends AppCompatActivity implements TaskComplete {

	private int id;
	private ListAdapter listAdapter;
	private ListView logList;
	private LogTask logTask;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		id = (int) (long) bundle.getLong("id");
		setContentView(R.layout.activity_log);

		logList = (ListView) findViewById(R.id.log_list);

		logTask = new LogTask(this, this, id);
		logTask.execute();

	}

	@Override
	public void onTaskCompleted(String result) {
		try {
			JSONArray data = new JSONArray(result);
			for (int i=0; i< data.length(); i ++) {
				JSONObject obj = data.getJSONObject(i);
				Line line = new Line(obj.getJSONObject("line"));

				TextView txtLineNumber = (TextView) findViewById(R.id.txt_line_number);
				txtLineNumber.setText(String.valueOf(line.getNumber()));

				TextView txtLineColor = (TextView) findViewById(R.id.txt_line_color);
				txtLineColor.setText(line.getColor());
				txtLineColor.setTextColor(line.getColorId());

				ArrayList<SimpleList> _list = new ArrayList<>();
				JSONArray logs = obj.getJSONArray("logs");
				for(int k=0;k< logs.length();k ++) {
					JSONObject _obj = logs.getJSONObject(k);
					Log log = new Log(line, _obj.getJSONObject("log"));
					SimpleDateFormat _formatter =  new SimpleDateFormat("dd/MM/yyyy KK:mm a");
					_formatter.setTimeZone(TimeZone.getTimeZone("GMT-5"));
					_list.add(new SimpleList(0, log.getStatus(), _formatter.format(log.getUpdated_at()), line.getColorId()));

					if (k==0) {

						TextView txtLineStatus = (TextView) findViewById(R.id.txt_line_status);
						txtLineStatus.setText(log.getStatus());

						TextView txtDescription = (TextView) findViewById(R.id.txt_description);
						txtDescription.setText(log.getDescription());

						TextView txtLastDate = (TextView) findViewById(R.id.txt_last_date);
						SimpleDateFormat formatter =  new SimpleDateFormat("dd/MM/yyyy");
						formatter.setTimeZone(TimeZone.getTimeZone("GMT-5"));
						txtLastDate.setText(formatter.format(log.getUpdated_at()));

						TextView txtLastHour = (TextView) findViewById(R.id.txt_last_hour);
						formatter =  new SimpleDateFormat("KK:mm a");
						formatter.setTimeZone(TimeZone.getTimeZone("GMT-5"));
						txtLastHour.setText(formatter.format(log.getUpdated_at()));

					}
				}

				listAdapter = new ListAdapter(this.getApplicationContext(), _list);
				logList.setAdapter(listAdapter);

			}
			/*Log log = new Log(line, new JSONObject(result).getJSONObject("log"));

			TextView txtLineNumber = (TextView) findViewById(R.id.txt_line_number);
			txtLineNumber.setText(String.valueOf(line.getNumber()));

			TextView txtLineColor = (TextView) findViewById(R.id.txt_line_color);
			txtLineColor.setText(line.getColor());

			TextView txtLineStatus = (TextView) findViewById(R.id.txt_line_status);
			txtLineStatus.setText(log.getStatus());

			TextView txtDescription = (TextView) findViewById(R.id.txt_description);
			txtDescription.setText(log.getDescription());

			TextView txtLastDate = (TextView) findViewById(R.id.txt_last_date);
			SimpleDateFormat formatter =  new SimpleDateFormat("dd/MM/yyyy");
			formatter.setTimeZone(TimeZone.getTimeZone("GMT-5"));
			txtLastDate.setText(formatter.format(log.getUpdated_at()));

			TextView txtLastHour = (TextView) findViewById(R.id.txt_last_hour);
			formatter =  new SimpleDateFormat("KK:mm a");
			formatter.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo\n"));
			txtLastHour.setText(formatter.format(log.getUpdated_at()));

			ProgressBar progress = (ProgressBar) findViewById(R.id.log_progress);
			progress.setVisibility(View.INVISIBLE);*/
			ProgressBar progress = (ProgressBar) findViewById(R.id.log_progress);
			progress.setVisibility(View.INVISIBLE);


		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
