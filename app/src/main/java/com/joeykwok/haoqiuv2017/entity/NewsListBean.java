package com.joeykwok.haoqiuv2017.entity;

import java.util.List;

/**
 * Created by gjwlg on 2017/1/9.
 */

public class NewsListBean {


    /**
     * code : 00
     * data : [{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091211245172.jpg","source":"天视体育","time":"2017-01-09 12:15:09 ","title":"卡纳瓦罗：维特塞尔欧洲一流，卡利尼奇只是备选"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091208005052.jpg","source":"重庆晨报","time":"2017-01-09 12:12:29 ","title":"渝媒：区楚良加入重庆管理层 负责球队建设和青训梯队"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091153576525.jpg","source":"每日镜报","time":"2017-01-09 11:54:46 ","title":"菲尔米诺家中被盗 7万镑财物遭窃"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091139164410.jpg","source":"FourFourTwo","time":"2017-01-09 11:39:58 ","title":"葡萄牙主帅：欧洲杯决赛C罗就像我们的第12人"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091133278789.jpg","source":"莱斯特城官网","time":"2017-01-09 11:36:14 ","title":"打破垄断，小舒梅切尔当选丹麦足球先生"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091123203884.jpg","source":"足球报","time":"2017-01-09 11:23:58 ","title":"孙鹏将接班沈力成为国安总经理"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091056094009.jpg","source":"twitter","time":"2017-01-09 10:56:41 ","title":"克莱门特想把巴德带到斯旺西"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091048484875.jpg","source":"每日邮报","time":"2017-01-09 10:52:31 ","title":"孔蒂：小法时刻做好比赛的准备 可以帮助球队"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091045017034.jpg","source":"FourFourTwo","time":"2017-01-09 10:46:37 ","title":"马洛塔：没有接到关于迪巴拉的电话"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091033289634.jpg","source":"直播吧","time":"2017-01-09 10:34:19 ","title":"申花新闻官：特维斯不是中超第一高薪"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091025284047.jpg","source":"每日邮报","time":"2017-01-09 10:25:46 ","title":"邮报：替代阿克，萨科和乔-戈麦斯成为伯恩茅斯新目标"},{"pic":"http://tu.qiumibao.com/uploads/day_170109/201701091007362017.jpg","source":"直播吧","time":"2017-01-09 10:19:39 ","title":"这题你会吗？巴神发问网友：哪个水箱先被注满"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091016173245.jpg","source":"图片报","time":"2017-01-09 10:17:39 ","title":"诺伊尔与女友在圣诞节期间订婚"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701091006089995.jpg","source":"天空体育","time":"2017-01-09 10:06:29 ","title":"穆里尼奥：拉什福德可能打破鲁尼和查尔顿的记录"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701090939043422.jpg","source":"直播吧","time":"2017-01-09 09:42:27 ","title":"奥斯卡：首场比赛表现不错 还需要和球队多磨合"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701090939074687.jpg","source":"每日镜报","time":"2017-01-09 09:41:39 ","title":"无缘大名单！尤文CEO：埃弗拉在思考自己的未来"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701090927415017.jpg","source":"天空体育","time":"2017-01-09 09:30:56 ","title":"温格：维尔贝克经历了一段艰难的时光"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701090919418092.jpg","source":"FourFourTwo","time":"2017-01-09 09:25:42 ","title":"拜利：林德洛夫很出色，希望能同他一起上场比赛"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701090903098908.jpg","source":"马卡报","time":"2017-01-09 09:09:53 ","title":"祝贺！阿杜里斯完成毕尔巴鄂300场"},{"pic":"http://tu.qiumibao.com/uploads/news/day_170109/201701090858088192.jpg","source":"阿斯报","time":"2017-01-09 09:00:55 ","title":"世界杯扩军预计将在2026年开始"}]
     * msg : 请求成功
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * pic : http://tu.qiumibao.com/uploads/news/day_170109/201701091211245172.jpg
         * source : 天视体育
         * time : 2017-01-09 12:15:09
         * title : 卡纳瓦罗：维特塞尔欧洲一流，卡利尼奇只是备选
         */

        private String pic;
        private String source;
        private String time;
        private String title;

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
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

        @Override
        public String toString() {
            return "DataBean{" +
                    "pic='" + pic + '\'' +
                    ", source='" + source + '\'' +
                    ", time='" + time + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
}
