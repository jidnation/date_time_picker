package plc.jidnation.spinner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class PopTime extends DialogFragment implements  View.OnClickListener {

    View myView;
    TimePicker myTimePicker;
    Button buttonTimeSelector;
    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.pop_time, container,  false);

        myTimePicker = myView.findViewById(R.id.timePicker);
        buttonTimeSelector = myView.findViewById(R.id.timeButton);
        buttonTimeSelector.setOnClickListener(this);
        return myView;

    }

    @Override
    public void onClick(View v) {
        this.dismiss();
        String time = myTimePicker.getHour() + ":" + myTimePicker.getMinute();
        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.setTime(time);
        Toast.makeText(getContext(), time, Toast.LENGTH_SHORT).show();
    }
}
