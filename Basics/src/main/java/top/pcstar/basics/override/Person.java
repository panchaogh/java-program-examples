package top.pcstar.basics.override;

import java.util.Objects;

/**
 * @Author: PanChao
 * @Description: 重写equals()方法和hashCode()方法
 * @Date: Created in 18:45 2018/7/2
 */
public class Person {
    private long id;
    private String name;
    private String sex;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        //自反性
        if (this == o) return true;
        //任何对象不等于null，比较是否为同一类型
        if (!(o instanceof Person)) return false;
        //强制类型转换
        Person person = (Person) o;
        //比较属性值
        return getId() == person.getId() &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getSex(), person.getSex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSex());
    }
}
