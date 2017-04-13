package com.joeykwok.haoqiuv2017.entity;

/**
 * Created by gjwlg on 2017/1/10.
 */

public class NewsBean {


    /**
     * code : 00
     * data : {"content":"\n近日，尤文图斯前锋伊瓜因接受了天空体育电台的采访，他在访谈中表示在皇马效力时曾与巴黎圣日耳曼取得过联系，同时还谈到了苏亚雷斯、莱万、梅西等球员。在谈到皇马时期曾收到巴黎合约时，伊瓜因说道：\u201c那时候我处在一个特殊的情况下，但是那是真的，我哥哥曾和我说有那样一份来自巴黎的合约。\u201d在谈到心目中的优秀前锋时，伊瓜因表示：\u201c说实话，我觉得苏亚雷斯是一位极强大的前锋，莱万多夫斯基也表现的非常出色。有许多优秀的前锋，但是历史上最优秀的那位就是我的好友梅西。\u201d（菲莉） ","img_url":"http://tu.qiumibao.com/uploads/news/day_170109/201701092216234386.jpg","source":"世界体育报","time":"2017-01-09 22:20:21","title":"伊瓜因：众多优秀前锋中，苏亚雷斯极强而梅西最优秀"}
     * msg : 请求成功
     */

    private String code;
    private DataBean data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * content :
         近日，尤文图斯前锋伊瓜因接受了天空体育电台的采访，他在访谈中表示在皇马效力时曾与巴黎圣日耳曼取得过联系，同时还谈到了苏亚雷斯、莱万、梅西等球员。在谈到皇马时期曾收到巴黎合约时，伊瓜因说道：“那时候我处在一个特殊的情况下，但是那是真的，我哥哥曾和我说有那样一份来自巴黎的合约。”在谈到心目中的优秀前锋时，伊瓜因表示：“说实话，我觉得苏亚雷斯是一位极强大的前锋，莱万多夫斯基也表现的非常出色。有许多优秀的前锋，但是历史上最优秀的那位就是我的好友梅西。”（菲莉）
         * img_url : http://tu.qiumibao.com/uploads/news/day_170109/201701092216234386.jpg
         * source : 世界体育报
         * time : 2017-01-09 22:20:21
         * title : 伊瓜因：众多优秀前锋中，苏亚雷斯极强而梅西最优秀
         */

        private String content;
        private String img_url;
        private String source;
        private String time;
        private String title;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
