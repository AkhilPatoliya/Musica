package joel.duet.musica;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import joel.duet.musica.databinding.PatchbayFragmentBinding;

/**
 *
 * Created by joel on 19/01/16 at 11:38 at 12:30 at 13:57 at 08:00.
 */
public final class PatchBayFragment extends Fragment {
    private static GridView grid;
    //private static final String TAG = "Patchbay";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState) {
        PatchbayFragmentBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.patchbay_fragment, container, false);
        grid = binding.gridView;

        grid.setNumColumns(CSD.effects.size() + 2);

        /*
        ViewGroup.LayoutParams layoutParams = grid.getLayoutParams();
        layoutParams.width = (int)((grid.getNumColumns() * 20.0f)*(float)getResources().getDisplayMetrics().densityDpi/ DisplayMetrics.DENSITY_DEFAULT);
        grid.setLayoutParams(layoutParams);
        */

        grid.setAdapter(new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, Matrix.cells) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final View view = super.getView(position, convertView, parent);

                int n = CSD.effects.size() + 2;
                int j = position % n;
                int i = (position - j) / n;

                int color = 0x00FFFFFF; // Transparent
                if (j == 0) {
                    if (i < CSD.instruments.size()) color = Default.instrument_color;
                    else if (i < CSD.instruments.size() + CSD.effects.size()) color = Default.effect_color;
                } else if (i == CSD.instruments.size() + CSD.effects.size() && j > 0) {
                    if (j <= CSD.effects.size()) color = Default.effect_color;
                    else color = Default.master_color;
                }

                view.setBackgroundColor(color);
                ((TextView) view).setTextSize(grid.getColumnWidth() / 4.5f);
                ((TextView) view).setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

                return view;
            }
        });

       grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                int n = CSD.effects.size() + 2;
                int j = position % n;
                int i = (position - j) / n;
                if (Matrix.get(i, j)) Matrix.getInstance().unset(i, j);
                else Matrix.getInstance().set(i, j);
                //Log.i(TAG,Matrix.serialize());
                grid.invalidateViews();
            }
        });

        return binding.getRoot();
    }
}
