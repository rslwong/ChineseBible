/*
    Bible Table class
 */
package com.example.rslwong.myapplication;

public class Item {

    public static Item[] ITEMS = new Item[] {
            new Item("舊 約 全 書",-1),
            new Item("創世紀", 50),
            new Item("出埃及記", 40),
            new Item("利未記", 27),
            new Item("民數記", 36),
            new Item("申命記", 34),
            new Item("約書亞記", 24),
            new Item("士師記", 21),
            new Item("路得記", 4),
            new Item("撒母耳記上", 31),
            new Item("撒母耳記下", 24),
            new Item("列王記上", 22),
            new Item("列王記下", 25),
            new Item("歷代志上", 29),
            new Item("歷代志下", 36),
            new Item("以斯拉記", 10),
            new Item("尼希米記", 13),
            new Item("以斯帖記", 10),
            new Item("約伯記", 42),
            new Item("詩篇", 150),
            new Item("箴言", 31),
            new Item("傳道書", 12),
            new Item("雅歌", 8),
            new Item("以賽亞書", 66),
            new Item("耶利米書", 52),
            new Item("耶利米哀歌", 5),
            new Item("以西結書", 48),
            new Item("但以理書", 12),
            new Item("何西阿書", 14),
            new Item("約珥書", 3),
            new Item("阿摩司書", 9),
            new Item("俄巴底亞書", 1),
            new Item("約拿書", 4),
            new Item("彌迦書", 7),
            new Item("那鴻書", 3),
            new Item("哈巴谷書", 3),
            new Item("西番雅書", 3),
            new Item("哈該書", 2),
            new Item("撒迦利亞", 14),
            new Item("瑪拉基書", 4),
            new Item("新 約 全 書",-1),
            new Item("馬太福音", 28),
            new Item("馬可福音", 16),
            new Item("路加福音", 24),
            new Item("約翰福音", 21),
            new Item("使徒行傳", 28),
            new Item("羅馬書", 16),
            new Item("哥林多前書", 16),
            new Item("哥林多後書", 13),
            new Item("加拉太書", 6),
            new Item("以弗所書", 6),
            new Item("腓立比書", 4),
            new Item("歌羅西書", 4),
            new Item("帖撒羅尼迦前書", 5),
            new Item("帖撒羅尼迦後書", 3),
            new Item("提摩太前書", 6),
            new Item("提摩太後書", 4),
            new Item("提多書", 3),
            new Item("腓利門書", 1),
            new Item("希伯來書", 13),
            new Item("雅各書", 5),
            new Item("彼得前書", 5),
            new Item("彼得後書", 3),
            new Item("約翰一書", 5),
            new Item("約翰二書", 1),
            new Item("約翰三書", 1),
            new Item("猶大書", 1),
            new Item("啟示錄", 22)
    };

    public static Item getItem(int id) {
        for (Item item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private final String mName;
    private final int mChapters;

    Item(String name, int chapters) {
        mName = name;
        mChapters = chapters;
    }

    public int getChapters(){
        return mChapters;
    }

    public int getId() {
        return mName.hashCode() + mChapters;
    }

    public String getName() {
        return mName;
    }

}
