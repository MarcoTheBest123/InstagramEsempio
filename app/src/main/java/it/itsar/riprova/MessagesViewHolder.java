package it.itsar.riprova;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MessagesViewHolder extends RecyclerView.ViewHolder {

    TextView messaggio;
    TextView orario;

    public MessagesViewHolder(@NonNull View itemView) {
        super(itemView);
        messaggio = itemView.findViewById(R.id.messaggio);
        orario = itemView.findViewById(R.id.orario_messaggio);
    }

    public void bind(Messages messages){
        messaggio.setText(messages.getMessaggio());
        orario.setText(String.valueOf(messages.getLocalDateTime()));
    }
}
