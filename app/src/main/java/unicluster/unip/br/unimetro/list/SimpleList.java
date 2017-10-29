package unicluster.unip.br.unimetro.list;

import unicluster.unip.br.unimetro.R;

public class SimpleList implements ListItem
{
	private int id;
	private String name;
	private String subtitle;
	private int color;

	private int layout = R.layout.list_item_single;
	
	public SimpleList(int id, String name, String subtitle)
	{
		this.id = id;
		this.name = name;
		this.subtitle = subtitle;
	}
	public SimpleList(int id, String name, String subtitle, int color)
	{
		this.id = id;
		this.name = name;
		this.subtitle = subtitle;
		this.color = color;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getColor() { return color; }

	public void setColor(int color) { this.color = color; }

	public void setLayout(int layout) {	this.layout = layout; }

	public int getLayout()	{ return layout; }
}
