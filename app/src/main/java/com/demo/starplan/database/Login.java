package com.demo.starplan.database;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

public class Login extends LitePalSupport {

    private CharSequence tellNum;

    private int code;

    private int passWord;

    public CharSequence getTellNum() {
        return tellNum;
    }

    public void setTellNum(CharSequence tellNum) {
        this.tellNum = tellNum;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPassWord() {
        return passWord;
    }

    public void setPassWord(int passWord) {
        this.passWord = passWord;
    }
}

