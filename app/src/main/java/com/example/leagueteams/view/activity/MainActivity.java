package com.example.leagueteams.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.leagueteams.R;
import com.example.leagueteams.databinding.ActivityMainBinding;
import com.example.leagueteams.model.TeamEntity;
import com.example.leagueteams.model.TeamEntityObject;
import com.example.leagueteams.util.NetworkHelper;
import com.example.leagueteams.view.adapter.TeamsListAdapter;
import com.example.leagueteams.viewModel.TeamsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private TeamsViewModel teamsViewModel;
    private TeamsListAdapter teamsListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        teamsViewModel = ViewModelProviders.of(this).get(TeamsViewModel.class);

        initRv();

        if (NetworkHelper.isNetworkAvailable(this))
            loadFromServer();
        else
            loadFromLocal();


    }

    private void loadFromLocal() {
        teamsViewModel.getAllTeams().observe(this, new Observer<List<TeamEntityObject>>() {
            @Override
            public void onChanged(@Nullable List<TeamEntityObject> teamsEntities) {
                if (teamsEntities != null) {
                    ConvertClassType(teamsEntities);
                }

            }
        });
    }

    private void ConvertClassType(List<TeamEntityObject> teamsEntities) {
        List<TeamEntity> list = new ArrayList<>();
        for (int i = 0; i < teamsEntities.size(); i++) {
            TeamEntity teamEntity = new TeamEntity();
            teamEntity.setAddress(teamsEntities.get(i).getAddress());
            teamEntity.setName(teamsEntities.get(i).getName());
            teamEntity.setWebsite(teamsEntities.get(i).getWebsite());
            teamEntity.setClubcolors(teamsEntities.get(i).getClubcolors());
            teamEntity.setVenue(teamsEntities.get(i).getVenue());
            teamEntity.setSquad(teamsEntities.get(i).getSquad());
            teamEntity.setId(teamsEntities.get(i).getId());

            list.add(teamEntity);
        }
        binding.teamsRv.setVisibility(View.VISIBLE);
        binding.progressBar2.setVisibility(View.GONE);
        teamsListAdapter.setList(list);
    }

    private void loadFromServer() {

        teamsViewModel.getLeagueTeams().observe(this, new Observer<List<TeamEntity>>() {
            @Override
            public void onChanged(@Nullable List<TeamEntity> teamsEntities) {
                binding.teamsRv.setVisibility(View.VISIBLE);
                binding.progressBar2.setVisibility(View.GONE);

                teamsListAdapter.setList(teamsEntities);
            }
        });
    }

    private void initRv() {
        teamsListAdapter = new TeamsListAdapter(MainActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.teamsRv.setLayoutManager(linearLayoutManager);
        binding.teamsRv.setAdapter(teamsListAdapter);


    }


}
