package com.balawo.models.takeouts;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "takeout_restaurants", schema = "public", catalog = "my_java")
public class TakeoutRestaurants {
    private long id;
    private String name;
    private Long adminId;
    private Long bossId;
    private Long departmentId;
    private Integer status;
    private Integer deliveryFastestTime;
    private Integer deliverySlowestTime;
    private Integer isBreakfast;
    private Integer isLunch;
    private Integer isDinner;
    private Time breakfastStartAt;
    private Time breakfastEndAt;
    private Time lunchStartAt;
    private Time lunchEndAt;
    private Time dinnerStartAt;
    private Time dinnerEndAt;
    private Integer overallStar;
    private Integer commentCount;
    private String payType;
    private String bigImg;
    private BigDecimal tablewarePrice;
    private BigDecimal packagePrice;
    private String takeoutRule;
    private String remark;
    private Integer sort;
    private Integer likeCount;
    private String phone;
    private String identifier;
    private String breakfastName;
    private String lunchName;
    private String dinnerName;
    private String listImg;
    private String detailImg;
    private Integer salesNum;
    private Integer onlineStatus;
    private BigDecimal orderMinPrice;
    private Integer[] deliveryType;
    private String pickPlace;
    private Integer pickTimeType;
    private String projectSource;
    private String orderListImg;
    private String businessTimesDesc;
    private String onlineStatusContent;
    private Timestamp deletedAt;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "admin_id")
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "boss_id")
    public Long getBossId() {
        return bossId;
    }

    public void setBossId(Long bossId) {
        this.bossId = bossId;
    }

    @Basic
    @Column(name = "department_id")
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "delivery_fastest_time")
    public Integer getDeliveryFastestTime() {
        return deliveryFastestTime;
    }

    public void setDeliveryFastestTime(Integer deliveryFastestTime) {
        this.deliveryFastestTime = deliveryFastestTime;
    }

    @Basic
    @Column(name = "delivery_slowest_time")
    public Integer getDeliverySlowestTime() {
        return deliverySlowestTime;
    }

    public void setDeliverySlowestTime(Integer deliverySlowestTime) {
        this.deliverySlowestTime = deliverySlowestTime;
    }

    @Basic
    @Column(name = "is_breakfast")
    public Integer getIsBreakfast() {
        return isBreakfast;
    }

    public void setIsBreakfast(Integer isBreakfast) {
        this.isBreakfast = isBreakfast;
    }

    @Basic
    @Column(name = "is_lunch")
    public Integer getIsLunch() {
        return isLunch;
    }

    public void setIsLunch(Integer isLunch) {
        this.isLunch = isLunch;
    }

    @Basic
    @Column(name = "is_dinner")
    public Integer getIsDinner() {
        return isDinner;
    }

    public void setIsDinner(Integer isDinner) {
        this.isDinner = isDinner;
    }

    @Basic
    @Column(name = "breakfast_start_at")
    public Time getBreakfastStartAt() {
        return breakfastStartAt;
    }

    public void setBreakfastStartAt(Time breakfastStartAt) {
        this.breakfastStartAt = breakfastStartAt;
    }

    @Basic
    @Column(name = "breakfast_end_at")
    public Time getBreakfastEndAt() {
        return breakfastEndAt;
    }

    public void setBreakfastEndAt(Time breakfastEndAt) {
        this.breakfastEndAt = breakfastEndAt;
    }

    @Basic
    @Column(name = "lunch_start_at")
    public Time getLunchStartAt() {
        return lunchStartAt;
    }

    public void setLunchStartAt(Time lunchStartAt) {
        this.lunchStartAt = lunchStartAt;
    }

    @Basic
    @Column(name = "lunch_end_at")
    public Time getLunchEndAt() {
        return lunchEndAt;
    }

    public void setLunchEndAt(Time lunchEndAt) {
        this.lunchEndAt = lunchEndAt;
    }

    @Basic
    @Column(name = "dinner_start_at")
    public Time getDinnerStartAt() {
        return dinnerStartAt;
    }

    public void setDinnerStartAt(Time dinnerStartAt) {
        this.dinnerStartAt = dinnerStartAt;
    }

    @Basic
    @Column(name = "dinner_end_at")
    public Time getDinnerEndAt() {
        return dinnerEndAt;
    }

    public void setDinnerEndAt(Time dinnerEndAt) {
        this.dinnerEndAt = dinnerEndAt;
    }

    @Basic
    @Column(name = "overall_star")
    public Integer getOverallStar() {
        return overallStar;
    }

    public void setOverallStar(Integer overallStar) {
        this.overallStar = overallStar;
    }

    @Basic
    @Column(name = "comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Basic
    @Column(name = "pay_type")
    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "big_img")
    public String getBigImg() {
        return bigImg;
    }

    public void setBigImg(String bigImg) {
        this.bigImg = bigImg;
    }

    @Basic
    @Column(name = "tableware_price")
    public BigDecimal getTablewarePrice() {
        return tablewarePrice;
    }

    public void setTablewarePrice(BigDecimal tablewarePrice) {
        this.tablewarePrice = tablewarePrice;
    }

    @Basic
    @Column(name = "package_price")
    public BigDecimal getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(BigDecimal packagePrice) {
        this.packagePrice = packagePrice;
    }

    @Basic
    @Column(name = "takeout_rule")
    public String getTakeoutRule() {
        return takeoutRule;
    }

    public void setTakeoutRule(String takeoutRule) {
        this.takeoutRule = takeoutRule;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "like_count")
    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "identifier")
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Basic
    @Column(name = "breakfast_name")
    public String getBreakfastName() {
        return breakfastName;
    }

    public void setBreakfastName(String breakfastName) {
        this.breakfastName = breakfastName;
    }

    @Basic
    @Column(name = "lunch_name")
    public String getLunchName() {
        return lunchName;
    }

    public void setLunchName(String lunchName) {
        this.lunchName = lunchName;
    }

    @Basic
    @Column(name = "dinner_name")
    public String getDinnerName() {
        return dinnerName;
    }

    public void setDinnerName(String dinnerName) {
        this.dinnerName = dinnerName;
    }

    @Basic
    @Column(name = "list_img")
    public String getListImg() {
        return listImg;
    }

    public void setListImg(String listImg) {
        this.listImg = listImg;
    }

    @Basic
    @Column(name = "detail_img")
    public String getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg;
    }

    @Basic
    @Column(name = "sales_num")
    public Integer getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }

    @Basic
    @Column(name = "online_status")
    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    @Basic
    @Column(name = "order_min_price")
    public BigDecimal getOrderMinPrice() {
        return orderMinPrice;
    }

    public void setOrderMinPrice(BigDecimal orderMinPrice) {
        this.orderMinPrice = orderMinPrice;
    }

    @Basic
    @Column(name = "delivery_type")
    public Integer[] getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer[] deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Basic
    @Column(name = "pick_place")
    public String getPickPlace() {
        return pickPlace;
    }

    public void setPickPlace(String pickPlace) {
        this.pickPlace = pickPlace;
    }

    @Basic
    @Column(name = "pick_time_type")
    public Integer getPickTimeType() {
        return pickTimeType;
    }

    public void setPickTimeType(Integer pickTimeType) {
        this.pickTimeType = pickTimeType;
    }

    @Basic
    @Column(name = "project_source")
    public String getProjectSource() {
        return projectSource;
    }

    public void setProjectSource(String projectSource) {
        this.projectSource = projectSource;
    }

    @Basic
    @Column(name = "order_list_img")
    public String getOrderListImg() {
        return orderListImg;
    }

    public void setOrderListImg(String orderListImg) {
        this.orderListImg = orderListImg;
    }

    @Basic
    @Column(name = "business_times_desc")
    public String getBusinessTimesDesc() {
        return businessTimesDesc;
    }

    public void setBusinessTimesDesc(String businessTimesDesc) {
        this.businessTimesDesc = businessTimesDesc;
    }

    @Basic
    @Column(name = "online_status_content")
    public String getOnlineStatusContent() {
        return onlineStatusContent;
    }

    public void setOnlineStatusContent(String onlineStatusContent) {
        this.onlineStatusContent = onlineStatusContent;
    }

    @Basic
    @Column(name = "deleted_at")
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TakeoutRestaurants that = (TakeoutRestaurants) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(adminId, that.adminId) &&
                Objects.equals(bossId, that.bossId) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(deliveryFastestTime, that.deliveryFastestTime) &&
                Objects.equals(deliverySlowestTime, that.deliverySlowestTime) &&
                Objects.equals(isBreakfast, that.isBreakfast) &&
                Objects.equals(isLunch, that.isLunch) &&
                Objects.equals(isDinner, that.isDinner) &&
                Objects.equals(breakfastStartAt, that.breakfastStartAt) &&
                Objects.equals(breakfastEndAt, that.breakfastEndAt) &&
                Objects.equals(lunchStartAt, that.lunchStartAt) &&
                Objects.equals(lunchEndAt, that.lunchEndAt) &&
                Objects.equals(dinnerStartAt, that.dinnerStartAt) &&
                Objects.equals(dinnerEndAt, that.dinnerEndAt) &&
                Objects.equals(overallStar, that.overallStar) &&
                Objects.equals(commentCount, that.commentCount) &&
                Objects.equals(payType, that.payType) &&
                Objects.equals(bigImg, that.bigImg) &&
                Objects.equals(tablewarePrice, that.tablewarePrice) &&
                Objects.equals(packagePrice, that.packagePrice) &&
                Objects.equals(takeoutRule, that.takeoutRule) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(sort, that.sort) &&
                Objects.equals(likeCount, that.likeCount) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(identifier, that.identifier) &&
                Objects.equals(breakfastName, that.breakfastName) &&
                Objects.equals(lunchName, that.lunchName) &&
                Objects.equals(dinnerName, that.dinnerName) &&
                Objects.equals(listImg, that.listImg) &&
                Objects.equals(detailImg, that.detailImg) &&
                Objects.equals(salesNum, that.salesNum) &&
                Objects.equals(onlineStatus, that.onlineStatus) &&
                Objects.equals(orderMinPrice, that.orderMinPrice) &&
                Objects.equals(deliveryType, that.deliveryType) &&
                Objects.equals(pickPlace, that.pickPlace) &&
                Objects.equals(pickTimeType, that.pickTimeType) &&
                Objects.equals(projectSource, that.projectSource) &&
                Objects.equals(orderListImg, that.orderListImg) &&
                Objects.equals(businessTimesDesc, that.businessTimesDesc) &&
                Objects.equals(onlineStatusContent, that.onlineStatusContent) &&
                Objects.equals(deletedAt, that.deletedAt) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, adminId, bossId, departmentId, status, deliveryFastestTime, deliverySlowestTime, isBreakfast, isLunch, isDinner, breakfastStartAt, breakfastEndAt, lunchStartAt, lunchEndAt, dinnerStartAt, dinnerEndAt, overallStar, commentCount, payType, bigImg, tablewarePrice, packagePrice, takeoutRule, remark, sort, likeCount, phone, identifier, breakfastName, lunchName, dinnerName, listImg, detailImg, salesNum, onlineStatus, orderMinPrice, deliveryType, pickPlace, pickTimeType, projectSource, orderListImg, businessTimesDesc, onlineStatusContent, deletedAt, createdAt, updatedAt);
    }
}
