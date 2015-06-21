package atchley.chris.dailyjoke;

/**
 * Created by Chris on 6/20/2015.
 */
public interface AdsController {

    public void showBannerAd();
    public void hideBannerAd();
    public boolean isWifiConnected();
    public void showInterstitialAd (Runnable then);
}
