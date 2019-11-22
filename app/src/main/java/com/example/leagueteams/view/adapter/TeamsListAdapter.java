package com.example.leagueteams.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leagueteams.R;
import com.example.leagueteams.model.TeamsEntity;

import java.util.ArrayList;
import java.util.List;

public class TeamsListAdapter extends
        RecyclerView.Adapter<TeamsListAdapter.ViewHolder> {

    private List<TeamsEntity> teamsEntities;
    private Context context;

    public TeamsListAdapter(Context context) {
        teamsEntities = new ArrayList<>();
        context = context;
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
        TeamsEntity teamsEntity = teamsEntities.get(position);
        holder.teamName.setText(teamsEntity.getName());
    }

    @Override
    public int getItemCount() {
        return teamsEntities.size();
    }

    public void setList(List<TeamsEntity> teamsEntities) {
        this.teamsEntities = teamsEntities;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView teamName;

        public ViewHolder(View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.team_name);
        }
    }


}