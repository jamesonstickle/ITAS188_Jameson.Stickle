package itas.jameson.pokedex.Retrofit;


import io.reactivex.Observable;
import itas.jameson.pokedex.Model.Pokedex;
import retrofit2.http.GET;

public interface IPokemonDex {
    @GET("pokedex.json")
    Observable<Pokedex> getListPokemon();
}
