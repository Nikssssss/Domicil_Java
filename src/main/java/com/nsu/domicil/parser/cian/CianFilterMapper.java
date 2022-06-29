package com.nsu.domicil.parser.cian;

import com.nsu.domicil.dto.enums.AccommodationType;
import com.nsu.domicil.dto.enums.SortingType;
import com.nsu.domicil.dto.enums.TransactionType;
import com.nsu.domicil.parser.common.AdFilterMapper;

import java.util.Properties;

public class CianFilterMapper implements AdFilterMapper {
    private final Properties properties;

    public CianFilterMapper(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String mapDomain(String locality) {
        return "https://" + locality + ".cian.ru/cat.php?";
    }

    @Override
    public String mapAccommodation(AccommodationType accommodationType) {
        switch (accommodationType) {
            case APARTMENT -> { return this.properties.getProperty("apartments"); }
            case ROOM -> { return this.properties.getProperty("rooms"); }
            case HOUSE, COTTAGE -> { return this.properties.getProperty("cottages"); }
            default -> { return ""; }
        }
    }

    @Override
    public String mapTransaction(TransactionType transactionType) {
        switch (transactionType) {
            case RENT -> { return "&" + this.properties.getProperty("rent"); }
            case SELL -> { return "&" + this.properties.getProperty("sell"); }
            default -> { return ""; }
        }
    }

    @Override
    public String mapSorting(SortingType sortingType) {
        switch (sortingType) {
            case DATE_FROM_NEW -> { return "&" + this.properties.getProperty("date_sort") + "&region=4897"; }
            case PRICE_FROM_LEAST -> { return "&" + this.properties.getProperty("price_sort") + "&region=4897"; }
            default -> { return ""; }
        }
    }

    @Override
    public String mapPage(Integer page) {
        return "&p=" + page;
    }
}
