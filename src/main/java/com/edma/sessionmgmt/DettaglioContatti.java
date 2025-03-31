package com.edma.sessionmgmt; 

public class DettaglioContatti {

    public String mobile;

    public String email;

    public String address;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DettaglioContatti(String mobile, String email, String address) {
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }
    


}
