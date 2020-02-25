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

public class FragmentOne extends Fragment {

    private EditText editTextA;
    private FragmentAListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one,container,false);


        Button buttonA = v.findViewById(R.id.button_one);

        editTextA = v.findViewById(R.id.edit_text_one);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          CharSequence input = editTextA.getText().toString();
                listener.onInputASent(input);
            }
        });

        return v;
    }

    public interface FragmentAListener{
        void onInputASent(CharSequence input);
    }


  public void updateEditText(CharSequence text){
          editTextA.setText(text);

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentAListener){
            listener = (FragmentAListener) context;
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
