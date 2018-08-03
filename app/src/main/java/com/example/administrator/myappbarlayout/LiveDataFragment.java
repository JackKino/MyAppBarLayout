package com.example.administrator.myappbarlayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LiveDataFragment extends Fragment {

    private static final String TAG = "LiveDataFragment";
    private NameViewModel mNameViewModel;
   /* @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.change_name)
    Button change_name;*/

    public static LiveDataFragment getInstance(){
        return new LiveDataFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* mNameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);
        mNameViewModel.getCurrentName().observe(this,(String name) -> {
            mTvName.setText(name);
           // Log.d(TAG, "currentName: " + name);
        }); // 订阅LiveData中当前Name数据变化，以lambda形式定义Observer
        mNameViewModel.getNameList().observe(this, (List<String> nameList) -> {
            for (String item : nameList) {
              //  Log.d(TAG, "name: " + item);
            }
        });*/ // 订阅LiveData中Name列表数据变化，以lambda形式定义Observer
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_livedata, container, false);
       // ButterKnife.bind(this, view);
        return view;
    }

   /* @OnClick({R.id.change_name})
    void onClicked(View view){
        switch (view.getId()){
            case R.id.change_name:
                mNameViewModel.getCurrentName().setValue("Jane");
                break;

        }
    }*/
}
