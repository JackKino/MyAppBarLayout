package com.example.administrator.myappbarlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.AppFragment_AppBarLayout)
    AppBarLayout appFragment_AppBarLayout;
    @Bind(R.id.AppFragment_CollapsingToolbarLayout)
    CollapsingToolbarLayout AppFragment_CollapsingToolbarLayout;
    @Bind(R.id.AppFragment_Toolbar)
    Toolbar appFragment_Toolbar;
    @Bind(R.id.AppFragment_recyclerView)
    RecyclerView appFragment_recyclerView;
    private MyAdapter recycleAdapter;
    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ButterKnife.bind(this);


        appFragment_AppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
               // Toast.makeText(MainActivity.this,"flling",Toast.LENGTH_LONG).show();
                appFragment_Toolbar.setBackgroundColor(changeAlpha(getResources().getColor(R.color.colorPrimary), Math.abs(verticalOffset * 1.0f) / appBarLayout.getTotalScrollRange()));
            }
        });
        datas=new ArrayList<>();
        for (int i=0;i<30;i++){
            datas.add("Hello");
        }

        recycleAdapter=new MyAdapter(this,datas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//设置布局管理器
        appFragment_recyclerView.setLayoutManager(layoutManager);
//设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
//设置Adapter
        appFragment_recyclerView.setAdapter(recycleAdapter);
        //设置分隔线
        appFragment_recyclerView.addItemDecoration(new DividerItemDecoration(this,1));
//设置增加或删除条目的动画
        appFragment_recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /**
     * 根据百分比改变颜色透明度
     */
    public int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }


}
