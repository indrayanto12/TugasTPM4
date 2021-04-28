package com.example.myrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<User> users;
    private Context context;

    public UserAdapter(ArrayList<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row_user, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final User user = users.get(position);

        Glide.with(holder.itemView.getContext())
                .load(user.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.ivPhoto);
        holder.tvName.setText(user.getName());
        holder.tvuUsername.setText(user.getUserName());
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Share User."+ users.get(holder.getAdapterPosition()).getUserName()+" User");
                sendIntent.setType("text/plain");

                context.startActivity(Intent.createChooser(sendIntent,"send to"));
            }
        });

        holder.cvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(context, UserDetail.class);
                sendIntent.putExtra("Name", user.getName());
                sendIntent.putExtra("UserName", user.getUserName());
                sendIntent.putExtra("Location", user.getLocation());
                sendIntent.putExtra("Sports", user.getCompany());
                sendIntent.putExtra("Medals", user.getRepository());
                sendIntent.putExtra("Followers", user.getFollowers());
                sendIntent.putExtra("Following", user.getFollowing());
                sendIntent.putExtra("photo", user.getPhoto());
                context.startActivity(sendIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvuUsername;
        ImageView ivPhoto;
        CardView cvCardView;
        RelativeLayout relativeLayout;
        ImageButton share;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_title);
            tvuUsername = itemView.findViewById(R.id.tv_tags);
            ivPhoto = itemView.findViewById(R.id.imgPhoto);
            cvCardView = itemView.findViewById(R.id.cv_cardView);
            relativeLayout = itemView.findViewById(R.id.rRelative);
            share = itemView.findViewById(R.id.Btnshare);
        }
    }
}
