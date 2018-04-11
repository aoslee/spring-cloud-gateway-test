package com.gatewaytest.aaa;

public class ReturnResutl {

    private long result;

    @Override
    public String toString() {
        return "{\"ReturnResutl\":{"
                + "\"result\":\"" + result + "\""
                + "}}";
    }

    public ReturnResutl() {
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }


}
