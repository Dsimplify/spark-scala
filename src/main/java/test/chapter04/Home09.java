package test.chapter04;

public class Home09 {
    public static void main(String[] args) {
        Music music = new Music("城府", 300);
        music.getInfo();

    }
}

/*
义Music类，里面有音乐名name、音乐时长times属性，
并有播放play功能和返回本身属性信息的功能方法getInfo
 */

class Music {
    String name;
    int times;

    public Music(String name, int times) {
        this.name = name;
        this.times = times;
    }

    public void play() {

    }

    public void getInfo() {
        System.out.println("歌名：" + name + ",时长：" + times);
    }

}
