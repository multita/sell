package org.jt.sell.VO;

import lombok.Data;
import lombok.Getter;

//http返回的最外层对象
@Data
public class ResultVO<T> {
//    错误码+详细信息+数据
    private Integer code;

    private String msg;

    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
