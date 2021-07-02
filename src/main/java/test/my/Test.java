package test.my;

import com.alibaba.fastjson.JSONObject;
import util.HttpUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

//public class Test {
//    public static void main(String[] args) {
////        Map<String, Object> suspectedUserMap = new HashMap<>();
////        suspectedUserMap.put("from", "big_data");
////        suspectedUserMap.put("userId", "168102441");
////
////        String url = "http://www.baidu.com";
////        JSONObject suspectedUserJson = new JSONObject().fluentPutAll(suspectedUserMap);
////        HttpUtil httpUtil = new HttpUtil();
////        httpUtil.post(url, suspectedUserJson);
//
//    }
//}

class Test{ //父类
    String name = "Rose";
    Test(){
        System.out.println("Test");//(1)
    }
    Test(String name){//name john
        this.name = name;//这里把父类的 name 修改 john
    }
}
class Demo extends Test{//子类
    String name="Jack";
    Demo()	{
        super();
        System.out.println("Demo");//(2)
    }
    Demo(String s){
        super(s);
    }
    public void test(){
        System.out.println(super.name);//(3) Rose (5) john
        System.out.println(this.name);//(4) Jack (6) Jack
    }
    public static void main(String[] args)	{
        //老韩分析
        //1. new Demo()
        new Demo().test(); //匿名对象
        new Demo("john").test();//匿名
    }
}