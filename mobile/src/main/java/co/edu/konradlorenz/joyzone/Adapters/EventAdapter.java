package co.edu.konradlorenz.joyzone.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.edu.konradlorenz.joyzone.R;
import co.edu.konradlorenz.joyzone.entities.EventEntity;

public class EventAdapter extends ArrayAdapter<EventEntity> {
    public EventAdapter(@NonNull Context context, int resource, @NonNull List<EventEntity> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_item_container,parent);
        }

        EventEntity event = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.Image_event);
        TextView name = (TextView) convertView.findViewById(R.id.Title_event);
        TextView date = (TextView) convertView.findViewById(R.id.Date_event);
        TextView direccion = (TextView) convertView.findViewById(R.id.Place_event);
        Button gotoButton = (Button) convertView.findViewById(R.id.Go_event);

        name.setText(event.getName());
        date.setText(event.getDate().toString());
        direccion.setText(event.getdireccion());

        return convertView;
    }
}
