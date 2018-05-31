package zhou.com.xmkj.bean;

import java.util.List;

/**
 * Created by zhou on 2018/5/30.
 */

public class FansListBean {

    /**
     * code : 200
     * msg : 获取粉丝列表成功
     * time : 1527663983
     * data : {"page":1,"pagesize":"10","total":1,"list":[{"username":"333","nickname":"公司","avatar":"http://p8tgt6pcw.bkt.clouddn.com/avatar.png","createtime":"2018-01-15"}]}
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
         * page : 1
         * pagesize : 10
         * total : 1
         * list : [{"username":"333","nickname":"公司","avatar":"http://p8tgt6pcw.bkt.clouddn.com/avatar.png","createtime":"2018-01-15"}]
         */

        private int page;
        private String pagesize;
        private int total;
        private List<ListBean> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getPagesize() {
            return pagesize;
        }

        public void setPagesize(String pagesize) {
            this.pagesize = pagesize;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * username : 333
             * nickname : 公司
             * avatar : http://p8tgt6pcw.bkt.clouddn.com/avatar.png
             * createtime : 2018-01-15
             */

            private String username;
            private String nickname;
            private String avatar;
            private String createtime;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "username='" + username + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", createtime='" + createtime + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "page=" + page +
                    ", pagesize='" + pagesize + '\'' +
                    ", total=" + total +
                    ", list=" + list +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "FansListBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
