package com.collegeproject.dev3dot.projecthealthcare;

import android.graphics.Color;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.collegeproject.dev3dot.projecthealthcare.R.id.webView;

public class Duedate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duedate);


        WebView view = (WebView) this.findViewById(webView);
        view.getSettings().setJavaScriptEnabled(true);

        // view.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);



        view.loadUrl("file:///android_asset/index.html");
        //  webView.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setSupportMultipleWindows(true);


        view.setWebChromeClient(new WebChromeClient() {


            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog,
                                          boolean isUserGesture, Message resultMsg) {



                WebView newWebView = new WebView(Duedate.this);
               // newWebView.setBackgroundColor(0);

                //newWebView.setBackgroundColor(Color.TRANSPARENT);

                newWebView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);


                newWebView.getSettings().setJavaScriptEnabled(true);
                newWebView.getSettings().setSupportZoom(true);
                newWebView.getSettings().setBuiltInZoomControls(true);
                newWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
                newWebView.getSettings().setSupportMultipleWindows(true);
                view.addView(newWebView);


               // newWebView.setBackgroundColor(Color.TRANSPARENT);
              //  newWebView.setBackgroundResource(R.drawable.background12);


                WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
                transport.setWebView(newWebView);
                resultMsg.sendToTarget();

                newWebView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }
                });

                return true;
            }
        });


    }


}
