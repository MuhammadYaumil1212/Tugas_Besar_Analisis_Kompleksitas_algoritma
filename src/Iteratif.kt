import kotlin.system.measureNanoTime

data class Hotel(val name: String, val rating: Double, val bintang: Int)

fun main() {
    // Daftar hotel
    val hotels = listOf(
        Hotel("Cherry Pink Hotel Medan Mitra RedDoorz", 7.5, 1),
        Hotel("Melissa Palace Hotel and Karaoke", 7.8, 1),
        Hotel("Hotel Benua", 8.1, 1),
        Hotel("Ghotic Hotel", 8.3, 1),
        Hotel("Griya Jogja Hotel", 8.5, 1),
        Hotel("RedDoorz near Stasiun Pematangsiantar", 9.1, 1),
        Hotel("RedDoorz @MG House Siantar Timur", 9.3, 1),
        Hotel("Anju Cottages", 7.4, 2),
        Hotel("Sapadia Hotel & Cottage Parapat", 7.9, 2),
        Hotel("Dbest Express", 8.0, 2),
        Hotel("Villa DSK - Buah Batu Bandung", 8.2, 2),
        Hotel("Malioboro Inn Yogyakarta", 8.6, 2),
        Hotel("Bohemian Jogja Villas With Private Pool", 9.4, 2),
        Hotel("Pia Hotel Bandung", 7.2, 3),
        Hotel("Saka Hotel Medan", 7.8, 3),
        Hotel("Yello Hotel Harmoni", 8.0, 3),
        Hotel("Bali World Hotel", 8.3, 3),
        Hotel("Narapati Syariah Hotel & Convention", 8.7, 3),
        Hotel("BW Express Jakarta Tanah Abang", 9.0, 3),
        Hotel("Anara Sky Kualanamu", 9.2, 3),
        Hotel("Asia Hotel Solo", 7.5, 4),
        Hotel("Kusuma Sahid Prince Hotel", 7.9, 4),
        Hotel("Al Azhar Azhima Hotel & Convention Solo", 7.7, 4),
        Hotel("Lumire Hotel & Convention Center", 8.3, 4),
        Hotel("Grage Hotel Cirebon", 8.4, 4),
        Hotel("Nata Azana Hotel Solo", 9.1, 4),
        Hotel("Moxy Solo", 9.5, 4),
        Hotel("C Hotel Cirebon", 7.6, 5),
        Hotel("Rumah Panggung Guest House Syariah Mitra RedDoors", 7.9, 5),
        Hotel("DoubleTree by Hilton Jakarta", 8.4, 5),
        Hotel("Hilton Bandung", 8.6, 5),
        Hotel("The Kharma Villas", 8.8, 5),
        Hotel("Hotel Tentrem Yogyakarta", 9.6, 5)
    )

    // Input pengguna
    println("Masukkan bintang hotel yang ingin dicari (1-5):")
    val bintang = readLine()?.toIntOrNull() ?: 0
    println("Masukkan rating minimum yang ingin dicari:")
    val minRating = readLine()?.toDoubleOrNull() ?: 0.0

    // Hitung waktu eksekusi filter
    val elapsedTime = measureNanoTime {
        val result = mutableListOf<Hotel>()
        for (hotel in hotels) {
            if (hotel.bintang == bintang && hotel.rating >= minRating) {
                result.add(hotel)
            }
        }

        // Output hasil
        if (result.isNotEmpty()) {
            println("Hotel ditemukan untuk Bintang $bintang dengan rating minimal $minRating:")
            result.forEach { println("- ${it.name} (${it.rating})") }
        } else {
            println("Tidak ada hotel yang ditemukan untuk Bintang $bintang dengan rating minimal $minRating.")
        }
    }

    val elapsedMillis = elapsedTime / 1_000_000.0
    println("Waktu eksekusi iteratif: %.3f ms".format(elapsedMillis))
}
