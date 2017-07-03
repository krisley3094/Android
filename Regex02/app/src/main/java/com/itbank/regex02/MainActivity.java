package com.itbank.regex02;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private EditText sample;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.input);
        sample = (EditText)findViewById(R.id.sample);
        result = (TextView)findViewById(R.id.result);

        String text = "Welcome to RegExr v2.1 by gskinner.com, proudly hosted by Media Temple!\n" +
                "\n" +
                "Edit the Expression & Text to see matches. Roll over matches or the expression for details. Undo mistakes with ctrl-z. Save Favorites & Share expressions with friends or the Community. Explore your results with Tools. A full Reference & Help is available in the Library, or watch the video Tutorial.\n" +
                "\n" +
                "Sample text for testing:\n" +
                "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ\n" +
                "0123456789 _+-.,!@#$%^&*();\\/|<>\"'\n" +
                "12345 -98.7 3.141 .6180 9,000 +42\n" +
                "555.123.4567\t+1-(800)-555-2468\n" +
                "foo@demo.net\tbar.ba@test.co.uk\n" +
                "www.demo.com\thttp://foo.co.uk/\n" +
                "http://regexr.com/foo.html?q=bar\n" +
                "https://mediatemple.net\n" +
                "\n" +
                "가나다라마바 사아자차 카타파하\n" +
                "안녕\n" +
                "하이\n";

        sample.setText(text);

        //input의 내용이 변경될 때마다 처리할 대상으로 finder를 설정
        input.addTextChangedListener(finder);
    }

    //sample의 글자를 검색하는 이벤트 처리 도구 생성(적용대상 : input)
    private Finder finder = new Finder();
    private class Finder implements TextWatcher{
        private SpannableStringBuilder spannable;
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            input.removeTextChangedListener(finder);

            try{
                String regex = input.getText().toString();  //검사식
                String text = sample.getText().toString(); //검사 대상
                //검사 어쩌구저쩌구.....(여기가 핵심)

                //Pattern , Matcher라는 클래스 두 개를 이용하여 검사를 구현
                //Matcher의 기능
                //.find()       탐색 결과가 존재하는가
                //.group()    탐색 결과를 반환하라
                //.start()      탐색 위치의 시작지점을 반환하라
                //.end()       탐색 위치의 종료지점을 반환하라

                Pattern p = Pattern.compile(regex);         //[1] 정규표현식을 검사 가능한 패턴으로 변경
                Matcher m = p.matcher(text);                 //[2] 만들어진 패턴으로 text를 검사한 결과를 m에 저장

                StringBuffer buffer = new StringBuffer();
                while(m.find()){
                    buffer.append("탐지 : "+m.group()+", 시작="+m.start()+", 종료="+m.end()+"\n");
                }
                result.setText(buffer.toString());

                //색상을 변경하는 코드
                spannable = new SpannableStringBuilder(text);
                p = Pattern.compile(regex);
                m = p.matcher(text);
                while(m.find()){
                    //필요한 변경 색상 설정
                    spannable.setSpan(new StyleSpan(Typeface.BOLD), m.start(), m.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    spannable.setSpan(new ForegroundColorSpan(Color.rgb(0, 0, 255)), m.start(), m.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }

                //변경된 내용 최종 적용 처리
                sample.setText(spannable);
                sample.setSelection(spannable.length());
            }catch(Exception e){}

            input.addTextChangedListener(finder);
        }
        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
}
