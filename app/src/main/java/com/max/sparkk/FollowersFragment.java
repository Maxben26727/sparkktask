package com.max.sparkk;

import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.swipe.util.Attributes;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FollowersFragment extends Fragment  {
    private Context mctx;
    private TabLayout tabLayout;
    public static List<FollowersViewModel> followersDataList=new ArrayList<>();
    public static List<FollowersViewModel> sortedlist=new ArrayList<>();
    public static followers_dataAdapter adapter;
    RecyclerView followers_recyclerview;
    private static final int SWIPE_THRESHOLD = 20;
    private static final int SWIPE_VELOCITY_THRESHOLD = 20;
    private GestureDetector gestureDetector;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.followers_fragment, container, false);
        mctx=view.getContext();
        tabLayout=view.findViewById(R.id.tabLayout);
        followers_recyclerview=view.findViewById(R.id.followers_recycler);
        followers_recyclerview.setHasFixedSize(true);
        followers_recyclerview.setLayoutManager(new LinearLayoutManager(mctx));


        tabLayout.setTabTextColors(Color.parseColor("#ffffff"),Color.parseColor("#29C68F"));
        tabLayout.setBackground(mctx.getDrawable(R.drawable.tab_bg_green));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               switch (tab.getPosition())
               {
                   case 0:tabLayout.setTabTextColors(Color.parseColor("#ffffff"),Color.parseColor("#29C68F"));
                            tabLayout.setBackground(mctx.getDrawable(R.drawable.tab_bg_green));
                            sort_data("personal");
                        break;
                   case 1:tabLayout.setTabTextColors(Color.parseColor("#ffffff"),Color.parseColor("#2972C6"));
                       tabLayout.setBackground(mctx.getDrawable(R.drawable.tab_bg));
                       sort_data("professional");
                       break;
                   case 2:tabLayout.setTabTextColors(Color.parseColor("#ffffff"),Color.parseColor("#7829C6"));
                       tabLayout.setBackground(mctx.getDrawable(R.drawable.tab_bg_purple));
                       sort_data("public");
                       break;

               }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }

        });
        gestureDetector=new GestureDetector(mctx, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {


                try {
                    float diffY = e2.getY() - e1.getY();
                    float diffX = e2.getX() - e1.getX();
                    if (Math.abs(diffX) > Math.abs(diffY)) {
                        if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(v) > SWIPE_VELOCITY_THRESHOLD) {
                            if (diffX > 0) {
                                Toast.makeText(mctx, "swipe right", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(mctx, "swipe left", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else {
                        if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(v1) > SWIPE_VELOCITY_THRESHOLD) {
                            if (diffY > 0) {
                               // onSwipeDown();
                            } else {
                               // onSwipeUp();
                            }
                        }
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    Toast.makeText(mctx, exception.toString(), Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

        return view;
    }
    private void sort_data(String type)
    {
        sortedlist.clear();
        for(FollowersViewModel data: followersDataList)
        {
            if(type=="personal" && data.getPersonal()==1&&data.getProfessional()==0)
                sortedlist.add(data);
            else if(type=="professional" && data.getPersonal()==0&&data.getProfessional()==1)
                sortedlist.add(data);
            else if(type=="personal" && data.getPersonal()==1&&data.getProfessional()==1)
                sortedlist.add(data);
            else if(type=="professional" && data.getPersonal()==1&&data.getProfessional()==1)
                sortedlist.add(data);
            else if(type=="public" && data.getPersonal()==0&&data.getProfessional()==0)
                sortedlist.add(data);


        }
        adapter=new followers_dataAdapter(mctx,sortedlist);
        ((followers_dataAdapter) adapter).setMode(Attributes.Mode.Single);
        followers_recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

private void fetch_data()
{
    followersDataList.clear();
    FollowersViewModel data1=new FollowersViewModel("mr_m","shivansh sharma","default.png",0,1,1,1);
    FollowersViewModel data2=new FollowersViewModel("max","Max Ben","default.png",1,0,1,0);
    FollowersViewModel data3=new FollowersViewModel("jack_sparrow","Nelson","default.png",0,0,1,0);
    FollowersViewModel data4=new FollowersViewModel("cutee_pie","shakshi","default.png",1,1,1,0);
    FollowersViewModel data5=new FollowersViewModel("terminator","Billal Khan","default.png",0,0,1,1);

    followersDataList.add(data1);
    followersDataList.add(data2);
    followersDataList.add(data3);
    followersDataList.add(data4);
    followersDataList.add(data5);


}

    @Override
    public void onStart() {
        super.onStart();
        fetch_data();
        sortedlist.clear();
        sort_data("personal");
    }


}