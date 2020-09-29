package com.lhwl.wzk.Util;

import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
@Accessors(chain = true)
public class JsonUtil<T> {
    private List<T> data=new ArrayList<>();

    public JsonUtil() {
    }

    public List<T> getData() {
        return this.data;
    }

    public JsonUtil<T> setData(List<T> data) {
        this.data = data;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof JsonUtil)) return false;
        final JsonUtil<?> other = (JsonUtil<?>) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof JsonUtil;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $data = this.getData();
        result = result * PRIME + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "JsonUtil(data=" + this.getData() + ")";
    }
}
