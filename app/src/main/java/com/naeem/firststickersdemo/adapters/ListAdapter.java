package com.naeem.firststickersdemo.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naeem.firststickersdemo.R;
import com.naeem.firststickersdemo.models.StickerPack;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public  abstract class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    private List<StickerPack> mList;
    private Context mContext;

    public ListAdapter(List<StickerPack> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_single_list_item, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        StickerPack model = mList.get(position);
        if (!TextUtils.isEmpty(model.getName())) {
            holder.textView.setText(model.getName());
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_view)
        TextView textView;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickStickerPack(mList.get(getAdapterPosition()));
                }
            });
        }
    }
    public abstract void onClickStickerPack(StickerPack stickerPack);
}
