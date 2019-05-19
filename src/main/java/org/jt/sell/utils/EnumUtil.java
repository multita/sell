package org.jt.sell.utils;

import org.jt.sell.enums.CodeEnum;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.utils
 * @ClassName: EnumUtil
 * @Author: hjt
 * @Date: 2019/5/14 15:48
 * @Version: 1.0
 */
public class EnumUtil {

    public static <T extends CodeEnum>T getByCode(Integer code,Class<T> enumClass){
        for (T each:enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }

}
