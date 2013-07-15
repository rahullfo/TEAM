/*
 * Copyright (c) 2007 Ariose Software Pvt. All rights reserved.
 * File name:ContactBean.java
 */

package org.ariose.model;

/**
 *
 * @author Atul
 */
public class ContactBean {
    private Long id;
    private String mobile;
    private String name;
    private String message;
    private String deliveryStatus;

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
