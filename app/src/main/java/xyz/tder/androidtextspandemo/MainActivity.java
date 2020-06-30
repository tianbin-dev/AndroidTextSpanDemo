package xyz.tder.androidtextspandemo;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int redColor = Color.parseColor("#ff0000");
    private int whiteColor = Color.parseColor("#ffffff");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTextSpan1();
        initTextSpan2();
        initTextSpan3();
        initTextSpan4();
    }

    private void initTextSpan1() {
        TextView tvSameHeightSpan = findViewById(R.id.tv_span1);
        SpannableString spannableString = new SpannableString("我是哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        TagSpan tagSpan = new TagSpan(Paint.Style.STROKE, redColor, redColor, sp2px(16), 3, 10, 10, 10);
        spannableString.setSpan(tagSpan, 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        TagSpan tagSpan1 = new TagSpan(Paint.Style.STROKE, redColor, redColor, sp2px(16), 3, 10, 10, 10);
        spannableString.setSpan(tagSpan1, 7, 18, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvSameHeightSpan.setText(spannableString);
    }

    private void initTextSpan2() {
        TextView tvSameHeightSpan = findViewById(R.id.tv_span2);
        SpannableString spannableString = new SpannableString("我是哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        TagSpan tagSpan2 = new TagSpan(Paint.Style.FILL, whiteColor, redColor, sp2px(16), 3, 10, 10, 10);
        spannableString.setSpan(tagSpan2, 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvSameHeightSpan.setText(spannableString);
    }

    private void initTextSpan3() {
        TextView tvSameHeightSpan = findViewById(R.id.tv_span3);
        SpannableString spannableString = new SpannableString("我是哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        TagSpan tagSpan2 = new TagSpan(Paint.Style.STROKE, redColor, redColor, sp2px(16), 3, 10, 10, 10, 20, 20);
        spannableString.setSpan(tagSpan2, 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvSameHeightSpan.setText(spannableString);
    }

    private void initTextSpan4() {
        TextView tvSameHeightSpan = findViewById(R.id.tv_span4);
        SpannableString spannableString = new SpannableString("我是哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        TagSpan tagSpan2 = new TagSpan(Paint.Style.FILL, whiteColor, redColor, sp2px(16), 3, 10, 10, 10, 20, 20);
        spannableString.setSpan(tagSpan2, 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvSameHeightSpan.setText(spannableString);
    }


    public int sp2px(float spValue) {
        return Math.round(spValue * getResources().getDisplayMetrics().scaledDensity);
    }
}
