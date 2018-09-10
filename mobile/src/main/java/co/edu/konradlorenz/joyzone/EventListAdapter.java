package co.edu.konradlorenz.joyzone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventListAdapter extends ArrayAdapter<Event> {

    private Context mContext;
    private int mResource;

    public EventListAdapter(@NonNull Context context, int resource, ArrayList<Event> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();

        Event event = new Event(name);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView  = inflater.inflate(mResource,parent,false);

        TextView eName = (TextView) convertView.findViewById(R.id.eventlist);

        eName.setText(name);

        return convertView;
    }



}
