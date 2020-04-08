package com.sidchiku9.adgtask3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<sampleItem> mSampleItems;

   public static class ExampleViewHolder extends RecyclerView.ViewHolder{
       public TextView mTextView1;
       public TextView mTextView2;

       public ExampleViewHolder(@NonNull View itemView) {
           super(itemView);
           mTextView1 = itemView.findViewById(R.id.sh);
           mTextView2 = itemView.findViewById(R.id.sc);
       }
   }

   public ExampleAdapter(ArrayList<sampleItem> sampleItems){
            mSampleItems = sampleItems;
   }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_item,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        sampleItem currentItem = mSampleItems.get(position);

        holder.mTextView1.setText(currentItem.getHeading());
        holder.mTextView2.setText(currentItem.getContent());
    }

    @Override
    public int getItemCount() {
        return mSampleItems.size();
    }
}
