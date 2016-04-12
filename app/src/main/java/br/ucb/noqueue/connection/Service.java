package br.ucb.noqueue.connection;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ronan Lima on 12/04/2016.
 */
public interface Service {
    @GET("")
    Call<JSONArray> getAllProdutos(@Path("tipoOperacao")String tipoOperacao);
}
