package org.dsw.test.databases;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "holiday_info", schema = "ss_product")
public class HolidayInfoEntity {
    private String id;
    private Boolean delflag;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private String username;
    private String inputer;
    private String checker;
    private String sts;
    private String country;
    private String marketType;
    private LocalDate holidayDate;
    private String holidayReason;

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "delflag")
    public Boolean getDelflag() {
        return delflag;
    }

    public void setDelflag(Boolean delflag) {
        this.delflag = delflag;
    }

    @Basic
    @Column(name = "create_date")
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "modify_date")
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "inputer")
    public String getInputer() {
        return inputer;
    }

    public void setInputer(String inputer) {
        this.inputer = inputer;
    }

    @Basic
    @Column(name = "checker")
    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    @Basic
    @Column(name = "sts")
    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "market_type")
    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    @Basic
    @Column(name = "holiday_date")
    public LocalDate getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(LocalDate holidayDate) {
        this.holidayDate = holidayDate;
    }

    @Basic
    @Column(name = "holiday_reason")
    public String getHolidayReason() {
        return holidayReason;
    }

    public void setHolidayReason(String holidayReason) {
        this.holidayReason = holidayReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HolidayInfoEntity that = (HolidayInfoEntity) o;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (delflag != null ? !delflag.equals(that.delflag) : that.delflag != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(that.modifyDate) : that.modifyDate != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (inputer != null ? !inputer.equals(that.inputer) : that.inputer != null) return false;
        if (checker != null ? !checker.equals(that.checker) : that.checker != null) return false;
        if (sts != null ? !sts.equals(that.sts) : that.sts != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (marketType != null ? !marketType.equals(that.marketType) : that.marketType != null) return false;
        if (holidayDate != null ? !holidayDate.equals(that.holidayDate) : that.holidayDate != null) return false;
        if (holidayReason != null ? !holidayReason.equals(that.holidayReason) : that.holidayReason != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (delflag != null ? delflag.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (inputer != null ? inputer.hashCode() : 0);
        result = 31 * result + (checker != null ? checker.hashCode() : 0);
        result = 31 * result + (sts != null ? sts.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (marketType != null ? marketType.hashCode() : 0);
        result = 31 * result + (holidayDate != null ? holidayDate.hashCode() : 0);
        result = 31 * result + (holidayReason != null ? holidayReason.hashCode() : 0);
        return result;
    }
}