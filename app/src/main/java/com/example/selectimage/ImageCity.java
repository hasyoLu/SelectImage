package com.example.selectimage;

import java.util.HashMap;

public class ImageCity {
    private volatile static ImageCity singleton;
    private ImageCity (){
        map = new HashMap<>();
        initMap();
    }
    public static ImageCity getSingleton() {
        if (singleton == null) {
            synchronized (ImageCity.class) {
                if (singleton == null) {
                    singleton = new ImageCity();
                }
            }
        }
        return singleton;
    }

    private HashMap<String, String> map;

    private void initMap() {
        map.put("人物", "https://s2.loli.net/2023/04/16/7n45MBElxeWcFjJ.webp");
        map.put("打篮球", "https://s2.loli.net/2023/04/16/b6o5qjBMk7YcvVF.webp");
        map.put("狗", "https://s2.loli.net/2023/04/16/2MOYvQFcdNteRBA.webp");
        map.put("球", "https://s2.loli.net/2023/04/16/jk5QyMx78OWfASg.webp");
        map.put("跳水", "https://s2.loli.net/2023/04/16/7n45MBElxeWcFjJ.webp");
        map.put("猫", "https://s2.loli.net/2023/04/16/7n45MBElxeWcFjJ.webp");
    }

    public String getPath (String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return "";
    }


    public int addImage(ImageCityBean image) {
        if (map.containsKey(image.getKey())) {
            return -1;
        }
        map.put(image.getKey(), image.getPath());
        return 200;
    }

    public int removeImage(String key) {
        if (map.containsKey(key)) {
            return -1;
        }
        map.remove(key);
        return 200;
    }

    public int reviseImage(ImageCityBean image) {
        if (map.containsKey(image.getKey())) {
            map.put(image.getKey(), image.getPath());
            return 200;
        }
        return -1;
    }
}
