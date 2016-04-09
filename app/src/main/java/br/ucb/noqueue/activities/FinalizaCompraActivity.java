package br.ucb.noqueue.activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import br.ucb.noqueue.R;
import br.ucb.noqueue.beans.Cliente;
import br.ucb.noqueue.beans.Loja;
import br.ucb.noqueue.beans.NotaFiscal;
import br.ucb.noqueue.beans.Pedido;
import br.ucb.noqueue.beans.Produto;
import br.ucb.noqueue.connection.WebService;
import br.ucb.noqueue.dto.ProdutoDTO;
import br.ucb.noqueue.util.Validator;

import com.google.gson.Gson;

public class FinalizaCompraActivity extends Activity {

	public String url = null;
	public String response = "";
	public Pedido pedido;
	public List<Produto> produtos;
	public Double valorTotal;
	public EditText numCartao;
	public EditText nomeTitular;
	public Spinner ano;
	public Spinner mes;
	public EditText codSeguranca;
	public Spinner bandeira;
	public Loja loja;
	public Cliente cliente;
	public NotaFiscal notaFiscal;
	public Spinner pagamento;
	private static ArrayList<ProdutoDTO> listDtoQuantidade;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		url = getResources().getString(R.string.iphome).toString();
		pedido = new Pedido();
		notaFiscal = new NotaFiscal();
		cliente = new Cliente();
		setContentView(R.layout.cartaocredito_activity);
		produtos = (ArrayList<Produto>) getIntent().getSerializableExtra(
				"produtos");
		listDtoQuantidade=new ArrayList<ProdutoDTO>();
		listDtoQuantidade = (ArrayList<ProdutoDTO>) getIntent().getSerializableExtra(
				"dto");
		valorTotal = (Double) getIntent().getSerializableExtra("valorTotal");
		numCartao = (EditText) findViewById(R.id.numCartao);
		nomeTitular = (EditText) findViewById(R.id.nomeTitular);

		ano = (Spinner) findViewById(R.id.spinnerAno);
		mes = (Spinner) findViewById(R.id.spinnerMes);
		pagamento = (Spinner) findViewById(R.id.spinnerPagamento);
		codSeguranca = (EditText) findViewById(R.id.codSeguranca);
		bandeira = (Spinner) findViewById(R.id.spinner);
		Date dataAtual = new Date();
		Integer mesAtual = dataAtual.getMonth();
		mes.setSelection(mesAtual);
		verificaAno(ano);

		//
		numCartao.setText("5899161379375986");
		nomeTitular.setText("Batman");
		codSeguranca.setText("444");
		//

		pedido.setValorTotal(valorTotal);
		pedido.setProdutos(produtos);
		try {
			loja = getLoja();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pedido.setLoja(loja);

	}

	private Loja getLoja() throws JSONException {
		JSONObject lojaJSON = getJsonLoja("loja");
		Gson gson = new Gson();
		loja = gson.fromJson(lojaJSON.toString(), Loja.class);
		return loja;
	}

	private JSONObject getJsonLoja(String loja) throws JSONException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("tipoOperacao", "pesquisaLoja");
		params.put("loja", loja);
		WebService ws = new WebService(url);
		response = ws.webGet("", params);

