package com.naeem.firststickersdemo.screens;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.naeem.firststickersdemo.R;
import com.naeem.firststickersdemo.adapters.StickersListAdapter;
import com.naeem.firststickersdemo.models.Sticker;
import com.naeem.firststickersdemo.models.StickerPack;
import com.naeem.firststickersdemo.utils.AddStickerPackActivity;
import com.naeem.firststickersdemo.utils.Constants;
import com.naeem.firststickersdemo.utils.Utilities;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StickersDetailScreen extends AddStickerPackActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.button_add)
    Button buttonAdd;
    @BindView(R.id.image_view)
    ImageView imageView;
    @BindView(R.id.text_view_name)
    TextView textViewName;
    @BindView(R.id.text_view_publisher)
    TextView textViewPublisher;
    private Context mContext;
    private StickerPack mStickerPack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stickers_detail_screen);
        ButterKnife.bind(this);
        mContext = StickersDetailScreen.this;
        initViews();
    }

    public void initViews() {
        initToolbar();
        mStickerPack = (StickerPack) getIntent().getSerializableExtra(Constants.STICKER_PACK);
        initRecyclerView();
        if (mStickerPack.getStickers() != null) {
            setRecyclerViewAdapter(mStickerPack.getStickers());
        }
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStickerPackToWhatsApp(mStickerPack.getIdentifier(), mStickerPack.getName());
            }
        });
        initDataOnViews();
    }

    public void initToolbar() {
        try {
            getSupportActionBar().setTitle("Sticker Pack");
            getSupportActionBar().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRecyclerViewAdapter(List<Sticker> list) {
        StickersListAdapter adapter = new StickersListAdapter(list, mContext, Utilities.stringToInt(mStickerPack.getIdentifier()));
        recyclerView.setAdapter(adapter);
    }

    public void initRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(mContext, 4);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
    }

    public void initDataOnViews() {
        if (mStickerPack != null) {
            if (!TextUtils.isEmpty(mStickerPack.getName())) {
                textViewName.setText(mStickerPack.getName());
            }

            if (!TextUtils.isEmpty(mStickerPack.getPublisher())) {
                textViewPublisher.setText(mStickerPack.getPublisher());
            }
Utilities.getIamgeFromAssets(mContext,imageView,Utilities.stringToInt(mStickerPack.getIdentifier()),mStickerPack.getTray_image_file());
        }
    }
}
