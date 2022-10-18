package ch.noseryoung.meilyv.domain.tea.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedDTO;
import ch.noseryoung.meilyv.domain.country.dto.CountryDTO;
import ch.noseryoung.meilyv.domain.teatype.dto.TeaTypeDTO;

import java.sql.Date;
import java.util.UUID;

public class TeaDTO extends ExtendedDTO {
    private String name;

    private Date harvest_date;

    private Float purchase_price;

    private Float selling_price;

    private Integer stockNumber;

    private TeaTypeDTO teaType;

    private CountryDTO country;

    public TeaDTO() {
    }

    public TeaDTO(UUID id, String name, Date harvest_date, Float purchase_price, Float selling_price, Integer stockNumber, TeaTypeDTO teaType, CountryDTO country) {
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

    public TeaDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Date getHarvest_date() {
        return harvest_date;
    }

    public TeaDTO setHarvest_date(Date harvest_date) {
        this.harvest_date = harvest_date;
        return this;
    }

    public Float getPurchase_price() {
        return purchase_price;
    }

    public TeaDTO setPurchase_price(Float purchase_price) {
        this.purchase_price = purchase_price;
        return this;
    }

    public Float getSelling_price() {
        return selling_price;
    }

    public TeaDTO setSelling_price(Float selling_price) {
        this.selling_price = selling_price;
        return this;
    }

    public Integer getStockNumber() {
        return stockNumber;
    }

    public TeaDTO setStockNumber(Integer stockNumber) {
        this.stockNumber = stockNumber;
        return this;
    }

    public TeaTypeDTO getTeaType() {
        return teaType;
    }

    public TeaDTO setTeaType(TeaTypeDTO teaType) {
        this.teaType = teaType;
        return this;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public TeaDTO setCountry(CountryDTO country) {
        this.country = country;
        return this;
    }
}