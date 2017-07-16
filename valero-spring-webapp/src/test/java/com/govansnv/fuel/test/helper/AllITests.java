package com.govansnv.fuel.test.helper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.govansnv.fuel.test.IFindByCompanySearchTerm;
import com.govansnv.fuel.test.IFindByCustomerSearchTerm;
import com.govansnv.fuel.test.IFindBySearchTermTest;
import com.govansnv.fuel.test.IManageDriversTest;

@RunWith(Suite.class)
@SuiteClasses({ IFindBySearchTermTest.class, IFindByCustomerSearchTerm.class, IFindByCompanySearchTerm.class,
		IManageDriversTest.class })
public class AllITests {

}
