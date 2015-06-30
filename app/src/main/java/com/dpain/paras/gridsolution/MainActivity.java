package com.dpain.paras.gridsolution;

import android.app.Activity;
/*import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;*/
import android.graphics.Point;
import android.os.Bundle;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    private static final int LEFT_MARGIN = 0;
    private static final int TOP_MARGIN = 0;
    private static final int RIGHT_MARGIN = 0;
    private static final int BOTTOM_MARGIN = 0;

    /*Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize
    int width = size.x;
    int height = size.y;*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long randSeed = 100;
        Matrix m = new Matrix(15, randSeed);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(LEFT_MARGIN, TOP_MARGIN, RIGHT_MARGIN, BOTTOM_MARGIN);

        TableLayout mainTable = (TableLayout) findViewById(R.id.main_table);
        TableRow[] rowObj = new TableRow[m.getRowSize()];
        EditText[][] val = new EditText[m.getRowSize()][m.getColumnSize()];

        DisplayMetrics display = this.getResources().getDisplayMetrics();
        int width = display.widthPixels;
        int colNum = m.getColumnSize();

        // Init and assign values
        for(int i=0;i<m.getRowSize();i++) {
            rowObj[i] = new TableRow((mainTable.getContext()));
            for(int j=0;j<colNum;j++){
                val[i][j] = new EditText(mainTable.getContext());
                val[i][j].setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
                val[i][j].setTextSize(TypedValue.COMPLEX_UNIT_PX, (width/(colNum-1)/3));
                val[i][j].setText(String.valueOf(m.GetElement(i,j)));
            }
        }

        // Adding to the rows and the table
        for(int i=0;i<m.getRowSize();i++) {
            for(int j=0;j<m.getColumnSize();j++){
                rowObj[i].addView(val[i][j], params);
            }
            mainTable.addView(rowObj[i], params);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
