package br.ucb.noqueue.adapters;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import br.ucb.noqueue.R;
import br.ucb.noqueue.beans.Produto;

public class ProdutoAdapter extends ArrayAdapter<Produto> {

    Context context;
    ArrayList<Produto> produtos;
    int layoutResourceId;
    ProdutoHolder holder;
    Produto produto;

    public ProdutoAdapter(Context context, int layoutResourceId,
                          ArrayList<Produto> produtos) {
        super(context, layoutResourceId, produtos);

        this.context = context;
        this.produtos = produtos;
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Produto getItem(int i) {
        return produtos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return produtos.get(i).getIdPRODUTO();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        produto = produtos.get(position);
        holder = null;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);

            holder = new ProdutoHolder();
            convertView.setTag(holder);
            holder.name = (TextView) convertView.findViewById(R.id.productName);
            holder.precoUnitario = (TextView) convertView.findViewById(R.id.productValue);

        } else {
            holder = (ProdutoHolder) convertView.getTag();
        }

        holder.name.setText(produto.getNome());
        holder.name.setTextColor(0xFF000000);
        holder.precoUnitario.setText("R$:"+produto.getValor().toString());
        holder.precoUnitario.setTextColor(0xFF000000);

        return convertView;
    }

    static class ProdutoHolder {
        TextView name;
        TextView precoUnitario;
        TextView qtdeSeek;
    }
}
