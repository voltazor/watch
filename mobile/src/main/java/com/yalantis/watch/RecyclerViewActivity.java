package com.yalantis.watch;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RecyclerViewActivity extends Activity implements RecycleAdapter.OnItemClickListener, RecycleAdapter.OnItemLongClickListener {

    private RecyclerView recyclerView;
    private RecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecycleAdapter(this, generateModels());
        adapter.setItemClickListener(this);
        adapter.setItemLongClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private List<Model> generateModels() {
        List<Model> models = new ArrayList<Model>();

        Random random = new Random(System.currentTimeMillis());
        int colorMax = 256;
        for (int i = 0; i < 20; i++) {
            models.add(new Model(i, "Model " + (i+1), Color.rgb(random.nextInt(colorMax), random.nextInt(colorMax), random.nextInt(colorMax))));
        }

        return models;
    }

    @Override
    public void onItemClick(View view, Model model, int position) {
        Toast.makeText(this, model != null ? model.getName() : "null", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(View view, Model model, int position) {
        adapter.removeItem(position);
        return true;
    }
}
