package com.example.alisa.quickcare;

/**
 * Created by Alisa on 2017-06-17.
 */

public class EnergyBarActivity {

    int energy;

    public EnergyBarActivity(){energy = 100;}

    public int getEnergy() {return energy;}

    public void setEnergyCake(){energy += 5;}

    public void setEnergyCarrots() {energy += 10;}

    public void setEnergyRice() {energy += 20;}

    public void setEnergyChicken() {energy += 50;}
}
