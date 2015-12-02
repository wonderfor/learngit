package org.hydl.chaper9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		//����ǽ��յ�����
		if(intent.getAction() == "android.provider.Telephony.SMS_RECEIVED") {
			//ȡ���㲥(���д��뽫����ϵͳ�ղ�������)
			abortBroadcast();
			StringBuilder sb = new StringBuilder();
			//������SMS������������
			Bundle bundle = intent.getExtras();
			//�ж��Ƿ�������
			if(bundle != null) {
				//ͨ��pdus���Ի�ý��յ������ж�����Ϣ
				Object[] pdus = (Object[]) bundle.get("pdus");
				//�������Ŷ���array,�������յ��Ķ��󳤶�������array�Ĵ�С
				SmsMessage[] messages = new SmsMessage[pdus.length];
				for(int i = 0 ; i < pdus.length ;i++) {
					messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
				}
				//���������Ķ��źϲ��Զ�����Ϣ��StringBuilder����
				for(SmsMessage message : messages) {
					sb.append("������Դ:");
					sb.append(message.getDisplayOriginatingAddress());
					sb.append("\n------��������------\n");
					//��ö��ŵ�����
					sb.append(message.getDisplayMessageBody());
				}
				
			}
			
			Toast.makeText(context, sb.toString(), Toast.LENGTH_LONG).show();
		}
	}

}
