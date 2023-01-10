package it.itsar.riprova;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonaViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private ImageView icon;

    public PersonaViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.person_name);
        icon = itemView.findViewById(R.id.person_image);
    }

    public void bind(Persone persone) {
        name.setText(persone.getNomeCognome());
        icon.setImageResource(persone.getIcona());
    }
}
