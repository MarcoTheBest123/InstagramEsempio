package it.itsar.riprova;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private ArrayList<Persone> amici = new ArrayList<Persone>();

    private ArrayList<Post> posts = new ArrayList<Post>();

    RecyclerView recyclerView;
    RecyclerView recyclerView1;
    private AmiciAdapter amiciAdapter;
    private PostAdapter postAdapter;


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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addPersone();
        addPosts();

        recyclerView = view.findViewById(R.id.elenco_amici);
        amiciAdapter = new AmiciAdapter(amici);
        recyclerView.setAdapter(amiciAdapter);

        recyclerView1 = view.findViewById(R.id.recycler_view_post);
        postAdapter = new PostAdapter(posts);
        recyclerView1.setAdapter(postAdapter);

    }

    private void addPersone(){
        amici.add(new Persone("Austin", "austin", R.drawable.austin));
        amici.add(new Persone("Jimmy", "jimmy", R.drawable.jimmy));
        amici.add(new Persone("Joseph", "joseph", R.drawable.joseph));
        amici.add(new Persone("Stefan", "stefan", R.drawable.stefan));
        amici.add(new Persone("Albert", "albert", R.drawable.albert));
        amici.add(new Persone("Austin", "austin", R.drawable.austin));
        amici.add(new Persone("Jimmy", "jimmy", R.drawable.jimmy));
        amici.add(new Persone("Joseph", "joseph", R.drawable.joseph));
        amici.add(new Persone("Stefan", "stefan", R.drawable.stefan));
        amici.add(new Persone("Albert", "albert", R.drawable.albert));

    }

    private void addPosts(){
        posts.add(new Post("Austin Austin", R.drawable.austin));
        posts.add(new Post("Austin Austin", R.drawable.austin));
        posts.add(new Post("Austin Austin", R.drawable.austin));
        posts.add(new Post("Austin Austin", R.drawable.austin));
        posts.add(new Post("Austin Austin", R.drawable.austin));
        posts.add(new Post("Austin Austin", R.drawable.austin));
    }

}