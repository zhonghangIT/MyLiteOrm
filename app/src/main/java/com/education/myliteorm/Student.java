package com.education.myliteorm;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by zhonghang on 16/7/8.
 */
@Table("student")
public class Student {
    @Column("_id")
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private Long id;
    @Column("name")
    @NotNull
    private String name;
    @Column("age")
    @NotNull
    private int age;
    @Column("sex")
    @NotNull
    private String sex;

    public Student() {
    }

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
