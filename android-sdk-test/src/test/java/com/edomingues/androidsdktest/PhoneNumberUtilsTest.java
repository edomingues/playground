package com.edomingues.androidsdktest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.telephony.PhoneNumberUtils;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class PhoneNumberUtilsTest {

	@Test
	public void test() {
		String number = "phone1";
		
		String phoneNumber = PhoneNumberUtils.stripSeparators(number);
		
		assertEquals(number, phoneNumber);		
	}

}
