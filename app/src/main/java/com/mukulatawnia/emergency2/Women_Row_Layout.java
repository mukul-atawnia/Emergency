package com.mukulatawnia.emergency2;


public class Women_Row_Layout  {

    private String organizations;
    private String phone_numbers;

    public String getOrganizations() {
        return organizations;
    }

    public Women_Row_Layout(String organizations,String phone_numbers)
    {
        this.organizations=organizations;
        this.phone_numbers=phone_numbers;
    }

    public void setOrganizations(String organizations) {
        this.organizations = organizations;
    }

    public String getPhone_numbers() {
        return phone_numbers;
    }

    public void setPhone_numbers(String phone_numbers) {
        this.phone_numbers = phone_numbers;
    }
}
