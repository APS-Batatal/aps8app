package unicluster.unip.br.unimetro.tasks;

import android.content.Context;
import android.os.AsyncTask;

import unicluster.unip.br.unimetro.web.Client;

public class UpdateTask extends AsyncTask<Void, Integer, String> {

	private Context context;

	private TaskComplete delegate;

	public UpdateTask(Context context, TaskComplete delegate) {
		this.context = context;
		this.delegate = delegate;
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
