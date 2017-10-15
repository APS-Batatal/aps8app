package unicluster.unip.br.aps8.web;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import unicluster.unip.br.aps8.constants.Api;

public class Client {
	public JSONObject update() {
		try {
			URL url = new URL(Api.UPDATE);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.connect();

			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuilder sb = new StringBuilder();

			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();

			String jsonString = sb.toString();

			return new JSONObject(jsonString);
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String status;
	public String log;
}
