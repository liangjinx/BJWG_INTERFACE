package com.mobile.blue.launcher.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AppProject implements Serializable {
	private static final long serialVersionUID = 4542282899714150621L;

	private Long paincbuyProjectId;

    private String name;

    private String summary;

    private String imgs;

    private Date ctime;

    private Byte type;

    private Byte status;

    private BigDecimal price;

    private Short num;

    private Short leftNum;

    private BigDecimal totalMoney;

    private Date beginTime;

    private Date endTime;

    private String otherFeeDetail;

    private BigDecimal otherFee;

    private Byte variety;

    private String detail;

    public AppProject(Long paincbuyProjectId, String name, String summary, String imgs, Date ctime, Byte type, Byte status, BigDecimal price, Short num, Short leftNum, BigDecimal totalMoney, Date beginTime, Date endTime, String otherFeeDetail, BigDecimal otherFee, Byte variety, String detail) {
        this.paincbuyProjectId = paincbuyProjectId;
        this.name = name;
        this.summary = summary;
        this.imgs = imgs;
        this.ctime = ctime;
        this.type = type;
        this.status = status;
        this.price = price;
        this.num = num;
        this.leftNum = leftNum;
        this.totalMoney = totalMoney;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.otherFeeDetail = otherFeeDetail;
        this.otherFee = otherFee;
        this.variety = variety;
        this.detail = detail;
    }

    public AppProject() {
        super();
    }

    public Long getPaincbuyProjectId() {
        return paincbuyProjectId;
    }

    public void setPaincbuyProjectId(Long paincbuyProjectId) {
        this.paincbuyProjectId = paincbuyProjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public Short getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(Short leftNum) {
        this.leftNum = leftNum;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOtherFeeDetail() {
        return otherFeeDetail;
    }

    public void setOtherFeeDetail(String otherFeeDetail) {
        this.otherFeeDetail = otherFeeDetail == null ? null : otherFeeDetail.trim();
    }

    public BigDecimal getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(BigDecimal otherFee) {
        this.otherFee = otherFee;
    }

    public Byte getVariety() {
        return variety;
    }

    public void setVariety(Byte variety) {
        this.variety = variety;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}