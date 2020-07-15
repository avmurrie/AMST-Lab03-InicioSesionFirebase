package com.grupo1.grupo1_ta3_iniciosesionfirebase;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

public class PerfilUsuario extends AppCompatActivity {
    //DatabaseReference db_reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
    }

    iniciarBaseDeDatos();
    leerTweets();
    escribirTweets(info_user.get("user_name"));

}
    public void iniciarBaseDeDatos(){
        db_reference = FirebaseDatabase.getInstance().getReference().child("Grupo");  }

    public void leerTweets(){

        db_reference.child("Grupo 0").child("tweets")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            System.out.println(snapshot);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        System.out.println(error.toException());
                    }
                });

    }

    public void escribirTweets(String autor){
        String tweet = "hola mundo firebase 2";
        String fecha = "31/10/2019";
        Map<String, String> hola_tweet = new HashMap<String, String>();
        hola_tweet.put("autor", autor);
        hola_tweet.put("fecha", fecha);
        DatabaseReference tweets = db_reference.child("Grupo 0").child("tweets");
        tweets.setValue(tweet);
        tweets.child(tweet).child("autor").setValue(autor);
        tweets.child(tweet).child("fecha").setValue(fecha);
    }