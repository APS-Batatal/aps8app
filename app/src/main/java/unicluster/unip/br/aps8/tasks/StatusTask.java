package unicluster.unip.br.aps8.tasks;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import unicluster.unip.br.aps8.web.Client;

public class StatusTask extends AsyncTask<Void, Integer, String> {

	private Context context;

	private TaskComplete delegate;

	public StatusTask(Context context, TaskComplete delegate) {
		this.context = context;
		this.delegate = delegate;
	}

	@Override
	protected String doInBackground(Void... voids) {
		return new Client().status();
	}

	@Override
	protected void onPostExecute(String result) {
		//super.onPostExecute(result);
		delegate.onTaskCompleted(result);
	}
}
