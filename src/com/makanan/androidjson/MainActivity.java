package com.makanan.androidjson;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    /** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		// Create an array of Strings, that will be put to our ListActivity
		String[] menu = new String[] { "Tambah Data", "Tampilkan Data", "Exit" };
		// Create an ArrayAdapter, that will actually make the Strings above
		// appear in the ListView
		// Menset nilai array ke dalam list adapater sehingga data pada array
		// akan dimunculkan dalam list
		this.setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, menu));
	}

	@Override
	/**method ini akan mengoveride method onListItemClick
	 * yang ada pada class List Activity
	 * method ini akan dipanggil apabilai ada salah satu item
	 * dari list menu yang dipilih
	 */
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		// Get the item that was clicked
		Object o = this.getListAdapter().getItem(position);
		String pilihan = o.toString();
		tampilkanPilihan(pilihan);
	}

	protected void tampilkanPilihan(String pilihan) {
		try {
			Intent i = null;
			if (pilihan.equals("Tambah Data")) {
				i = new Intent(this, InsertActivity.class);
			} else if (pilihan.equals("Tampilkan Data")) {
				i = new Intent(this, JSONActivity.class);
			} else if (pilihan.equals("Exit")) {
				finish();
			} else {
				Toast.makeText(this,"Anda Memilih: " + pilihan + " , " +
						"Actionnya belum dibuat", Toast.LENGTH_LONG).show();
			}
			startActivity(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
