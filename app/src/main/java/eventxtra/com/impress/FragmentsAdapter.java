package eventxtra.com.impress;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public abstract class FragmentsAdapter extends FragmentStatePagerAdapter {

	public FragmentsAdapter(FragmentManager fm) {
		super(fm);
	}

	public abstract Fragment getItem(int position);
	public abstract int getCount();

}
