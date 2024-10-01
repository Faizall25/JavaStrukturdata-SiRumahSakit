package DataRS;

import java.util.ArrayList;
import java.util.List;

public class Data {

    //Class data paseien
    public static class Pasien {

        String nama;
        String tanggalLahir;
        String alamat;
        String nomorAntrian;
        String jk;
        int noTf;
        String keluhan;
        String riwayat;

        public Pasien(String nama, String tanggalLahir, String alamat, String nomorAntrian, String jk, int noTf, String keluhan, String riwayat) {
            this.nama = nama;
            this.tanggalLahir = tanggalLahir;
            this.alamat = alamat;
            this.nomorAntrian = nomorAntrian;
            this.jk = jk;
            this.noTf = noTf;
            this.keluhan = keluhan;
            this.riwayat = riwayat;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getTanggalLahir() {
            return tanggalLahir;
        }

        public void setTanggalLahir(String tanggalLahir) {
            this.tanggalLahir = tanggalLahir;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getNomorAntrian() {
            return nomorAntrian;
        }

        public void setNomorAntrian(String nomorAntrian) {
            this.nomorAntrian = nomorAntrian;
        }

        public String getJk() {
            return jk;
        }

        public void setJk(String jk) {
            this.jk = jk;
        }

        public int getNoTf() {
            return noTf;
        }

        public void setNoTf(int noTf) {
            this.noTf = noTf;
        }

        public String getKeluhan() {
            return keluhan;
        }

        public void setKeluhan(String keluhan) {
            this.keluhan = keluhan;
        }

        public String getRiwayat() {
            return riwayat;
        }

        public void setRiwayat(String riwayat) {
            this.riwayat = riwayat;
        }
    }

    //Class data dokter
    public static class Dokter {

        String nama;
        String tanggalLahir;
        String alamat;
        String nomorAntrian;
        String jk;
        int noTf;
        String spesialis;
        String jadwalPraktek;

        public Dokter(String nama, String tanggalLahir, String alamat, String nomorAntrian, String jk, int noTf, String spesialis, String jadwalPraktek) {
            this.nama = nama;
            this.tanggalLahir = tanggalLahir;
            this.alamat = alamat;
            this.nomorAntrian = nomorAntrian;
            this.jk = jk;
            this.noTf = noTf;
            this.spesialis = spesialis;
            this.jadwalPraktek = jadwalPraktek;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getTanggalLahir() {
            return tanggalLahir;
        }

        public void setTanggalLahir(String tanggalLahir) {
            this.tanggalLahir = tanggalLahir;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getNomorAntrian() {
            return nomorAntrian;
        }

        public void setNomorAntrian(String nomorAntrian) {
            this.nomorAntrian = nomorAntrian;
        }

        public String getJk() {
            return jk;
        }

        public void setJk(String jk) {
            this.jk = jk;
        }

        public int getNoTf() {
            return noTf;
        }

        public void setNoTf(int noTf) {
            this.noTf = noTf;
        }

        public String getSpesialis() {
            return spesialis;
        }

        public void setSpesialis(String spesialis) {
            this.spesialis = spesialis;
        }

        public String getJadwalPraktek() {
            return jadwalPraktek;
        }

        public void setJadwalPraktek(String jadwalPraktek) {
            this.jadwalPraktek = jadwalPraktek;
        }
    }

    public static class Ruangan {

        String jenis;
        List<Pasien> daftarPasien;

        public Ruangan(String jenis) {
            this.jenis = jenis;
            this.daftarPasien = new ArrayList<>();
        }

        public void tambahPasien(Pasien pasien) {
            daftarPasien.add(pasien);
        }
    }

    public static class RumahSakit {

        List<Pasien> daftarPasien;
        List<Dokter> daftarDokter;
        List<Ruangan> daftarRuangan;

        public RumahSakit() {
            this.daftarPasien = new ArrayList<>();
            this.daftarDokter = new ArrayList<>();
            this.daftarRuangan = new ArrayList<>();
        }

        public void tambahPasien(Pasien pasien) {
            daftarPasien.add(pasien);
        }

        public void tambahDokter(Dokter dokter) {
            daftarDokter.add(dokter);
        }

        public void tambahRuangan(Ruangan ruangan) {
            daftarRuangan.add(ruangan);
        }
    }
}
