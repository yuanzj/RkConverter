package com.rokyinfo.convert;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by apple on 16/4/29.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RkField {

    /**
     * 字段在字节数组中的位置
     *
     * @return
     */
    public int position();

    /**
     * 字段在字节数组中的长度
     *
     * @return
     */
    public int length();

}
