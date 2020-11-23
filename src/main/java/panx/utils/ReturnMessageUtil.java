package panx.utils;

import panx.entity.AllBorrow;
import panx.entity.AllUser;
import panx.entity.ResultMessaage;
import panx.entity.UserData;

import java.util.List;

public class ReturnMessageUtil {
    private static ResultMessaage returnMsg = null;
    public static ResultMessaage getReturnLogin(int errCode, String errMsg, AllUser allUser, List<AllBorrow> allBorrows) {
        returnMsg = new ResultMessaage();
        returnMsg.setErrCode(errCode);
        if (!errMsg.isEmpty()) {
            returnMsg.setErrMsg(errMsg);
        }
        if (!allUser.getToken().isEmpty()) {
            returnMsg.setUsercode(allUser.getToken());
        }
        UserData userData = new UserData();
        userData.setName(allUser.getName());
        userData.setAllBorrow(allBorrows);
        returnMsg.setUserData(userData);
        return returnMsg;
    }
}
