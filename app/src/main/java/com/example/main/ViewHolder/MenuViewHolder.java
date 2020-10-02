package com.example.main.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.main.Interface.ItemClickListener;
import com.example.main.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

   public TextView txtMenuName;
   public ImageView imageView;


   public MenuViewHolder(View itemView){
       super(itemView);

       txtMenuName = (TextView)itemView.findViewById(R.id.menu_name);
       imageView=(ImageView)itemView.findViewById(R.id.imageView);
       itemView.setOnClickListener(this);


   }
   public void setItemClickListener(ItemClickListener itemClickListener){
       this.itemClickListener=itemClickListener;
   }


    @Override
    public void onClick(View v) {
       itemClickListener.onClick(view,getAdapterPosition(),false);



    }




}
