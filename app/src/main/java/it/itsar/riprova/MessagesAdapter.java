package it.itsar.riprova;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesViewHolder> {

    private final ArrayList<Messages> messaggi;

    public MessagesAdapter(ArrayList<Messages> messaggi) {
        this.messaggi = messaggi;
    }

    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_layout, parent, false);
        return new MessagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder holder, int position) {
        holder.bind(messaggi.get(position));
    }

    @Override
    public int getItemCount() {
        return messaggi.size();
    }
}
