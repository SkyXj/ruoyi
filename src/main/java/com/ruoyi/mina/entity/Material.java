package com.ruoyi.mina.entity;

import com.ruoyi.common.utils.ByteUtils;

import java.io.UnsupportedEncodingException;

public class Material {
    //
    private double dPotencyPpb;
    //256个字节
    private String szMatName;
    private double dCps;
    private double dPotencyUgm3;

    public Material(){

    }

    public Material(byte[] bytes){
        this.dPotencyPpb=ByteUtils.bytes2Double(ByteUtils.subByte(bytes,0,8));
        try {
            this.szMatName =new String(ByteUtils.subByte(bytes, 8, 128),"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.dCps=ByteUtils.bytes2Double(ByteUtils.subByte(bytes,136,8));
        this.dPotencyUgm3=ByteUtils.bytes2Double(ByteUtils.subByte(bytes,144,8));
    }



    public double getdPotencyPpb() {
        return dPotencyPpb;
    }

    public void setdPotencyPpb(double dPotencyPpb) {
        this.dPotencyPpb = dPotencyPpb;
    }

    public String getSzMatName() {
        return szMatName;
    }

    public void setSzMatName(String szMatName) {
        this.szMatName = szMatName;
    }

    public double getdCps() {
        return dCps;
    }

    public void setdCps(double dCps) {
        this.dCps = dCps;
    }

    public double getdPotencyUgm3() {
        return dPotencyUgm3;
    }

    public void setdPotencyUgm3(double dPotencyUgm3) {
        this.dPotencyUgm3 = dPotencyUgm3;
    }

    @Override
    public String toString() {
        return szMatName+":"+dPotencyPpb+":"+dCps+":"+dPotencyUgm3;
    }
}
