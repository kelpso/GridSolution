package com.dpain.paras.gridsolution;

import android.app.Activity;
import android.os.Bundle;
import android.widget.HorizontalScrollView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // limit of the randomly generated numbers (zero based)
        long randSeed = 100;
        Matrix m = new Matrix(5, randSeed);

        // View which is supposed to containt the generated matrix TableLayout
        HorizontalScrollView parentVew = (HorizontalScrollView) findViewById(R.id.scroll_hor);

        MatrixHandler first = new MatrixHandler(m, parentVew);
        first.DisplayMatrix();
    }
}
