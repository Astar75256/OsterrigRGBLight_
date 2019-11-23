package com.astar.rgblighting.screen.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.astar.rgblighting.R;

public class AddGroupDialog extends DialogFragment {

    private EditText nameGroup;

    private OnClickActionButton onClickActionButton;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.add_group_dialog_layout, null, false);
        nameGroup = view.findViewById(R.id.nameGroup);

        return new AlertDialog.Builder(getContext())
                .setView(view)
                .setNegativeButton("Отмена", (dialog, which) -> {
                    if (onClickActionButton != null) onClickActionButton.onClickSave(getGroupName());
                })
                .setPositiveButton("Сохранить", (dialog, which) -> {
                    if (onClickActionButton != null) onClickActionButton.onClickCancel();
                })
                .setCancelable(false)
                .create();
    }

    private String getGroupName() {
        return nameGroup.getText().toString();
    }

    public void setOnClickActionButton(OnClickActionButton onClickActionButton) {
        this.onClickActionButton = onClickActionButton;
    }

    public interface OnClickActionButton {
        void onClickSave(String text);
        void onClickCancel();
    }
}

