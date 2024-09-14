package cl.bootcamp.myapplication9;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import cl.bootcamp.myapplication9.PokemonFragment;

public class CharmanderFragment extends PokemonFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getPokemonImage() {
        return R.drawable.chamanderl;
    }
}