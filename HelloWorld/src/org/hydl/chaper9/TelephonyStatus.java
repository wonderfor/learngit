package org.hydl.chaper9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hydl.helloworld.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class TelephonyStatus extends Activity {

	ListView showView;
	// ��������״̬��������
	String[] statusNames;
	// ���������ֻ�״̬�ļ���
	ArrayList<String> statusValues = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_telephony);
		// ��ȡϵͳ��TelephonyManger����
		TelephonyManager tManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		// ��ȡ����״̬���Ƶ�����
		statusNames = getResources().getStringArray(R.array.statusNames);
		// ��ȡ����SIM��״̬������
		String[] simState = getResources().getStringArray(R.array.simState);
		// ��ȡ����绰�������͵�����
		String[] phoneType = getResources().getStringArray(R.array.phoneType);
		// ��ȡ�豸���
		statusValues.add(tManager.getDeviceId());
		// ��ȡϵͳƽ̨�汾
		statusValues.add(tManager.getDeviceSoftwareVersion() != null ? tManager
				.getDeviceSoftwareVersion() : "δ֪");
		// ��ȡ������Ӫ�̴���
		statusValues.add(tManager.getNetworkOperator());
		// ��ȡ������Ӫ������
		statusValues.add(tManager.getNetworkOperatorName());
		// ��ȡ�ֻ���������
		statusValues.add(phoneType[tManager.getPhoneType()]);
		// ��ȡ�豸����λ��
		statusValues.add(tManager.getCellLocation() != null ? tManager
				.getCellLocation().toString() : "δ֪λ��");
		// ��ȡSIM�����ڵĹ���
		statusValues.add(tManager.getSimCountryIso());
		// ��ȡSIM�����к�
		statusValues.add(tManager.getSimSerialNumber());
		// ��ȡ SIM��״̬
		statusValues.add(simState[tManager.getSimState()]);
		// ��ȡlistview����
		showView = (ListView) findViewById(R.id.show);
		ArrayList<Map<String, String>> status = new ArrayList<Map<String, String>>();
		// ����statusValues����,��statusName,statusValues�����ݷ�װ��
		// List<Map<String,String>>������
		for (int i = 0; i < statusValues.size(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", statusNames[i]);
			map.put("value", statusValues.get(i));
			status.add(map);
		}

		// ʹ��SimpleAdapter��װList����
		SimpleAdapter adapter = new SimpleAdapter(this, status, R.layout.lines,
				new String[] { "name", "value" }, new int[] { R.id.my_title,
						R.id.my_content });
		showView.setAdapter(adapter);

	}
}
