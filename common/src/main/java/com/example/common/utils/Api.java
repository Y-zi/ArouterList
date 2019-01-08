package com.example.common.utils;

public class Api {
    /*

A ＝ QU (“https://kuaiyinshi.com/api/dou-yin/recommend/”)
B ＝ “http://aweme.snssdk.com/aweme/v1/play/?video_id=” ＋ 解密 (文本_取出中间文本 (A, “video_id=:”, “&line”, , )) ＋ “&line=0&ratio=720p&media_type=4&vr_type=0&test_cdn=None&improve_bitrate=0”
C ＝ 文本_取出中间文本 (A, #c, #d, 1, )
E ＝ 文本_取出中间文本 (A, #z, #y, , )
D ＝ “http:” ＋ 文本_取出中间文本 (A, #f, #g, , )

作品URL_保存变量 ＝ B
作者名称_保存变量 ＝ E
描述_保存变量 ＝ C
头像地址_保存变量 ＝ D

.子程序 QU, 文本型
.参数 a, 文本型
.局部变量 b, 文本型
.局部变量 c, 文本型

b ＝ a
c ＝ 网页_取网页源码 (b)
c ＝ 编码_usc2到ansi (c)
返回 (c)

.子程序 解密, 文本型
.参数 a, 文本型
.局部变量 b, 整数型, , "160"
.局部变量 c, 整数型
.局部变量 d, 文本型, , "0"
.局部变量 e, 文本型

d ＝ 分割文本 (a, “:”, )
b ＝ { 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106 }
        *被赋值的变量或数组:b
        *用作赋予的值或资源:{ 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106, 65, 48, 77, 106, 90, 102, 77, 84, 89, 48, 78, 68, 65, 51, 77, 106 }
.计次循环首 (取数组成员数 (d), c)
    e ＝ e ＋ 字符 (到整数 (d [c]) － b [c])
.计次循环尾 ()
返回 (e)

*/
}
/*
*
* A{
    "code":200,
    "data":[
        {
            "desc":"千万不要用耳机食用！会把你耳朵震聋的，有很多小可爱在我的视频底下说了自己的情感，我只想说你们得去追不会留遗憾",
            "avatar":"//p3.pstatp.com/aweme/100x100/8aea0002f5705e3347be.jpeg",
            "video_url":"//api.amemv.com/aweme/v1/playwm/?video_id=:183:96:127:154:138:204:132:182:137:96:126:116:163:150:187:154:118:161:195:157:189:214:130:185:207:104:181:170:117:160:131:154&line=0&ratio=720p&media_type=4&vr_type=0&test_cdn=None&improve_bitrate=0",
            "unique_id":null,
            "nickname":"木槿",
            "short_id":":115:96:134:162:146:150:126:133:137",
            "share_url":"//www.amemv.com/share/video/6570192121020550413/",
            "video_img":"//p3.pstatp.com/large/919c00034389faa68cdd.jpeg",
            "statistics":{
                "zan":1530,
                "comment":17,
                "share":14,
                "play":0
            },
评论            "comments":[
                {
                    "text":"我爱你，即使我知道你还没有忘了她，我可以等",
                    "create_time":1529788895,
                    "nickname":"樱花树下的那段情",
                    "zan":0,
                    "avatar":"//p1.pstatp.com/aweme/100x100/90ee000ff727e7892820.jpeg",
                    "short_id":"964542648"
                },
                {
                    "text":"我爱你，你不是说我是你重要的人吗？可你为什么要对你重要的人这样？💔我真的好爱你",
                    "create_time":1529788808,
                    "nickname":"樱花树下的那段情",
                    "zan":0,
                    "avatar":"//p1.pstatp.com/aweme/100x100/90ee000ff727e7892820.jpeg",
                    "short_id":"964542648"
                },
                {
                    "text":"我爱你 你还爱我吗？“不爱 你只是我的习惯而已”",
                    "create_time":1529787735,
                    "nickname":"辞殇雪",
                    "zan":0,
                    "avatar":"//p1.pstatp.com/aweme/100x100/8e4000011732d6255f31.jpeg",
                    "short_id":"104046717"
                },
                {
                    "text":"猜不透",
                    "create_time":1529762227,
                    "nickname":"木槿",
                    "zan":1,
                    "avatar":"//p3.pstatp.com/aweme/100x100/8aea0002f5705e3347be.jpeg",
                    "short_id":"209880110"
                },
                {
                    "text":"我爱你，你爱我吗？ 不爱对吧我知道，你爱的是她",
                    "create_time":1529753942,
                    "nickname":"染七♡",
                    "zan":0,
                    "avatar":"//p3.pstatp.com/aweme/100x100/5fcf00269bfbeaf8ac00.jpeg",
                    "short_id":"199390275"
                },
                {
                    "text":"@听书生 我爱你，你还爱我吗",
                    "create_time":1529752974,
                    "nickname":"小璃儿💕",
                    "zan":0,
                    "avatar":"//p1.pstatp.com/aweme/100x100/8e4d0024d0daae6cab95.jpeg",
                    "short_id":"818136331"
                },
                {
                    "text":"第24天了，再见",
                    "create_time":1529752737,
                    "nickname":"大佬易",
                    "zan":0,
                    "avatar":"//p9.pstatp.com/thumb/78bf0019f75cf3ecde6b",
                    "short_id":"837613856"
                },
                {
                    "text":"什么歌",
                    "create_time":1529751922,
                    "nickname":"大傻子",
                    "zan":0,
                    "avatar":"//p3.pstatp.com/aweme/100x100/8e49001f18012d4c3da3.jpeg",
                    "short_id":"382827816"
                },
                {
                    "text":"💛",
                    "create_time":1529751541,
                    "nickname":"Angelikun💛",
                    "zan":0,
                    "avatar":"//p3.pstatp.com/aweme/100x100/8aea0015b6d61921a916.jpeg",
                    "short_id":"159274818"
                },
                {
                    "text":"乖，他不爱了",
                    "create_time":1529750562,
                    "nickname":"宥沐",
                    "zan":8,
                    "avatar":"//p1.pstatp.com/aweme/100x100/90fb000996f4c4e85ff7.jpeg",
                    "short_id":"198378478"
                },
                {
                    "text":"哦，那我第四",
                    "create_time":1529750257,
                    "nickname":"trust with doubt.",
                    "zan":2,
                    "avatar":"//p3.pstatp.com/aweme/100x100/75b7002a5e45adc20b5e.jpeg",
                    "short_id":"597871282"
                },
                {
                    "text":"其实第四啦！",
                    "create_time":1529750206,
                    "nickname":"木槿",
                    "zan":2,
                    "avatar":"//p3.pstatp.com/aweme/100x100/8aea0002f5705e3347be.jpeg",
                    "short_id":"209880110"
                },
                {
                    "text":"不爱他了",
                    "create_time":1529750194,
                    "nickname":"残瞳",
                    "zan":1,
                    "avatar":"//p3.pstatp.com/aweme/100x100/90f50020cf180821ac11.jpeg",
                    "short_id":"693769734"
                },
                {
                    "text":"第七",
                    "create_time":1529749962,
                    "nickname":"草莓🍓有点甜",
                    "zan":1,
                    "avatar":"//p3.pstatp.com/aweme/100x100/90f8001023897e336025.jpeg",
                    "short_id":"576327564"
                },
                {
                    "text":"那你去",
                    "create_time":1529749890,
                    "nickname":"滚！",
                    "zan":1,
                    "avatar":"//p1.pstatp.com/aweme/100x100/6720000172248655c0cc.jpeg",
                    "short_id":"96662001"
                },
                {
                    "text":"第三，🐌",
                    "create_time":1529749856,
                    "nickname":"trust with doubt.",
                    "zan":1,
                    "avatar":"//p3.pstatp.com/aweme/100x100/75b7002a5e45adc20b5e.jpeg",
                    "short_id":"597871282"
                },
                {
                    "text":"第三",
                    "create_time":1529749833,
                    "nickname":"霞",
                    "zan":1,
                    "avatar":"//p3.pstatp.com/aweme/100x100/8d77002cbdbba8e60a8b.jpeg",
                    "short_id":"147699860"
                },
                {
                    "text":"第二，嘻嘻",
                    "create_time":1529749236,
                    "nickname":"呆萌小仙女",
                    "zan":0,
                    "avatar":"//p3.pstatp.com/thumb/834a001b7281112c21f9",
                    "short_id":"947560747"
                },
                {
                    "text":"第一",
                    "create_time":1529746343,
                    "nickname":"樱雪恋",
                    "zan":3,
                    "avatar":"//p1.pstatp.com/aweme/100x100/85e40024edd49bfa49f3.jpeg",
                    "short_id":"287817131"
                }
            ],
            "tb_link":null
        }
    ]
}
©2014 JSON.cn All right reserved. 京ICP备15025187号-1 邮箱：service@json.cn*/


