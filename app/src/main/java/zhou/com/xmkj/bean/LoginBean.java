package zhou.com.xmkj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/5/25.
 * 登录接口返回成功参数
 */

public class LoginBean implements Serializable{

    /**
     * code : 200
     * msg : 登录成功
     * time : 1527235106
     * data : {"id":3,"token":"5d290a944f0d1dee002dfe7ea9f8939c","username":"33","mobile":"","nickname":"公司","gender":1,"pos":2,"avatar":"http://p8tgt6pcw.bkt.clouddn.com/avatar.png","jhstatus":1}
     */

    private int code;
    private String msg;
    private String time;
    private DataBean data;
    private List<?> data2;

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
         * token : 5d290a944f0d1dee002dfe7ea9f8939c
         * username : 33
         * mobile :
         * nickname : 公司
         * gender : 1
         * pos : 2
         * avatar : http://p8tgt6pcw.bkt.clouddn.com/avatar.png
         * jhstatus : 1
         */

        private int id;
        private String token;
        private String username;
        private String mobile;
        private String nickname;
        private int gender;
        private int pos;
        private String avatar;
        private int jhstatus;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getJhstatus() {
            return jhstatus;
        }

        public void setJhstatus(int jhstatus) {
            this.jhstatus = jhstatus;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", token='" + token + '\'' +
                    ", username='" + username + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", gender=" + gender +
                    ", pos=" + pos +
                    ", avatar='" + avatar + '\'' +
                    ", jhstatus=" + jhstatus +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
