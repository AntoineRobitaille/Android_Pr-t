package com.example.eleves.android_comptoir_grasset;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NouveauPret extends AppCompatActivity {

    final Context context = this;
    Button btn_choix_materiel, btn_annuler;
    Spinner spin_professeur;
    EditText nom_etudiant, courriel_etudiant, date_editTx, comment_editTx;
    AutoCompleteTextView titre_cours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_pret);
        //================================================
        setTitle("IG Pret");

        nom_etudiant = (EditText)findViewById(R.id.nom_etudiant);
        courriel_etudiant = (EditText)findViewById(R.id.courriel_etudiant);
        titre_cours = (AutoCompleteTextView) findViewById(R.id.titre_cours);
        spin_professeur = (Spinner)findViewById(R.id.spin_professeur);
        date_editTx = (EditText)findViewById(R.id.date_editTx);
        comment_editTx = (EditText)findViewById(R.id.comment_editTx);

        btn_choix_materiel = (Button)findViewById(R.id.btn_choix_materiel);
        btn_annuler = (Button)findViewById(R.id.btn_annuler);

        //================================================
        btn_annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( spin_professeur.getSelectedItem() == "-"){System.out.println("retour au menu");}
                else{System.out.println(spin_professeur.getSelectedItem().toString());}

                //Si aucune information entrée, retour au menu de depart
                if(nom_etudiant.getText().toString().isEmpty() &&
                        courriel_etudiant.getText().toString().isEmpty() &&
                        titre_cours.getText().toString().isEmpty() &&
                        spin_professeur.getSelectedItem().toString().equals("-") &&
                        date_editTx.getText().toString().isEmpty() &&
                        comment_editTx.getText().toString().isEmpty())
                {
                    Intent intent = new Intent(NouveauPret.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    //code pour le pop-up
                    //================================================
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Alerte");
                    alertDialogBuilder.setMessage("Voulez-vous vraiment annuler votre nouvelle demande?");
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(NouveauPret.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    alertDialogBuilder.setNegativeButton("NON", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }
        });

        //================================================

        //================================================
        btn_choix_materiel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Si un champ n'est pas rempli (excepté commentaire)
                if(nom_etudiant.getText().toString().isEmpty() ||
                        courriel_etudiant.getText().toString().isEmpty() ||
                        titre_cours.getText().toString().isEmpty() ||
                        spin_professeur.getSelectedItem() == null ||
                        date_editTx.getText().toString().isEmpty())
                {
                    //code pour le pop-up
                    //================================================
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Alerte");
                    alertDialogBuilder.setMessage("Veuillez remplir tous les champs avant de choisir votre matériel (commentaire non obligatoire)");
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
                else
                {
                    Intent intent = new Intent(NouveauPret.this, ChoisirMateriel.class);
                    startActivity(intent);
                }


            }
        });
        //================================================


    }
}
