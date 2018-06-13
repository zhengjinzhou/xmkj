package zhou.com.xmkj.bean;

import java.io.Serializable;

/**
 * Created by zhou
 * on 2018/6/13.
 * 获取用户钱包
 * 类型,0:定仓主链,1:定仓子链,2:流通子链,3:交易子链,4:重消积分,5:注册链
 */

public class WalletBean implements Serializable {

    /**
     * code : 200
     * msg : 获取用户钱包成功
     * time : 1528870999
     * data : {"name":"定仓主链","money":"119.0500"}
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
         * name : 定仓主链
         * money : 119.0500
         */

        private String name;
        private String money;

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

        @Override
        public String toString() {
            return "DataBean{" +
                    "name='" + name + '\'' +
                    ", money='" + money + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WalletBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
