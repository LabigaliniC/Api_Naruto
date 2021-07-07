package com.example.naruto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naruto.model.Naruto;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NarutoRecyclerAdapter extends RecyclerView.Adapter<NarutoRecyclerAdapter.NarutoViewHolder>{
    Context context;
    List<Naruto> narutos;
    public static final String EXTRA_NARUTO = "EXTRA_NARUTO";

    public NarutoRecyclerAdapter(Context context, List<Naruto> narutos) {
        this.context = context;
        this.narutos = narutos;
    }

    public void setNarutos(List<Naruto> narutos) {
        this.narutos = narutos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NarutoRecyclerAdapter.NarutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.naruto_recyclerview_layout, parent, false);
        return new NarutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NarutoRecyclerAdapter.NarutoViewHolder holder, int position) {
        Naruto naruto = narutos.get(position);
        holder.narutoTitle.setText(naruto.getTitle());
        holder.narutoType.setText(naruto.getType());
        holder.narutoEpisodes.setText(naruto.getEpisodes());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context))
                .build().load(naruto.getImage_url())
                .placeholder(R.drawable.baseline_image_black_48dp)
                .into(holder.narutoImage);

    }

    @Override
    public int getItemCount() {
        if (narutos != null){
            return narutos.size();
        }
        return 0;
    }

    public class NarutoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView narutoTitle;
        TextView narutoEpisodes;
        TextView narutoType;
        ImageView narutoImage;

        public NarutoViewHolder(@NonNull View itemView) {
            super(itemView);
            narutoTitle = itemView.findViewById(R.id.naruto_name);
            narutoEpisodes = itemView.findViewById(R.id.naruto_epi);
            narutoType = itemView.findViewById(R.id.naruto_type);
            narutoImage = itemView.findViewById(R.id.naruto_img);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, NarutoDetailActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(EXTRA_NARUTO, narutos.get(position));
            context.startActivity(intent);
        }
    }
}
