package org.hydl.readother;

import java.util.List;

import org.hydl.chaper9.IPet;
import org.hydl.chaper9.Person;
import org.hydl.chaper9.Pet;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ComplexClient extends Activity {

	private IPet petService;
	private Button get;
	EditText personView;
	ListView showView;

	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			petService = null;
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			petService = IPet.Stub.asInterface(service);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_complex);
		personView = (EditText) findViewById(R.id.personView);
		get = (Button) findViewById(R.id.get);
		showView = (ListView) findViewById(R.id.showView);

		Intent intent = new Intent();
		intent.setAction("org.hydl.chaper9.complexservice");
		bindService(intent, conn, Service.BIND_AUTO_CREATE);
		get.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				
				try {
					String personName = personView.getText().toString();
					List<Pet> pets = petService.getPets(new Person(1, personName,
							personName));
					if(pets == null) {
						System.out.println("pets is null");
					}else{
						System.out.println("pets:"+pets);
					}
					
					ArrayAdapter<Pet> adapter = new ArrayAdapter<Pet>(
							ComplexClient.this,
							android.R.layout.simple_list_item_1, pets);
					showView.setAdapter(adapter);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		this.unbindService(conn);
	}

}
