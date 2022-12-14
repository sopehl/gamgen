package com.gamgen.model;

import java.util.ArrayList;

public class GamePixApiResponse {
    public String status;
    public int code;
    public ArrayList<GamePixApiData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<GamePixApiData> getData() {
        return data;
    }

    public void setData(ArrayList<GamePixApiData> data) {
        this.data = data;
    }
}
