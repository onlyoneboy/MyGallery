package com.example.admin.mygallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";

    private RecyclerView photoRecyclerView;
    private List<GalleryItem> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        photoRecyclerView = findViewById(R.id.photo_gallery_recycler_view);
        photoRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private class PhotoHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;

        public PhotoHolder(View itemView) {
            super(itemView);
            itemView = itemView.findViewById(R.id.photo_gallery_image_view);
        }
    }

    private class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {
        private List<GalleryItem> mGalleryItems;

        private PhotoAdapter(List<GalleryItem> items) {
            mGalleryItems = items;
        }

        @Override
        public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(GalleryActivity.this);
            View v = inflater.inflate(R.layout.gallery_item, parent);
            return new PhotoHolder(v);
        }

        @Override
        public void onBindViewHolder(PhotoHolder holder, int position) {
            GalleryItem galleryItem = mGalleryItems.get(position);
            Picasso.with(GalleryActivity.this).load(galleryItem.getUrl()).into(holder.itemImageView);
        }

        @Override
        public int getItemCount() {
            return mGalleryItems.size();
        }
    }
}
