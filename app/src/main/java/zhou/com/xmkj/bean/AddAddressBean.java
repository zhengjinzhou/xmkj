package zhou.com.xmkj.bean;

import java.io.Serializable;

/**
 * Created by zhou
 * on 2018/6/14.
 */

public class AddAddressBean implements Serializable {

    /**
     * code : 200
     * msg : 添加成功
     * time : 1528939286
     * data : {"username":"周","mobile":"13631555","address":"东莞市东城区","id":"3"}
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
         * username : 周
         * mobile : 13631555
         * address : 东莞市东城区
         * id : 3
         */

        private String username;
        private String mobile;
        private String address;
        private String id;

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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "username='" + username + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", address='" + address + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "AddAddressBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
