package zhou.com.xmkj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou
 * on 2018/6/13.
 * 交易转换
 */

public class TradingBean implements Serializable {

    /**
     * code : 200
     * msg : 获取钱包互转明细成功
     * time : 1528873194
     * data : {"page":1,"pagesize":"10","total":4,"list":[{"id":174705,"type":2,"money":"-100.00","createtime":"2018-06-13 14:58:40","note":"流通子链100￥转换注册链100￥,手续费0￥","from_type":"交易转换"},{"id":174706,"type":1,"money":"100.00","createtime":"2018-06-13 14:58:40","note":"流通子链100￥转换注册链100￥,手续费0￥","from_type":"交易转换"},{"id":174703,"type":2,"money":"-110.00","createtime":"2018-06-13 14:58:31","note":"流通子链110￥转换交易子链100￥,手续费10￥","from_type":"交易转换"},{"id":174704,"type":1,"money":"100.00","createtime":"2018-06-13 14:58:31","note":"流通子链110￥转换交易子链100￥,手续费10￥","from_type":"交易转换"}]}
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
         * total : 4
         * list : [{"id":174705,"type":2,"money":"-100.00","createtime":"2018-06-13 14:58:40","note":"流通子链100￥转换注册链100￥,手续费0￥","from_type":"交易转换"},{"id":174706,"type":1,"money":"100.00","createtime":"2018-06-13 14:58:40","note":"流通子链100￥转换注册链100￥,手续费0￥","from_type":"交易转换"},{"id":174703,"type":2,"money":"-110.00","createtime":"2018-06-13 14:58:31","note":"流通子链110￥转换交易子链100￥,手续费10￥","from_type":"交易转换"},{"id":174704,"type":1,"money":"100.00","createtime":"2018-06-13 14:58:31","note":"流通子链110￥转换交易子链100￥,手续费10￥","from_type":"交易转换"}]
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
             * id : 174705
             * type : 2
             * money : -100.00
             * createtime : 2018-06-13 14:58:40
             * note : 流通子链100￥转换注册链100￥,手续费0￥
             * from_type : 交易转换
             */

            private int id;
            private int type;
            private String money;
            private String createtime;
            private String note;
            private String from_type;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getNote() {
                return note;
            }

            public void setNote(String note) {
                this.note = note;
            }

            public String getFrom_type() {
                return from_type;
            }

            public void setFrom_type(String from_type) {
                this.from_type = from_type;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id=" + id +
                        ", type=" + type +
                        ", money='" + money + '\'' +
                        ", createtime='" + createtime + '\'' +
                        ", note='" + note + '\'' +
                        ", from_type='" + from_type + '\'' +
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
        return "TradingBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
