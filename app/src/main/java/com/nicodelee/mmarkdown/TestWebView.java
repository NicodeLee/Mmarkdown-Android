package com.nicodelee.mmarkdown;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicodelee on 15/9/22.
 */
public class TestWebView extends AppCompatActivity {
  private WebView mWebView;
  private List<String> list;
  private int mkeyCode;

  @JavascriptInterface @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mWebView = (WebView) findViewById(R.id.wv_md);
    initData();

    WebSettings webSettings = mWebView.getSettings();

    // 是否允许在webview中执行javascript
    webSettings.setJavaScriptEnabled(true);

    mWebView.addJavascriptInterface(this, "javatojs");
    //加载网页
    mWebView.loadUrl("file:///android_asset/index.html");
  }

  @Override public boolean onKeyUp(int keyCode, KeyEvent event) {
    mkeyCode = keyCode;
    Log.i("AA", "keyCode=" + keyCode);
    mWebView.loadUrl("javascript: OnKeyUp()");
    return super.onKeyUp(keyCode, event);
  }

  public int getKeyCode() {
    return mkeyCode;
  }

  void initData() {
    list = new ArrayList<String>();
    for (int i = 0; i < 5; i++) {
      list.add("我是List中的第" + (i + 1) + "行");
    }
  }

  /**
   * 该方法将在js脚本中，通过window.javatojs.....()进行调用
   */
  public Object getObject(int index) {
    Log.i("A", "getObject");
    return list.get(index);
  }

  public int getSize() {
    Log.i("A", "getSize");
    return list.size();
  }

  public void Callfunction() {
    Log.i("A", "Callfunction");
    mWebView.loadUrl("javascript: GetList()");
  }

  public void printStr(String str) {
    Log.i("A", "GetList:" + str);
  }
}
