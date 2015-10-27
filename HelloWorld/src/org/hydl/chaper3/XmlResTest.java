package org.hydl.chaper3;

import java.io.IOException;

import org.hydl.helloworld.R;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class XmlResTest extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xmlrestest);
		
		Button bn = (Button) findViewById(R.id.btn_jiexi);
		bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				XmlResourceParser xrp = getResources().getXml(R.xml.books);
				try {
					StringBuilder sb = new StringBuilder("");
					while(xrp.getEventType()!=XmlResourceParser.END_DOCUMENT) {
						if(xrp.getEventType() == XmlResourceParser.START_TAG) {
							String tagName = xrp.getName();
							if(tagName.equals("book")) {
								String bookName = xrp.getAttributeValue(null,"price");
								sb.append("价格： ");
								sb.append(bookName);
								String bookPrice = xrp.getAttributeValue(1);
								sb.append("           出版日期:");
								sb.append(bookPrice);
								sb.append("  书名 :  ");
								sb.append(xrp.nextText());
							}
							sb.append("\n");
						}
						xrp.next();
					}
					
					EditText show = (EditText) findViewById(R.id.edit03);
					show.setText(sb.toString());
				} catch (XmlPullParserException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
