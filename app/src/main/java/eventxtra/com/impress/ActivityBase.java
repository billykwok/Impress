package eventxtra.com.impress;

import android.app.Activity;
import android.content.Intent;


public class ActivityBase extends Activity {

	protected void startActivity(Class<? extends Activity> activityClass) {
		this.startActivity(activityClass, (Intent) null);
	}
	protected void startActivity(Class<? extends Activity> activityClass, Intent intent) {
		if (intent == null)
			intent = new Intent(this, activityClass);
		else
			intent.setClass(this, activityClass);

		super.startActivity(intent);
	}

}
