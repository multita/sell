package org.jt.sell.utils;

import java.util.Random;

public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);

    }

    /**
     * 生成8位随机密码
     * 格式: 混合 字符字母和数字
     * @return
     */
    public static String randomPassword() {

        // 定义一个字符型数组用来存放密码数据随机取值的内容
        char[] pardStore = new char[62];

        // 把所有的大写字母放进去
         char beg = 'A';
         for(int i=0;i<=25;i++){

            pardStore[i]=beg;

            beg=(char)(beg+1);//因为相加所以数据类型会自动转换为int型，所以要强制转换为char型不然不匹配

        }

        // 把所有的小写字母放进去

        char beg1 = 'a';

        for(int i=26;i<=51;i++){

            pardStore[i]=beg1;

            beg1=(char)(beg1+1);

        }

        // 把0到9放进去

        char beg2 = '0';

        for(int i=52;i<=61;i++){

            pardStore[i]=beg2;

            beg2=(char)(beg2+1);

        }

        StringBuffer result=new StringBuffer("");
        for(int i=1 ; i<=6;i++)

        {
            int n =(int) (Math.random() * 62);;//随机生成一个整数，这个整数的范围就是[0,61）
           result.append(pardStore[n]);
        }
        return result.toString();
    }
}
