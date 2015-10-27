package org.hydl.chaper3;

import org.hydl.helloworld.R;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableListsActivity extends ExpandableListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ExpandableListAdapter adapter = new BaseExpandableListAdapter() {

			int[] logos = new int[] { R.drawable.ic_launcher,
					R.drawable.ic_launcher, R.drawable.ic_launcher };
			private String[] armTypes = new String[] { "神族兵种", "虫族兵种", "人族兵种" };
			private String[][] arms = new String[][] {
					{ "狂战士", "龙骑士", "黑暗圣堂", "电兵" },
					{ "小狗", "刺蛇", "飞龙", "自爆飞机" }, { "机枪兵", "护士妹妹", "幽灵" } };

			@Override
			public boolean isChildSelectable(int groupPosition,
					int childPosition) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
					ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout ll = new LinearLayout(ExpandableListsActivity.this);
				ll.setOrientation(0);
				ImageView logo = new ImageView(ExpandableListsActivity.this);
				logo.setImageResource(logos[groupPosition]);
				ll.addView(logo);
				TextView textView = getTextView();
				textView.setText(getGroup(groupPosition).toString());
				ll.addView(textView);
				return ll;
			}

			@Override
			public long getGroupId(int groupPosition) {
				// TODO Auto-generated method stub
				return groupPosition;
			}

			@Override
			public int getGroupCount() {
				// TODO Auto-generated method stub
				return armTypes.length;
			}

			@Override
			public Object getGroup(int groupPosition) {
				// TODO Auto-generated method stub
				return armTypes[groupPosition];
			}

			@Override
			public int getChildrenCount(int groupPosition) {
				// TODO Auto-generated method stub
				return arms[groupPosition].length;
			}

			@Override
			public View getChildView(int groupPosition, int childPosition, boolean isLashChild,
					View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView textView = getTextView();
				textView.setText(getChild(groupPosition, childPosition).toString());
				return textView;
			}

			@Override
			public long getChildId(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return childPosition;
			}

			@Override
			public Object getChild(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return arms[groupPosition][childPosition];
			}

			private TextView getTextView() {
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
						ViewGroup.LayoutParams.FILL_PARENT, 64);
				TextView textView = new TextView(ExpandableListsActivity.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
				textView.setPadding(36, 0, 0, 0);
				textView.setTextSize(20);
				return textView;
			}
		};
		setListAdapter(adapter);
	}
}
