package br.ucb.noqueue.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import br.ucb.noqueue.R;
import br.ucb.noqueue.beans.Produto;
import br.ucb.noqueue.connection.WebService;
import br.ucb.noqueue.util.Validator;

public class BuscarProdutosActivity extends Activity {
	/*public String url = null;
	public String response = "";
	RadioButton rbNome = null;
	RadioButton rbPreco = null;

	*//** Called when the activity is first created. *//*
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		url = getResources().getString(R.string.iphome).toString();
		setContentView(R.layout.buscarprodutos_activity);
	}

	public void botaoPesquisarProduto(View view) throws JSONException {

		RadioGroup rg = (RadioGroup) findViewById(R.id.rgopcoes);
		Integer op = rg.getCheckedRadioButtonId();

		// Recupera a pesquisa informada pelo cliente
		EditText campoPesquisa = (EditText) findViewById(R.id.campotextobusca);
		String parametroPesquisa = campoPesquisa.getText().toString();

		if (op != -1) {

			rbPreco = (RadioButton) findViewById(R.id.pesqPreco);
			Integer idPreco = rbPreco.getId();
			if (parametroPesquisa != null && parametroPesquisa.length() != 0) {

				if (op.toString().equalsIgnoreCase(idPreco.toString())) {
					if (parametroPesquisa != null
							&& parametroPesquisa.length() != 0
							&& Validator.ehDouble(
									parametroPesquisa,
									getResources().getString(
											R.string.precoInvalido), this)) {
						retornaProdutos(parametroPesquisa, op);
					}
				} else {
					retornaProdutos(parametroPesquisa, op);
				}

			} else {
				Toast.makeText(this, R.string.validacaoParamPesquisa,
						Toast.LENGTH_SHORT).show();
			}

		} else {
			Toast.makeText(this, R.string.validacaoOpcao, Toast.LENGTH_SHORT)
					.show();
		}

	}

	private void retornaProdutos(String parametroPesquisa, Integer op)
			throws JSONException {
		JSONArray produtos = pesquisarProdutos(parametroPesquisa, op);

		String[] resultado = new String[produtos.length()];
		for (int i = 0; i < produtos.length(); i++) {
			resultado[i] = produtos.getString(i);
		}

		if (resultado != null && resultado.length != 0) {
			Intent intent = new Intent(this, ShowProdutosActivity.class);
			Bundle b = new Bundle();
			b.putStringArray("selectedItems", resultado);

			intent.putExtras(b);

			startActivity(intent);

		} else {
			Toast.makeText(this, R.string.validacaoLista, Toast.LENGTH_SHORT)
					.show();
		}
	}

	private JSONArray pesquisarProdutos(String parametroPesquisa, Integer op)
			throws JSONException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("tipoOperacao", "pesquisaProdutos");
		params.put("pesquisa", parametroPesquisa);
		rbNome = (RadioButton) findViewById(R.id.pesqNome);
		rbPreco = (RadioButton) findViewById(R.id.pesqPreco);

		Integer idNome = rbNome.getId();
		Integer idPreco = rbPreco.getId();
		if (idNome.toString().equalsIgnoreCase(op.toString())) {
			params.put("opcao", op.toString());
			params.put("tipoNome", idNome.toString());
		} else if (idPreco.toString().equalsIgnoreCase(op.toString())) {
			params.put("opcao", op.toString());
			params.put("tipoPreco", idPreco.toString());
		}
		WebService ws = new WebService(url);
		response = ws.webGet("", params);

		return new JSONArray(response);
	}

	public ArrayList<Produto> preparaPesquisa(String parametroPesquisa) {
		return null;
	}*/
}