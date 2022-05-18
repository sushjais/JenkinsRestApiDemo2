package com.mindflur.POJO;

import java.util.List;

public class Courses {
    private List<WebAutomation> webAutomation;
    private List<Api> api;
    private List<Mobiles> mobile;

    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(WebAutomation webAutomation) {

        this.webAutomation = (List<WebAutomation>) webAutomation;
    }

    public List<Api> getApi() {
        return api;
    }

    public void setApi(Api api) {
        this.api = (List<Api>) api;
    }

    public List<Mobiles> getMobile() {
        return mobile;
    }

    public void setMobile(Mobiles mobile) {
        this.mobile = (List<Mobiles>) mobile;
    }


}
