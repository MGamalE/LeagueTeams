package com.example.leagueteams.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leagueteams.R;
import com.example.leagueteams.model.TeamEntity;
import com.example.leagueteams.util.Extras;
import com.example.leagueteams.view.activity.TeamDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class TeamsListAdapter extends
        RecyclerView.Adapter<TeamsListAdapter.ViewHolder> {

    private List<TeamEntity> teamsEntities;
    private Context context;

    public TeamsListAdapter(Context context) {
        teamsEntities = new ArrayList<>();
        this.context = context;
    }


    @Override
    public TeamsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team_list,
                parent, false);
        return new TeamsListAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TeamEntity teamEntity = teamsEntities.get(position);
        holder.teamName.setText(teamEntity.getName());


    }

    @Override
    public int getItemCount() {
        return teamsEntities.size();
    }

    public void setList(List<TeamEntity> teamsEntities) {
        this.teamsEntities = teamsEntities;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView teamName;

        public ViewHolder(final View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.team_name);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TeamEntity teamEntity = teamsEntities.get(getAdapterPosition());

                    Intent intent = new Intent(context, TeamDetailsActivity.class);
                    intent.putExtra(Extras.TEAM_DETAILS_EXTRAS, teamEntity);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

        }
    }


}