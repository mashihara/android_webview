package nttdata.co.jp.webmovie;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import nttdata.co.jp.webmovie.controller.INativeController;
import nttdata.co.jp.webmovie.controller.NativeController;

public class MainActivity extends Activity implements INativeController{
    /**
     * 表示中のWebView.
     */
    private WebView mWebView;
    /**
     * JavaScriptから操作可能なインターフェース.
     */
    private NativeController mNativeController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // WevViewの初期化
        initWebView();
        // 動画再生開始
        startVideo();
    }

    /**
     * WebViewの初期化.
     */
    private void initWebView() {
        // WebViewの取得
        mWebView = findViewById(R.id.main_webview);
        // WebViewに対する動作設定を行う
        WebSettings settings = mWebView.getSettings();
        // Mediaの自動再生を有効にする
        settings.setMediaPlaybackRequiresUserGesture(false);
        // JavaScriptを有効にする
        settings.setJavaScriptEnabled(true);
        // JavaScriptからNative操作可能なIFを追加する
        mNativeController = new NativeController(this);
        mWebView.addJavascriptInterface(mNativeController, NativeController.class.getSimpleName());
    }

    /**
     * 動画再生開始.
     */
    private void startVideo() {
// mWebView.loadUrl("file:///android_asset/html/video.html");
        mWebView.loadUrl("https://s3-ap-northeast-1.amazonaws.com/ntteata.robohon.movie.hls/video/20000.m3u8");
    }
    @Override
    public void onBackPress() {
        // 戻るボタンがコールされたら画面終了
        finish();
    }
}
