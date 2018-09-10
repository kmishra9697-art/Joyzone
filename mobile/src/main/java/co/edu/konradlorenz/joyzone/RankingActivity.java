package co.edu.konradlorenz.joyzone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);


        ListView mListView = (ListView) findViewById(R.id.ranking_list);
        ArrayList<Event> eventlist = new ArrayList<>();

        Event a = new Event("Rock Al Parque");
        eventlist.add(a);
        Event b = new Event("Jazz Al Parque");
        eventlist.add(b);
        Event c = new Event("HipHop Al Parque");
        eventlist.add(c);

        EventListAdapter adapter = new EventListAdapter(this, R.layout.adapter_event_view_layout, eventlist);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long i){
                if (position == 0){
                    Toast.makeText(RankingActivity.this, "First ...", Toast.LENGTH_SHORT).show();
                }
                if (position == 1){
                    Toast.makeText(RankingActivity.this, "Second ...", Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    Toast.makeText(RankingActivity.this, "Third ...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mListView.setAdapter(adapter);

    }
}
