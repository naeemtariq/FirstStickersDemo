package com.naeem.firststickersdemo.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.naeem.firststickersdemo.R;
import com.naeem.firststickersdemo.models.Sticker;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StickersListAdapter extends RecyclerView.Adapter<StickersListAdapter.StickersListHolder> {

    private List<Sticker> mList;
    private Context mContext;
private int identifire;
    public StickersListAdapter(List<Sticker> mList, Context mContext,int id) {
        this.mList = mList;
        this.mContext = mContext;
        this.identifire=id;
    }

    @NonNull
    @Override
    public StickersListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_single_sticker_view, parent, false);
        return new StickersListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StickersListHolder holder, int position) {
Sticker sticker=mList.get(position);
if (!TextUtils.isEmpty(sticker.getImage_file()))
{
    setImage(holder.imageView,sticker.getImage_file());
}
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class StickersListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_view)
        ImageView imageView;
        public StickersListHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public void setImage(ImageView imageView,String imageName) {
        try {
            // get input stream
            InputStream ims =mContext. getAssets().open(identifire+"/"+imageName);
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView.setImageDrawable(d);
            ims.close();
        } catch (IOException ex) {
            return;
        }
    }

}
