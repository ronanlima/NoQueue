package br.ucb.noqueue.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import br.ucb.noqueue.R;
import br.ucb.noqueue.beans.Produto;

import com.google.gson.Gson;

public class ShowProdutosActivity extends Activity {

	ListView listView;
	Button button;
	ArrayAdapter<Produto> produtosAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listproduto_activity);
		listView = (ListView) findViewById(R.id.listView);
		button = (Button) findViewById(R.id.button1);
		Bundle b = getIntent().getExtras();
		String[] resultArr = b.getStringArray("selectedItems");
		Produto novoProduto;
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		for (String string : resultArr) {
			Gson gson = new Gson();
			novoProduto = new Produto();
			novoProduto = gson.fromJson(string, Produto.class);
			produtos.add(novoProduto);
		}

		produtosAdapter = new ArrayAdapter<Produto>(ShowProdutosActivity.this,
				android.R.layout.simple_list_item_multiple_choice, produtos) {
		
			@Override
		    public View getView(int position, View convertView, ViewGroup parent) {
		        TextView textView = (TextView) super.getView(position, convertView, parent);
		        textView.setTextColor(0xFF000000);

		        return textView;
		    }
		};
		
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		// listView.setBackgroundColor(Color.WHITE);
		listView.setAdapter(produtosAdapter);

	}

	public void botaoComprar(View v) {
		SparseBooleanArray checked = listView.getCheckedItemPositions();
		ArrayList<Produto> selectedItems = new ArrayList<Produto>();
		for (int i = 0; i < checked.size(); i++) {
			// Item position in adapter
			int position = checked.keyAt(i);
			// Add sport if it is checked i.e.) == TRUE!
			if (checked.valueAt(i))
				selectedItems.add(produtosAdapter.getItem(position));
		}
		if (selectedItems.size() > 0) {
			Intent intent = new Intent(this,
					ProdutoQuantidadeActivity.class);
			intent.putExtra("Produto", selectedItems);
			startActivity(intent);
		}
		else {
			Toast.makeText(this, R.string.validaQuantidade, Toast.LENGTH_LONG)
			.show();
		}
			
	}
}
