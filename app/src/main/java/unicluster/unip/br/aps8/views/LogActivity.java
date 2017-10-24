package unicluster.unip.br.aps8.views;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import unicluster.unip.br.aps8.R;
import unicluster.unip.br.aps8.list.ListAdapter;
import unicluster.unip.br.aps8.models.Line;
import unicluster.unip.br.aps8.models.Log;
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
		try {
			Line line = new Line(new JSONObject(result).getJSONObject("line"));
			Log log = new Log(line, new JSONObject(result).getJSONObject("log"));

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
			formatter.setTimeZone(TimeZone.getTimeZone("GMT-5"));
			txtLastHour.setText(formatter.format(log.getUpdated_at()));

			ProgressBar progress = (ProgressBar) findViewById(R.id.log_progress);
			progress.setVisibility(View.INVISIBLE);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
