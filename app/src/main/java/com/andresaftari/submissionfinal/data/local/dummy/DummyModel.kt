package com.andresaftari.submissionfinal.data.local.dummy

import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.local.entity.MovieDetail
import com.andresaftari.submissionfinal.data.local.entity.Show
import com.andresaftari.submissionfinal.data.local.entity.ShowDetail
import com.andresaftari.submissionfinal.data.remote.response.DataResponse

object DummyModel {
    fun setMovieData(): ArrayList<Movie> {
        val movies = ArrayList<Movie>()

        movies.add(
            Movie(
                "M1",
                "American Sniper",
                "Biographical, Drama, Action",
                "American Sniper mengisahkan sosok Chris Kyle (Bradley Cooper), anggota Navy Seal, tokoh utama film ini, yang lahir dan tumbuh di Texas. Ia sedari kecil digembleng oleh ayahnya cara menembak dan berburu. Keahlian Kyle semakin terasah seiring berjalannya waktu yang membuatnya menjadi koboi rodeo. Suatu hari Kyle tidak sengaja mendapati kekasihnya berselingkuh. Dia merasa frustasi.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/american_sniper.jpg"
            )
        )
        movies.add(
            Movie(
                "M2",
                "Assassin's Creed",
                "Action, Thriller",
                "Callum Lynch adalah pria dengan masa lalu kelam. Ini membuat sosok dewasanya menjelma menjadi sosok agresif yang tak ragu membunuh. Pada akhirnya, satu pembunuhan yang ia lakukan membuat dia dijatuhi hukuman mati. Tapi Lynch tidak mati. Dia justru diseret ke fasilitas Abstergo, di mana ia dihubungkan dengan mesin canggih Animus untuk melihat sepak terjang terakhir Aguilar, Assassin leluhurnya.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/assassin.jpg"
            )
        )
        movies.add(
            Movie(
                "M3",
                "Bhrams: The Boy 2",
                "Horror, Mystery, Thriller",
                "Sebuah keluarga muda memutuskan pindah untuk memulai hidup baru. Namun di rumah baru tersebut, Liza (Katie Holmes) mendapati anaknya, Jude (Christopher Convery) berteman dengan boneka yang sangat mirip dengan manusia yang diberi nama Brahms. Satu per satu teror datang pasca Brahms berada di rumah mereka.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/bhrams_the_boy2.jpg"
            )
        )
        movies.add(
            Movie(
                "M4",
                "Djoerig Salawe",
                "Horror, Drama, Comedy",
                "Dua jawara desa - Adang dan Asep, bersaing menjadi calon lurah. Meskipun Adang menang, ia malah bangkrut dan ditinggal istri. Sementara Asep justru makin kaya raya. Bahkan mampu melunasi utang Adang. Dari cerita Ujang, Adang tahu bahwa Asep mendapatkan kekayaan melalui dukun Rojan. Adang pun meminta Rojan, cara memenangkan judi togel. Rojan menyanggupi setelah Adang menawarkan jabatan wakil lurah.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/djoerig_salawe.jpg"
            )
        )
        movies.add(
            Movie(
                "M5",
                "Fantasy Island",
                "Adventure, Horror",
                "Diadaptasi dari serial tv horor tahun 1970-an. Fantasy Island akan berkisah tentang sekelompok muda mudi yang berkunjung ke pulau tropis terpencil. Di pulau yang dikelola oleh Roarke (Michael Pena) ini mereka diyakinkan bahwa fantasi para tamu bisa diwujudkan menjadi nyata. Namun perlahan, para tamu mengetahui bahwa fantasi mereka menjadi mimpi buruk saat perlahan pulau tersebut memutarbalikkan keinginan mereka.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/fantasy_island.jpg"
            )
        )
        movies.add(
            Movie(
                "M6",
                "Gretel & Hansel",
                "Horror",
                "Sepeninggal ayah, Gretel dan adiknya yang masih kecil, Hansel, diusir dari rumah oleh ibu mereka yang depresi sama keadaan. Gretel membawa Hansel menyusur hutan yang marak oleh rumor keberadaan penyihir dan entah apa lagi hal mengerikan yang menunggu di dalamnya demi mencari kediaman lain supaya bisa bekerja di sana.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/gretel.jpg"
            )
        )
        movies.add(
            Movie(
                "M7",
                "Hitman",
                "Action, Thriller",
                "Agent 47 adalah hasil dari pelatihan dan pendidikan keras yang disertai dengan tingkat disiplin yang bertugas untuk membunuh. Sebagai penandanya, para murid yang turut pelatihan itu diberi tato barcode di belakang kepalanya yang hanya tertulis angka tanpa nama. Agent 47 menjadi cetakan yang selalu berhasil menjalankan tugasnya.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/hitman.jpg"
            )
        )
        movies.add(
            Movie(
                "M8",
                "M-Spy",
                "Action, Comedy, Family",
                "JJ (Dave Bautista) adalah seorang agen CIA yang sangat hebat. Namun dibalik kesangarannya JJ adalah pribadi yang baik. Hal ini terjadi saat ia harus bekerjasama dengan Sophie (Chloe Coleman), gadis cantik berusia 9 tahun. Keduanya akan menjadi tim dan memecahkan kasus sulit.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/m_spy.jpg"
            )
        )
        movies.add(
            Movie(
                "M9",
                "Malik and Elsa",
                "Drama, Romance",
                "Kadang kedekatan bisa berawal dari sebuah perkenalan yang tidak biasa. Contohnya, seperti Malik (Endi Arfian) dan Elsa (Salshabilla Adriani). Berawal dari permainan tebak-tebakan, di mana Elsa kalah dan dihukum harus mentraktir Malik selama 7 hari berturut-turut, Malik dan Elsa lalu seperti menemukan dunia mereka bersama. 7 hari itu ternyata bisa menyatukan Malik yang kondisi keluarganya bertolak belakang dari Elsa.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/malik_n_elsa.jpg"
            )
        )
        movies.add(
            Movie(
                "M10",
                "Mariposa",
                "Drama, Romance",
                "Mariposa (Kupu-kupu) seperti kamu, aku mengejar tapi kamu menghindar. Begitulah gambaran sosok IQBAL GUANNA bagi NATASHA KAY LOOVY atau ACHA. Acha bertekad ingin mendapatkan hati Iqbal, seorang cowok cakep, pintar dan dikenal berhati dingin.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/mariposa.jpg"
            )
        )
        movies.add(
            Movie(
                "M11",
                "Milea: Suara dari Dilan",
                "Drama, Romance",
                "Tidak ada kisah yang lebih Indah dari kisah cinta di SMA. Sama halnya dengan kisah cinta Dilan dan Milea. Dari yang awalnya benci hingga saling mencintai. Dari yang awalnya manis hingga menjadi rumit. Menjelang reuni akbar, Dilan memutuskan untuk menceritakan kembali masa - masa itu.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/milea_suara_dari_dilan.jpg"
            )
        )
        movies.add(
            Movie(
                "M12",
                "The Invisible Man",
                "Sci-Fi, Thriller, Horror",
                "Cecilia Kass (Elisabeth Moss) tidak pernah percaya bahwa mantan kekasihnya yang tempramental bunuh diri dan meninggalkan warisan kepadanya. Cecilia berusaha membuktikan bahwa ia sedang diburu oleh seseorang yang tidak terlihat oleh siapapun.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/the_invisible_man.jpg"
            )
        )
        return movies
    }

