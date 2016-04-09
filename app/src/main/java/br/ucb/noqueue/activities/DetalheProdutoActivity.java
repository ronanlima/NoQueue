package br.ucb.noqueue.activities;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import br.ucb.noqueue.R;
import br.ucb.noqueue.beans.Produto;

public class DetalheProdutoActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalheproduto_activity);
		getIntent().getSerializableExtra("Produto");
		Produto produto = new Produto();
		produto = (Produto) getIntent().getSerializableExtra("selected");
		TextView tv = (TextView) findViewById(R.id.widget39);
		tv.setText(produto.getNome());
		tv = (TextView) findViewById(R.id.tvProteina);
		tv.setText(produto.getInformacaoNutricional().getCarboidratos().toString());
		tv = (TextView) findViewById(R.id.tvCarboidrato);
		tv.setText(produto.getInformacaoNutricional().getGordurasTrans().toString());
		tv = (TextView) findViewById(R.id.tvGordura);
		tv.setText(produto.getInformacaoNutricional().getProteinas().toString());
		tv = (TextView) findViewById(R.id.tvGorduraTrans);
		tv.setText(produto.getInformacaoNutricional().getCalorias().toString());
		tv = (TextView) findViewById(R.id.tvCaloria);
		tv.setText(produto.getInformacaoNutricional().getFibras().toString());
		tv = (TextView) findViewById(R.id.tvFibra);
		tv.setText(produto.getInformacaoNutricional().getGorduras().toString());
	}
}
