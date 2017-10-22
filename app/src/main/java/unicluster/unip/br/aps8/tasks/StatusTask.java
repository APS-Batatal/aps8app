package unicluster.unip.br.aps8.tasks;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import unicluster.unip.br.aps8.web.Client;

public class StatusTask extends AsyncTask<Void, Integer, String> {

	private Context context;

	private TaskComplete delegate;

	private Client client;

	private int line = -1;

	public StatusTask(Context context, TaskComplete delegate) {
		this.context = context;
		this.delegate = delegate;
		this.client = new Client();
	}

	public StatusTask(Context context, TaskComplete delegate, int line) {
		this.context = context;
		this.delegate = delegate;
		this.line = line;
		this.client = new Client();
	}


	@Override
	protected String doInBackground(Void... voids) {
		if (this.line != -1) {
			return  client.status(this.line);
		} else {
			return client.status();
		}
	}

	@Override
	protected void onPostExecute(String result) {
		//super.onPostExecute(result);
		delegate.onTaskCompleted(result);
	}
}
