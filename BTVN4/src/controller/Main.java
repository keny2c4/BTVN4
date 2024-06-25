/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.SinhVien;

/**
 *
 * @author minhk
 */
public class Main {
    private static ArrayList<SinhVien> listSinhVien = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. them sinh vien");
            System.out.println("2. xoa sinh vien");
            System.out.println("3. in thong tin sinh vien");
            System.out.println("4. sua thong tin sinh vien");
            System.out.println("5. in thong tin tat ca sinh vien nam");
            System.out.println("6. in thong tin tat ca sinh vien nu");
            System.out.println("7. dung chuong trinh");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    themSinhVien();
                    break;
                case 2:
                    xoaSinhVien();
                    break;
                case 3:
                    inThongTinSinhVien();
                    break;
                case 4:
                    suaThongTinSinhVien();
                    break;
                case 5:
                    inSinhVienTheoGioiTinh("Nam");
                    break;
                case 6:
                    inSinhVienTheoGioiTinh("Nu");
                    break;
                case 7:
                    System.out.println("dung chuong trinh.");
                    System.exit(0);
                default:
                    System.out.println("vui long chon tu 1 den 7 !");
            }
        }
    }

    private static void themSinhVien() {
        System.out.print("Nhap ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhap tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gender = scanner.nextLine();
        System.out.print("Nhap nganh hoc: ");
        String major = scanner.nextLine();

        SinhVien sv = new SinhVien(id, name, gender, major);
        listSinhVien.add(sv);
        System.out.println("da them thanh cong.");
    }

    private static void xoaSinhVien() {
        System.out.print("Nhap ID sinh vien muon xoa: ");
        String id = scanner.nextLine();
        boolean found = false;

        for (SinhVien sv : listSinhVien) {
            if (sv.getId().equals(id)) {
                listSinhVien.remove(sv);
                System.out.println("da xoa thanh cong.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("khong tim thay sinh vien voi ID: " + id);
        }
    }

    private static void inThongTinSinhVien() {
        System.out.print("nhap id sinh vien can in ra: ");
        String id = scanner.nextLine();
        boolean found = false;

        for (SinhVien sv : listSinhVien) {
            if (sv.getId().equals(id)) {
                System.out.println(sv);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("khong tim thay sinh vien voi ID: " + id);
        }
    }

    private static void suaThongTinSinhVien() {
        System.out.print("nhap ID sinh vien can sua thong tin: ");
        String id = scanner.nextLine();
        boolean found = false;

        for (SinhVien sv : listSinhVien) {
            if (sv.getId().equals(id)) {
                System.out.print("Nhap ten moi: ");
                String name = scanner.nextLine();
                System.out.print("Nhap gioi tinh moi: ");
                String gender = scanner.nextLine();
                System.out.print("Nhap nganh hoc moi: ");
                String major = scanner.nextLine();

                sv.setName(name);
                sv.setGender(gender);
                sv.setMajor(major);

                System.out.println("da sua thong tin thanh cong.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("khong tim thay sinh vien voi ID " + id);
        }
    }

    private static void inSinhVienTheoGioiTinh(String gender) {
        for (SinhVien sv : listSinhVien) {
            if (sv.getGender().equalsIgnoreCase(gender)) {
                System.out.println(sv);
            }
        }
    }
}
