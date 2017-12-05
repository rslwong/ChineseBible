/*
    Bible Table class
 */
package com.example.rslwong.myapplication;

public class ItemPage2 {

 /*   public static ItemPage2 getItem(int id) {
        for (ItemPage2 item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
*/

    private final int mChapter;

    ItemPage2(int chapter) {
        mChapter = chapter;
    }

    public int getChapter(){
        return mChapter;
    }

    public int getId() {  return mChapter; }

}
