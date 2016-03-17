package eventxtra.com.impress;

import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_email)
public class ActivityEmail extends FragmentActivityBase implements VerticalViewPager.OnPageChangeListener {

	FragmentsAdapter fragmentsAdapter;

	@ViewById(R.id.pager)
	VerticalViewPager viewPager;

	@AfterViews
	void onCreate() {

		fragmentsAdapter = new FragmentsAdapter(getSupportFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				if(position == 0)
					return new FragmentEmail_();
				else return new FragmentWeb_();
			}

			@Override
			public int getCount() {
				return 2;
			}
		};

		viewPager.setAdapter(fragmentsAdapter);
		viewPager.setPageMargin(0);
		viewPager.setOnPageChangeListener(this);
	}

	public void setCurrentPagerItem(int i) {
		viewPager.setCurrentItem(i, true);
	}

	@Override
	protected ObjectContainer getRetainedObjectsContainer() {
		return null;
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {

	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}
}
