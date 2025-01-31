package com.hkm.slidingmenulib.advancedtreeview;

/**
 * Created by hesk on 10/7/15.
 */
public interface ParentVH<bindData extends ExpandableItemData> {

    void bindView(final bindData itemData, final int position, final ItemDataClickListener imageClickListener);

    void rotationExpandIcon(float from, float to);

    void onParentItemClick(final String path);

    int openDegree();

    int closeDegree();
}
