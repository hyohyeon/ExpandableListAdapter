package com.example.java.a_zapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hyohyeon on 2018-10-25.
 */

public class ListActivity extends Activity {
    ExpandableListView lvData;
    ArrayList<Item> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);
        lvData = (ExpandableListView) findViewById(R.id.lvExp);
        setData();
        ExpandableAdapter adapter = new ExpandableAdapter(getApplicationContext(), R.layout.group_row, R.layout.child_row, list);
        lvData.setAdapter(adapter);

    }

    private void setData() {
        list = new ArrayList<Item>();

        // 1
        Item it = new Item("일번");
        ItemVo vo = new ItemVo();
        vo.setCkYn("Y");
        vo.setText1("1");
        vo.setText2("2");
        vo.setText3("3");

        it.setItems(vo);
        list.add(it);

        // 2
        it = new Item("이번");
        vo = new ItemVo();
        vo.setCkYn("Y");
        vo.setText1("1");
        vo.setText2("2");
        vo.setText3("3");

        it.setItems(vo);
        list.add(it);

        // 3
        it = new Item("삼번");
        vo = new ItemVo();
        vo.setCkYn("N");
        vo.setText1("1");
        vo.setText2("2");
        vo.setText3("3");

        it.setItems(vo);
        list.add(it);

        // 4
        it = new Item("사번");
        vo = new ItemVo();
        vo.setCkYn("N");
        vo.setText1("1");
        vo.setText2("2");
        vo.setText3("3");

        it.setItems(vo);
        list.add(it);

        // 5
        it = new Item("오번");
        vo = new ItemVo();
        vo.setCkYn("Y");
        vo.setText1("1");
        vo.setText2("2");
        vo.setText3("3");

        it.setItems(vo);
        list.add(it);

        // 6
        it = new Item("육번");
        vo = new ItemVo();
        vo.setCkYn("Y");
        vo.setText1("1");
        vo.setText2("2");
        vo.setText3("3");

        it.setItems(vo);
        list.add(it);

        // 7
        it = new Item("칠번");
        vo = new ItemVo();
        vo.setCkYn("Y");
        vo.setText1("1");
        vo.setText2("2");
        vo.setText3("3");

        it.setItems(vo);
        list.add(it);

        // 8
        it = new Item("팔번");
        vo = new ItemVo();
        vo.setCkYn("Y");
        vo.setText1("1");
        vo.setText2("2");
        vo.setText3("3");

        it.setItems(vo);
        list.add(it);

        // 9
        it = new Item("구번");
        vo = new ItemVo();
        vo.setCkYn("N");
        vo.setText1("1");
        vo.setText2("2");
        vo.setText3("3");

        it.setItems(vo);
        list.add(it);

        // 10
        it = new Item("십번");
        vo = new ItemVo();
        vo.setCkYn("N");
        vo.setText1("1");
        vo.setText2("2");
        vo.setText3("3");

        it.setItems(vo);
        list.add(it);
    }
    private CompoundButton.OnCheckedChangeListener onCheckedChange = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean Checked) {
            int fos = Integer.parseInt(String.valueOf(buttonView.getTag(R.id.TAG_ORDER_GROUP)));
            Item item = null;
            ExpandableAdapter adapter = (ExpandableAdapter) lvData.getExpandableListAdapter();
            item = adapter.getGroup(fos);

            if (Checked == true) {
                item.getItems().setCkYn("Y");
            } else if (Checked == false) {
                item.getItems().setCkYn("N");
            }

            adapter.notifyDataSetChanged();

        }
    };

    public class ExpandableAdapter extends BaseExpandableListAdapter {

        private Context context;
        private int groupLayout = 0;
        private int chlidLayout = 0;
        private ArrayList<Item> DataList;
        private LayoutInflater myinf = null;
        private ViewHolder viewHolder;

        public ExpandableAdapter(Context context, int groupLay, int chlidLay, ArrayList<Item> DataList) {
            this.DataList = DataList;
            this.groupLayout = groupLay;
            this.chlidLayout = chlidLay;
            this.context = context;
            this.myinf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = myinf.inflate(this.groupLayout, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.groupName = (TextView) convertView.findViewById(R.id.groupNm);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.groupName.setText(DataList.get(groupPosition).getGroupNm());
            return convertView;


        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            if (convertView == null) {
                convertView = myinf.inflate(this.chlidLayout, parent, false);
                viewHolder = new ViewHolder();

                viewHolder.childName1 = (TextView) convertView.findViewById(R.id.text1);
                viewHolder.childName2 = (TextView) convertView.findViewById(R.id.text2);
                viewHolder.childName3 = (TextView) convertView.findViewById(R.id.text3);
                viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);
                viewHolder.checkBox.setOnCheckedChangeListener(onCheckedChange);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.checkBox.setTag(R.id.TAG_ORDER_GROUP,groupPosition);
            final Item vo = DataList.get(groupPosition);
            viewHolder.childName1.setText(vo.getItems().getText1());
            viewHolder.childName2.setText(vo.getItems().getText2());
            viewHolder.childName3.setText(vo.getItems().getText3());
            if (vo.getItems().getCkYn().equals("Y")) {
                vo.getItems().setCkYn("Y");
                viewHolder.checkBox.setChecked(true);
            } else {
                vo.getItems().setCkYn("N");
                viewHolder.checkBox.setChecked(false);
            }

            return convertView;


        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return DataList.get(groupPosition).getItems();
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub
            return 1;
        }

        @Override
        public Item getGroup(int groupPosition) {
            // TODO Auto-generated method stub
            return DataList.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            // TODO Auto-generated method stub
            return DataList.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            // TODO Auto-generated method stub
            return groupPosition;
        }
    }

    class ViewHolder {
        TextView groupName;
        TextView childName1;
        TextView childName2;
        TextView childName3;
        CheckBox checkBox;
    }
}
