package zhou.com.xmkj.bean;

/**
 * Created by zhou on 2018/5/28.
 * 我的界面的通用bean
 */

public class MyBaseBean {

    Class aClass;
    String name;
    int icon;

    public MyBaseBean(Class aClass, String name, int icon) {
        this.aClass = aClass;
        this.name = name;
        this.icon = icon;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
