package it.itsar.riprova;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder {

    TextView nome;
    ImageView image;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.post_person_name);
        image = itemView.findViewById(R.id.post_image);
    }

    public void bind(Post post){
        nome.setText(post.getNome());
        image.setImageResource(post.getImmagine());
    }
}