//https://kuaiyinshi.com/api/kuai-shou/recommend/
/*{
    "code":200,
    "data":[
        {
            "desc":"感谢支持宝的亲人们。。",
            "avatar":"//ali2.a.yximgs.com/uhead/AB/2018/05/21/11/BMjAxODA1MjExMTI5MzhfNDIxNTQ3MTg0XzJfaGQxOTVfNzU1_s.jpg",
            "video_url":"//js2.a.yximgs.com/upic/2018/10/21/07/:131:125:183:171:210:181:145:153:208:125:184:137:184:129:199:183:114:125:183:206:192:180:145:157:209:126:162:149:116:128:161:209:113:136:199:209:139:180:161:173:139:126:162:157:116:129:183:180:167:125:185:162:212:197:175:179:155:101:132:169:121:151:131:161:165:145:131:204:191:155:127:139:145:104:129:168:162:103:177:160:116:97:131:161:140:152:175:181:144.mp4",
            "unique_id":null,
            "nickname":"东北颜宝",
            "short_id":":117:98:126:159:142:157:126:140:141",
            "share_url":null,
            "video_img":"//tx2.a.yximgs.com/upic/2018/10/21/07/BMjAxODEwMjEwNzM1MjdfNDIxNTQ3MTg0Xzg1NTY2NTY3NjJfMl8z_Ba178385d5daaba9cf9223fc28da7e788.jpg",
            "statistics":{
                "zan":12594,
                "comment":735,
                "share":0,
                "play":222752
            },
            "comments":[
                {
                    "text":"你老公呢？为什么都你干活？",
                    "create_time":1540511144,
                    "nickname":"行风千里之外<img width="14" class="emoji" src="//static.yximgs.com/s1/archive/i/emoji/2x/1f64f.png">",
                    "zan":0,
                    "avatar":"//tx2.a.yximgs.com/uhead/AB/2017/01/05/15/BMjAxNzAxMDUxNTA1MjdfNDE1NDg5ODk2XzJfaGQ3MA==.jpg",
                    "short_id":421547184
                },
                {
                    "text":"66666666666",
                    "create_time":1540499626,
                    "nickname":"独我孤单<img width="14" class="emoji" src="//static.yximgs.com/s1/archive/i/emoji/2x/1f339.png">521☘",
                    "zan":0,
                    "avatar":"//tx2.a.yximgs.com/uhead/AB/2016/07/02/19/BMjAxNjA3MDIxOTI3MzRfMjA5ODU4NzcyXzJfaGQ2MA==.jpg",
                    "short_id":421547184
                },
                {
                    "text":"四平哪里的美女，我去找你",
                    "create_time":1540477018,
                    "nickname":"张福增",
                    "zan":0,
                    "avatar":"//js2.a.yximgs.com/uhead/AB/2016/05/07/22/BMjAxNjA1MDcyMjUyMTlfMjM0NzQ1MDg3XzJfaGQ2Mw==.jpg",
                    "short_id":421547184
                },
                {
                    "text":"66666666",
                    "create_time":1540476382,
                    "nickname":"麦小龙4",
                    "zan":0,
                    "avatar":"//tx2.a.yximgs.com/uhead/AB/2018/09/02/11/BMjAxODA5MDIxMTEyMThfMTQxNDYxNDM0XzJfaGQxMTJfNTcy_s.jpg",
                    "short_id":421547184
                },
                {
                    "text":"女汉子666",
                    "create_time":1540464261,
                    "nickname":"观八方",
                    "zan":0,
                    "avatar":"//js2.a.yximgs.com/uhead/AB/2018/08/12/18/BMjAxODA4MTIxODI5MTlfODgyMjc0ODg3XzJfaGQ1MjJfOTY1_s.jpg",
                    "short_id":421547184
                }
            ],
            "tb_link":null
        }
    ]
}*/