
package cl.bootcamp.myapplication9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cl.bootcamp.myapplication9.databinding.FragmentPokemonBinding;

public abstract class PokemonFragment extends Fragment {
    private FragmentPokemonBinding binding; // Declara el binding

    protected abstract int getPokemonImage();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPokemonBinding.inflate(inflater, container, false); // Inicializa el binding
        ImageView imageView = binding.pokemonImage; // Accede al ImageView a través del binding
        imageView.setImageResource(getPokemonImage());
        return binding.getRoot(); // Devuelve la vista inflada
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Limpia la referencia al binding
    }
}
