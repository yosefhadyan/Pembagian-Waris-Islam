package id.barkost.waris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MateriAhli extends Activity {

	String[] ahli;
	ListView list_ahli;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.materi_ahli);
		
		ahli = getResources().getStringArray(R.array.ahli_items);
		list_ahli = (ListView) findViewById(R.id.listViewAhli);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, ahli);
		
		list_ahli.setAdapter(adapter);
		
		list_ahli.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	Intent intent = new Intent(MateriAhli.this, MateriAhliCnt.class);
            	MateriAhliCnt.pos = position;            	
            	startActivity(intent);
            	overridePendingTransition(R.anim.slide_from_right, R.anim.stand);
            }
        });
	}
	
	public void onBackPressed() {
		finish();
		overridePendingTransition(R.anim.stand, R.anim.slide_to_right);
	}
}