		return new JSONObject(response);
	}

	public void verificaAno(Spinner spinner) {
		Date dataAtual = new Date();
		Integer ano2 = dataAtual.getYear() + 1900;
		for (int i = 0; i < 5; i++) {
			if (spinner.getItemAtPosition(i).toString()
					.equalsIgnoreCase(ano2.toString())) {
				ano.setSelection(i);
			}
		}
	}

	public void finalizarPedido(View view) {

		boolean erroNomeTitular = false;
		boolean erroCodSegurancaCampoNulo = false;
		boolean erroCodSegurancaTamanhoString = false;
		boolean erroCodSegurancaStringToNumber = false;
		boolean tamanhoNumCartao = false;
		boolean cardValidation = false;
		boolean mesInvalido = false;
		boolean anoInvalido = false;

		erroNomeTitular = Validator.campoNulo(findViewById(R.id.nomeTitular),
				getResources().getString(R.string.nomeTitularInvalido)
						.toString());
		erroCodSegurancaCampoNulo = Validator.campoNulo(
				findViewById(R.id.codSeguranca),
				getResources().getString(R.string.codSegurancaInvalido)
						.toString());
		erroCodSegurancaTamanhoString = Validator.validateTamanhoString(
				findViewById(R.id.codSeguranca), 3,
				getResources().getString(R.string.codSegurancaInvalido)
						.toString());
		erroCodSegurancaStringToNumber = Validator.validateStringToNumber(
				codSeguranca.getText().toString(),
				getResources().getString(R.string.codSegurancaInvalido)
						.toString(), findViewById(R.id.codSeguranca));

		tamanhoNumCartao = Validator.validateTamanhoString(
				findViewById(R.id.numCartao), 16,
				getResources().getString(R.string.numeroCartaoInvalido)
						.toString());
		mesInvalido = Validator.mesInvalido(findViewById(R.id.spinnerMes),this,
				mes.getSelectedItem().toString(), ano.getSelectedItem().toString(),
				getResources().getString(R.string.mesInvalido));
		anoInvalido = Validator.anoInvalido(findViewById(R.id.spinnerAno),this,
				ano.getSelectedItem().toString(), getResources().getString(R.string.mesInvalido));
		if (!tamanhoNumCartao) {
			cardValidation = Validator.trataNumCartao(
					findViewById(R.id.numCartao), numCartao.getText()
							.toString(),
					getResources().getString(R.string.numeroCartaoInvalido)
							.toString());
		}
		if (cardValidation && !erroNomeTitular && !erroCodSegurancaCampoNulo
				&& !erroCodSegurancaTamanhoString
				&& !erroCodSegurancaStringToNumber && mesInvalido
				&& anoInvalido) {
			cliente.setNomeTitular(nomeTitular.getText().toString());
			cliente.setNumeroCartao(numCartao.getText().toString());
			cliente.setDataValidadeCartao(mes.getSelectedItem().toString()
					+ "/" + ano.getSelectedItem().toString());
			cliente.setCodigoSeguranca(Integer.parseInt(codSeguranca.getText()
					.toString()));
			cliente.setFormaPagamento(pagamento.getSelectedItem().toString());
			cliente.setBandeira(bandeira.getSelectedItem().toString());
			pedido.setCliente(cliente);
			// try {
			// enviarPedido(pedido);
			// } catch (JSONException e) {
			// e.printStackTrace();
			// }

			notaFiscal.setPedido(pedido);
			notaFiscal.setDescricao(pedido.toString());
			
			for (int i = 0; i < listDtoQuantidade.size(); i++) {
				notaFiscal.getPedido().getProdutos().get(i).setEstoque(notaFiscal.getPedido().getProdutos().get(i).getEstoque()-listDtoQuantidade.get(i).getQuantidade());
			}
			
			try {
				enviarNotaFiscal(notaFiscal);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			Intent intent = new Intent(this, IndexActivity.class);
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendMultipartTextMessage("06184680498", null,
					smsManager.divideMessage(notaFiscal.getDescricao()), null,
					null);
			startActivity(intent);
			Toast.makeText(this, R.string.pedidoEfetuado, Toast.LENGTH_SHORT)
					.show();
		}
	}

	private void enviarPedido(Pedido pedido) throws JSONException {
		String retorno;
		Gson gson = new Gson();
		retorno = gson.toJson(pedido);

		Map<String, String> params = new HashMap<String, String>();
		params.put("tipoOperacao", "salvarPedido");
		params.put("pedido", retorno);
		WebService ws = new WebService(url);
		ws.webGet("", params);
	}

	private void enviarNotaFiscal(NotaFiscal notaFiscal) throws JSONException {
		String retorno;
		Gson gson = new Gson();
		retorno = gson.toJson(notaFiscal);

		Map<String, String> params = new HashMap<String, String>();
		params.put("tipoOperacao", "salvarNota");
		params.put("notaFiscal", retorno);
		WebService ws = new WebService(url);
		ws.webGet("", params);
	}

}
