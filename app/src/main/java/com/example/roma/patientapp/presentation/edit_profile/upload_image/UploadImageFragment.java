package com.example.roma.patientapp.presentation.edit_profile.upload_image;


import android.widget.TextView;

import com.example.roma.patientapp.R;
import com.example.roma.patientapp.presentation.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class UploadImageFragment extends BaseFragment {

    @BindView(R.id.photo_iv)
    CircleImageView photo_iv;

    @BindView(R.id.skip_tv)
    TextView skip_tv;

    @BindView(R.id.upload_photo_tv)
    TextView upload_photo_tv;


    @Override
    protected void initializeDagger() {

    }

    @Override
    protected void initializePresenter() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_upload_image;
    }

    @OnClick(R.id.upload_photo_tv)
    public void navigateToHomeActivity() {
        navigationManager.navigateToHomeActivity();
    }

    @OnClick(R.id.skip_tv)
    public void skip(){
        navigationManager.navigateToHomeActivity();
    }
}
