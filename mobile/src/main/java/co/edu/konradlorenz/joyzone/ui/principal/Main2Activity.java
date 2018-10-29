package co.edu.konradlorenz.joyzone.ui.principal;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.edu.konradlorenz.joyzone.R;

public class Main2Activity extends AppCompatActivity implements
        TestFragment.OnFragmentInteractionListener,
        TestFragment2.OnFragmentInteractionListener,
        TestFragment3.OnFragmentInteractionListener{

    TestFragment testFragment;
    TestFragment2 testFragment2;
    TestFragment3 testFragment3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        testFragment = new TestFragment();
        testFragment2 = new TestFragment2();
        testFragment3 = new TestFragment3();

        getSupportFragmentManager().beginTransaction().add(R.id.frag_container, testFragment).commit();



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view) {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.frag1:
                transaction.replace(R.id.frag_container, testFragment);
                break;
            case R.id.frag2:
                transaction.replace(R.id.frag_container, testFragment2);
                break;
            case R.id.frag3:
                transaction.replace(R.id.frag_container, testFragment3);
                break;

        }

        transaction.commit();
    }
}
