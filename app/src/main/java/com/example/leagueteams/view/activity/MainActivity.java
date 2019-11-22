package com.example.leagueteams.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.leagueteams.R;
import com.example.leagueteams.databinding.ActivityMainBinding;
import com.example.leagueteams.model.TeamsEntity;
import com.example.leagueteams.view.adapter.TeamsListAdapter;
import com.example.leagueteams.viewModel.LeagueTeamsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private LeagueTeamsViewModel leagueTeamsViewModel;
    private TeamsListAdapter teamsListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        leagueTeamsViewModel = ViewModelProviders.of(this).get(LeagueTeamsViewModel.class);


        initRv();

    }

    private void initRv() {
        teamsListAdapter = new TeamsListAdapter(MainActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.teamsRv.setLayoutManager(linearLayoutManager);
        binding.teamsRv.setAdapter(teamsListAdapter);


        leagueTeamsViewModel.getLeagueTeams().observe(this, new Observer<List<TeamsEntity>>() {
            @Override
            public void onChanged(@Nullable List<TeamsEntity> teamsEntities) {
                teamsListAdapter.setList(teamsEntities);
            }
        });
    }


}
