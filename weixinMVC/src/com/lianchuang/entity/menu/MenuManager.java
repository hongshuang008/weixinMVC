package com.lianchuang.entity.menu;

import com.lianchuang.entity.AccessToken;
import com.lianchuang.util.Constants;
import com.lianchuang.util.PropertiesUtil;
import com.lianchuang.util.WeixinUtil;
import com.sun.jmx.snmp.Timestamp;

public class MenuManager
{
	private static AccessToken token = new AccessToken();
    /**
     * 菜单文件路径
     */
//    private static readonly string Menu_Data_Path = System.AppDomain.CurrentDomain.BaseDirectory + "/Data/menu.txt";
	private static String myMenu ="{\"button\":[{\"name\":\"菜单看看\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.sohu.com\"},{\"type\":\"click\",\"name\":\"子菜单一二\",\"key\":\"V1001_GOOD\"}]},{\"name\":\"菜单二\",\"sub_button\":[{\"type\":\"click\",\"name\":\"子菜单二一\",\"key\":\"V1002_HELLO_WORLD\"},{\"type\":\"click\",\"name\":\"子菜单二二\",\"key\":\"V1002_GOOD\"}]},{\"name\":\"菜单三\",\"sub_button\":[{\"type\":\"click\",\"name\":\"子菜单三一\",\"key\":\"V1003_GOOD\"}]}]}";
    /**
     * 获取菜单
     * @return
     */
    public static String GetMenu()
    {
    	String requestUrl = Constants.GET_MENU.replace("ACCESS_TOKEN" , token.getAccessToken());
        String result = WeixinUtil.httpRequest(requestUrl , "GET" , null);
        System.out.println(result);
        return result;
    }
    /**
     * 创建菜单
     * @param menu
     */
    public static void CreateMenu()
    {
        String requestUrl = Constants.CREATE_MENU.replace("ACCESS_TOKEN" , token.getAccessToken());
        String result = WeixinUtil.httpRequest(requestUrl , "POST" , LoadMenu());
        System.out.println(result);
    }
    /**
     * 删除菜单
     */
    public static void DeleteMenu()
    {
    	String requestUrl = Constants.DELETE_MENU.replace("ACCESS_TOKEN" , token.getAccessToken());
        String result = WeixinUtil.httpRequest(requestUrl , "GET" , null);
        System.out.println(result);
    }
    /**
     * 加载菜单
     * @return
     */
    public static String LoadMenu()
    {
//        return FileUtility.Read(Menu_Data_Path);
    	return myMenu;
    }
    
    public static void main(String[] args) {
		WeixinUtil util = new WeixinUtil();
		try {
			token = util.getAccessToken2(Constants.APPID, Constants.SECRET);
			DeleteMenu();
			CreateMenu();
			GetMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
