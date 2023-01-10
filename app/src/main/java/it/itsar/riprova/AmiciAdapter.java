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


public class AmiciAdapter extends RecyclerView.Adapter<AmiciViewHolder> {
    private final ArrayList<Persone> persone;
    private Persone[] amici;

    private RecyclerClickListener recyclerClickListener;

    public ArrayList<Persone> getPersone() {
        return persone;
    }

    public AmiciAdapter(ArrayList<Persone> persone) {
        this.persone = persone;
    }

    @NonNull
    @Override
    public AmiciViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_image, parent, false);
        AmiciViewHolder amiciViewHolder = new AmiciViewHolder(view);

        return amiciViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AmiciViewHolder holder, int position) {
        holder.bind(persone.get(position));
    }

    @Override
    public int getItemCount() {
        return persone.size();
    }

}
