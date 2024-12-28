package plc.jidnation.spinner;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> spinnerItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spinner = findViewById(R.id.spinnerBox);

         spinnerItems = new ArrayList<>();
         spinnerItems.add("Home");
         spinnerItems.add("Department");
         spinnerItems.add("Nations");
         spinnerItems.add("Country");
         spinnerItems.add("Mission");


        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, spinnerItems);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "The Item selected is " + spinnerItems.get(position), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }
        public void setTime(String time) {
            Toast.makeText(this, "Selected Time: " + time, Toast.LENGTH_SHORT).show();
//            PopTime dialog = new PopTime();
//            dialog.show(getSupportFragmentManager(), "Time Picker");
        }

    public void openPicker(View view) {
//        fra fragmentManager  = getSupportFragmentManager();
        PopTime dialog = new PopTime();
        dialog.show( getSupportFragmentManager(), "Show fragment");
    }

    ///Date Picker
    public void openDateDialog(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag("DateFragment") == null) {
            PopDate dateDialog = new PopDate();
            dateDialog.show(fragmentManager, "DateFragment");
        }
    }

    public void setDate(String date) {
    }

    public void openAlertDialog(View view) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setMessage("We are just getting started, we will be there in no time.")
                .setTitle("Word of Motivation")
                .setPositiveButton("Noted", (dialog, which) -> {
                }).setNegativeButton("Ok", (dialog, which) -> {

                })
                .show();
    }
}
