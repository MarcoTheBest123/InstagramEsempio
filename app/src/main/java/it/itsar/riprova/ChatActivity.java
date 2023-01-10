package it.itsar.riprova;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private Persone persona;
    private ArrayList<Messages> messaggi = new ArrayList<Messages>();

    TextView nomeAmico;
    ImageView immagineAmico;
    RecyclerView recyclerView;
    private MessagesAdapter messagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        View view = getWindow().getDecorView().findViewById(android.R.id.content);

        persona =(Persone) getIntent().getSerializableExtra("persona");
        Log.d("persona", String.valueOf(persona.getNome()));


        addMessages();
        sortMessages();

        nomeAmico = (TextView) view.findViewById(R.id.chat_person_name);
        immagineAmico = (ImageView) view.findViewById(R.id.chat_person_image);

        nomeAmico.setText(String.valueOf(persona.getNomeCognome()));
        immagineAmico.setImageResource(persona.getIcona());

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_messages);
        messagesAdapter = new MessagesAdapter(messaggi);
        recyclerView.setAdapter(messagesAdapter);

        Log.d("ora", String.valueOf(messaggi.get(0).getLocalDateTime()));
        Log.d("messaggi", String.valueOf(messaggi.get(0).getMessaggio()));
    }

    private void addMessages() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            messaggi.add(new Messages("ciaooooooooooooooo", LocalDate.of(2020, Month.JANUARY, 18).atStartOfDay(), String.valueOf(persona.getNome())));
            messaggi.add(new Messages("aaaaaaaaaaaaaaaaaaa", LocalDate.of(2021, Month.APRIL, 2).atTime(16,20), String.valueOf(persona.getNome())));
            messaggi.add(new Messages("eeeeeeeeeeeeeeeeeee", LocalDate.of(2022, Month.JUNE, 22).atTime(8,7), String.valueOf(persona.getNome())));
            messaggi.add(new Messages("iiiiiiiiiiiiiiiiiii", LocalDateTime.now(), String.valueOf(persona.getNome())));
            messaggi.add(new Messages("ciaooooooooooooooo", LocalDate.of(2020, Month.JANUARY, 18).atStartOfDay(), String.valueOf(persona.getNome())));
            messaggi.add(new Messages("aaaaaaaaaaaaaaaaaaa", LocalDate.of(2021, Month.APRIL, 2).atTime(16,20), String.valueOf(persona.getNome())));
            messaggi.add(new Messages("eeeeeeeeeeeeeeeeeee", LocalDate.of(2022, Month.JUNE, 22).atTime(8,7), String.valueOf(persona.getNome())));
            messaggi.add(new Messages("iiiiiiiiiiiiiiiiiii", LocalDateTime.now(), String.valueOf(persona.getNome())));

        }
    }

    private void sortMessages(){
        messaggi.sort((o1, o2) -> {
            return o2.getLocalDateTime().compareTo(o1.getLocalDateTime());
        });
    }

    private void goBack(String messaggio, int activityCode){
        Intent intent = new Intent();
        intent.putExtra("messaggi", messaggio);
        try {
            setResult(activityCode, Intent.getIntent(messaggio));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        finish();
    }

}