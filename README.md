# Anime Explorer
## Overview
Android app using Jikan API to list top anime and show details with trailer support.
Stack: Kotlin, Jetpack Compose, MVVM, Retrofit+Moshi, Room, Glide.

## Features implemented
- Top anime grid (title, poster, score, episodes)
- Anime detail page (poster, synopsis, genres, episodes, rating)
- Trailer playback (YouTube embed via WebView)
- Room caching for top list and details
- Offline-first UI: shows cached data if offline and syncs when online
- Error handling and retry

## How to run
1. Open project in Android Studio (Electric Eel+ recommended).
2. Ensure `minSdk 25`.
3. Build and run on device/emulator with Internet.
4. For offline testing: turn off network — cached data will show.

## Assumptions
- Using Jikan API v4 endpoints (`/top/anime` and `/anime/{id}`).
- Trailer is available from `trailer.youtube_id` and playable via WebView embed.

## Known limitations
- No advanced paging (only page 1 top anime).
- No background periodic sync worker configured (can be added with WorkManager).
- WebView embed may be blocked for some trailers due to YouTube policy — fallback is poster.
