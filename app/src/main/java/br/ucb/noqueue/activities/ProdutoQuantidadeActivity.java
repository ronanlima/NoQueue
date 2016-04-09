package br.ucb.noqueue.activities;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import br.ucb.noqueue.R;
import br.ucb.noqueue.adapters.ProdutoAdapter;
import br.ucb.noqueue.beans.Produto;
import br.ucb.noqueue.dto.ProdutoDTO;

@SuppressLint("NewApi")
public class ProdutoQuantidadeActivity extends Activity {

	ProdutoAdapter produtosAdapter;
	ListView listView;
	Button button;
	private static TextView tvTotal;
	static Dialog dialog;
	NumberPicker numberPicker;
	Double valorTotal = (double) 0;
	ArrayList<Produto> produtos;
	private static ArrayList<ProdutoDTO> listDtoQuantidade;
	private static Integer qtdCadaProduto;
	private static int posicaoGlobal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listarprodutoquantidade_activity);
		listView = (ListView) findViewById(R.id.listView);
		button = (Button) findViewById(R.id.button1);
		tvTotal = (TextView) findViewById(R.id.tvTotal);
		getIntent().getSerializableExtra("Produto");
		produtos = new ArrayList<Produto>();
		produtos = (ArrayList<Produto>) getIntent().getSerializableExtra(
				"Produto");
		listDtoQuantidade = new ArrayList<ProdutoDTO>();
		for (Produto produto : produtos) {
			valorTotal += produto.getValor();
			listDtoQuantidade.add(new ProdutoDTO(1,produto.getValor()));
		}
		tvTotal.setText(getResources().getString(R.string.valorCompra).concat(valorTotal.toString()));
		produtosAdapter = new ProdutoAdapter(this, R.layout.produto_list_row,
				produtos);
		listView.setScrollingCacheEnabled(true);
		listView.setFastScrollEnabled(true);
		listView.setAdapter(produtosAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				final Produto produto = (Produto) listView
						.getItemAtPosition(position);
				posicaoGlobal = position;
				dialog = new Dialog(listView.getContext());
				dialog.setTitle(R.string.qtdeProduto);
				dialog.setContentView(R.layout.dialog_activity);
				Button b1 = (Button) dialog.findViewById(R.id.nbbutton);
				numberPicker = (NumberPicker) dialog
						.findViewById(R.id.numberPicker1);
				numberPicker.setMaxValue(produto.getEstoque());
				numberPicker.setMinValue(1);
				numberPicker.setWrapSelectorWheel(false);
				numberPicker.setOnValueChangedListener(new OnValueChangeListener() {
					
					@Override
					public void onValueChange(NumberPicker picker, int oldVal,
							int newVal) {
						// TODO Auto-generated method stub

					}
				});
				b1.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						qtdCadaProduto = numberPicker.getValue();
						listDtoQuantidade.get(posicaoGlobal).setQuantidade(qtdCadaProduto);
						dialog.dismiss();
						tvTotal.setText(getResources().getString(R.string.valorCompra)+somaValores(listDtoQuantidade));
						}
				});
				
				dialog.show();
				
			}
		});

		listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Intent intent = new Intent(
						ProdutoQuantidadeActivity.this,
						DetalheProdutoActivity.class);
				Produto produto = (Produto) listView
						.getItemAtPosition(position);
				intent.putExtra("selected", produto);
				startActivity(intent);

				return true;
			}
		});
		Toast.makeText(this, R.string.tipoClique, Toast.LENGTH_LONG).show();
	}
	
	public void continuarCompra(View v) {
        
		Intent intent = new Intent(this, FinalizaCompraActivity.class);
		intent.putExtra("produtos",produtos);
		intent.putExtra("valorTotal", somaValores(listDtoQuantidade));
		intent.putExtra("dto", listDtoQuantidade);
        startActivity(intent);
    }
	
	public double somaValores(ArrayList<ProdutoDTO> lista){
		double soma = 0;
		for (ProdutoDTO produtoDTO : lista) 
			soma+= produtoDTO.getValor()*produtoDTO.getQuantidade();
		return soma;
	}
}
