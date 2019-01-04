package com.example.common.utils.db;

/*
 classpath "io.realm:realm-gradle-plugin:5.4.1"

 apply plugin: 'realm-android'

// 主要内容封装进各自Dao中

 */

import android.app.Application;

import com.example.common.utils.JsonUtils;
import com.example.common.utils.app.AppContent;

import java.util.List;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DbHelper {

    public static void init(Application app) {
        Realm.init(app);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .name(AppContent.APP_NAME)
//                .directory()
                .deleteRealmIfMigrationNeeded()
                .initialData(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
//                        realm.insert(new FeatureBean(1, "好友微视", null, "1"));
//                        realm.insert(new FeatureBean(2, "同城服务", null, "1"));
//                        realm.insert(new FeatureBean(3, "游戏", null, "1"));
//                        realm.insert(new FeatureBean(4, "看点", null, "1"));
//                        realm.insert(new FeatureBean(5, "京东购物", null, "1"));
//                        realm.insert(new FeatureBean(6, "企鹅电竞", null, "0"));
//                        realm.insert(new FeatureBean(7, "鹅漫U品", null, "0"));
//                        realm.insert(new FeatureBean(8, "动漫", null, "0"));
//                        realm.insert(new FeatureBean(9, "阅读", null, "0"));
//                        realm.insert(new FeatureBean(10, "音乐", null, "0"));
//                        realm.insert(new FeatureBean(11, "直播", null, "0"));
//                        realm.insert(new FeatureBean(12, "运动", null, "0"));
//                        realm.insert(new FeatureBean(13, "吃喝玩乐", null, "0"));
//                        realm.insert(new FeatureBean(14, "腾讯新闻", null, "0"));
//                        realm.insert(new FeatureBean(15, "腾讯课堂", null, "0"));
                        // 1、可以写在application初始化数据库数据，如果要更新数据（1）先卸载后安装（2）改版本号，然后再处理
                        // 2、可以写在SplashActivity初始化数据库数据（1）初始化数据前，需要自己先判断需不需要更新

//                        String json = "[{\"id\":1,\"name\":\"好友\",\"friends\":[{\"id\":1,\"name\":\"红猪\",\"headUrl\":\"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d3198678185,878755003\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":2,\"name\":\"黑帽子\",\"headUrl\":\"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d1934952861,3453579486\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":3,\"name\":\"Ara\",\"headUrl\":\"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d3303741086,3211617265\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":4,\"name\":\"Bri\",\"headUrl\":\"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d4233882545,270382672\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"}]},{\"id\":2,\"name\":\"家人\",\"friends\":[{\"id\":5,\"name\":\"苹果\",\"headUrl\":\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d2659519208,2040552462\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":6,\"name\":\"Smoke\",\"headUrl\":\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d3063085903,3230502727\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":7,\"name\":\"BigDog\",\"headUrl\":\"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d2370424667,3031767846\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"}]},{\"id\":3,\"name\":\"XX公司\",\"friends\":[{\"id\":8,\"name\":\"小蜘蛛\",\"headUrl\":\"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d1053771801,4239224829\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":9,\"name\":\"Ali\",\"headUrl\":\"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d3266183129,26862261\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":10,\"name\":\"Logan\",\"headUrl\":\"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u\\u003d2503440006,744810055\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":11,\"name\":\"Es\",\"headUrl\":\"http://img4.imgtn.bdimg.com/it/u\\u003d2838532421,4231779873\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"},{\"id\":12,\"name\":\"SmallCat\",\"headUrl\":\"http://img0.imgtn.bdimg.com/it/u\\u003d2661993305,1199724439\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"}]},{\"id\":4,\"name\":\"客户\",\"friends\":[{\"id\":13,\"name\":\"Mask\",\"headUrl\":\"http://img5.imgtn.bdimg.com/it/u\\u003d1606972337,3987749266\\u0026fm\\u003d200\\u0026gp\\u003d0.jpg\"},{\"id\":14,\"name\":\"SmallCar\",\"headUrl\":\"http://img1.imgtn.bdimg.com/it/u\\u003d2623703544,3858420575\\u0026fm\\u003d27\\u0026gp\\u003d0.jpg\"}]},{\"id\":5,\"name\":\"新分组\",\"friends\":[]}]";
//                        List<FrdGroup> groups = JsonUtils.toBean(json, JsonUtils.newParamType(List.class, FrdGroup.class));
//                        // 放入数据库
//                        realm.insert(groups);

                    }
                })
                .build();
        Realm.setDefaultConfiguration(config);
    }


}
