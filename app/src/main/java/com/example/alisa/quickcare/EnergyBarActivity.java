package com.example.alisa.quickcare;

/**
 * Created by Alisa on 2017-06-17.
 */

public class EnergyBarActivity {

    int energy;

    public EnergyBarActivity(){energy = 0;}

    public int getEnergy() {return energy;}

    public void setEnergyCake() {
        if (energy <= 95) {
            energy += 5;
        }
    }

    public void setEnergyCarrots() {
        if (energy <= 90) {
            energy += 10;
        }
    }

    public void setEnergyRice() {
        if (energy <= 80) {
            energy += 20;
        }
    }

    public void setEnergyChicken() {
        if (energy <= 50) {
            energy += 50;
        }
    }



}
