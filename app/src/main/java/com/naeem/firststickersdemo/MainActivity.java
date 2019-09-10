package com.naeem.firststickersdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.naeem.firststickersdemo.adapters.ListAdapter;
import com.naeem.firststickersdemo.models.StickerPack;
import com.naeem.firststickersdemo.screens.StickersDetailScreen;
import com.naeem.firststickersdemo.utils.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private Context mContext;

    public static final String CONTENT_FILE_NAME = "contents.json";
    private List<StickerPack> mStickerPackList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = MainActivity.this;
        initViews();
    }

    public void initViews() {
        initRecyclerView(mContext, recyclerView);
//        List<StickerPack> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            StickerPack model = new StickerPack();
//            model.setName("Sticker " + i);
//            list.add(model);
//        }
        readContentFile(this);
        if (mStickerPackList!=null) {
            ListAdapter adapter = new ListAdapter(mStickerPackList, mContext) {
                @Override
                public void onClickStickerPack(StickerPack stickerPack) {
                    startActivity(new Intent(mContext, StickersDetailScreen.class).putExtra(Constants.STICKER_PACK,stickerPack));
                }
            };
            recyclerView.setAdapter(adapter);
        }
    }


    private synchronized void readContentFile(@NonNull Context context) {
//        try (InputStream contentsInputStream = context.getAssets().open(CONTENT_FILE_NAME)) {
//            mStickerPackList = ContentFileParser.parseStickerPacks(contentsInputStream);
//        } catch (IOException | IllegalStateException e) {
//            throw new RuntimeException(CONTENT_FILE_NAME + " file has some issues: " + e.getMessage(), e);
//        }
        try {
            String json = getAssetJsonData(context);
            Type type = new TypeToken<List<StickerPack>>() {
            }.getType();
            mStickerPackList = new Gson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAssetJsonData(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(CONTENT_FILE_NAME);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Log.e("data", json);
        return json;

    }
}
