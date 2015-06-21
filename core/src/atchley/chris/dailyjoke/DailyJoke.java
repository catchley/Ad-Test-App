package atchley.chris.dailyjoke;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DailyJoke extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

    private AdsController adsController;

    public DailyJoke(AdsController adsController){
        if (adsController != null) {
            this.adsController = adsController;
        } else {
            this.adsController = new DummyAdsController();
        }
    }
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        if(adsController.isWifiConnected()) {adsController.showBannerAd();}
	}

	@Override
	public void render () {

        if (adsController.isWifiConnected()) {
            adsController.showInterstitialAd(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Interstitial app closed");
                    Gdx.app.exit();
                }
            });
        } else {
            System.out.println("Interstitial ad not (yet) loaded");
        }
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

    private class DummyAdsController implements AdsController {
        @Override
        public void showBannerAd() {

        }

        @Override
        public void hideBannerAd() {

        }

        @Override
        public boolean isWifiConnected() {
            return false;
        }

        @Override
        public void showInterstitialAd(Runnable then) {

        }
    }

}
