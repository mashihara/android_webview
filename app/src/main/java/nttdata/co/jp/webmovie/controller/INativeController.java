package nttdata.co.jp.webmovie.controller;

/**
 * WebView(JavaScript)からNative操作するためのインターフェース定義.
 */
public interface INativeController {
    /**
     * 戻るボタン押下.
     */
    void onBackPress();
}