    fun setShowData(): ArrayList<Show> {
        val show = ArrayList<Show>()

        show.add(
            Show(
                "S1",
                "Avatar: The Last Airbender",
                "Action, Adventure, Fantasy, Comedy, Animation",
                "Avatar: The Legend of Aang mengambil tempat di sebuah dunia fantasi, tempat tinggal manusia, berbagai binatang fantastik, dan roh-roh. Peradaban manusia terbagi-bagi menjadi empat bangsa, Suku Air (Water Tribe), Kerajaan Bumi (Earth Kingdom), Pengembara Udara (Air Nomads), dan Negara Api (Fire Nation).",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_avatar_tla.jpg"
            )
        )
        show.add(
            Show(
                "S2",
                "Empire",
                "Musical, Drama, Romance",
                "Serial televisi Empire bercerita tentang Lucious Lyon (Terrence Howard) dan keluarganya yang memiliki perusahaan studio musik bernama \"Empire Entertainment\" yang berfokus pada musik hiphop sebagai bidang utamanya. Lucious didiagnosa menderita ALS (Amyotrophic Lateral Sclerosis) dan harus memutuskan siapa dari ketiga anaknya yang akan mengambil alih Empire.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_empire.jpg"
            )
        )
        show.add(
            Show(
                "S3",
                "Family Guy",
                "Situational Comedy, Adventure, Adult, Animation",
                "Film ini adalah petualangan keluarga Griffin, yaitu ayah Peter Griffin, seorang pekerja kerah biru yang kikuk namun bermaksud baik; Lois, seorang ibu dan guru piano yang tinggal di rumah yang cantik yang merupakan anggota keluarga Pewterschmidt yang kaya; Meg, putri remaja mereka yang sering digertak yang juga selalu diejek atau diabaikan oleh keluarga; Chris, putra remaja canggung mereka, yang kelebihan berat badan, versi yang lebih muda dari ayahnya; dan Stewie, bayi mereka yang kejam.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_family_guy.jpg"
            )
        )
        show.add(
            Show(
                "S4",
                "Game of Thrones",
                "Adventure, Drama, Fantasy",
                "Game of Thrones adalah serial televisi drama fantasi Amerika Serikat yang diciptakan oleh David Benioff dan D. B. Weiss untuk saluran HBO. Berlatar tempat di benua fiktif Westeros dan Essos, Game of Thrones memiliki beberapa plot dan dibintangi oleh sejumlah besar pemeran ansambel serta mengisahkan beberapa alur cerita. Salah satu alur mengisahkan mengenai Takhta Besi di Seven Kingdoms dan rangkaian aliansi dan konflik antar wangsa bangsawan yang saling berlomba untuk mengklaim takhta atau berjuang untuk memerdekakan diri.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_game_of_thrones.jpg"
            )
        )
        show.add(
            Show(
                "S5",
                "Grey's Anatomy",
                "Drama, Science, Romance",
                "Greys Anatomy berikut cerita warga bedah, rekan, dan dokter bedah karena mereka mengalami kesulitan karir kompetitif mereka telah memilih. Dalam 11 season, dengan perubahan di rumah dan bekerja, Meredith berjuang untuk menemukan rasa normal.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_grey_anatomy.jpg"
            )
        )
        show.add(
            Show(
                "S6",
                "Homeland",
                "Thriller, Drama, Political",
                "Homeland adalah serial televisi Amerika Serikat yang dikembangkan oleh Howard Gordon dan Alex Gansa berdasarkan serial televisi Israel Hatufim (judul bahasa Inggris: Prisoners of War) yang diciptakan oleh Gideon Raff. Seri ini disiarkan di Showtime sejak 2 Oktober 2011 dan diproduksi oleh Fox Television Studios 21 (sebelumnya Fox 21).",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_homeland.jpg"
            )
        )
        show.add(
            Show(
                "S7",
                "Naruto Shippuden",
                "Action, Adventure, Fantasy, Animation",
                "Naruto Shippuden adalah sebuah seri anime yang diadaptasi dari bagian II manga Naruto. Film ini menceritakan tentang usaha ninja jahat dalam membangkitkan Mouryou, roh jahat yang telah dikalahkan 20 tahun yang lalu. Pada bagian ini, pergerakan organisasi Akatsuki semakin terlihat.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_naruto_shipudden.jpg"
            )
        )
        show.add(
            Show(
                "S8",
                "NCIS",
                "Action, Crime Investigation, Drama",
                "NCIS (Naval Criminal Investigative Service) adalah serial televisi Amerika Serikat yang di produksi oleh CBS Television Studios. NCIS adalah badan agensi federal yang menginvestigasi kasus-kasus kejahatan kepada US Navy dan US Marine Corps, baik anggota maupun keluarganya (seperti pembunuhan atau penculikan), instalasi militer, persenjataan militer, hingga kontraterorisme dan kontraintelijen. NCIS bersifat agensi sipil independen yang bertanggungjawab langsung kepada Menteri Angkatan Laut Amerika Serikat.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_ncis.jpg"
            )
        )
        show.add(
            Show(
                "S9",
                "Stranger Things",
                "Sci-Fi, Horror, Supernatural, Drama",
                "Stranger Things berlatar di kota pedesaan fiksi Hawkins, Indiana pada awal tahun 1980-an. Laboratorium Nasional Hawkins di dekatnya seolah-olah melakukan penelitian ilmiah untuk Departemen Energi Amerika Serikat, tetapi secara diam-diam melakukan eksperimen ke dalam paranormal dan supranatural, termasuk yang melibatkan subjek uji coba untuk manusia. Secara tidak sengaja, mereka telah membuat portal ke dimensi alternatif yang disebut the Upside Down.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_stranger_things.jpg"
            )
        )
        show.add(
            Show(
                "S10",
                "The Simpsons",
                "Situational Comedy, Adventure, Adult, Animation",
                "Setiap episode Simpsons berfokus pada kehidupan keluarga Simpsons yang terdiri dari Homer, Marge, Bart, Lisa dan Maggie tinggal di sebuah kota bernama Springfield. Keluarga Simpsons ini disertai lebih dari 300 tokoh-tokoh pendukung yang sendiri juga telah cukup dikenal para penontonnya. Saat ini, The Simpsons ditayangkan oleh FOX di Amerika Serikat, dan merupakan serial animasi terpanjang dalam sejarah Amerika Serikat.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_the_simpson.jpg"
            )
        )
        show.add(
            Show(
                "S11",
                "The Walking Dead",
                "Horror, Post Apocalypse, Drama",
                "The Walking Dead terjadi setelah permulaan sebuah kiamat zombi di seluruh dunia. Zombi-zombi yang biasa disebut walker tersebut, berjalan menuju manusia dan makhluk hidup lainnya untuk memakannya (mereka tertarik pada kebisingan, misalnya suara tembakan, dan aroma yang berbeda, misalnya aroma manusia). Manusia yang mereka gigit atau cakar menjadi terinfeksi dan perlahan berubah menjadi walker juga. Terungkap di awal serial bahwa semua manusia yang hidup membawa patogen ini, sehingga jika mereka meninggal karena sebab lain, mereka juga akan berubah menjadi walker.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_walking_dead.jpg"
            )
        )
        return show
    }

