package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List_Activity extends AppCompatActivity {

    // 1.1 initial variable
    ListView listView;
    // 1.2 string data array list
    String[] list_name = {"List of Activities: ","Sign Up","Login","Grid View","Dialog","Home Navigation",
            "To be linked: ","Forgot Password","Splash Screen","List View",
            "List of Fruits:","Apple","Banana","Coconut","Dragon fruit","Eggfruit",
            "Farkleberry","Grapes","Honeydew melon","Indonesian lime","Jackfruit",
            "Kiwi","Lime (Lemon)","Mango","Navel Orange","Oranges","Papaya"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);

        // 1.3 assign id to variable
        listView = findViewById(R.id.lv_list);

        // adapter collects data and display them
        // 1.4 string adapter and default list view layout, list data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_name);
        // 1.5 applying the adapter to listView
        listView.setAdapter(adapter);

        // 1.6 perform action when clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){
                    Intent intent=new Intent(getApplicationContext(),SignUp_Activity.class);
                    startActivity(intent);
                }
                if(i==2){
                    Intent intent=new Intent(getApplicationContext(),Login_Activity.class);
                    startActivity(intent);
                }
                if(i==3){
                    Intent intent=new Intent(getApplicationContext(),GridView_Activity.class);
                    startActivity(intent);
                }
                if(i==4){
                    Intent intent=new Intent(getApplicationContext(),Dialog_Activity.class);
                    startActivity(intent);
                }
                if(i==5){
                    Intent intent=new Intent(getApplicationContext(),Home_Activity.class);
                    startActivity(intent);
                }

            }
        });

    }
}