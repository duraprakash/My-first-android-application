package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Dialog_Activity extends AppCompatActivity {

    // 1.6 initial variable
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        // 1.7 assign id to variable
        textView=(TextView) findViewById(R.id.dummy_txt);
    }

    // 1.1 showing dialog output in dialog activity
    public void btn_show(View view) {
        // location to be showed
        final AlertDialog.Builder alert = new AlertDialog.Builder(Dialog_Activity.this);
        // location from where it is showed
        View mView = getLayoutInflater().inflate(R.layout.activity_dialog_output,null);

        // 1.2 assign id to variable directly
        final EditText txt_inputText= (EditText) mView.findViewById(R.id.txt_input);
        Button btn_cancel = (Button) mView.findViewById(R.id.btn_cancel);
        Button btn_ok =(Button) mView.findViewById(R.id.btn_ok);

        // 1.3 show dialog when clicked
        alert.setView(mView);

        // 1.4 create alert box and disable closing alert box when clicked on outside
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        
        // 1.5 perform action when clicked on
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();

            }
        });

        // 1.8 perform action when clicked
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get text from dialog and show in text
                textView.setText(txt_inputText.getText().toString().trim());
                alertDialog.dismiss();
            }
        });

        // 1.9 show alert box
        alertDialog.show();
    }
}