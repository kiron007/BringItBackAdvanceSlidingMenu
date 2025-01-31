package com.hkm.slidingmenulib.layoutdesigns.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.hkm.slidingmenulib.advancedtreeview.ExpAdapter;
import com.hkm.slidingmenulib.advancedtreeview.presnt.system.ExpSystem;
import com.hkm.slidingmenulib.advancedtreeview.ExpandableItemData;

import java.util.List;

/**
 * Created by hesk on 8/7/15.
 */
public abstract class treelist<adapter extends ExpAdapter, T extends ExpandableItemData> extends simpleTreeList<adapter> {

    protected final Handler h = new Handler();
    public final static int
            UNSET = -1,
            LOADMENU = -949,
            LOADSYSTEM = -593;

    protected String adapter_url, cate_title, slugtag;
    protected int requestType;

    @Override
    protected boolean onArguments(final Bundle r) {
        requestType = r.getInt(REQUEST_TYPE, UNSET);
        adapter_url = r.getString(URL, "");
        slugtag = r.getString(SLUG, "");
        cate_title = r.getString(FRAGMENTTITLE, "");
        return !adapter_url.equalsIgnoreCase("") || requestType != UNSET;
    }

    /**
     * corresponding to - LOADMENU
     * by launching the custom menu. this is the trigger point to get the custom menu out
     *
     * @return the List of T
     */
    protected abstract List<T> loadCustomMenu();

    protected void loadDataInitial(final adapter ad) {
        if (ad instanceof ExpSystem) {
            ExpSystem p = (ExpSystem) ad;
            p.startListFromPath("/sdcard/");
        } else {
            try {
                ad.addAll(loadCustomMenu(), 0);
            } catch (Exception e) {
                Log.d(TAG, "there is no items in the customize menu");
            }
        }
    }
}
