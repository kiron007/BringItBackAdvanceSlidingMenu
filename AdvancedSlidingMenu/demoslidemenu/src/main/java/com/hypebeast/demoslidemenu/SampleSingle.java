package com.hypebeast.demoslidemenu;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.Toolbar;

import com.hkm.advancedtoolbar.V5.BeastBar;
import com.hkm.slidingmenulib.layoutdesigns.singleDetailPost;
import com.hypebeast.demoslidemenu.pages.mainpageDemo;

/**
 * Created by hesk on 10/11/15.
 */
public class SampleSingle extends singleDetailPost<mainpageDemo> {
    @Override
    protected void loadPageWithFullURL(String url) {

    }

    /**
     * the location to setup and configure the toolbar widget under AppCompat V7
     *
     * @param v7 Toolbar object
     */
    @Override
    protected boolean configToolBar(Toolbar v7) {
        BeastBar actionToolBar = BeastBar.withToolbar(
                this,
                v7,
                getSingleToolBar(this)
        );
        actionToolBar.setBackIconFunc(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        });


        return true;
    }


    public static BeastBar.Builder getSingleToolBar(Context mContext) {
        BeastBar.Builder bb = new BeastBar.Builder();
        bb.back(R.drawable.backios);
        bb.background(R.drawable.actionbar_bg_dark_black);
        bb.setToolBarTitleSize(R.dimen.title_bar);
        bb.setToolBarTitleColor(R.color.not_pref_v2);
        //bb.setFontFace(mContext, "FrancoisOne.ttf");
        bb.defaultTitle(mContext.getString(R.string.comment_area));
        return bb;
    }


    @Override
    protected void loadPageWithPID(long pid) {

    }

    /**
     * setting the first initial fragment at the beginning
     *
     * @return generic type fragment
     * @throws Exception the exception for the wrongs
     */
    @Override
    protected mainpageDemo getInitFragment() throws Exception {
        return new mainpageDemo();
    }

    @Override
    protected void onMenuItemSelected(@IdRes int Id) {

    }
}
