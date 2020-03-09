package com.example.hotelreception.common;

import java.util.Objects;

/**
 * @author Ehtiram_Abdullayev on 3/7/2020
 * @project hotel-reception
 */
public class CreatePackageCommand<T> extends AbstractPackageCommand {
    private int packageId;
    private String packageDescription;

    public CreatePackageCommand() {
    }

    public CreatePackageCommand(Integer guestId, int packageId, String packageDescription) {
        super(guestId);
        this.packageId = packageId;
        this.packageDescription = packageDescription;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CreatePackageCommand<?> that = (CreatePackageCommand<?>) o;
        return packageId == that.packageId &&
                Objects.equals(packageDescription, that.packageDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), packageId, packageDescription);
    }

    @Override
    public String toString() {
        return "CreatePackageCommand{" +
                "packageId=" + packageId +
                ", packageDescription='" + packageDescription + '\'' +
                '}';
    }
}
