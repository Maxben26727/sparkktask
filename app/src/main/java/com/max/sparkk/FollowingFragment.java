package com.max.sparkk;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FollowingFragment extends Fragment {
    private Context mctx;
    private List<FollowingViewModel> followingDataList =new ArrayList<>();
    RecyclerView following_recyclerview;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.following_fragment, container, false);
        mctx=view.getContext();

        following_recyclerview =view.findViewById(R.id.following_recycler);
        following_recyclerview.setHasFixedSize(true);
        following_recyclerview.setLayoutManager(new LinearLayoutManager(mctx));

        FollowingViewModel data1=new FollowingViewModel("mr_m","shivansh sharma","default.png",1);
        FollowingViewModel data2=new FollowingViewModel("mr_m","shivansh sharma","default.png",1);
        FollowingViewModel data3=new FollowingViewModel("mr_m","shivansh sharma","default.png",1);
        FollowingViewModel data4=new FollowingViewModel("mr_m","shivansh sharma","default.png",1);
        FollowingViewModel data5=new FollowingViewModel("mr_m","shivansh sharma","default.png",1);

        followingDataList.add(data1);
        followingDataList.add(data2);
        followingDataList.add(data3);
        followingDataList.add(data4);
        followingDataList.add(data5);


        following_dataAdapter adapter=new following_dataAdapter(mctx, followingDataList);
        following_recyclerview.setAdapter(adapter);

        return view;
    }


}