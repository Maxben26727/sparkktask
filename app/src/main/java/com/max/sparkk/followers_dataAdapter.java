package com.max.sparkk;


import android.app.ProgressDialog;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class followers_dataAdapter extends RecyclerSwipeAdapter<followers_dataViewHolder> {
    private Context mctx;
    private List<FollowersViewModel> followers_datalist;

    public followers_dataAdapter(Context mctx, List<FollowersViewModel> followers_datalist) {
        this.mctx = mctx;
        this.followers_datalist = followers_datalist;
    }

    @NonNull
    @Override
    public followers_dataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mctx);
        View view = inflater.inflate(R.layout.followers_item_layout, null);
        return new followers_dataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final followers_dataViewHolder holder, final int position) {
        holder.swipe.setShowMode(SwipeLayout.ShowMode.LayDown);
        holder.swipe.addDrag(SwipeLayout.DragEdge.Right,holder.swipe.findViewById(R.id.bottom));
        holder.swipe.addDrag(SwipeLayout.DragEdge.Left,holder.swipe.findViewById(R.id.bottom2));
        holder.name.setText(followers_datalist.get(position).getName());
        holder.username.setText(followers_datalist.get(position).getUsername());
        if(followers_datalist.get(position).getImage_url()=="default.png") {
            holder.profilepic.setImageDrawable(mctx.getDrawable(R.drawable.photoceo));

        }else
        {
            Glide.with(mctx).load(followers_datalist.get(position).image_url).into(holder.profilepic);

        }
        if(followers_datalist.get(position).getFollowing()==0) {
            holder.follow_btn.setText("Follow");
            holder.follow_btn.setBackground(mctx.getDrawable(R.drawable.btn_blue_bg));

        }
        holder.follow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(followers_datalist.get(position).getFollowing()==0) {
                    holder.follow_btn.setText("Following");
                    holder.follow_btn.setBackground(mctx.getDrawable(R.drawable.btn_gray_bg));
                    FollowersFragment.sortedlist.get(position).setFollowing(1);
                    notifyDataSetChanged();
                }
                else
                {
                    holder.follow_btn.setText("Follow");
                    holder.follow_btn.setBackground(mctx.getDrawable(R.drawable.btn_blue_bg));
                    FollowersFragment.sortedlist.get(position).setFollowing(0);
                    notifyDataSetChanged();
                }
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return followers_datalist.size();
    }


    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }
}

class followers_dataViewHolder extends RecyclerView.ViewHolder {
    CircleImageView profilepic;
    TextView name, username;
    Button follow_btn;
    SwipeLayout swipe;
    ImageButton delete,mute,message,call;

    followers_dataViewHolder(View itemView) {
        super(itemView);
        profilepic=itemView.findViewById(R.id.profile_pic);
        name=itemView.findViewById(R.id.name);
        username=itemView.findViewById(R.id.username);
        follow_btn=itemView.findViewById(R.id.follow_btn);
        swipe=itemView.findViewById(R.id.swipe);
        delete=itemView.findViewById(R.id.delete);
        mute=itemView.findViewById(R.id.mute);
        message=itemView.findViewById(R.id.message);
        swipe=itemView.findViewById(R.id.call);


    }
}