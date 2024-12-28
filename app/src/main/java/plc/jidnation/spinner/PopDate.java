package plc.jidnation.spinner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class PopDate extends DialogFragment implements View.OnClickListener {

    View myDateView;
    DatePicker datePicker;
    Button dateShower;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container2, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myDateView =  inflater.inflate(R.layout.date_picker,  null);
        datePicker = myDateView.findViewById(R.id.datePicker);
        dateShower = myDateView.findViewById(R.id.saveDateButton);

        dateShower.setOnClickListener(this);
        return  myDateView;
    }

    @Override
    public void onClick(View view) {
        this.dismiss();
        String date = (datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear());
        MainActivity mainActivity = (MainActivity)  getActivity();

        assert mainActivity != null;
        mainActivity.setDate(date);
        Toast.makeText(getContext(), date, Toast.LENGTH_LONG).show();
    }
}
