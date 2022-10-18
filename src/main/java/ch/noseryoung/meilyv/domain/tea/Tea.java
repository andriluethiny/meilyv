package ch.noseryoung.meilyv.domain.tea;

import ch.noseryoung.meilyv.core.generic.ExtendedEntity;
import ch.noseryoung.meilyv.domain.country.Country;
import ch.noseryoung.meilyv.domain.teatype.TeaType;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "tea")
public class Tea extends ExtendedEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "harvest_date")
    private Date harvest_date;

    @Column(name = "purchase_price")
    private Float purchase_price;

    @Column(name = "selling_price")
    private Float selling_price;

    @Column(name = "stock_number")
    private Integer stockNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teatype_id", referencedColumnName = "id", updatable = false, nullable = false)
    private TeaType teaType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", referencedColumnName = "id", updatable = false, nullable = false)
    private Country country;

    public Tea() {
    }

    public Tea(UUID id, String name, Date harvest_date, Float purchase_price, Float selling_price, Integer stockNumber, TeaType teaType, Country country) {
        super(id);
        this.name = name;
        this.harvest_date = harvest_date;
        this.purchase_price = purchase_price;
        this.selling_price = selling_price;
        this.stockNumber = stockNumber;
        this.teaType = teaType;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Tea setName(String name) {
        this.name = name;
        return this;
    }

    public Date getHarvest_date() {
        return harvest_date;
    }

    public Tea setHarvest_date(Date harvest_date) {
        this.harvest_date = harvest_date;
        return this;
    }

    public Float getPurchase_price() {
        return purchase_price;
    }

    public Tea setPurchase_price(Float purchase_price) {
        this.purchase_price = purchase_price;
        return this;
    }

    public Float getSelling_price() {
        return selling_price;
    }

    public Tea setSelling_price(Float selling_price) {
        this.selling_price = selling_price;
        return this;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public Tea setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
        return this;
    }

    public TeaType getTeaType() {
        return teaType;
    }

    public Tea setTeaType(TeaType teaType) {
        this.teaType = teaType;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Tea setCountry(Country country) {
        this.country = country;
        return this;
    }
}