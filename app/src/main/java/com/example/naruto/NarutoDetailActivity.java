package com.example.naruto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.naruto.model.Naruto;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

public class NarutoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naruto_detail);

        Intent intent = getIntent();
        Naruto naruto = (Naruto) intent.getSerializableExtra(NarutoRecyclerAdapter.EXTRA_NARUTO);

        TextView narutoDetailTitle = findViewById(R.id.naruto_detail_title);
        TextView narutoDetailSynopsis = findViewById(R.id.naruto_detail_synopsis);
        TextView narutoDetailType = findViewById(R.id.naruto_detail_type);
        TextView narutoDetailEpisodes = findViewById(R.id.naruto_detail_epi);
        ImageView narutoDetailImg = findViewById(R.id.naruto_detail_img);

        narutoDetailTitle.setText(naruto.getTitle());
        narutoDetailSynopsis.setText(naruto.getSynopsis());
        narutoDetailType.setText(naruto.getType());
        narutoDetailEpisodes.setText(naruto.getEpisodes());

        Picasso.Builder builder = new Picasso.Builder(getApplicationContext());
        builder.downloader(new OkHttp3Downloader(getApplicationContext()))
                .build().load(naruto.getImage_url())
                .placeholder(R.drawable.baseline_image_black_48dp)
                .into(narutoDetailImg);
    }
}