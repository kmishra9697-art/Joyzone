package co.edu.konradlorenz.joyzone.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import co.edu.konradlorenz.joyzone.R;
import co.edu.konradlorenz.joyzone.entities.UserEntity;

public class UserAdapter extends ArrayAdapter<UserEntity> {

    public UserAdapter(@NonNull Context context, int resource, @NonNull List<UserEntity> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_profile,parent);
        }

        UserEntity user = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.Profile_image);
        TextView name = (TextView) convertView.findViewById(R.id.Name_user);
        TextView puntuacion = (TextView) convertView.findViewById(R.id.Punctuation_user);
        RatingBar stars = (RatingBar) convertView.findViewById(R.id.ratingBar);
        Button gotoButton = (Button) convertView.findViewById(R.id.Go_event);

        name.setText(user.getFirstName());

        return convertView;
    }

}
