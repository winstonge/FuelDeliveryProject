package com.govansnv.fuel.test.helper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.govansnv.fuel.test.IFindByCustomerSearchTerm;
import com.govansnv.fuel.test.IFindBySearchTermTest;

@RunWith(Suite.class)
@SuiteClasses({  IFindBySearchTermTest.class, IFindByCustomerSearchTerm.class, })
public class AllITests {

}
