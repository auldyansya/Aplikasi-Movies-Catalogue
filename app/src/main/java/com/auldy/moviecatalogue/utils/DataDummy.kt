package com.auldy.moviecatalogue.utils

import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auldy.moviecatalogue.data.source.remote.response.MoviesResponse
import com.auldy.moviecatalogue.data.source.remote.response.TvShowResponse

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
object DataDummy {
    fun generateDummyMovies(): List<MoviesEntity> {

        val movies = ArrayList<MoviesEntity>()

        movies.add(
            MoviesEntity(
                "m01",
                "https://www.themoviedb.org/t/p/original/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                "https://www.themoviedb.org/t/p/original/yiu9ISHAbbZATKl0FaMPh8is7Oa.jpg",
                "Mortal Kombat",
                "14/04/2021",
                "Fantasy, Action, Adventure, Science Fiction, Thriller",
                "1h 50m",
                "78%",
                "Get over here.",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "Released",
                "Inggris",
                "$20,000,000.00",
                "$50,115,000.00",
                false
            )
        )
        movies.add(
            MoviesEntity(
                "m02",
                "https://www.themoviedb.org/t/p/original/mGJuQwMq1bEboaVTqQAK4p4zQvC.jpg",
                "https://www.themoviedb.org/t/p/original/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "Godzilla vs. Kong",
                "03/31/2021",
                "Science Fiction, Action, Drama",
                "1h 53m",
                "82%",
                "One Will Fall",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "Released",
                "English",
                "$160,000,000.00",
                "$406,575,844.00",
                false
            )
        )
        movies.add(
            MoviesEntity(
                "m03",
                "https://www.themoviedb.org/t/p/original/mb3fcmQzXd8aUf7r6izZfMHSJmz.jpg",
                "https://www.themoviedb.org/t/p/original/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                "Vanquish",
                "04/16/2021",
                "Action, Crime, Thriller",
                "1h 36m",
                "61%",
                "She's got one night to save her life.",
                "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                "Released",
                "English",
                "-",
                "-",
                false
            )
        )
        movies.add(
            MoviesEntity(
                "m04",
                "https://www.themoviedb.org/t/p/original/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                "https://www.themoviedb.org/t/p/original/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "Nobody",
                "03/26/2021",
                "Action, Thriller, Crime",
                "1h 32m",
                "85%",
                "Never underestimate a nobody.",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "Released",
                "English",
                "$17,000,000.00",
                "$35,731,879.00",
                false
            )
        )
        movies.add(
            MoviesEntity(
                "m05",
                "https://www.themoviedb.org/t/p/original/3FVe3OAdgz060JaxIAaUl5lo6cx.jpg",
                "https://www.themoviedb.org/t/p/original/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                "04/23/2021",
                "Animation, Action, Adventure, Fantasy, Drama",
                "1h 57m",
                "83%",
                "With your blade, bring an end to the nightmare.",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                "Released",
                "Japanese",
                "-",
                "$444,500,000.00",
                false
            )
        )
        movies.add(
            MoviesEntity(
                "m06",
                "https://www.themoviedb.org/t/p/original/zDq2pwPyt4xwSFHKUoNN2LohDWj.jpg",
                "https://www.themoviedb.org/t/p/original/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                "The Unholy",
                "04/02/2021",
                "Horror",
                "1h 39m",
                "57%",
                "Be careful who you pray to.",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "Released",
                "English",
                "$10,000,000.00",
                "-",
                false
            )
        )
        movies.add(
            MoviesEntity(
                "m07",
                "https://www.themoviedb.org/t/p/original/5Zv5KmgZzdIvXz2KC3n0MyecSNL.jpg",
                "https://www.themoviedb.org/t/p/original/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
                "The Marksman",
                "01/15/2021",
                "Action, Thriller, Crime",
                "1h 48m",
                "75%",
                "Justice comes down to him.",
                "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                "Released",
                "English",
                "$23,000,000.00",
                "$22,039,969.00",
                false
            )
        )
        movies.add(
            MoviesEntity(
                "m08",
                "https://www.themoviedb.org/t/p/original/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
                "https://www.themoviedb.org/t/p/original/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "Zack Snyder's Justice League",
                "03/18/2021",
                "Action, Adventure, Fantasy, Science Fiction",
                "4h 2m",
                "85%",
                "-",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "Released",
                "English",
                "$70,000,000.00",
                "-",
                false
            )
        )
        movies.add(
            MoviesEntity(
                "m09",
                "https://www.themoviedb.org/t/p/original/z7HLq35df6ZpRxdMAE0qE3Ge4SJ.jpg",
                "https://www.themoviedb.org/t/p/original/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
                "Thunder Force",
                "04/09/2021",
                "Action, Adventure, Comedy, Fantasy",
                "1h 47m",
                "58%",
                "Newly super. Almost heroes.",
                "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                "Released",
                "English",
                "-",
                "-",
                false
            )
        )
        movies.add(
            MoviesEntity(
                "m10",
                "https://www.themoviedb.org/t/p/original/lHhc60NXYzswU4TvKSo45nY9Jzs.jpg",
                "https://www.themoviedb.org/t/p/original/msI5a9TPnepx47JUb2vl88hb80R.jpg",
                "Miraculous World: Shanghai – The Legend of Ladydragon",
                "04/04/2021",
                "Animation, Comedy, Family, Adventure",
                "52m",
                "79%",
                "Miraculous World",
                "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time...",
                "Released",
                "French",
                "-",
                "-",
                false
            )
        )

        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {

        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity(
                "tv01",
                "https://www.themoviedb.org/t/p/original/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "https://www.themoviedb.org/t/p/original/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "The Falcon and the Winter Soldier",
                "Mar 19, 2021",
                "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
                "50m",
                "79%",
                "Honor the shield.",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "Released",
                "Inggris",
                " - ",
                " - ",
                false
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv02",
                "https://www.themoviedb.org/t/p/original/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                "https://www.themoviedb.org/t/p/original/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "Invincible",
                "Mar 26, 2021",
                "Animation, Action & Adventure, Drama, Sci-Fi & Fantasy",
                "45m",
                "89%",
                "-",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv03",
                "https://www.themoviedb.org/t/p/original/lEZLrd3N9nIk5fnCL30GsboCEmB.jpg",
                "https://www.themoviedb.org/t/p/original/Q1ZYG3kDS8iVIHOYOJ9NQmV0q7.jpg",
                "Haunted: Latin America",
                "Mar 31, 2021",
                "Reality",
                "30m",
                "74%",
                "-",
                "Real people's terrifying tales of the chilling, unexplained and paranormal come to life with dramatic reenactments in this reality series.",
                "Returning Series",
                "Spanish; Castilian",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv04",
                "https://www.themoviedb.org/t/p/original/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                "https://www.themoviedb.org/t/p/original/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "The Good Doctor",
                "Sep 25, 2017",
                "Drama",
                "43m",
                "86%",
                "His mind is a mystery, his methods are a miracle.",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv05",
                "https://www.themoviedb.org/t/p/original/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
                "https://www.themoviedb.org/t/p/original/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "The Flash",
                "Oct 07, 2014",
                "Drama, Sci-Fi & Fantasy",
                "44m",
                "77%",
                "The fastest man alive.",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv06",
                "https://www.themoviedb.org/t/p/original/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                "https://www.themoviedb.org/t/p/original/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "Grey's Anatomy",
                "Mar 27, 2005",
                "Drama",
                "43m",
                "82%",
                "The life you save may be your own.",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv07",
                "https://www.themoviedb.org/t/p/original/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg",
                "https://www.themoviedb.org/t/p/original/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "Lucifer",
                "Jan 25, 2016",
                "Crime, Sci-Fi & Fantasy",
                "45m",
                "85%",
                "It's good to be bad.",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv08",
                "https://www.themoviedb.org/t/p/original/wkyzeBBKLhSg1Oqhky5yoiFF2hG.jpg",
                "https://www.themoviedb.org/t/p/original/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                "Luis Miguel: The Series",
                "Apr 22, 2018",
                "Drama",
                "-",
                "80%",
                "-",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                "Returning Series",
                "Spanish; Castilian",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv09",
                "https://www.themoviedb.org/t/p/original/5VltHQJXdmbSD6gEJw3R8R1Kbmc.jpg",
                "https://www.themoviedb.org/t/p/original/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
                "Van Helsing",
                "Sep 23, 2016",
                "Mystery, Sci-Fi & Fantasy, Action & Adventure",
                "42m",
                "69%",
                "-",
                "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowEntity(
                "tv10",
                "https://www.themoviedb.org/t/p/original/qZtAf4Z1lazGQoYVXiHOrvLr5lI.jpg",
                "https://www.themoviedb.org/t/p/original/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "Riverdale",
                "Jan 26, 2017",
                "Mystery, Drama, Crime",
                "45m",
                "86%",
                "Small town. Big secrets.",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )

        return tvShow
    }


    fun generateMovies(): List<MoviesResponse> {

        val movies = ArrayList<MoviesResponse>()

        movies.add(
            MoviesResponse(
                "m01",
                "https://www.themoviedb.org/t/p/original/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                "https://www.themoviedb.org/t/p/original/yiu9ISHAbbZATKl0FaMPh8is7Oa.jpg",
                "Mortal Kombat",
                "14/04/2021",
                "Fantasy, Action, Adventure, Science Fiction, Thriller",
                "1h 50m",
                "78%",
                "Get over here.",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "Released",
                "Inggris",
                "$20,000,000.00",
                "$50,115,000.00",
                false
            )
        )
        movies.add(
            MoviesResponse(
                "m02",
                "https://www.themoviedb.org/t/p/original/mGJuQwMq1bEboaVTqQAK4p4zQvC.jpg",
                "https://www.themoviedb.org/t/p/original/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "Godzilla vs. Kong",
                "03/31/2021",
                "Science Fiction, Action, Drama",
                "1h 53m",
                "82%",
                "One Will Fall",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "Released",
                "English",
                "$160,000,000.00",
                "$406,575,844.00",
                false
            )
        )
        movies.add(
            MoviesResponse(
                "m03",
                "https://www.themoviedb.org/t/p/original/mb3fcmQzXd8aUf7r6izZfMHSJmz.jpg",
                "https://www.themoviedb.org/t/p/original/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                "Vanquish",
                "04/16/2021",
                "Action, Crime, Thriller",
                "1h 36m",
                "61%",
                "She's got one night to save her life.",
                "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                "Released",
                "English",
                "-",
                "-",
                false
            )
        )
        movies.add(
            MoviesResponse(
                "m04",
                "https://www.themoviedb.org/t/p/original/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                "https://www.themoviedb.org/t/p/original/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "Nobody",
                "03/26/2021",
                "Action, Thriller, Crime",
                "1h 32m",
                "85%",
                "Never underestimate a nobody.",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "Released",
                "English",
                "$17,000,000.00",
                "$35,731,879.00",
                false
            )
        )
        movies.add(
            MoviesResponse(
                "m05",
                "https://www.themoviedb.org/t/p/original/3FVe3OAdgz060JaxIAaUl5lo6cx.jpg",
                "https://www.themoviedb.org/t/p/original/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                "04/23/2021",
                "Animation, Action, Adventure, Fantasy, Drama",
                "1h 57m",
                "83%",
                "With your blade, bring an end to the nightmare.",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                "Released",
                "Japanese",
                "-",
                "$444,500,000.00",
                false
            )
        )
        movies.add(
            MoviesResponse(
                "m06",
                "https://www.themoviedb.org/t/p/original/zDq2pwPyt4xwSFHKUoNN2LohDWj.jpg",
                "https://www.themoviedb.org/t/p/original/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                "The Unholy",
                "04/02/2021",
                "Horror",
                "1h 39m",
                "57%",
                "Be careful who you pray to.",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "Released",
                "English",
                "$10,000,000.00",
                "-",
                false
            )
        )
        movies.add(
            MoviesResponse(
                "m07",
                "https://www.themoviedb.org/t/p/original/5Zv5KmgZzdIvXz2KC3n0MyecSNL.jpg",
                "https://www.themoviedb.org/t/p/original/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
                "The Marksman",
                "01/15/2021",
                "Action, Thriller, Crime",
                "1h 48m",
                "75%",
                "Justice comes down to him.",
                "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                "Released",
                "English",
                "$23,000,000.00",
                "$22,039,969.00",
                false
            )
        )
        movies.add(
            MoviesResponse(
                "m08",
                "https://www.themoviedb.org/t/p/original/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
                "https://www.themoviedb.org/t/p/original/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "Zack Snyder's Justice League",
                "03/18/2021",
                "Action, Adventure, Fantasy, Science Fiction",
                "4h 2m",
                "85%",
                "-",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "Released",
                "English",
                "$70,000,000.00",
                "-",
                false
            )
        )
        movies.add(
            MoviesResponse(
                "m09",
                "https://www.themoviedb.org/t/p/original/z7HLq35df6ZpRxdMAE0qE3Ge4SJ.jpg",
                "https://www.themoviedb.org/t/p/original/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
                "Thunder Force",
                "04/09/2021",
                "Action, Adventure, Comedy, Fantasy",
                "1h 47m",
                "58%",
                "Newly super. Almost heroes.",
                "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                "Released",
                "English",
                "-",
                "-",
                false
            )
        )
        movies.add(
            MoviesResponse(
                "m10",
                "https://www.themoviedb.org/t/p/original/lHhc60NXYzswU4TvKSo45nY9Jzs.jpg",
                "https://www.themoviedb.org/t/p/original/msI5a9TPnepx47JUb2vl88hb80R.jpg",
                "Miraculous World: Shanghai – The Legend of Ladydragon",
                "04/04/2021",
                "Animation, Comedy, Family, Adventure",
                "52m",
                "79%",
                "Miraculous World",
                "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time...",
                "Released",
                "French",
                "-",
                "-",
                false
            )
        )


        return movies
    }

    fun generateTvShow(): List<TvShowResponse> {

        val tvShow = ArrayList<TvShowResponse>()

        tvShow.add(
            TvShowResponse(
                "tv01",
                "https://www.themoviedb.org/t/p/original/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "https://www.themoviedb.org/t/p/original/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "The Falcon and the Winter Soldier",
                "Mar 19, 2021",
                "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
                "50m",
                "79%",
                "Honor the shield.",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "Released",
                "Inggris",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv02",
                "https://www.themoviedb.org/t/p/original/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                "https://www.themoviedb.org/t/p/original/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "Invincible",
                "Mar 26, 2021",
                "Animation, Action & Adventure, Drama, Sci-Fi & Fantasy",
                "45m",
                "89%",
                "-",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv03",
                "https://www.themoviedb.org/t/p/original/lEZLrd3N9nIk5fnCL30GsboCEmB.jpg",
                "https://www.themoviedb.org/t/p/original/Q1ZYG3kDS8iVIHOYOJ9NQmV0q7.jpg",
                "Haunted: Latin America",
                "Mar 31, 2021",
                "Reality",
                "30m",
                "74%",
                "-",
                "Real people's terrifying tales of the chilling, unexplained and paranormal come to life with dramatic reenactments in this reality series.",
                "Returning Series",
                "Spanish; Castilian",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv04",
                "https://www.themoviedb.org/t/p/original/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                "https://www.themoviedb.org/t/p/original/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "The Good Doctor",
                "Sep 25, 2017",
                "Drama",
                "43m",
                "86%",
                "His mind is a mystery, his methods are a miracle.",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv05",
                "https://www.themoviedb.org/t/p/original/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
                "https://www.themoviedb.org/t/p/original/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "The Flash",
                "Oct 07, 2014",
                "Drama, Sci-Fi & Fantasy",
                "44m",
                "77%",
                "The fastest man alive.",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv06",
                "https://www.themoviedb.org/t/p/original/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                "https://www.themoviedb.org/t/p/original/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "Grey's Anatomy",
                "Mar 27, 2005",
                "Drama",
                "43m",
                "82%",
                "The life you save may be your own.",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv07",
                "https://www.themoviedb.org/t/p/original/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg",
                "https://www.themoviedb.org/t/p/original/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "Lucifer",
                "Jan 25, 2016",
                "Crime, Sci-Fi & Fantasy",
                "45m",
                "85%",
                "It's good to be bad.",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv08",
                "https://www.themoviedb.org/t/p/original/wkyzeBBKLhSg1Oqhky5yoiFF2hG.jpg",
                "https://www.themoviedb.org/t/p/original/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                "Luis Miguel: The Series",
                "Apr 22, 2018",
                "Drama",
                "-",
                "80%",
                "-",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                "Returning Series",
                "Spanish; Castilian",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv09",
                "https://www.themoviedb.org/t/p/original/5VltHQJXdmbSD6gEJw3R8R1Kbmc.jpg",
                "https://www.themoviedb.org/t/p/original/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
                "Van Helsing",
                "Sep 23, 2016",
                "Mystery, Sci-Fi & Fantasy, Action & Adventure",
                "42m",
                "69%",
                "-",
                "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )
        tvShow.add(
            TvShowResponse(
                "tv10",
                "https://www.themoviedb.org/t/p/original/qZtAf4Z1lazGQoYVXiHOrvLr5lI.jpg",
                "https://www.themoviedb.org/t/p/original/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "Riverdale",
                "Jan 26, 2017",
                "Mystery, Drama, Crime",
                "45m",
                "86%",
                "Small town. Big secrets.",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "Returning Series",
                "English",
                "-",
                "-",
                false
            )
        )


        return tvShow
    }


}