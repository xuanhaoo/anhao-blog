package com.blog.common.model;

import java.io.Serializable;
/**
 * 公共基础model
 * @author liangxuanhao
 * @date 2018年03月18日  10:32
 */

public abstract class baseModel<ID extends Serializable> implements Serializable  {

    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        baseModel that = (baseModel) obj;

        return null == this.getId() ? false : this.getId().equals(that.getId());
    }


    @Override
    public int hashCode() {

        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }

}

