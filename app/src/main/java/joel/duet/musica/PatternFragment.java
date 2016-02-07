package joel.duet.musica;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.csounds.CsoundObj;

import java.util.LinkedList;

/**
 *
 * Created by joel on 22/01/16 at 23:25 at 14:27.
 */
public final class PatternFragment extends Fragment {
    private PatternView patternview;
    private final LinkedList<String> instrumentIds = new LinkedList<>();
    private static final String TAG = "PatternFragment";

    static public MainActivity activity;
    static public CsoundObj csoundObj;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
        csoundObj = MainActivity.csoundObj;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState) {
        final View view = inflater.inflate(R.layout.pattern_fragment, container, false);


        view.findViewById(R.id.mode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PatternView.edit_mode = !PatternView.edit_mode;
            }
        });

        final ToggleButton loudnessButton = (ToggleButton) view.findViewById(R.id.loudness);
                loudnessButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        PatternView.loudness_mode = isChecked;
                        if (isChecked) loudnessButton.setBackgroundResource(R.drawable.ic_loudness_on);
                        else loudnessButton.setBackgroundResource(R.drawable.ic_loudness_off);
                    }
                });

        for(String instr:CSD.mapInstr.keySet()) instrumentIds.add(instr);

        final ArrayAdapter<String> instruments_adapter =
                new ArrayAdapter<>(getContext(),
                        android.R.layout.simple_spinner_item,
                        instrumentIds);
        final Spinner instrument_spinner = (Spinner)view.findViewById(R.id.instrument);
        instrument_spinner.setAdapter(instruments_adapter);
        instrument_spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        patternview.pattern.setInstr(CSD.mapInstr.keySet().toArray(new String[CSD.getNbInstruments()])[i]);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });

        view.findViewById(R.id.recenter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patternview.pattern.mPosX = 0;
                patternview.pattern.mPosY = Default.initial_pattern_height;
                patternview.invalidate();
            }
        });

        final Spinner resolution_spinner = (Spinner) view.findViewById(R.id.resolution);
        SimpleImageArrayAdapter adapter = new SimpleImageArrayAdapter(getContext(),Default.resolution_icons);
        resolution_spinner.setAdapter(adapter);

        resolution_spinner.setSelection(getArguments().getInt("resolution_index"));

        resolution_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                patternview.pattern.resolution = i;
                patternview.invalidate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        view.findViewById(R.id.preview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String csd = Score.sendPatterns(patternview.pattern.singleton(),
                        patternview.pattern.start,
                        patternview.pattern.finish);
                Log.i(TAG, csd);
                csoundObj.stop();
                csoundObj.startCsound(activity.csoundUtil.createTempFile(csd));
            }
        });

        view.findViewById(R.id.in_context).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String csd = Score.sendPatterns(Score.allPatterns(),
                        patternview.pattern.start,
                        patternview.pattern.finish);
                csoundObj.stop();
                csoundObj.startCsound(activity.csoundUtil.createTempFile(csd));
            }
        });

        view.findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                csoundObj.stop();
            }
        });

        patternview = (PatternView) view.findViewById(R.id.pattern_view);
        PatternView.note_loudness = (ImageView) view.findViewById(R.id.note_loudness);

        PatternView.edit_mode = ((Switch)view.findViewById(R.id.mode)).isChecked();

        int instr_selected = 0;
        String names[] = CSD.mapInstr.keySet().toArray(new String[CSD.getNbInstruments()]);
        String name = getArguments().getString("instr_name");
        while(instr_selected<CSD.getNbInstruments() && !names[instr_selected].equals(name))
            instr_selected ++;
        instrument_spinner.setSelection(instr_selected);

        return view;
    }

}
