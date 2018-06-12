package zhou.com.xmkj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou
 * on 2018/6/12.
 */

public class IndexBean implements Serializable{

    /**
     * code : 200
     * msg : 获取首页数据成功
     * time : 1528773452
     * data : {"banner":[{"id":10,"title":"顶部02","imageUrl":"http://lian.xingmaii.com/uploads/20180531/770a2230605164818c6f7ea2e211cd54.jpg","url":""},{"id":7,"title":"顶部01","imageUrl":"http://lian.xingmaii.com/uploads/20180531/6437d5bbb3a3fd2c6f246d6c08d0b5e9.png","url":""}],"topNews":[{"id":4,"title":"app上线啦，未来已来！","url":"http://lian.xingmaii.com/api/notice/newsdetail/newsid/4.html"}],"operation":[],"middleImage":"","category1":"公司公告","notices1":[{"id":6,"title":"东融VR简介","createtime":"2018-05-31","url":"http://lian.xingmaii.com/api/notice/newsdetail/newsid/6.html"},{"id":5,"title":"秒杀水果忍者！","createtime":"2018-05-31","url":"http://lian.xingmaii.com/api/notice/newsdetail/newsid/5.html"}],"category2":"系统公告","notices2":[{"id":3,"title":"平台APP上线","createtime":"2018-05-31","url":"http://lian.xingmaii.com/api/notice/newsdetail/newsid/3.html"}],"bottomBanner":[{"id":9,"title":"底部002","imageUrl":"http://lian.xingmaii.com/uploads/20180531/ba13e40f938804bfe956d1b46028854f.png","url":""},{"id":8,"title":"底部001","imageUrl":"http://lian.xingmaii.com/uploads/20180531/4273fafb85d7b42376c1d7f6be63e83d.png","url":""}],"bottomName":"东融VR"}
     */

    private int code;
    private String msg;
    private String time;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * banner : [{"id":10,"title":"顶部02","imageUrl":"http://lian.xingmaii.com/uploads/20180531/770a2230605164818c6f7ea2e211cd54.jpg","url":""},{"id":7,"title":"顶部01","imageUrl":"http://lian.xingmaii.com/uploads/20180531/6437d5bbb3a3fd2c6f246d6c08d0b5e9.png","url":""}]
         * topNews : [{"id":4,"title":"app上线啦，未来已来！","url":"http://lian.xingmaii.com/api/notice/newsdetail/newsid/4.html"}]
         * operation : []
         * middleImage :
         * category1 : 公司公告
         * notices1 : [{"id":6,"title":"东融VR简介","createtime":"2018-05-31","url":"http://lian.xingmaii.com/api/notice/newsdetail/newsid/6.html"},{"id":5,"title":"秒杀水果忍者！","createtime":"2018-05-31","url":"http://lian.xingmaii.com/api/notice/newsdetail/newsid/5.html"}]
         * category2 : 系统公告
         * notices2 : [{"id":3,"title":"平台APP上线","createtime":"2018-05-31","url":"http://lian.xingmaii.com/api/notice/newsdetail/newsid/3.html"}]
         * bottomBanner : [{"id":9,"title":"底部002","imageUrl":"http://lian.xingmaii.com/uploads/20180531/ba13e40f938804bfe956d1b46028854f.png","url":""},{"id":8,"title":"底部001","imageUrl":"http://lian.xingmaii.com/uploads/20180531/4273fafb85d7b42376c1d7f6be63e83d.png","url":""}]
         * bottomName : 东融VR
         */

        private String middleImage;
        private String category1;
        private String category2;
        private String bottomName;
        private List<BannerBean> banner;
        private List<TopNewsBean> topNews;
        private List<?> operation;
        private List<Notices1Bean> notices1;
        private List<Notices2Bean> notices2;
        private List<BottomBannerBean> bottomBanner;

        public String getMiddleImage() {
            return middleImage;
        }

        public void setMiddleImage(String middleImage) {
            this.middleImage = middleImage;
        }

        public String getCategory1() {
            return category1;
        }

        public void setCategory1(String category1) {
            this.category1 = category1;
        }

        public String getCategory2() {
            return category2;
        }

        public void setCategory2(String category2) {
            this.category2 = category2;
        }

        public String getBottomName() {
            return bottomName;
        }

        public void setBottomName(String bottomName) {
            this.bottomName = bottomName;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<TopNewsBean> getTopNews() {
            return topNews;
        }

        public void setTopNews(List<TopNewsBean> topNews) {
            this.topNews = topNews;
        }

        public List<?> getOperation() {
            return operation;
        }

        public void setOperation(List<?> operation) {
            this.operation = operation;
        }

        public List<Notices1Bean> getNotices1() {
            return notices1;
        }

        public void setNotices1(List<Notices1Bean> notices1) {
            this.notices1 = notices1;
        }

        public List<Notices2Bean> getNotices2() {
            return notices2;
        }

        public void setNotices2(List<Notices2Bean> notices2) {
            this.notices2 = notices2;
        }

        public List<BottomBannerBean> getBottomBanner() {
            return bottomBanner;
        }

        public void setBottomBanner(List<BottomBannerBean> bottomBanner) {
            this.bottomBanner = bottomBanner;
        }

        public static class BannerBean {
            /**
             * id : 10
             * title : 顶部02
             * imageUrl : http://lian.xingmaii.com/uploads/20180531/770a2230605164818c6f7ea2e211cd54.jpg
             * url :
             */

            private int id;
            private String title;
            private String imageUrl;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "BannerBean{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", imageUrl='" + imageUrl + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        public static class TopNewsBean {
            /**
             * id : 4
             * title : app上线啦，未来已来！
             * url : http://lian.xingmaii.com/api/notice/newsdetail/newsid/4.html
             */

            private int id;
            private String title;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "TopNewsBean{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        public static class Notices1Bean {
            /**
             * id : 6
             * title : 东融VR简介
             * createtime : 2018-05-31
             * url : http://lian.xingmaii.com/api/notice/newsdetail/newsid/6.html
             */

            private int id;
            private String title;
            private String createtime;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "Notices1Bean{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", createtime='" + createtime + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        public static class Notices2Bean {
            /**
             * id : 3
             * title : 平台APP上线
             * createtime : 2018-05-31
             * url : http://lian.xingmaii.com/api/notice/newsdetail/newsid/3.html
             */

            private int id;
            private String title;
            private String createtime;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "Notices2Bean{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", createtime='" + createtime + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        public static class BottomBannerBean {
            /**
             * id : 9
             * title : 底部002
             * imageUrl : http://lian.xingmaii.com/uploads/20180531/ba13e40f938804bfe956d1b46028854f.png
             * url :
             */

            private int id;
            private String title;
            private String imageUrl;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "BottomBannerBean{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", imageUrl='" + imageUrl + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "middleImage='" + middleImage + '\'' +
                    ", category1='" + category1 + '\'' +
                    ", category2='" + category2 + '\'' +
                    ", bottomName='" + bottomName + '\'' +
                    ", banner=" + banner +
                    ", topNews=" + topNews +
                    ", operation=" + operation +
                    ", notices1=" + notices1 +
                    ", notices2=" + notices2 +
                    ", bottomBanner=" + bottomBanner +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "IndexBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
