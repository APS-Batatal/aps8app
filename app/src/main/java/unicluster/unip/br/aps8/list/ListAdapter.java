package unicluster.unip.br.aps8.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;
import unicluster.unip.br.aps8.R;

public class ListAdapter extends BaseAdapter
{
	private Context context;
	private ArrayList<SimpleList> list;
	private ArrayList<SimpleList> original;

	public ListAdapter(Context context, ArrayList<SimpleList> list)
	{
		this.context = context;
		this.list = list;
		this.original = new ArrayList<>();
		original.addAll(list);
	}

	@Override
	public int getCount()
	{
		return list.size();
	}

	@Override
	public Object getItem(int position)
	{
		return list.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return list.get(position).getId();
	}

	public void updateData(ArrayList<SimpleList> list)
	{
		this.list.clear();
		this.list.addAll(list);
		notifyDataSetChanged();
	}

	public void clearList()
	{
		this.list.clear();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		SimpleList list = (SimpleList) getItem(position);
		list.setLayout(R.layout.list_item_single);
		convertView = inflater.inflate(list.getLayout(), parent, false);

		TextView title = (TextView) convertView.findViewById(R.id.itemTitle);
		title.setText(list.getName());

		TextView subtitle = (TextView) convertView.findViewById(R.id.item_subtitle);
		subtitle.setText(list.getSubtitle());

		return convertView;
	}
}