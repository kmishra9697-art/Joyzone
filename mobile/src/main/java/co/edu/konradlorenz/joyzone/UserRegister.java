package co.edu.konradlorenz.joyzone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import co.edu.konradlorenz.joyzone.entities.EventEntity;
import co.edu.konradlorenz.joyzone.entities.UserEntity;

public class UserRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        final String userData =  getIntent().getExtras().getString("user");



        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference myRef = database.getReference(userData);




        Button botonadduser = (Button) findViewById(R.id.Create_User);

        botonadduser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final EditText name = (EditText) findViewById(R.id.Name_user);
                final EditText lastname = (EditText) findViewById(R.id.Last_name_user);
                final EditText age = (EditText) findViewById(R.id.age_User);
                final int edad = Integer.parseInt(age.getText().toString());
                final EditText about = (EditText) findViewById(R.id.About_User);
                final ArrayList<EventEntity> eventos = new ArrayList<>();


                UserEntity user = new UserEntity(name.getText().toString(),lastname.getText().toString(),edad,about.getText().toString(),eventos);
                DatabaseReference childRef = myRef.push();

                childRef.setValue(user);

                Intent intento = new Intent(UserRegister.this, MainActivity.class);
                intento.putExtra("user",userData);
                startActivity(intento);
            }
        });
    }
}
