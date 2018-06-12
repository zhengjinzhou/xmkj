package zhou.com.xmkj.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou
 * on 2018/6/12.
 */

public class AddressBean implements Serializable {

    /**
     * code : 200
     * msg : 获取收货地址列表成功
     * time : 1528791769
     * data : {"page":1,"pagesize":"10","total":2,"list":[{"id":2,"username":"邱","mobile":"13712181902","address":"东莞2"},{"id":1,"username":"邱","mobile":"13812152673","address":"东莞"}]}
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
         * total : 2
         * list : [{"id":2,"username":"邱","mobile":"13712181902","address":"东莞2"},{"id":1,"username":"邱","mobile":"13812152673","address":"东莞"}]
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
             * id : 2
             * username : 邱
             * mobile : 13712181902
             * address : 东莞2
             */

            private int id;
            private String username;
            private String mobile;
            private String address;

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

            @Override
            public String toString() {
                return "ListBean{" +
                        "id=" + id +
                        ", username='" + username + '\'' +
                        ", mobile='" + mobile + '\'' +
                        ", address='" + address + '\'' +
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
        return "AddressBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
