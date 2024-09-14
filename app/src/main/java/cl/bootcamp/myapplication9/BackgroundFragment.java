package cl.bootcamp.myapplication9;

import android.os.Bundle;

import cl.bootcamp.myapplication9.R;
import cl.bootcamp.myapplication9.PokemonFragment;

public class BackgroundFragment extends PokemonFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getPokemonImage() {
        return R.drawable.pokebola;
    }
}
