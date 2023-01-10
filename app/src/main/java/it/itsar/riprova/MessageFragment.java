package it.itsar.riprova;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Locale;


public class MessageFragment extends Fragment{

    private ArrayList<Persone> persone = new ArrayList<Persone>();


    private ArrayList<Persone> filter = new ArrayList<Persone>();
    RecyclerView recyclerView;
    private PersonaAdapter personaAdapter;
    private TextView lastMessage;

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                switch (result.getResultCode()){
                    case Activity.RESULT_OK:
                        Intent itn = result.getData();
                        String resultString =itn.getStringExtra("messaggio");
                        Log.d("messaggio", resultString);
                        break;

                    case Activity.RESULT_CANCELED:
                        Log.d("errore", "errore");
                        break;
                }

            });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addPersone();

        EditText searchFriends = view.findViewById(R.id.searchFriends);
        lastMessage = view.findViewById(R.id.last_message);

        recyclerView = view.findViewById(R.id.recycler_view_persona);
        personaAdapter = new PersonaAdapter(persone, activityResultLauncher);
        recyclerView.setAdapter(personaAdapter);

        searchFriends.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().isEmpty()){
                    personaAdapter = new PersonaAdapter(persone, activityResultLauncher);
                    recyclerView.setAdapter(personaAdapter);
                    personaAdapter.notifyDataSetChanged();
                }
                else{
                    Filter(charSequence.toString());
                    personaAdapter = new PersonaAdapter(filter, activityResultLauncher);
                    recyclerView.setAdapter(personaAdapter);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });



    }

    private void Filter(String text) {
        String splitted[] = text.split("");
        for(Persone persona: persone){
            for (int j = 0; j< splitted.length; j++){
                if(persona.getNomeCognome().toLowerCase(Locale.ROOT).contains(splitted[j].toLowerCase(Locale.ROOT))){
                    filter.add(persona);
                }
            }
        }
    }

    private void addPersone(){
        persone.add(new Persone("Austin", "austin", R.drawable.austin));
        persone.add(new Persone("Jimmy", "jimmy", R.drawable.jimmy));
        persone.add(new Persone("Joseph", "joseph", R.drawable.joseph));
        persone.add(new Persone("Stefan", "stefan", R.drawable.stefan));
        persone.add(new Persone("Albert", "albert", R.drawable.albert));
        persone.add(new Persone("Austin", "austin", R.drawable.austin));
        persone.add(new Persone("Jimmy", "jimmy", R.drawable.jimmy));
        persone.add(new Persone("Joseph", "joseph", R.drawable.joseph));
        persone.add(new Persone("Stefan", "stefan", R.drawable.stefan));
        persone.add(new Persone("Albert", "albert", R.drawable.albert));

    }

}
