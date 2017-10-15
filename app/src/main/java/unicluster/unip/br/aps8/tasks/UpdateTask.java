package unicluster.unip.br.aps8.tasks;

import android.content.Context;
import android.os.AsyncTask;

import unicluster.unip.br.aps8.web.Client;

public class UpdateTask extends AsyncTask<Void, Integer, String> {

	private Context context;

	public TaskComplete delegate = null;
	public UpdateTask(Context context) {
		this.context = context;
	}

	@Override
	protected String doInBackground(Void... voids) {
		return new Client().update().toString();
	}

	@Override
	protected void onPostExecute(String result) {
		//super.onPostExecute(result);
		delegate.onTaskCompleted(result);
	}
}
