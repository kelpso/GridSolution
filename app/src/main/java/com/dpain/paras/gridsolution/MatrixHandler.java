package com.dpain.paras.gridsolution;

import android.app.Fragment;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MatrixHandler {

    public GridViewGroup _rootView;
    private Matrix _m;

    public MatrixHandler(GridViewGroup rootView, Matrix m) {
        _rootView = rootView;
        _m = m;
    }

    public void DisplayGrid() {
        // local vars
        int row = _m.getRowSize();
        int column = _m.getColumnSize();
        double[][] grid = _m.getGrid();

        TextView[][] textViewGrid = new TextView[row][column];

        // textView Init and assignment
        for(int ro = 0; ro < row; ro++) {
            for (int col = 0; col < column; col++) {
                textViewGrid[ro][col] = new TextView(_rootView.getContext());
                textViewGrid[ro][col].setTextColor(34);
                textViewGrid[ro][col].setText(String.valueOf(grid[ro][col]));
                // WRAP_CONTENT = -2
                _rootView.addView(textViewGrid[ro][col], ViewGroup.LayoutParams.WRAP_CONTENT);
            }// --column loop end
        }// --row loop end;

    }
}
