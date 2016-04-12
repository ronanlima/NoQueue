package br.ucb.noqueue.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import br.ucb.noqueue.R;
import br.ucb.noqueue.connection.NoQueueService;
import br.ucb.noqueue.connection.WebService;
import br.ucb.noqueue.util.VerificaConexaoInternet;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndexActivity extends Activity {

    protected static final String ZXING_MARKET = "market://search?q=pname:com.google.zxing.client.android";
    protected static final String ZXING_DIRECT = "https://zxing.googlecode.com/files/BarcodeScanner3.1.apk";
    public String url = null;
    public String response = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = "http://192.168.25.5:8080/NoQueueServidor/";
        setContentView(R.layout.index_activity);
        VerificaConexaoInternet verificaConexão = new VerificaConexaoInternet(
                this);

        if (!verificaConexão.isConnectingToInternet()) {
            mostraAlerta();
        }
    }

    private void mostraAlerta() {
        AlertDialog.Builder informa = new AlertDialog.Builder(this);
        informa.setTitle("Alerta!").setMessage("Sem conexão com a internet.");
        informa.setNeutralButton("Fechar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Process.killProcess(Process.myPid());
            }
        }).show();
    }

    public void botaoBuscarProdutos(View v) {
        Intent intent = new Intent(this, BuscarProdutosActivity.class);

        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            String resultado = intent.getStringExtra("SCAN_RESULT");

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(resultado));
            startActivity(i);
        }
    }

    /*public void listar(View view) throws JSONException {
        JSONArray produtos = pesquisarProdutos("");

        String[] resultado = new String[produtos.length()];
        for (int i = 0; i < produtos.length(); i++) {
            resultado[i] = produtos.getString(i);
        }

        Intent intent = new Intent(this, ShowProdutosActivity.class);
        Bundle b = new Bundle();
        b.putStringArray("selectedItems", resultado);

        intent.putExtras(b);

        startActivity(intent);
    }*/

    public void listar(View v) throws JSONException{
        Call<JSONArray> call = NoQueueService.getInstance().getService().getAllProdutos("pesquisaProdutos");
        call.enqueue(new Callback<JSONArray>() {
            @Override
            public void onResponse(Call<JSONArray> call, Response<JSONArray> response) {
                if (response.isSuccess() && response.code() == 200){
                    JSONArray produtos = response.body();
                    String[] resultado = new String[produtos.length()];
                    for (int i = 0; i < produtos.length(); i++) {
                        try {
                            resultado[i] = produtos.getString(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    Intent intent = new Intent(getApplicationContext(), ShowProdutosActivity.class);
                    Bundle b = new Bundle();
                    b.putStringArray("selectedItems", resultado);

                    intent.putExtras(b);

                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<JSONArray> call, Throwable t) {
                Log.d("IndexActivity", "Deu merda!!!");
            }
        });
    }

    public void lerQR(View view) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");

        try {
            startActivityForResult(intent, 0);

        } catch (ActivityNotFoundException e) {
            mostrarMensagem();
        }
    }

    private void mostrarMensagem() {
        new AlertDialog.Builder(this)
                .setTitle("Instalar barcode scanner?")
                .setMessage(
                        "Para escanear QR code você precisa instalar o ZXing barcode scanner.")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Instalar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                Intent intent = new Intent(Intent.ACTION_VIEW,
                                        Uri.parse(ZXING_MARKET));
                                try {
                                    startActivity(intent);
                                } catch (ActivityNotFoundException e) {
                                    intent = new Intent(Intent.ACTION_VIEW, Uri
                                            .parse(ZXING_DIRECT));
                                    startActivity(intent);
                                }
                            }
                        }).setNegativeButton("Cancelar", null).show();

    }

    private JSONArray pesquisarProdutos(String parametroPesquisa)
            throws JSONException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("tipoOperacao", "pesquisaProdutos");
        params.put("pesquisaProduto", parametroPesquisa);
        WebService ws = new WebService(url);
        response = ws.webGet("", params);

        return new JSONArray(response);
    }
}
