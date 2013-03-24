package com.android.dslv;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

public class myTabListener implements android.app.ActionBar.TabListener {

	  private final Activity mActivity;
      private final String mTag;
      
      private final Bundle mArgs;
      private Fragment mFragment;

      public myTabListener(Activity activity, String tag) {
          this(activity, tag, null);
      }

      public myTabListener(Activity activity, String tag, Bundle args) {
          mActivity = activity;
          mTag = tag;
          
          mArgs = args;

          // Check to see if we already have a fragment for this tab, probably
          // from a previously saved state.  If so, deactivate it, because our
          // initial state is that a tab isn't shown.
          mFragment = mActivity.getFragmentManager().findFragmentByTag(mTag);
          if (mFragment != null && !mFragment.isDetached()) {
              FragmentTransaction ft = mActivity.getFragmentManager().beginTransaction();
              ft.detach(mFragment);
              ft.commit();
          }
      }

      public void onTabSelected(Tab tab, FragmentTransaction ft) {
          if (mFragment == null) {
              mFragment = Fragment.instantiate(mActivity, "baby", mArgs);
              ft.add(android.R.id.content, mFragment, mTag);
          } else {
              ft.attach(mFragment);
          }
      }

      public void onTabUnselected(Tab tab, FragmentTransaction ft) {
          if (mFragment != null) {
              ft.detach(mFragment);
          }
      }

      public void onTabReselected(Tab tab, FragmentTransaction ft) {
          Toast.makeText(mActivity, "Reselected!", Toast.LENGTH_SHORT).show();
      }

}

