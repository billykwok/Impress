package eventxtra.com.impress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public abstract class FragmentBase extends Fragment {

	private boolean isStopping = false;

	protected void startActivity(Class<? extends Activity> activityClass) {
		this.startActivity(activityClass, (Intent) null);
	}

	protected void startActivity(Class<? extends Activity> activityClass, Intent intent) {
		super.startActivity(intentForActivity(activityClass, intent));
	}

	protected void startActivityForResult(Class<? extends Activity> activityClass) {
		this.startActivityForResult(activityClass, 0, null);
	}

	protected void startActivityForResult(Class<? extends Activity> activityClass, int requestCode) {
		this.startActivityForResult(activityClass, requestCode, null);
	}

	protected void startActivityForResult(Class<? extends Activity> activityClass, int requestCode, Intent intent) {
		super.startActivityForResult(intentForActivity(activityClass, intent), requestCode);
	}

	private Intent intentForActivity(Class<? extends Activity> activityClass, Intent intent) {
		if (intent == null)
			intent = new Intent(this.getActivity(), activityClass);
		else
			intent.setClass(this.getActivity(), activityClass);
		return intent;
	}

	protected boolean isFragmentStopping() {
		return isStopping;
	}

	public FragmentActivityBase getFragmentActivity() {
		return (FragmentActivityBase) this.getActivity();
	}

	public void putRetained(String key, Object object) {
		getFragmentActivity().putRetained(key, object);
	}

	public <T> T getRetained(String key, Class<T> cls) {
		return getFragmentActivity().getRetained(key, cls);
	}

	public Object getRetained(String key) {
		return getFragmentActivity().getRetained(key);
	}

	public ObjectContainer getRetained() {
		return getFragmentActivity().getRetainedObjectsContainer();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		isStopping = false;
	}

	@Override
	public void onStart() {
		super.onStart();
		isStopping = false;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		FragmentActivity activity = this.getActivity();
		if (activity.isDestroyed()) return;

		Fragment[] subFragments = getSubFragments();
		if (subFragments == null || subFragments.length == 0) return;

		FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
		for (Fragment fragment : subFragments) {
			transaction.remove(fragment);
		}
		transaction.commitAllowingStateLoss();
	}

	@Override
	public void onStop() {
		super.onStop();
		isStopping = true;
	}

	protected Fragment[] getSubFragments() {
		return new Fragment[0];
	}

}
