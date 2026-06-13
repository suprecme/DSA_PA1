import java.util.Scanner;

// Class utama untuk menjalankan program
public class Main {

    // Method untuk menampilkan seluruh data mahasiswa (sesuai Soal 1)
    public static void tampilkanSemuaMahasiswa(Mahasiswa[] daftar) {
        System.out.println("\n=== Data Mahasiswa ===");
        for (Mahasiswa mhs : daftar) {
            mhs.tampilkanInfo();
        }
    }

    // Method untuk update IPK mahasiswa berdasarkan NIM (sesuai Soal 2)
    public static void updateIpkMahasiswa(Mahasiswa[] daftar, Scanner input) {
        System.out.print("\nMasukkan NIM mahasiswa yang ingin diupdate: ");
        String nimCari = input.nextLine();

        boolean ditemukan = false;

        for (Mahasiswa mhs : daftar) {
            if (mhs.getNim().equals(nimCari)) {
                ditemukan = true;

                System.out.print("Masukkan IPK baru (0 - 4): ");
                String ipkInput = input.nextLine().replace(',', '.');

                try {
                    double ipkBaru = Double.parseDouble(ipkInput);

                    // Validasi IPK
                    if (ipkBaru >= 0 && ipkBaru <= 4) {
                        mhs.updateIpk(ipkBaru);

                        System.out.println("\nData berhasil diperbarui!\n");
                        System.out.println("=== Data Mahasiswa ===");
                        mhs.tampilkanInfoDenganStatus();
                    } else {
                        System.out.println("\nIPK tidak valid. Masukkan nilai antara 0 sampai 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nInput IPK tidak valid. Masukkan angka, misalnya 3.5 atau 3,5.");
                }

                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }

    // Method untuk menampilkan semua data mahasiswa lengkap dengan predikat (sesuai Soal 3)
    public static void tampilkanSemuaPredikat(Mahasiswa[] daftar) {
        System.out.println("\n=== Data Mahasiswa ===");
        for (Mahasiswa mhs : daftar) {
            mhs.tampilkanInfoLengkap();
        }
    }

    public static void main(String[] args) {

        // Menyimpan 5 objek mahasiswa ke dalam array
        Mahasiswa[] daftar = new Mahasiswa[5];

        // Mengisi data mahasiswa
        daftar[0] = new Mahasiswa("Dimas Ramadhan", "2546048", "Manajemen", 2.79);
        daftar[1] = new Mahasiswa("Dino Sadewa", "2521395", "Teknik Sipil", 2.52);
        daftar[2] = new Mahasiswa("Nabila Permata", "2540495", "Teknik Informatika", 3.31);
        daftar[3] = new Mahasiswa("Galih Nugroho", "2538893", "Desain Grafis", 3.35);
        daftar[4] = new Mahasiswa("Alya Wijaya", "2565392", "Ilmu Komunikasi", 2.88);

        // Scanner untuk menerima input pengguna
        Scanner input = new Scanner(System.in);

        int pilihan;

        do {
            // Menampilkan menu
            System.out.println("=== Main Menu EduTech ===");
            System.out.println("1. Tampilkan data (Soal 1)");
            System.out.println("2. Update IPK (Soal 2)");
            System.out.println("3. Menentukan predikat akademik (Soal 3)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            String menuInput = input.nextLine();

            try {
                pilihan = Integer.parseInt(menuInput);

                switch (pilihan) {
                    case 1:
                        tampilkanSemuaMahasiswa(daftar);
                        break;
                    case 2:
                        updateIpkMahasiswa(daftar, input);
                        break;
                    case 3:
                        tampilkanSemuaPredikat(daftar);
                        break;
                    case 4:
                        System.out.println("\nProgram selesai.");
                        break;
                    default:
                        System.out.println("\nPilihan tidak valid. Silakan pilih angka 1 sampai 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInput menu harus berupa angka.");
                pilihan = 0;
            }

            System.out.println();

        } while (pilihan != 4);

        // Menutup Scanner
        input.close();
    }
}