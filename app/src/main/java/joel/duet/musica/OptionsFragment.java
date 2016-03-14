package joel.duet.musica;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import joel.duet.musica.databinding.OptionsFragmentBinding;

/**
 *
 * Created by joel on 16/02/16 at 15:46 at 16:06 at 23:28.
 */
public final class OptionsFragment extends Fragment {

    public static boolean isMajor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState) {

        OptionsFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.options_fragment, container, false);

        EditText options_tempo = binding.optionsTempo;
        options_tempo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{

                    Float tempo = Float.parseFloat(editable.toString());
                            CSD.tempo_ratio = tempo / 60.0;
                }catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
            }
        });

        binding.tonalMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMajor=!isMajor;
            }
        });

        String format = getResources().getString(R.string.floating_point_format);
        options_tempo.setText(String.format(format,CSD.tempo_ratio * 60));
        isMajor=false;


        return binding.getRoot();
    }
}
