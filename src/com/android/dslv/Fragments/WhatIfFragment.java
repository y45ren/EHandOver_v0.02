package com.android.dslv.Fragments;

import com.example.ehandover.R;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.SimpleDragSortCursorAdapter;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class WhatIfFragment extends Fragment {

    private SimpleDragSortCursorAdapter adapter;

    /** Called when the activity is first created. */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.whatif_fragment, container, false);

        String[] cols = {"name"};
        int[] ids = {R.id.text};
        
        adapter = new MAdapter(getActivity(),
                R.layout.list_item_click_remove, null, cols, ids, 0);

        DragSortListView dslv = (DragSortListView) rootView.findViewById(R.id.list);
        dslv.setAdapter(adapter);

        // build a cursor from the String array
        MatrixCursor cursor = new MatrixCursor(new String[] {"_id", "name"});
        String[] artistNames = getResources().getStringArray(R.array.jazz_artist_names);
        for (int i = 0; i < artistNames.length; i++) {
            cursor.newRow()
                    .add(i)
                    .add(artistNames[i]);
        }
        adapter.changeCursor(cursor);
        
        return rootView; 
    }

    private class MAdapter extends SimpleDragSortCursorAdapter {
        private Context mContext;

        public MAdapter(Context ctxt, int rmid, Cursor c, String[] cols, int[] ids, int something) {
            super(ctxt, rmid, c, cols, ids, something);
            mContext = ctxt;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);
            View tv = v.findViewById(R.id.text);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(mContext, "text clicked", Toast.LENGTH_SHORT).show();
                }
            });
            return v;
        }
    }
}
