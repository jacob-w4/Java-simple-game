package com.simulation;

public class Weapon {
    private int weaponPower;
    private boolean isEquipped;

    public int getWeaponPower() {
        return weaponPower;
    }

    public boolean equip() {
        isEquipped = true;
        return isEquipped;
    }
}
