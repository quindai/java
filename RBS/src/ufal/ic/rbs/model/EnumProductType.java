/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ufal.ic.rbs.model;

/**
 *
 * @author randy
 */
public enum EnumProductType {
    FOOD, DRINK;
    private int value;
    private EnumProductType(){
        value = ordinal();
    }
}
