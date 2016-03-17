package eventxtra.com.impress;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_email)
public class FragmentEmail extends FragmentBase implements TextureView.SurfaceTextureListener {

	MediaPlayer mediaPlayer;

	@ViewById(R.id.bg_video)
	TextureView bgVideo;

	@ViewById(R.id.overlay)
	LinearLayout linearLayout;

	@AfterViews
	void onCreate() {
		initVideo();
	}

	@UiThread
	void initVideo() {
		bgVideo.setSurfaceTextureListener(this);
		Uri videoPath = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video);
		mediaPlayer = MediaPlayer.create(getActivity(), videoPath);
		mediaPlayer.setScreenOnWhilePlaying(true);
	}

	@Override
	public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
		Surface s = new Surface(surface);
		mediaPlayer.setSurface(s);
		mediaPlayer.start();
	}

	@Override
	public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

	}

	@Override
	public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
		return false;
	}

	@Override
	public void onSurfaceTextureUpdated(SurfaceTexture surface) {

	}
}
