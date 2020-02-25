package com.swetajain.fragmentapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    private EditText editTextB;
    private FragmentBListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v  = inflater.inflate(R.layout.fragment_two,container,false);

        Button buttonB = v.findViewById(R.id.button_two);

        editTextB = v.findViewById(R.id.edit_text_two);

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editTextB.getText().toString();
                listener.onInputBSent(input);
            }
        });

        return v;
    }

    public interface FragmentBListener{

        void onInputBSent(CharSequence input);
    }


    public void updateEditText(CharSequence text){
        editTextB.setText(text);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentBListener){
            listener = (FragmentBListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + "must implement FragmentBListener");

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
