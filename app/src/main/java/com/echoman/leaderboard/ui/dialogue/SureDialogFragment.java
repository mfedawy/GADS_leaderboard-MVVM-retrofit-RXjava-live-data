package com.echoman.leaderboard.ui.dialogue;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;

import com.echoman.leaderboard.R;

public class SureDialogFragment extends DialogFragment {

    SureDialogueListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (SureDialogueListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getApplication().toString()
                    + " must implement NoticeDialogListener");
        }
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.fragment_sure, null);
        builder.setView(view);

        CardView cardView = view.findViewById(R.id.card_button);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.yesClicked();
                SureDialogFragment.this.getDialog().cancel();
            }
        });
        ImageView imageView = view.findViewById(R.id.image_close);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SureDialogFragment.this.getDialog().cancel();
            }
        });


        return builder.create();


    }

    public interface SureDialogueListener {
        public void yesClicked();


    }
}
