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
public enum EnumPaymntType {
    A_VISTA, DEBITO, SEM_JUROS_2X, SEM_JUROS_3X;	
	private int value;
	private EnumPaymntType() {
		value = ordinal();
	}
}