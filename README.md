# 🎌 Anime Explorer  

An Android app that brings your favorite anime closer to you!  
Built with **Kotlin, Jetpack Compose, MVVM, Retrofit+Moshi, Room, and Glide**, powered by the **Jikan API (MyAnimeList unofficial API)**.  

---

## 🚀 Overview  
Anime Explorer is a **modern, offline-first anime browsing app** where you can:  
- 📺 **Explore Top Anime** in a clean grid UI  
- 📖 **Dive into detailed pages** with genres, scores, and synopsis  
- ▶️ **Watch trailers** directly in-app via YouTube embed  
- 💾 **Enjoy offline access** thanks to Room database caching  

---

## ✨ Features Implemented  

✅ **Top Anime Grid** — title, poster, score, episodes  
✅ **Anime Detail Page** — poster, synopsis, genres, episodes, rating  
✅ **Trailer Playback** — seamless YouTube embed (WebView)  
✅ **Offline-First UI** — cached data shows instantly if offline  
✅ **Room Caching** — for both top list & anime details  
✅ **Error Handling + Retry** — smooth fallback for network issues  

---

## 🖼️ Screenshots  

| Anime List | Anime Details |
|------------|---------------|
| <img width="349" height="733" alt="AnimeList" src="https://github.com/user-attachments/assets/c047b483-dd9b-4ce7-a543-af3c6d2c9e26" /> | <img width="349" height="733" alt="AnimeDetail" src="https://github.com/user-attachments/assets/255619bb-8f99-4eec-9db6-f77227b5f172" />
 |

---

## ⚙️ How to Run  

1. Open project in **Android Studio (Electric Eel or newer)**  
2. Set `minSdk = 25`  
3. Build & run on emulator/device with internet access  
4. 🔌 To test **offline mode**: turn off network → cached data still works!  

---

## 📌 Assumptions  

- Using **Jikan API v4** endpoints (`/top/anime` & `/anime/{id}`)  
- Trailer playable via `trailer.youtube_id` in a WebView embed  

---

## ⚠️ Known Limitations  

- 🚫 No advanced pagination (currently shows only Page 1)  
- ⏳ Background periodic sync not yet configured (future: WorkManager)  
- 📵 Some YouTube trailers may be blocked → fallback = poster  

---

## 💡 Why This Project Stands Out  

🔥 Full **MVVM + Repository architecture** with clean separation of concerns  
🔥 **Compose-first UI** for declarative, modern design  
🔥 **Offline-first caching strategy** (usable even without internet)  
🔥 **Real-world API integration** with error handling & resilience  
🔥 **Expandable foundation** → can add Paging 3, WorkManager sync, favorites & search  
