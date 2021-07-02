package test.chapter01;

public class Break01 {
    public static void main(String[] args) {

//        // 1-100 以内的数求和，求出 当和 第一次大于 20 的当前数 【for + break】
//
//        int sum = 0;
//        for (int i = 1; i <= 100; i++ ) {
//            sum += i;
//            if (sum > 20) {
//                System.out.println(sum);
//                break;
//            }
//
//        }

        // 实现登录验证，有 3 次机会，如果用户名为"丁真" ,密码"666"提示登录成功，否则提示还有几次机会，请使用 for+break


        label1:
        for(int j = 0; j < 4; j++){
            label2:
            for(int i = 0; i < 10; i++){
                if(i == 2){
                    //看看分别输出什么值，并分析
                    //continue ;
                    //continue label2;
                    continue label1;
                }
                System.out.println("i = " + i);
            }
            System.out.println();
        }
    }
}
