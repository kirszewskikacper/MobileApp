package edu.zsk.zadanie;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;

public class dialog extends DialogFragment {

    private static final String IMAGE_ARGUMENT_KEY = "img_key";

    public static dialog createInstance(int resourceId) {
        dialog newDialog = new dialog();
        Bundle arguments = new Bundle();
        arguments.putInt(IMAGE_ARGUMENT_KEY, resourceId);
        newDialog.setArguments(arguments);
        return newDialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedState) {
        int imageResourceId = getArguments().getInt(IMAGE_ARGUMENT_KEY);

        ImageView pictureView = new ImageView(requireContext());
        pictureView.setImageResource(imageResourceId);
        pictureView.setAdjustViewBounds(true);

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(requireContext());
        alertBuilder.setView(pictureView);
        
        AlertDialog createdDialog = alertBuilder.create();
        return createdDialog;
    }
}