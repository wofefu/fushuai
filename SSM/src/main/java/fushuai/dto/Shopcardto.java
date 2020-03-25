package fushuai.dto;

import fushuai.entity.FsGoods;

public class Shopcardto extends FsGoods {
    private int carid;

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
