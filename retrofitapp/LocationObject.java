package com.example.hazelwang.retrofitapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationObject extends Resource{
        @SerializedName("id")
        @Expose
        private Long id;
        @SerializedName("name")
        @Expose
        private String name;
        @Expose
        private String parentLocationUuid;
        @Expose
        private String description;
        @Expose
        private String address2;
        @Expose
        private String address1;
        @Expose
        private String cityVillage;
        @Expose
        private String stateProvince;
        @Expose
        private String country;
        @Expose
        private String postalCode;


        public LocationObject() {}

        public LocationObject(String display) {
            this.display = display;
        }

        public LocationObject(Long id, String name, String parentLocationUuid, String description, String address2, String address1, String cityVillage, String stateProvince, String country, String postalCode) {
            this.id = id;
            this.name = name;
            this.parentLocationUuid = parentLocationUuid;
            this.description = description;
            this.address2 = address2;
            this.address1 = address1;
            this.cityVillage = cityVillage;
            this.stateProvince = stateProvince;
            this.country = country;
            this.postalCode = postalCode;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParentLocationUuid() {
            return parentLocationUuid;
        }

        public void setParentLocationUuid(String parentLocationUuid) {
            this.parentLocationUuid = parentLocationUuid;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getCityVillage() {
            return cityVillage;
        }

        public void setCityVillage(String cityVillage) {
            this.cityVillage = cityVillage;
        }

        public String getStateProvince() {
            return stateProvince;
        }

        public void setStateProvince(String stateProvince) {
            this.stateProvince = stateProvince;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }
}

