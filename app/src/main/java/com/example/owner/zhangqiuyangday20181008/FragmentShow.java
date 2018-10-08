package com.example.owner.zhangqiuyangday20181008;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.owner.zhangqiuyangday20181008.view.WaterView;

public class FragmentShow extends Fragment {
    private WaterView  mWaterView;
    private ImageView mImageView;
    private RelativeLayout.LayoutParams layoutParams;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.activity_fragment_show, null);
        mImageView =  view.findViewById(R.id.img_view);
        mWaterView =  view.findViewById(R.id.water_view);

        layoutParams = (RelativeLayout.LayoutParams) mImageView.getLayoutParams();
        mWaterView.animation(new WaterView.getBigView() {
            @Override
            public void success(float y) {
                layoutParams.setMargins(0,0,0, (int) y);
                mImageView.setLayoutParams(layoutParams);
            }
        });
        return  view;
    }
}
