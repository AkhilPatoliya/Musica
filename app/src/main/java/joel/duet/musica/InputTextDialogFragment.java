package joel.duet.musica;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public final class InputTextDialogFragment extends DialogFragment implements
		OnEditorActionListener {

	public interface EditNameDialogListener {
		void onFinishEditDialog(String inputText);
	}

	private EditText mEditText;
    private String state;

    public InputTextDialogFragment() {
        // Empty constructor required for DialogFragment
    }


    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.input_text_dialog, container);
		mEditText = (EditText) view.findViewById(R.id.edit_name_box);
		getDialog().setTitle("Name it");
		// Show soft keyboard automatically
		mEditText.requestFocus();
		mEditText.setOnEditorActionListener(this);

        state = getArguments().getString("state");
		view.findViewById(R.id.done_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // When button is clicked, call up to owning activity.
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            	FragmentPlus caller = (FragmentPlus)fragmentManager.findFragmentByTag(state);
			    caller.onFinishEditDialog(mEditText.getText().toString());
			    getDialog().dismiss();
            }
        });
        return view;
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		if (EditorInfo.IME_ACTION_DONE == actionId) {
			// Return input text to activity
			FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentPlus caller = (FragmentPlus)fragmentManager.findFragmentByTag(state);
			caller.onFinishEditDialog(mEditText.getText().toString());
			this.dismiss();
			return true;
		}
		return false;
	}
}