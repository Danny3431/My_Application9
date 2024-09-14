package cl.bootcamp.myapplication9;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SquirtleFragment extends PokemonFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getPokemonImage() {
        return R.drawable.squirtle;
    }
}