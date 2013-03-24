package com.android.dslv;

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
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class DummySectionFragment extends Fragment {

        public static final String ARG_SECTION_NUMBER = "section_number";

        
        
        ArrayAdapter<String> adapter;

        private DragSortListView.DropListener onDrop = new DragSortListView.DropListener()
        {
            @Override
            public void drop(int from, int to)
            {
                if (from != to)
                {
                    String item = adapter.getItem(from);
                    adapter.remove(item);
                    adapter.insert(item, to);
                }
            }
        };
        
        private DragSortListView.RemoveListener onRemove = new DragSortListView.RemoveListener()
        {
            @Override
            public void remove(int which)
            {
                adapter.remove(adapter.getItem(which));
            }
        };


        public DummySectionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment, container, false);
            
            
            DragSortListView listView = (DragSortListView) rootView.findViewById(R.id.listview);
    	    
    	    String[] names = new String[] { "Android", "iPhone", "WindowsMobile",
    	  		  "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
    	  		  "Linux", "OS/2" };
    	    ArrayList<String> list = new ArrayList<String>(Arrays.asList(names));

    	  	adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, list);
    	  	
    	    System.out.println(listView);
    	    
    	    listView.setAdapter((ListAdapter)adapter);
    	    listView.setDropListener(onDrop);
    	    listView.setRemoveListener(onRemove);

    	    DragSortController controller = new DragSortController(listView);
    	  //  controller.setDragHandleId(R.id.imageView1);
    	            //controller.setClickRemoveId(R.id.);
    	    controller.setRemoveEnabled(false);
    	    controller.setSortEnabled(true);
    	    controller.setDragInitMode(1);
    	            //controller.setRemoveMode(removeMode);

    	    listView.setFloatViewManager(controller);
    	    listView.setOnTouchListener(controller);
    	    listView.setDragEnabled(true);
            
            
            return rootView;
        }
    

}
