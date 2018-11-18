package co.edu.konradlorenz.joyzone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import co.edu.konradlorenz.joyzone.entities.EventEntity;
import co.edu.konradlorenz.joyzone.entities.UserEntity;

public class UserRegister extends AppCompatActivity {

    AwesomeValidation mAwesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        mAwesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        mAwesomeValidation.addValidation(UserRegister.this, R.id.Name_user, "[a-ZA-Z]\\s+", R.string.error_name);
        mAwesomeValidation.addValidation(UserRegister.this, R.id.Last_name_user, "[a-ZA-Z]\\s+", R.string.error_lastname);
        mAwesomeValidation.addValidation(UserRegister.this, R.id.age_User, Range.closed(1,100), R.string.error_age);

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
