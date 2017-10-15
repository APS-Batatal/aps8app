package unicluster.unip.br.aps8.list;

import unicluster.unip.br.aps8.R;

public class SimpleList implements ListItem
{
	private int id;
	private String name;
	private String subtitle;
	private int layout = R.layout.list_item_single;
	
	public SimpleList(int id, String name, String subtitle)
	{
		this.id = id;
		this.name = name;
		this.subtitle = subtitle;
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

	public void setLayout(int layout) {	this.layout = layout; }

	public int getLayout()	{ return layout; }

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

}
