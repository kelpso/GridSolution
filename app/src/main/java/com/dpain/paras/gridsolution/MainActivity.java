package com.dpain.paras.gridsolution;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.InputType;
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


public class MainActivity extends ActionBarActivity {

    private static final int LEFT_MARGIN = 20;
    private static final int TOP_MARGIN = 15;
    private static final int RIGHT_MARGIN = 20;
    private static final int BOTTOM_MARGIN = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long randSeed = 100;
        Matrix m = new Matrix(4, randSeed);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(LEFT_MARGIN, TOP_MARGIN, RIGHT_MARGIN, BOTTOM_MARGIN);

        TableLayout mainTable = (TableLayout) findViewById(R.id.main_table);
        TableRow[] rowObj = new TableRow[m.getRowSize()];
        EditText[][] val = new EditText[m.getRowSize()][m.getColumnSize()];

        // Init and assign values
        for(int i=0;i<m.getRowSize();i++) {
            rowObj[i] = new TableRow((mainTable.getContext()));
            for(int j=0;j<m.getColumnSize();j++){
                val[i][j] = new EditText(mainTable.getContext());
                val[i][j].setInputType(InputType.TYPE_CLASS_NUMBER);
                val[i][j].setTextSize(30);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            GridViewGroup gridViewL = (GridViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
            Matrix m = new Matrix(4,4,1);

            MatrixHandler matrixHandler = new MatrixHandler(gridViewL, m);
            matrixHandler.DisplayGrid();

            return matrixHandler._rootView;
        }
    }
}
