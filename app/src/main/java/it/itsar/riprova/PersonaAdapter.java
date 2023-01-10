package it.itsar.riprova;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class PersonaAdapter extends RecyclerView.Adapter<PersonaViewHolder> {
    private final ArrayList<Persone> persone;
    private Persone[] amici;

    private RecyclerClickListener recyclerClickListener;
    private final ActivityResultLauncher<Intent> activityResultLauncher;

    public ArrayList<Persone> getPersone() {
        return persone;
    }

    public PersonaAdapter(ArrayList<Persone> persone, ActivityResultLauncher<Intent> activityResultLauncher) {
        this.persone = persone;
        this.activityResultLauncher = activityResultLauncher;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.persona_layout, parent, false);
        PersonaViewHolder personaViewHolder = new PersonaViewHolder(view);

        personaViewHolder.itemView.findViewById(R.id.chat_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = personaViewHolder.getBindingAdapterPosition();
                if(recyclerClickListener != null) recyclerClickListener.onItemCLicked(position);

                Persone persona = persone.get(position);
                Intent intent = new Intent(view.getContext(), ChatActivity.class);
                intent.putExtra("persona", persona);
                activityResultLauncher.launch(intent);


            }
        });



        personaViewHolder.itemView.findViewById(R.id.friends_option).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = personaViewHolder.getBindingAdapterPosition();
                if(recyclerClickListener != null) recyclerClickListener.onItemCLicked(position);
                Log.d("options: ", String.valueOf(position));
            }
        });

        return personaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        holder.bind(persone.get(position));
    }

    @Override
    public int getItemCount() {
        return persone.size();
    }

}
