package com.example.cardview.horizontal;


import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class HorizontalListFragment extends Fragment {

    private int imageResource[] = {R.drawable.check_file,
            R.drawable.couple,
            R.drawable.dog,
            R.drawable.iphone,
            R.drawable.sheep};
    private ArrayList<Images> listItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int i;
        listItems = new ArrayList<>();
        for (i = 0; i < imageResource.length; i++) {
            Images images = new Images();
            images.setImageId(imageResource[i]);
            listItems.add(images);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
        if (listItems.size() > 0 && recyclerView != null) {
            recyclerView.setAdapter(new ImageApapter(listItems));
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }

    public class ImageApapter extends RecyclerView.Adapter<ImageApapter.MyHolder> {

        public class MyHolder extends RecyclerView.ViewHolder {

            public ImageView imageView;

            public MyHolder(View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.imageView);
            }
        }

        public ArrayList<Images> list;

        @Override
        public int getItemCount() {
            return list.size();
        }


        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_list, parent, false);
            MyHolder myHolder = new MyHolder(view);
            return myHolder;
        }

        public ImageApapter(ArrayList<Images> data) {
            list = data;
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.imageView.setImageResource(list.get(position).getImageId());
        }
    }

}
