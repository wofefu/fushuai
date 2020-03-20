package com.example.demo.enums;

public enum RoleType {

    SUPER_ADMIN,
    SHOP_MANAGER,
    SALESMAN

}
class Test{
    public static void main(String[] args) {
        System.out.println(RoleType.SHOP_MANAGER.name());
    }
}