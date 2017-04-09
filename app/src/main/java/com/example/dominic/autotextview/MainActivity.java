package com.example.dominic.autotextview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.paradoxie.autoscrolltextview.VerticalTextview;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private VerticalTextview mTextview;
    private ArrayList<String> mTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextview = (VerticalTextview) findViewById(R.id.text);
        
        initData();

        mTextview.setTextList(mTips);//加入显示内容,集合类型
        mTextview.setText(26, 5, Color.RED);//设置属性,具体跟踪源码        
        mTextview.setTextStillTime(3000);//设置停留时长间隔        
        mTextview.setAnimTime(300);//设置进入和退出的时间间隔        
        //对单条文字的点击监听 
        mTextview.setOnItemClickListener(new VerticalTextview.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "第" + position +"被点中了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        mTips = new ArrayList<>();
        mTips.add("赵丽颖");
        mTips.add("杨颖");
        mTips.add("郑爽");
        mTips.add("杨幂");
        mTips.add("刘诗诗");
        mTips.add("迪丽热巴");
        mTips.add("李沁");
        mTips.add("唐嫣");
        mTips.add("林心如");
        mTips.add("陈乔恩");
        mTips.add("范冰冰");
        mTips.add("刘亦菲");
        mTips.add("李小璐");
        mTips.add("佟丽娅");
    }

    //开始滚动
    @Override
    protected void onResume() {
        super.onResume();
        mTextview.startAutoScroll();
    }
    //停止滚动
    @Override
    protected void onPause() {
        super.onPause();
        mTextview.stopAutoScroll();
    }
}
