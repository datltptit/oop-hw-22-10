public class order {
    // Thuộc tính (private)
    private String tenKhach;
    private product product;
    private int soLuong;

    // Constructor nhận đủ 3 giá trị
    public order(String tenKhach, product product, int soLuong) {
        this.tenKhach = tenKhach;
        this.product = product;
        // Số lượng nhỏ hơn 1 thì tự sửa thành 1
        if (soLuong < 1) {
            this.soLuong = 1;
        } else {
            this.soLuong = soLuong;
        }
    }

    // Getter
    public String getTenKhach() {
        return tenKhach;
    }

    public product getSanPham() {
        return product;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Thành tiền = đơn giá x số lượng; từ 5 cái trở lên giảm 10%
    public double tinhThanhTien() {
        double thanhTien = product.getDonGia() * soLuong;
        if (soLuong >= 5) {
            thanhTien = thanhTien * 0.9;
        }
        return thanhTien;
    }

    // In tiêu đề bảng đơn hàng
    public static void inTieuDe() {
        System.out.printf("%-8s %-16s %-4s %s%n", "Khách", "Sản phẩm", "SL", "Thành tiền");
    }

    // In thông tin đơn hàng ra màn hình
    public void inDonHang() {
        System.out.printf("%-8s %-16s %-4d %10s%n",
                tenKhach, product.getTenSP(), soLuong,
                product.dinhDangTien(tinhThanhTien()));
        if (soLuong >= 5) {
            System.out.println("         (đã giảm 10%)");
        }
    }
}
