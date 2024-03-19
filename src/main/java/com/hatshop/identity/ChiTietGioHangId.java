package com.hatshop.identity;

import java.util.Objects;

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
public class ChiTietGioHangId {
	private String maKhachHang;
	private String maSanPham;

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietGioHangId that = (ChiTietGioHangId) o;
        return Objects.equals(maKhachHang, that.maKhachHang) &&
                Objects.equals(maSanPham, that.maSanPham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKhachHang, maSanPham);
    }
}
