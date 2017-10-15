package unicluster.unip.br.aps8.list;

import unicluster.unip.br.aps8.R;

public class SimpleList implements ListItem
{
	private int id;
	private String name;
	private String friendlyName;
	private Boolean divider = false;
	private String listIdentifier;
	private int layout = R.layout.list_item_single;
	private Boolean firstPosition = false;
	private String url;
	
	public SimpleList(int id, String name)
	{
		this.id = id;
		this.name = name;
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

	public Boolean getDivider()
	{
		return divider;
	}

	public void setDivider(Boolean divider)
	{
		this.divider = divider;
	}

	public String getListIdentifier()
	{
		return listIdentifier;
	}

	public void setListIdentifier(String listIdentifier)
	{
		this.listIdentifier = listIdentifier;
	}

	public void setLayout(int layout) {	this.layout = layout; }

	public int getLayout()	{ return layout; }

	public Boolean getFirstPosition() {	return firstPosition; }

	public void setFirstPosition(Boolean firstPosition) { this.firstPosition = firstPosition;	}

	public String getFriendlyName()
	{
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName)
	{
		this.friendlyName = friendlyName;
	}

	public String getUrl()	{ return url; 	}

	public void setUrl(String url)	{	this.url = url; }
}
