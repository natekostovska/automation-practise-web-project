package com.automationpractise.tests.dataproviders;

import com.automationpractise.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.automationpractise.staticvariables.StaticVariables.HOME_PAGE_MENU_ITEMS;

public class HomePageDataProviderTests extends BaseTests {
    @DataProvider(name="homePage")
    public static Object[][] dataProvider(){
        return new Object[][]{
                {"fdgdfggdfdfgdfgdfgdgdgdggdgdgdfgdgdgdfggdfgfdfgdfg321213132131fg31d31gd23f1g3d1g2f3g1fd1g3d1gfd3g1fd31gd31g3df1gd1g3d1gd1g3d1gd31gd31g31g31gd31gd31g3d13g13fd1g3fd1g3d1g3d1gd1g3fd1g3fd1g3d1g3fd1g3d1gfd31gfd1gfd31gfd1g3d1g3fd1gd1gd31g31gd31gd1g3d1g3d1g3d1g3d1gdf1gd3f1g3fd1gd1g3"},
                {"$#%^&&^*^&*^%#!"},
                {"123456"},
                {"Blouse"},
                {" "},
                {"dfgdfg fdgdfg "},
                {"%"}
        };
    }
    @Test(dataProvider = "homePage",groups = {"Smoke","Regression"})
    public void homePageSearchBarTest(String search){
        homePage.searchItems(search);
    }

    @DataProvider(name="homePageMenuItems")
    public static Object[][] dataProvider1(){
        return new Object[][]{
                {HOME_PAGE_MENU_ITEMS[0],HOME_PAGE_MENU_ITEMS[0]},
                {HOME_PAGE_MENU_ITEMS[1],HOME_PAGE_MENU_ITEMS[1]},
                {HOME_PAGE_MENU_ITEMS[2],HOME_PAGE_MENU_ITEMS[2]}

        };
    }
    @Test(dataProvider = "homePageMenuItems",groups = {"Smoke","Regression"})
    public void homePageMenuItemsTest(String menuItem,String pageName){
        homePage.clickMenuItem(menuItem);
        Assert.assertEquals(menuItem,pageName);
    }

}
