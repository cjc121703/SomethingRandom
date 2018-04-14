package com.example.christinecarroll.somethingrandom;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by christinecarroll on 4/8/18.
 */

public class RandomThingsListAdapter extends RecyclerView.Adapter<RandomThingsListAdapter.MyViewHolder> {

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mMytextview;
        private TextView numberOfTimesView;

        public MyViewHolder(View itemView){
            super(itemView);
            mMytextview = itemView.findViewById(R.id.list_item_textview);
            numberOfTimesView = itemView.findViewById(R.id.item_picked_count);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);

        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        Log.e("Outputing item number ", Integer.toString(position));

        RandomThing randomThing = RandomThingHolder.getInstance().getRandomThings().get(position);
        Log.e("name", randomThing.getName());
        holder.mMytextview.setText(randomThing.getName());
        holder.numberOfTimesView.setText(Integer.toString(randomThing.getNumberOfTimesPicked()));
    }

    @Override
    public int getItemCount(){
        Log.e("Total items: ", Integer.toString(RandomThingHolder.getInstance().getRandomThings().size()));
        return RandomThing.randomThings.size();
    }
}