    fun setRemoteMovieData(): ArrayList<DataResponse> {
        val movies = ArrayList<DataResponse>()

        movies.add(
            DataResponse(
                "M1",
                "American Sniper",
                "Biographical, Drama, Action",
                "American Sniper mengisahkan sosok Chris Kyle (Bradley Cooper), anggota Navy Seal, tokoh utama film ini, yang lahir dan tumbuh di Texas. Ia sedari kecil digembleng oleh ayahnya cara menembak dan berburu. Keahlian Kyle semakin terasah seiring berjalannya waktu yang membuatnya menjadi koboi rodeo. Suatu hari Kyle tidak sengaja mendapati kekasihnya berselingkuh. Dia merasa frustasi.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/american_sniper.jpg"
            )
        )
        movies.add(
            DataResponse(
                "M2",
                "Assassin's Creed",
                "Action, Thriller",
                "Callum Lynch adalah pria dengan masa lalu kelam. Ini membuat sosok dewasanya menjelma menjadi sosok agresif yang tak ragu membunuh. Pada akhirnya, satu pembunuhan yang ia lakukan membuat dia dijatuhi hukuman mati. Tapi Lynch tidak mati. Dia justru diseret ke fasilitas Abstergo, di mana ia dihubungkan dengan mesin canggih Animus untuk melihat sepak terjang terakhir Aguilar, Assassin leluhurnya.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/assassin.jpg"
            )
        )
        movies.add(
            DataResponse(
                "M3",
                "Bhrams: The Boy 2",
                "Horror, Mystery, Thriller",
                "Sebuah keluarga muda memutuskan pindah untuk memulai hidup baru. Namun di rumah baru tersebut, Liza (Katie Holmes) mendapati anaknya, Jude (Christopher Convery) berteman dengan boneka yang sangat mirip dengan manusia yang diberi nama Brahms. Satu per satu teror datang pasca Brahms berada di rumah mereka.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/bhrams_the_boy2.jpg"
            )
        )
        movies.add(
            DataResponse(
                "M4",
                "Djoerig Salawe",
                "Horror, Drama, Comedy",
                "Dua jawara desa - Adang dan Asep, bersaing menjadi calon lurah. Meskipun Adang menang, ia malah bangkrut dan ditinggal istri. Sementara Asep justru makin kaya raya. Bahkan mampu melunasi utang Adang. Dari cerita Ujang, Adang tahu bahwa Asep mendapatkan kekayaan melalui dukun Rojan. Adang pun meminta Rojan, cara memenangkan judi togel. Rojan menyanggupi setelah Adang menawarkan jabatan wakil lurah.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/djoerig_salawe.jpg"
            )
        )
        movies.add(
            DataResponse(
                "M5",
                "Fantasy Island",
                "Adventure, Horror",
                "Diadaptasi dari serial tv horor tahun 1970-an. Fantasy Island akan berkisah tentang sekelompok muda mudi yang berkunjung ke pulau tropis terpencil. Di pulau yang dikelola oleh Roarke (Michael Pena) ini mereka diyakinkan bahwa fantasi para tamu bisa diwujudkan menjadi nyata. Namun perlahan, para tamu mengetahui bahwa fantasi mereka menjadi mimpi buruk saat perlahan pulau tersebut memutarbalikkan keinginan mereka.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/fantasy_island.jpg"
            )
        )
        movies.add(
            DataResponse(
                "M6",
                "Gretel & Hansel",
                "Horror",
                "Sepeninggal ayah, Gretel dan adiknya yang masih kecil, Hansel, diusir dari rumah oleh ibu mereka yang depresi sama keadaan. Gretel membawa Hansel menyusur hutan yang marak oleh rumor keberadaan penyihir dan entah apa lagi hal mengerikan yang menunggu di dalamnya demi mencari kediaman lain supaya bisa bekerja di sana.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/gretel.jpg"
            )
        )
        movies.add(
            DataResponse(
                "M7",
                "Hitman",
                "Action, Thriller",
                "Agent 47 adalah hasil dari pelatihan dan pendidikan keras yang disertai dengan tingkat disiplin yang bertugas untuk membunuh. Sebagai penandanya, para murid yang turut pelatihan itu diberi tato barcode di belakang kepalanya yang hanya tertulis angka tanpa nama. Agent 47 menjadi cetakan yang selalu berhasil menjalankan tugasnya.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/hitman.jpg"
            )
        )
        movies.add(
            DataResponse(
                "M8",
                "M-Spy",
                "Action, Comedy, Family",
                "JJ (Dave Bautista) adalah seorang agen CIA yang sangat hebat. Namun dibalik kesangarannya JJ adalah pribadi yang baik. Hal ini terjadi saat ia harus bekerjasama dengan Sophie (Chloe Coleman), gadis cantik berusia 9 tahun. Keduanya akan menjadi tim dan memecahkan kasus sulit.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/m_spy.jpg"
            )
        )
        movies.add(
            DataResponse(
                "M9",
                "Malik and Elsa",
                "Drama, Romance",
                "Kadang kedekatan bisa berawal dari sebuah perkenalan yang tidak biasa. Contohnya, seperti Malik (Endi Arfian) dan Elsa (Salshabilla Adriani). Berawal dari permainan tebak-tebakan, di mana Elsa kalah dan dihukum harus mentraktir Malik selama 7 hari berturut-turut, Malik dan Elsa lalu seperti menemukan dunia mereka bersama. 7 hari itu ternyata bisa menyatukan Malik yang kondisi keluarganya bertolak belakang dari Elsa.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/malik_n_elsa.jpg"
            )
        )
        movies.add(
            DataResponse(
                "M10",
                "Mariposa",
                "Drama, Romance",
                "Mariposa (Kupu-kupu) seperti kamu, aku mengejar tapi kamu menghindar. Begitulah gambaran sosok IQBAL GUANNA bagi NATASHA KAY LOOVY atau ACHA. Acha bertekad ingin mendapatkan hati Iqbal, seorang cowok cakep, pintar dan dikenal berhati dingin.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/mariposa.jpg"
            )
        )
        movies.add(
            DataResponse(
                "M11",
                "Milea: Suara dari Dilan",
                "Drama, Romance",
                "Tidak ada kisah yang lebih Indah dari kisah cinta di SMA. Sama halnya dengan kisah cinta Dilan dan Milea. Dari yang awalnya benci hingga saling mencintai. Dari yang awalnya manis hingga menjadi rumit. Menjelang reuni akbar, Dilan memutuskan untuk menceritakan kembali masa - masa itu.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/milea_suara_dari_dilan.jpg"
            )
        )
        movies.add(
            DataResponse(
                "M12",
                "The Invisible Man",
                "Sci-Fi, Thriller, Horror",
                "Cecilia Kass (Elisabeth Moss) tidak pernah percaya bahwa mantan kekasihnya yang tempramental bunuh diri dan meninggalkan warisan kepadanya. Cecilia berusaha membuktikan bahwa ia sedang diburu oleh seseorang yang tidak terlihat oleh siapapun.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/the_invisible_man.jpg"
            )
        )

        return movies
    }

