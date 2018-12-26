package com.example.java.a_zapp;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AutoCompleteTextView extends Activity implements View.OnClickListener, TextWatcher, AdapterView.OnItemClickListener {
    android.widget.AutoCompleteTextView autoCompleteTextView1, autoCompleteTextView2;
    ListView lv1, lv2;
    ArrayList<String> base;
    ArrayList<SpannableStringBuilder> datas;
    ArrayAdapter<SpannableStringBuilder> spannbleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_complete);
        autoCompleteTextView1 = findViewById(R.id.atcTv1);
        autoCompleteTextView2 = findViewById(R.id.atcTv2);
        lv1 = findViewById(R.id.lv1);
        lv2 = findViewById(R.id.lv2);

        // 1
        String[] COUNTRIES = new String[]{
                "Belgium", "France", "Italy", "Germany", "Spain"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        autoCompleteTextView1.setAdapter(adapter);
        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
        lv1.setAdapter(adapter1);

        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AutoCompleteTextView.this, autoCompleteTextView1.getText(), Toast.LENGTH_SHORT).show();
                list.add(autoCompleteTextView1.getText().toString());
                adapter1.notifyDataSetChanged();
                autoCompleteTextView1.setText("");
            }
        });
        // 2
        dataSet();
        datas = new ArrayList<>();

        ArrayAdapter<String> baseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, base);

        lv2.setAdapter(baseAdapter);
        lv2.setOnItemClickListener(this);

        autoCompleteTextView2.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    private void dataSet(){
        base = new ArrayList<>();
        base.add("권래다");
        base.add("오걸두");
        base.add("위빈상");
        base.add("남심가");
        base.add("염지묵");
        base.add("옥래삼");
        base.add("신웅직");
        base.add("함백자");
        base.add("허을율");
        base.add("표흥바");
        base.add("전량운");
        base.add("구항탁");
        base.add("편운신");
        base.add("인솜길");
        base.add("성덕동");
        base.add("옥린재");
        base.add("신강뜸");
        base.add("최고덕");
        base.add("이별솜");
        base.add("강학경");
        base.add("강덕봉");
        base.add("엄숭강");
        base.add("조진빈");
        base.add("기리용");
        base.add("탁조옥");
        base.add("추바후");
        base.add("남은길");
        base.add("백일시");
        base.add("문설타");
        base.add("길손애");
        base.add("채원조");
        base.add("백월해");
        base.add("곽옥석");
        base.add("하선송");
        base.add("주더형");
        base.add("남모율");
        base.add("어산묵");
        base.add("배고문");
        base.add("길술잎");
        base.add("노훈단");
        base.add("모여잎");
        base.add("진혜들");
        base.add("용담현");
        base.add("여열울");
        base.add("허휘주");
        base.add("방향용");
        base.add("왕직만");
        base.add("설리미");
        base.add("어길도");
        base.add("표건새");
        base.add("오서찬");
        base.add("임출석");
        base.add("백혜의");
        base.add("황시송");
        base.add("송다회");
        base.add("황엽번");
        base.add("길항훈");
        base.add("홍만엄");
        base.add("심언자");
        base.add("곽회라");
        base.add("채려열");
        base.add("길더얀");
        base.add("임권조");
        base.add("한의혜");
        base.add("옥상평");
        base.add("조병바");
        base.add("강미헌");
        base.add("탁하달");
        base.add("주섭중");
        base.add("방향석");
        base.add("유비철");
        base.add("설손무");
        base.add("이천비");
        base.add("맹묵보");
        base.add("성도울");
        base.add("박순자");
        base.add("황견채");
        base.add("임영애");
        base.add("차더익");
        base.add("남묵현");
        base.add("정한새");
        base.add("연문희");
        base.add("길요흥");
        base.add("주디변");
        base.add("우희덕");
        base.add("주하소");
        base.add("탁엽설");
        base.add("양으자");
        base.add("박술늬");
        base.add("임헌춘");
        base.add("용배란");
        base.add("최탁더");
        base.add("박회휴");
        base.add("용양번");
        base.add("주추형");
        base.add("나동길");
        base.add("모영판");
        base.add("전훔늘");
        base.add("선인정");
        base.add("신고봉");

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        datas = new ArrayList<>();
        for(String txt : base){
            if(txt.contains(s)){
                int startPos = txt.indexOf(s.toString());
                int endPos = startPos+s.length();
                SpannableStringBuilder builder = new SpannableStringBuilder(txt);
                builder.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                builder.setSpan(new StyleSpan(Typeface.BOLD),startPos,endPos,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                datas.add(builder);
            }
        }
        spannbleAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datas);
        lv2.setAdapter(spannbleAdapter);

    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(AutoCompleteTextView.this, String.valueOf(parent.getAdapter().getItem(position)), Toast.LENGTH_SHORT).show();

        String value = String.valueOf(parent.getAdapter().getItem(position));
        autoCompleteTextView2.setText(value);

        ArrayList<String> emptyData = new ArrayList<String>();
        ArrayAdapter<String> baseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, emptyData);
        lv2.setAdapter(baseAdapter);

        autoCompleteTextView2.setSelection(value.length());
        autoCompleteTextView2.requestFocus();
        autoCompleteTextView2.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
