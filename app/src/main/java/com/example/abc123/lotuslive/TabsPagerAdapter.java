package com.example.abc123.lotuslive;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new ProductDetailsFragment();
		//	return new CustomerDetails();
//		case 1:
//			// Games fragment activity
//			return new ProductDetailsFragment();
//		case 2:
//			// Movies fragment activity
//			//return new MoviesFragment();
//			return new ProductDetailsFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 1;
	}

}
