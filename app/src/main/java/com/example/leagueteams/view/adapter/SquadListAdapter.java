package com.example.leagueteams.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leagueteams.R;
import com.example.leagueteams.model.SquadEntity;
import com.example.leagueteams.model.TeamEntity;
import com.example.leagueteams.util.Extras;
import com.example.leagueteams.view.activity.TeamDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class SquadListAdapter extends
        RecyclerView.Adapter<SquadListAdapter.ViewHolder> {

    private List<SquadEntity> squadEntities;
    private Context context;

    public SquadListAdapter(Context context) {
        squadEntities = new ArrayList<>();
        this.context = context;
    }


    @Override
    public SquadListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team_squad_list,
                parent, false);
        return new SquadListAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SquadEntity squadEntity = squadEntities.get(position);
        holder.playerName.setText(squadEntity.getName());
        holder.playerPos.setText(squadEntity.getPosition());


    }

    @Override
    public int getItemCount() {
        return squadEntities.size();
    }

    public void setList(List<SquadEntity> squadEntity) {
        this.squadEntities = squadEntity;
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView playerName, playerPos;

        ViewHolder(final View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.player_name);
            playerPos = itemView.findViewById(R.id.player_position);


        }
    }


}