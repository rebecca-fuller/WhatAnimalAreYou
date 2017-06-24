package com.rebeccafuller.whatanimalareyou;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by cding on 6/23/2017.
 */

public class AboutFragmentDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        return new AlertDialog.Builder(getActivity())
                .setTitle("About")
                .setMessage("Coded by Rebecca Fuller in Android Studio 2.3.3")
                .setPositiveButton("OK", null)
                .create();
    }

}
