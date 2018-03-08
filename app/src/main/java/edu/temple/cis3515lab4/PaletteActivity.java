package edu.temple.cis3515lab4;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class PaletteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        Resources res = getResources();
        final String[] colors = res.getStringArray(R.array.Colors);


        ColorAdapter colorAdapter = new ColorAdapter(this, colors);

        //this is the gridView in the layout
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(colorAdapter);

        //when item is clicked
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //create the intent
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                //put string into the extra with the key: color
                intent.putExtra("color", colors[position]);
                //launch the intent
                startActivity(intent);
            }
        });
    }
}
