package test.project01.view;


import test.project01.domain.House;
import test.project01.service.HouseService;
import test.project01.util.Utility;

import javax.sound.midi.Soundbank;
import java.time.temporal.ValueRange;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(2);


    public void listHouse() {
        System.out.println("---------------房屋列表---------------");
        System.out.println("编号\t" + "房主\t" + "电话\t" + "地址\t"
                + "月住\t" + "状态\t");
        House[] list = houseService.list();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                break;
            }
            System.out.println(list[i]);
        }

    }

    public void addHouse() {
        System.out.println("---------------新增房源---------------");
    }

    public void menuMain() {
        do {
            System.out.println("---------------房屋出租系统---------------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退      出");
            System.out.println("输入1-6：");
            key = Utility.readChar();
            switch (this.key) {
                case '1':
                    System.out.println("add");
                    break;
                case '2':
                    System.out.println("read");
                    break;
                case '3':
                    System.out.println("delete");
                    break;
                case '4':
                    System.out.println("update");
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    System.out.println("退出");
                    loop = false;
                    break;
            }
        } while (loop);

    }
}
