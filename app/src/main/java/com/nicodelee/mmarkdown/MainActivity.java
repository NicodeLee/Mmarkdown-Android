package com.nicodelee.mmarkdown;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

  private WebView webView;

  @JavascriptInterface @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    webView = (WebView) findViewById(R.id.wv_md);
    WebSettings webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setLoadWithOverviewMode(true);//自适应
    webSettings.setUseWideViewPort(true);
    webSettings.setJavaScriptCanOpenWindowsAutomatically(true);//允许js弹出窗口
    webView.setHorizontalScrollbarOverlay(false);
    webView.addJavascriptInterface(this, "handler");
    webView.setWebViewClient(new WebViewClient());
    webView.loadUrl("file:///android_asset/markdown.html");

    findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //startActivity(new Intent(MainActivity.this,TestWebView.class));
        loadMarkDown(str);
      }
    });
  }

  public void loadMarkDown(String str) {
    webView.loadUrl("javascript:parseMarkdown(\"" + str + "\")");
    //webView.loadUrl("javascript:parseMarkdown(\"" + str + "\", " + gfmEnabled + ")");
    //this.webView.loadUrl("javascript:parseMarkdown(\"" + e.a(str) + "\", " + gfmEnabled + ")");
  }

  String str =
      "# Awesome-RxJava\\n" + "RxJava resources\\n" + "\\n" + "## Blog\\n" + "\\n"
          + " * [那些年我们错过的响应式编程](http://www.devtf.cn/?p=174)，非常棒的讲解响应式编程的文章。\\n" + "\\n"
          + " * 这篇入门极力推荐，手把手，深入浅出教你实现一个简易的RxJava库，更好的理解RxJava的实现思路[NotRxJava懒人专用指南](http://www.devtf.cn/?p=323)\\n"
          + "\\n" + " * [深入浅出RxJava（一：基础篇）](http://blog.csdn.net/lzyzsd/article/details/41833541)\\n"
          + "\\n" + " * [深入浅出RxJava(二：操作符)](http://blog.csdn.net/lzyzsd/article/details/44094895)\\n"
          + "\\n"
          + " * [深入浅出RxJava三--响应式的好处](http://blog.csdn.net/lzyzsd/article/details/44891933)\\n"
          + "\\n"
          + " * [深入浅出RxJava四-在Android中使用响应式编程](http://blog.csdn.net/lzyzsd/article/details/45033611)\\n"
          + "" + " 开发者前线翻译的一系列很赞的教程\\n" + "\\n"
          + " * [使用RxJava从多个数据源中加载数据](http://www.devtf.cn/?p=764)\\n" + "\\n"
          + " * [使用RxJava.Observable取代AsyncTask和AsyncTaskLoader](http://www.devtf.cn/?p=114)\\n"
          + "\\n" + " * [当复仇者联盟遇上Dragger2、RxJava和Retrofit的巧妙结合](http://www.devtf.cn/?p=565)\\n" + "\\n"
          + " * [结合RxJava使用SQLite](http://www.devtf.cn/?p=734)\\n" + "\\n"
          + " * [比钢铁侠反应更灵敏-RxJava](http://www.devtf.cn/?p=770)\\n" + " \\n"
          + " 一篇不错的介绍操作符的，[地址](http://blog.csdn.net/job_hesc/article/details/46242117) \\n" + " \\n"
          + " 翻译 [Deferring Observable code until subscription in RxJava](http://www.jianshu.com/p/c83996149f5b)\\n"
          + "\\n"
          + " 翻译 [RxJava Observable tranformation: concatMap() vs flatMap()](http://www.jianshu.com/p/6d16805537ef)\\n"
          + " \\n"
          + " 翻译 [Loading data from multiple sources with RxJava](http://www.jianshu.com/p/be084df924dc)\\n"
          + " \\n"
          + " 翻译 [Don't break the chain: use RxJava's compose() operator](http://www.jianshu.com/p/e9e03194199e)\\n"
          + " \\n" + "## App\\n" + "\\n"
          + " 简介：Android application that loads gifs via gfycat for efficiency's sake\\n" + "\\n"
          + " [android-gfycat](https://github.com/dlew/android-gfycat)\\n" + "\\n"
          + " Jake大神的项目，里面有RxJava和Retrofit一起使用的例子\\n"
          + " [JakeWharton/u2020](https://github.com/JakeWharton/u2020)\\n" + " \\n"
          + " 一个使用Retrofit+RxJava+MVP的app\\n" + " [Avengers](https://github.com/saulmm/Avengers)\\n"
          + " \\n" + " Android中使用Rx的一种架构\\n"
          + " [rx-android-architecture](https://github.com/tehmou/rx-android-architecture)\\n";
  //String str =
  //    "# Awesome-RxJava RxJava resources \\\n## Blog\\\n* [那些年我们错过的响应式编程](http://www.devtf.cn/?p=174)，非常棒的讲解响应式编程的文章。";
}
