package unicluster.unip.br.aps8.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.sql.Date;

import unicluster.unip.br.aps8.utils.Utils;

public class Log {

	private Line line;
	private String status;
	private String description;
	private Date updated_at;

	public Log(Line line, JSONObject data) throws JSONException {
		this.line = line;
		this.status = data.getString("status");
		this.description = data.getString("description");
		this.updated_at = Utils.parseDate(data.getString("updated_at"));
	}
	public Log(Line line, String status, String description, Date updated_at) {
		this.line = line;
		this.status = status;
		this.description = description;
		this.updated_at = updated_at;
	}

	public Line getLine() { return line; }

	public void setLine(Line line) {
		this.line = line;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
}
