package chihane.jdaddressselector.demo;

import java.util.Collections;

import chihane.jdaddressselector.AddressProvider;
import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;

public class TestAddressProvider implements AddressProvider {
    @Override
    public void provideProvinces(AddressReceiver<Province> addressReceiver) {
        Province province = new Province();
        province.id = 1;
        province.name = "测试用省份";
        addressReceiver.send(Collections.singletonList(province));
    }

    @Override
    public void provideCitiesWith(int provinceId, AddressReceiver<City> addressReceiver) {
        City city = new City();
        city.province_id = provinceId;
        city.id = 2;
        city.name = "测试用城市";
        addressReceiver.send(Collections.singletonList(city));
    }

    @Override
    public void provideCountiesWith(int cityId, AddressReceiver<County> addressReceiver) {
        County county = new County();
        county.city_id = cityId;
        county.id = 3;
        county.name = "测试用乡镇";
        addressReceiver.send(Collections.singletonList(county));
    }

    @Override
    public void provideStreetsWith(int countyId, AddressReceiver<Street> addressReceiver) {
        Street street = new Street();
        street.county_id = countyId;
        street.id = 4;
        street.name = "测试用街道";
        addressReceiver.send(Collections.singletonList(street));
    }
}
