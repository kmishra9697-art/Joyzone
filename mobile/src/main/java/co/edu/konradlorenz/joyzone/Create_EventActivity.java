package co.edu.konradlorenz.joyzone;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.custom.SimpleCustomValidation;
import com.google.common.collect.Range;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import co.edu.konradlorenz.joyzone.Adapters.EventAdapter;
import co.edu.konradlorenz.joyzone.entities.EventEntity;
import co.edu.konradlorenz.joyzone.entities.UserEntity;

public class Create_EventActivity extends AppCompatActivity {

    AwesomeValidation mAwesomeValidation;

    FloatingActionButton fab;
    String user;
    UserEntity userdata;
    ArrayList<EventEntity> events = new ArrayList<EventEntity>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__event);

        mAwesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);


        user = getIntent().getExtras().getString("user");

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference myRef = database.getReference(user);

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userdata = dataSnapshot.getValue(UserEntity.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        FloatingActionButton boton = (FloatingActionButton) findViewById(R.id.EventAddButton);
        final EditText name = (EditText) findViewById(R.id.Nombre);
        final EditText date = (EditText) findViewById(R.id.Fecha);
        final EditText descripcion = (EditText) findViewById(R.id.descripcion);
        final EditText cantidad = (EditText) findViewById(R.id.Capacidad);

        mAwesomeValidation.addValidation(Create_EventActivity.this, R.id.Nombre, "[a-zA-Z\\s]+", R.string.error_event_name);
        mAwesomeValidation.addValidation(Create_EventActivity.this, R.id.Fecha,new SimpleCustomValidation() {
            @Override
            public boolean compare(String input) {
                // check if the Event Date is upper
                try {
                    Calendar calendarEvent = Calendar.getInstance();
                    Calendar calendarToday = Calendar.getInstance();
                    calendarEvent.setTime(new SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(input));
                    int yearOfToday = calendarToday.get(Calendar.YEAR);
                    int yearOfEvent = calendarEvent.get(Calendar.YEAR);
                        if (yearOfToday >= yearOfEvent ) {
                            return true;
                        }else{
                            return false;
                        }
                } catch(ParseException e) {
                    e.printStackTrace();
                }
                return false;
            }
            },R.string.error_event_date);

        mAwesomeValidation.addValidation(Create_EventActivity.this, R.id.Capacidad, Range.closed(1,1000000), R.string.error_event_capacity);


        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){


                final EventEntity eventadd = new EventEntity(name.getText().toString(),descripcion.getText().toString(),date.getText().toString(),"spot","direccion", cantidad.getText().toString());

                myRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                            if(userdata.getEventos() != null){
                                events = userdata.getEventos();
                            }
                            events.add(eventadd);
                            userdata.setEventos(events);

                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w("TAG:", "Failed to read value.", databaseError.toException());
                    }
                });




                DatabaseReference myRef2 = database.getReference("events");
                DatabaseReference childRef = myRef2.push();

                childRef.setValue(userdata);
                if (mAwesomeValidation.validate()){
                    Intent intento = new Intent(Create_EventActivity.this, MainActivity.class);
                    intento.putExtra("user",user);
                    startActivity(intento);
                }
            }
        });
    }
}
