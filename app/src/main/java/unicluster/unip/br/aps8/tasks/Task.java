package unicluster.unip.br.aps8.tasks;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONObject;



public abstract class Task extends AsyncTask<String, Integer, JSONObject>{
	private Context context;
	public TaskComplete delegate = null;

	public Task(Context context) {
		this.context = context;
	}

	protected void onPostExecute(String result) {
		delegate.onTaskCompleted(result);
	}
}
