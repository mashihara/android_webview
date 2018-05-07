package nttdata.co.jp.webmovie.controller;

import android.webkit.JavascriptInterface;

/**
 * WebView(HTML)からNative操作するためのController.
 */
public class NativeController {
    /**
     * コールバック先.
     */
    private INativeController mCallback = null;

    /**
     * コンストラクタ.
     * @param callback コールバック先
     */
    public NativeController(final INativeController callback) {
        mCallback = callback;
    }

    /**
     * 戻るボタン押下.
     * JavaScriptからコールされる
     */
    @JavascriptInterface
    public void onBackPress() {
        if (mCallback != null) {
            mCallback.onBackPress();
        }
    }

    /**
     * オブジェクト破棄
     */
    public void dispose() {
        // コールバック先を破棄
        mCallback = null;
    }
}
