package com.example.leagueteams.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.leagueteams.R;
import com.example.leagueteams.databinding.ActivityTeamDetailsBinding;
import com.example.leagueteams.model.SquadEntity;
import com.example.leagueteams.model.TeamEntity;
import com.example.leagueteams.model.TeamEntityObject;
import com.example.leagueteams.util.Extras;
import com.example.leagueteams.view.adapter.SquadListAdapter;
import com.example.leagueteams.view.adapter.TeamsListAdapter;
import com.example.leagueteams.viewModel.TeamDetailsViewModel;
import com.example.leagueteams.viewModel.TeamsViewModel;

import java.util.List;

public class TeamDetailsActivity extends AppCompatActivity {
    private ActivityTeamDetailsBinding binding;
    private TeamDetailsViewModel teamDetailsViewModel;
    private SquadListAdapter squadListAdapter;
    private TeamEntity teamEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_details);

        teamDetailsViewModel = ViewModelProviders.of(this).get(TeamDetailsViewModel.class);

        loadItemDetails();
    }

    private void loadItemDetails() {
        if (getIntent().hasExtra(Extras.TEAM_DETAILS_EXTRAS)) {
            teamEntity = getIntent().getParcelableExtra(Extras.TEAM_DETAILS_EXTRAS);
            teamDetailsViewModel.getTeamDetails(teamEntity.getId()).observe(this, new Observer<TeamEntity>() {
                @Override
                public void onChanged(@Nullable TeamEntity teamEntity) {
                    if (teamEntity != null) {
                        binding.teamName.setText(teamEntity.getName());
                        binding.teamAddress.setText(teamEntity.getAddress());
                        binding.teamColor.setText(teamEntity.getClubcolors());
                        binding.teamVenue.setText(teamEntity.getVenue());
                        binding.teamWeb.setText(teamEntity.getWebsite());
                    }

                }
            });

            initRv();

            teamDetailsViewModel.getSquad(teamEntity.getId()).observe(TeamDetailsActivity.this, new Observer<List<SquadEntity>>() {
                @Override
                public void onChanged(@Nullable List<SquadEntity> squadEntities) {
                    binding.cardView1.setVisibility(View.VISIBLE);
                    binding.cardView2.setVisibility(View.VISIBLE);
                    binding.progressBar.setVisibility(View.GONE);
                    squadListAdapter.setList(squadEntities);
                }
            });


        }

        binding.teamWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(binding.teamWeb.getText().toString())));

            }
        });

    }


    private void initRv() {
        squadListAdapter = new SquadListAdapter(TeamDetailsActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(squadListAdapter);


    }


}
