package com.max.sparkk;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class following_dataAdapter extends RecyclerView.Adapter<following_dataViewHolder> {
    private Context mctx;
    private List<FollowingViewModel> following_datalist;

    public following_dataAdapter(Context mctx, List<FollowingViewModel> following_datalist) {
        this.mctx = mctx;
        this.following_datalist = following_datalist;
    }

    @NonNull
    @Override
    public following_dataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mctx);
        View view = inflater.inflate(R.layout.following_item_layout, null);
        return new following_dataViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull following_dataViewHolder holder, int position) {
        holder.name.setText(following_datalist.get(position).getName());
        holder.username.setText(following_datalist.get(position).getUsername());
        if(following_datalist.get(position).getImage_url()=="default.png") {
            holder.profilepic.setImageDrawable(mctx.getDrawable(R.drawable.photoceo));

        }else
        {
            Glide.with(mctx).load(following_datalist.get(position).image_url).into(holder.profilepic);

        }



    }

    @Override
    public int getItemCount() {
        return following_datalist.size();
    }


}

class following_dataViewHolder extends RecyclerView.ViewHolder {
    CircleImageView profilepic;
    TextView name, username;
    Button follow_btn;
    ImageButton more_btn;

    following_dataViewHolder(View itemView) {
        super(itemView);
        profilepic=itemView.findViewById(R.id.profile_pic);
        name=itemView.findViewById(R.id.name);
        username=itemView.findViewById(R.id.username);
        follow_btn=itemView.findViewById(R.id.follow_btn);
        more_btn=itemView.findViewById(R.id.more_btn);


    }
}