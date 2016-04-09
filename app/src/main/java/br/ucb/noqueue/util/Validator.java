package br.ucb.noqueue.util;

import java.util.Date;

import br.ucb.noqueue.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Validator {

	public static Integer twoDigit;
	public static Integer oneDigit;

	@SuppressLint("NewApi")
	public static boolean campoNulo(View pView, String pMessage) {
		if (pView instanceof EditText) {
			EditText edText = (EditText) pView;
			Editable text = edText.getText();
			if (text != null) {
				String strText = text.toString();
				if (!strText.trim().isEmpty())
					return false;
			}
			edText.setError(pMessage);
			edText.setFocusable(true);
			edText.requestFocus();
		}
		return true;

	}

	public static boolean validateTamanhoString(View pView, Integer tamanho,
			String pMessage) {
		if (pView instanceof EditText) {
			EditText edText = (EditText) pView;
			Editable text = edText.getText();
			String strText = text.toString();
			if (strText.length() == tamanho) {
				return false;
			}
			edText.setError(pMessage);
			edText.setFocusable(true);
			edText.requestFocus();
		}

		return true;
	}

	public static boolean validateStringToNumber(String numero,
			String pMessage, View pView) {
		try {
			Integer num = new Integer(numero);
		} catch (NumberFormatException e) {
			EditText edText = (EditText) pView;
			edText.setError(pMessage);
			edText.setFocusable(true);
			edText.requestFocus();
			return true;

		}
		return false;
	}
	
	public static boolean ehDouble(String numero,String pMessage, View pView) 
	{
		try {
			Double num = new Double(numero);
		} catch (NumberFormatException e) {
			EditText edText = (EditText) pView;
			edText.setError(pMessage);
			edText.setFocusable(true);
			edText.requestFocus();
			return false;

		}
		return true;
	}
	
	public static boolean ehDouble(String numero,String pMessage, Activity ac) 
	{
		try {
			Double num = new Double(numero);
		} catch (NumberFormatException e) {
			Toast.makeText(ac, R.string.precoInvalido,
					Toast.LENGTH_SHORT).show();
			return false;

		}
		return true;
	}

	public static boolean trataNumCartao(View view, String numCartao, String msgErro) {
		String CardNo = numCartao;
		CardNo = CardNo.replace(" ", "");// removing empty space
		CardNo = CardNo.replace("-", "");// removing '-'
		twoDigit = Integer.parseInt(CardNo.substring(0, 2));
		oneDigit = Integer.parseInt(Character.toString(CardNo.charAt(0)));

		boolean cardValidation = false;
		if (CardNo.length() >= 14) {

			cardValidation = cardValidationMethod(view, CardNo, msgErro);

		}
		return cardValidation;
	}

	public static boolean cardValidationMethod(View view, String CardNo, String msgErro) {                  
		if (CardNo.length() == 16 && twoDigit >= 51 && twoDigit <= 58)			// for MasterCard
			return true;
		else if (CardNo.length() == 16  && oneDigit == 4)// for VISA
			return true;
		else {
			EditText edit = (EditText) view;
			edit.setError(msgErro);
			edit.setFocusable(true);
			edit.requestFocus();
			return false;
		}
	}
	
	public static boolean mesInvalido(View view, Context context, String mes, String ano, String msgErro){
		Integer mesAtual = new Date().getMonth();
		Integer anoAtual = new Date().getYear()+1900;
		if ((Integer.parseInt(mes)-1) < mesAtual && Integer.parseInt(ano) == anoAtual){
			Toast.makeText(context, R.string.mesInvalido, Toast.LENGTH_SHORT)
			.show();
			return false;
		}
		return true;
	}

	public static boolean anoInvalido(View view, Context context, String ano, String msgErro){
		Integer anoAtual = new Date().getYear()+1900;
		if (Integer.parseInt(ano) < anoAtual){
			Toast.makeText(context, R.string.mesInvalido, Toast.LENGTH_SHORT)
			.show();
			return false;
		}
		return true;
	}
	
}
