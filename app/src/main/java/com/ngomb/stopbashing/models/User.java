
package com.ngomb.stopbashing.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("family_tree_id")
    @Expose
    private Integer familyTreeId;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("family_code")
    @Expose
    private String familyCode;
    @SerializedName("error_message")
    @Expose
    private String errorMessage;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param errorMessage
     * @param updatedAt
     * @param id
     * @param familyTreeId
     * @param lastName
     * @param phoneNumber
     * @param email
     * @param createdAt
     * @param familyCode
     * @param role
     * @param firstName
     */
    public User(Integer id, String firstName, String lastName, String email, String phoneNumber, String createdAt, String updatedAt, Integer familyTreeId, String role, String familyCode, String errorMessage) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.familyTreeId = familyTreeId;
        this.role = role;
        this.familyCode = familyCode;
        this.errorMessage = errorMessage;
    }

    public User(String phoneNumber, String familyCode) {
        this.phoneNumber=phoneNumber;
        this.familyCode=familyCode;
    }

    protected User(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        firstName = in.readString();
        lastName = in.readString();
        email = in.readString();
        phoneNumber = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        if (in.readByte() == 0) {
            familyTreeId = null;
        } else {
            familyTreeId = in.readInt();
        }
        role = in.readString();
        familyCode = in.readString();
        errorMessage = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getFamilyTreeId() {
        return familyTreeId;
    }

    public void setFamilyTreeId(Integer familyTreeId) {
        this.familyTreeId = familyTreeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(email);
        parcel.writeString(phoneNumber);
        parcel.writeString(createdAt);
        parcel.writeString(updatedAt);
        if (familyTreeId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(familyTreeId);
        }
        parcel.writeString(role);
        parcel.writeString(familyCode);
        parcel.writeString(errorMessage);
    }
}
