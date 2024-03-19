package com.hatshop.identity;

import java.io.Serializable;
import java.util.Objects;

import com.hatshop.entity.DonHang;
import com.hatshop.entity.SanPham;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietDonHangId implements Serializable{
	private String maDonHang;
	
	private String maSanPham;

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietDonHangId that = (ChiTietDonHangId) o;
        return Objects.equals(maDonHang, that.maDonHang) &&
                Objects.equals(maSanPham, that.maSanPham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDonHang, maSanPham);
    }
}
