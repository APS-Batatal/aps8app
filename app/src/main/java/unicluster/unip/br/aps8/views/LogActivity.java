package unicluster.unip.br.aps8.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import unicluster.unip.br.aps8.R;

public class LogActivity extends AppCompatActivity {

	private int id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		id = (int) (long) bundle.getLong("id");
		setContentView(R.layout.activity_log);
		// TextView label = (TextView) findViewById(R.id.logBox);
		// label.setText(Integer.toString(id));
	}
}
