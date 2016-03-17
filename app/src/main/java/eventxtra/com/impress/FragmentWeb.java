package eventxtra.com.impress;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_web)
public class FragmentWeb extends FragmentBase {

	WebSettings webSettings;

	@ViewById(R.id.web_view)
	WebView webView;

	@Click(R.id.btn_back)
	void onClicked() {
		((ActivityEmail) getActivity()).setCurrentPagerItem(0);
	}

	@AfterViews
	void onCreate() {
		webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setLoadsImagesAutomatically(true);
		webSettings.setBuiltInZoomControls(true);
		webSettings.setDisplayZoomControls(true);
		webView.setWebViewClient(new WebViewClient());
		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		webView.loadUrl("http://www.eventxtra.com");
	}

}
