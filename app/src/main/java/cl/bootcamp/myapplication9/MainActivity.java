package cl.bootcamp.myapplication9;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import cl.bootcamp.myapplication9.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding; // Declarar el binding
    private String currentPokemon = "pokeball";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); // Inicializa el binding
        setContentView(binding.getRoot()); // Establece la vista

        binding.pokemonIcon.setImageResource(R.drawable.pokeball); // Establece la imagen inicial
        binding.pokemonIcon.setVisibility(View.GONE); // Oculta el icono al inicio

        binding.buttonValidate.setOnClickListener(v -> {
            int selectedId = binding.radioGroup.getCheckedRadioButtonId();

            if (selectedId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                String choice = selectedRadioButton.getText().toString();
                showPokemonDialog(choice);
            } else {
                Toast.makeText(MainActivity.this, "Por favor, selecciona una opción", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showPokemonDialog(String pokemonName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_pokemon, null);
        builder.setView(dialogView);

        ImageView dialogPokemonIcon = dialogView.findViewById(R.id.dialog_pokemon_icon);
        TextView pokemonNameTextView = dialogView.findViewById(R.id.pokemon_name);
        Button buttonAccept = dialogView.findViewById(R.id.button_accept);
        Button buttonCancel = dialogView.findViewById(R.id.button_cancel);

        pokemonNameTextView.setText(pokemonName);
        setPokemonIcon(pokemonName, dialogPokemonIcon);

        builder.setTitle("Pokémon Seleccionado es");
        AlertDialog dialog = builder.create();

        buttonAccept.setOnClickListener(v -> {
            dialog.dismiss();
            changePokemonFragment(pokemonName);
            currentPokemon = pokemonName;
        });

        buttonCancel.setOnClickListener(v -> {
            dialog.dismiss();
            resetSelection();
            changeToBackgroundFragment();
        });

        dialog.show();
    }

    private void setPokemonIcon(String pokemonName, ImageView imageView) {
        switch (pokemonName) {
            case "Charmander":
                imageView.setImageResource(R.drawable.charmander_icon);
                break;
            case "Bulbasaur":
                imageView.setImageResource(R.drawable.bulbasaur_icon);
                break;
            case "Squirtle":
                imageView.setImageResource(R.drawable.squirtle_icon);
                break;
            default:
                imageView.setImageResource(R.drawable.pokeball);
                break;
        }
    }

    private void changePokemonFragment(String pokemonName) {
        Fragment fragment;

        switch (pokemonName) {
            case "Charmander":
                fragment = new CharmanderFragment();
                break;
            case "Bulbasaur":
                fragment = new BulbasaurFragment();
                break;
            case "Squirtle":
                fragment = new SquirtleFragment();
                break;
            default:
                fragment = new PokemonFragment() {
                    @Override
                    protected int getPokemonImage() {
                        return R.drawable.pokebola;
                    }
                };
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private void resetSelection() {
        binding.radioGroup.clearCheck(); // Limpia la selección de RadioButtons
        binding.main.setBackgroundResource(R.drawable.pokebola); // Imagen original
    }

    private void changeToBackgroundFragment() {
        Fragment fragment = new cl.bootcamp.myapplication9.BackgroundFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null; // Limpia la referencia al binding
    }
}