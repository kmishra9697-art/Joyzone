package co.edu.konradlorenz.joyzone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.edu.konradlorenz.joyzone.ui.principal.PrincipalFragment;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PrincipalFragment.newInstance())
                    .commitNow();
        }
    }
}
