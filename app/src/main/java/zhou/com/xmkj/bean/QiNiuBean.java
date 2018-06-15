package zhou.com.xmkj.bean;

import java.io.Serializable;

/**
 * Created by zhou
 * on 2018/6/15.
 */

public class QiNiuBean implements Serializable{

    /**
     * code : 200
     * msg : 获取七牛token成功
     * time : 1529044026
     * data : {"upToken":"CSt5ov_qgON8VT_4DF8jJtbGlhMfUsPQ___pluAR:aYqEBd4Q24TPTwkiGdpoBCJJO7s=:eyJzY29wZSI6ImRyc3N2ciIsImRlYWRsaW5lIjoxNTI5MDQ3NjI2fQ=="}
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
         * upToken : CSt5ov_qgON8VT_4DF8jJtbGlhMfUsPQ___pluAR:aYqEBd4Q24TPTwkiGdpoBCJJO7s=:eyJzY29wZSI6ImRyc3N2ciIsImRlYWRsaW5lIjoxNTI5MDQ3NjI2fQ==
         */

        private String upToken;

        public String getUpToken() {
            return upToken;
        }

        public void setUpToken(String upToken) {
            this.upToken = upToken;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "upToken='" + upToken + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "QiNiuBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
