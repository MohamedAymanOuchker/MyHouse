//A

package com.example.myhouse;

public class ImageModel {
    String FirstName;
    String LastName;
    String image;

    public ImageModel() {
    }

    public ImageModel(String firstName, String lastName, String image) {
        FirstName = firstName;
        LastName = lastName;
        this.image = image;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
