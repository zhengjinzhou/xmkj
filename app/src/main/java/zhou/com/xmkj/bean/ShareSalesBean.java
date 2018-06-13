package zhou.com.xmkj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou
 * on 2018/6/13.
 * 交易大厅
 */

public class ShareSalesBean implements Serializable {

    /**
     * code : 200
     * msg : 获取交易大厅首页成功
     * time : 1528862692
     * data : {"list":[{"id":2036,"num":"5000.00","createtime":"2018-06-04","avatar":"http://qiniu.weiwachuang.com/a45289de-7c57-40c0-8692-47fc2393f6bb","username":"11"},{"id":2035,"num":"600.00","createtime":"2018-05-29","avatar":"http://qiniu.weiwachuang.com/avatar.png","username":"lj2918"},{"id":2034,"num":"800.00","createtime":"2018-05-29","avatar":"http://qiniu.weiwachuang.com/avatar.png","username":"lxl7808"},{"id":2033,"num":"1000.00","createtime":"2018-05-29","avatar":"http://qiniu.weiwachuang.com/avatar.png","username":"w0001"},{"id":2032,"num":"1000.00","createtime":"2018-05-29","avatar":"http://qiniu.weiwachuang.com/avatar.png","username":"zh123456"},{"id":2031,"num":"500.00","createtime":"2018-05-29","avatar":"http://qiniu.weiwachuang.com/avatar.png","username":"yys6792"},{"id":2030,"num":"5000.00","createtime":"2018-05-29","avatar":"http://qiniu.weiwachuang.com/avatar.png","username":"aaa1111"},{"id":2029,"num":"800.00","createtime":"2018-05-29","avatar":"http://qiniu.weiwachuang.com/avatar.png","username":"yys679"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 2036
             * num : 5000.00
             * createtime : 2018-06-04
             * avatar : http://qiniu.weiwachuang.com/a45289de-7c57-40c0-8692-47fc2393f6bb
             * username : 11
             */

            private int id;
            private String num;
            private String createtime;
            private String avatar;
            private String username;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id=" + id +
                        ", num='" + num + '\'' +
                        ", createtime='" + createtime + '\'' +
                        ", avatar='" + avatar + '\'' +
                        ", username='" + username + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "list=" + list +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ShareSalesBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
