package com.example.administrator.myappbarlayout;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity implements LifecycleOwner{
    private static final String TAG = "LiveDataFragment";
    private NameViewModel mNameViewModel;
    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.change_name)
    Button change_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_livedata);
        mNameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);
        Log.i(TAG,"mNameViewModel not null  "+mNameViewModel.getCurrentName());
        if(mNameViewModel!=null) {
            Log.i(TAG,"mNameViewModel not null");
         /*   mNameViewModel.getCurrentName().observe(this, (String name) -> {
                mTvName.setText(name);
                // Log.d(TAG, "currentName: " + name);
            }); // 订阅LiveData中当前Name数据变化，以lambda形式定义Observer*/

            mNameViewModel.getCurrentName().observe(this, new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    mTvName.setText(s);
                }
            });

         /*   mNameViewModel.getNameList().observe(this, (List<String> nameList) -> {
                for (String item : nameList) {
                    // Log.d(TAG, "name: " + item);
                }
            }); // 订阅LiveData中Name列表数据变化，以lambda形式定义Observer*/
        }else{
            Log.i(TAG,"mNameViewModel null");

        }
    }

    @OnClick({R.id.change_name})
    void onClicked(View view){
        switch (view.getId()){
            case R.id.change_name:
                mNameViewModel.getCurrentName().setValue("Jane");
                break;

        }
    }
}
