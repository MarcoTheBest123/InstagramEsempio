package it.itsar.riprova;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AmiciViewHolder extends RecyclerView.ViewHolder {

    ImageView image;

    public AmiciViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.person_image_post);
    }

    public void bind(Persone persone){
        image.setImageResource(persone.getIcona());
    }
}
