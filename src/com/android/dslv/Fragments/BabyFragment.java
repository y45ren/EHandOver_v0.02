package com.android.dslv.Fragments;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.ehandover.R;
import com.mobeta.android.dslv.DragSortController;
import com.mobeta.android.dslv.DragSortListView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BabyFragment extends Fragment {

    ArrayAdapter<String> adapter;


    public BabyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.baby_fragment, container, false);
        
        
        DragSortListView listView = (DragSortListView) rootView.findViewById(R.id.listview);
	    
	    String[] names = new String[] { "Android", "iPhone", "WindowsMobile",
	  		  "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
	  		  "Linux", "OS/2" };
	    ArrayList<String> list = new ArrayList<String>(Arrays.asList(names));

	  	adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, list);
	  	
//	    System.out.println(listView);
	    
	    listView.setAdapter((ListAdapter)adapter);
	   

	    
        
        
        return rootView;
    }
}
