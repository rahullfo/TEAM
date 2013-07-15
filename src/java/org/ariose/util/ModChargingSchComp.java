/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.util;

import java.util.Comparator;
import org.ariose.model.ModChargingScheduler;

/**
 *
 * @author Sukhdeep
 */
public class ModChargingSchComp implements Comparator {

	public int compare(Object o1, Object o2) {
		ModChargingScheduler cs1 = (ModChargingScheduler) o1;
		ModChargingScheduler cs2 = (ModChargingScheduler) o2;

		int t1 = cs1.getTime();
		int t2 = cs2.getTime();

		int pr1 = cs1.getPriority();
		int pr2 = cs2.getPriority();

		int result = -1;

		if (t1 > t2) {
			result = 1;
		} else if (t1 < t2) {
			result = -1;
		} else {
			if (pr2 > pr1) {
				result = 1;
			} else if (pr2 < pr1) {
				result = -1;
			} else {
				result = 0;
			}
		}

		return result;
	}
}