    fun setRemoteShowData(): ArrayList<DataResponse> {
        val show = ArrayList<DataResponse>()

        show.add(
            DataResponse(
                "S1",
                "Avatar: The Last Airbender",
                "Action, Adventure, Fantasy, Comedy, Animation",
                "Avatar: The Legend of Aang mengambil tempat di sebuah dunia fantasi, tempat tinggal manusia, berbagai binatang fantastik, dan roh-roh. Peradaban manusia terbagi-bagi menjadi empat bangsa, Suku Air (Water Tribe), Kerajaan Bumi (Earth Kingdom), Pengembara Udara (Air Nomads), dan Negara Api (Fire Nation).",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_avatar_tla.jpg"
            )
        )
        show.add(
            DataResponse(
                "S2",
                "Empire",
                "Musical, Drama, Romance",
                "Serial televisi Empire bercerita tentang Lucious Lyon (Terrence Howard) dan keluarganya yang memiliki perusahaan studio musik bernama \"Empire Entertainment\" yang berfokus pada musik hiphop sebagai bidang utamanya. Lucious didiagnosa menderita ALS (Amyotrophic Lateral Sclerosis) dan harus memutuskan siapa dari ketiga anaknya yang akan mengambil alih Empire.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_empire.jpg"
            )
        )
        show.add(
            DataResponse(
                "S3",
                "Family Guy",
                "Situational Comedy, Adventure, Adult, Animation",
                "Film ini adalah petualangan keluarga Griffin, yaitu ayah Peter Griffin, seorang pekerja kerah biru yang kikuk namun bermaksud baik; Lois, seorang ibu dan guru piano yang tinggal di rumah yang cantik yang merupakan anggota keluarga Pewterschmidt yang kaya; Meg, putri remaja mereka yang sering digertak yang juga selalu diejek atau diabaikan oleh keluarga; Chris, putra remaja canggung mereka, yang kelebihan berat badan, versi yang lebih muda dari ayahnya; dan Stewie, bayi mereka yang kejam.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_family_guy.jpg"
            )
        )
        show.add(
            DataResponse(
                "S4",
                "Game of Thrones",
                "Adventure, Drama, Fantasy",
                "Game of Thrones adalah serial televisi drama fantasi Amerika Serikat yang diciptakan oleh David Benioff dan D. B. Weiss untuk saluran HBO. Berlatar tempat di benua fiktif Westeros dan Essos, Game of Thrones memiliki beberapa plot dan dibintangi oleh sejumlah besar pemeran ansambel serta mengisahkan beberapa alur cerita. Salah satu alur mengisahkan mengenai Takhta Besi di Seven Kingdoms dan rangkaian aliansi dan konflik antar wangsa bangsawan yang saling berlomba untuk mengklaim takhta atau berjuang untuk memerdekakan diri.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_game_of_thrones.jpg"
            )
        )
        show.add(
            DataResponse(
                "S5",
                "Grey's Anatomy",
                "Drama, Science, Romance",
                "Greys Anatomy berikut cerita warga bedah, rekan, dan dokter bedah karena mereka mengalami kesulitan karir kompetitif mereka telah memilih. Dalam 11 season, dengan perubahan di rumah dan bekerja, Meredith berjuang untuk menemukan rasa normal.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_grey_anatomy.jpg"
            )
        )
        show.add(
            DataResponse(
                "S6",
                "Homeland",
                "Thriller, Drama, Political",
                "Homeland adalah serial televisi Amerika Serikat yang dikembangkan oleh Howard Gordon dan Alex Gansa berdasarkan serial televisi Israel Hatufim (judul bahasa Inggris: Prisoners of War) yang diciptakan oleh Gideon Raff. Seri ini disiarkan di Showtime sejak 2 Oktober 2011 dan diproduksi oleh Fox Television Studios 21 (sebelumnya Fox 21).",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_homeland.jpg"
            )
        )
        show.add(
            DataResponse(
                "S7",
                "Naruto Shippuden",
                "Action, Adventure, Fantasy, Animation",
                "Naruto Shippuden adalah sebuah seri anime yang diadaptasi dari bagian II manga Naruto. Film ini menceritakan tentang usaha ninja jahat dalam membangkitkan Mouryou, roh jahat yang telah dikalahkan 20 tahun yang lalu. Pada bagian ini, pergerakan organisasi Akatsuki semakin terlihat.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_naruto_shipudden.jpg"
            )
        )
        show.add(
            DataResponse(
                "S8",
                "NCIS",
                "Action, Crime Investigation, Drama",
                "NCIS (Naval Criminal Investigative Service) adalah serial televisi Amerika Serikat yang di produksi oleh CBS Television Studios. NCIS adalah badan agensi federal yang menginvestigasi kasus-kasus kejahatan kepada US Navy dan US Marine Corps, baik anggota maupun keluarganya (seperti pembunuhan atau penculikan), instalasi militer, persenjataan militer, hingga kontraterorisme dan kontraintelijen. NCIS bersifat agensi sipil independen yang bertanggungjawab langsung kepada Menteri Angkatan Laut Amerika Serikat.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_ncis.jpg"
            )
        )
        show.add(
            DataResponse(
                "S9",
                "Stranger Things",
                "Sci-Fi, Horror, Supernatural, Drama",
                "Stranger Things berlatar di kota pedesaan fiksi Hawkins, Indiana pada awal tahun 1980-an. Laboratorium Nasional Hawkins di dekatnya seolah-olah melakukan penelitian ilmiah untuk Departemen Energi Amerika Serikat, tetapi secara diam-diam melakukan eksperimen ke dalam paranormal dan supranatural, termasuk yang melibatkan subjek uji coba untuk manusia. Secara tidak sengaja, mereka telah membuat portal ke dimensi alternatif yang disebut the Upside Down.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_stranger_things.jpg"
            )
        )
        show.add(
            DataResponse(
                "S10",
                "The Simpsons",
                "Situational Comedy, Adventure, Adult, Animation",
                "Setiap episode Simpsons berfokus pada kehidupan keluarga Simpsons yang terdiri dari Homer, Marge, Bart, Lisa dan Maggie tinggal di sebuah kota bernama Springfield. Keluarga Simpsons ini disertai lebih dari 300 tokoh-tokoh pendukung yang sendiri juga telah cukup dikenal para penontonnya. Saat ini, The Simpsons ditayangkan oleh FOX di Amerika Serikat, dan merupakan serial animasi terpanjang dalam sejarah Amerika Serikat.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_the_simpson.jpg"
            )
        )
        show.add(
            DataResponse(
                "S11",
                "The Walking Dead",
                "Horror, Post Apocalypse, Drama",
                "The Walking Dead terjadi setelah permulaan sebuah kiamat zombi di seluruh dunia. Zombi-zombi yang biasa disebut walker tersebut, berjalan menuju manusia dan makhluk hidup lainnya untuk memakannya (mereka tertarik pada kebisingan, misalnya suara tembakan, dan aroma yang berbeda, misalnya aroma manusia). Manusia yang mereka gigit atau cakar menjadi terinfeksi dan perlahan berubah menjadi walker juga. Terungkap di awal serial bahwa semua manusia yang hidup membawa patogen ini, sehingga jika mereka meninggal karena sebab lain, mereka juga akan berubah menjadi walker.",
                "https://andresaftari.student.telkomuniversity.ac.id/files/2020/06/show_walking_dead.jpg"
            )
        )

        return show
    }

    fun setMovieDetail(movie: Movie, favorited: Boolean): MovieDetail {
        movie.favorited = favorited
        return MovieDetail(movie, movie)
    }

    fun setShowDetail(show: Show, favorited: Boolean): ShowDetail {
        show.favorited = favorited
        return ShowDetail(show, show)
    }
}