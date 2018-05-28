package zhou.com.xmkj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/5/28.
 * 我的
 * 获取用户信息
 */

public class UserInfoBean implements Serializable{

    /**
     * code : 200
     * msg : 获取用户信息成功
     * time : 1527499756
     * data : {"id":3,"username":"33","nickname":"公司","mobile":"","avatar":"http://p8tgt6pcw.bkt.clouddn.com/avatar.png","pname":"22","rname":"22","posname":"B区","pos":2,"gender":1,"email":"","jhstatus":1,"wallet":[{"name":"VR主链","money":"10000.00","icon":"http://lian.xingmaii.com/icon/icon_0.png"},{"name":"定仓子链","money":"115355.76","icon":"http://lian.xingmaii.com/icon/icon_1.png"},{"name":"流通子链","money":"7350.85","icon":"http://lian.xingmaii.com/icon/icon_2.png"},{"name":"交易子链","money":"0.00","icon":"http://lian.xingmaii.com/icon/icon_3.png"},{"name":"重消子链","money":"10.00","icon":"http://lian.xingmaii.com/icon/icon_4.png"},{"name":"注册链","money":"0.00","icon":"http://lian.xingmaii.com/icon/icon_5.png"}]}
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
         * id : 3
         * username : 33
         * nickname : 公司
         * mobile :
         * avatar : http://p8tgt6pcw.bkt.clouddn.com/avatar.png
         * pname : 22
         * rname : 22
         * posname : B区
         * pos : 2
         * gender : 1
         * email :
         * jhstatus : 1
         * wallet : [{"name":"VR主链","money":"10000.00","icon":"http://lian.xingmaii.com/icon/icon_0.png"},{"name":"定仓子链","money":"115355.76","icon":"http://lian.xingmaii.com/icon/icon_1.png"},{"name":"流通子链","money":"7350.85","icon":"http://lian.xingmaii.com/icon/icon_2.png"},{"name":"交易子链","money":"0.00","icon":"http://lian.xingmaii.com/icon/icon_3.png"},{"name":"重消子链","money":"10.00","icon":"http://lian.xingmaii.com/icon/icon_4.png"},{"name":"注册链","money":"0.00","icon":"http://lian.xingmaii.com/icon/icon_5.png"}]
         */

        private int id;
        private String username;
        private String nickname;
        private String mobile;
        private String avatar;
        private String pname;
        private String rname;
        private String posname;
        private int pos;
        private int gender;
        private String email;
        private int jhstatus;
        private List<WalletBean> wallet;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public String getRname() {
            return rname;
        }

        public void setRname(String rname) {
            this.rname = rname;
        }

        public String getPosname() {
            return posname;
        }

        public void setPosname(String posname) {
            this.posname = posname;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getJhstatus() {
            return jhstatus;
        }

        public void setJhstatus(int jhstatus) {
            this.jhstatus = jhstatus;
        }

        public List<WalletBean> getWallet() {
            return wallet;
        }

        public void setWallet(List<WalletBean> wallet) {
            this.wallet = wallet;
        }

        public static class WalletBean {
            /**
             * name : VR主链
             * money : 10000.00
             * icon : http://lian.xingmaii.com/icon/icon_0.png
             */

            private String name;
            private String money;
            private String icon;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            @Override
            public String toString() {
                return "WalletBean{" +
                        "name='" + name + '\'' +
                        ", money='" + money + '\'' +
                        ", icon='" + icon + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", pname='" + pname + '\'' +
                    ", rname='" + rname + '\'' +
                    ", posname='" + posname + '\'' +
                    ", pos=" + pos +
                    ", gender=" + gender +
                    ", email='" + email + '\'' +
                    ", jhstatus=" + jhstatus +
                    ", wallet=" + wallet +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UserInfoBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
