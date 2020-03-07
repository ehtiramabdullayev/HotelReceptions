package com.example.hotelreception.common;

import java.util.Objects;

/**
 * @author Ehtiram_Abdullayev on 3/7/2020
 * @project hotel-reception
 */
public class CreatePackageCommand extends AbstractPackageCommand{
    private Integer packageId;

    public CreatePackageCommand(Integer guestId, Integer packageId) {
        super(guestId);
        this.packageId = packageId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CreatePackageCommand that = (CreatePackageCommand) o;
        return Objects.equals(packageId, that.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), packageId);
    }

    @Override
    public String toString() {
        return "CreatePackageCommand{" +
                "packageId=" + packageId +
                '}';
    }
}
