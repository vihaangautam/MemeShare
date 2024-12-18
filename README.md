# MemeShare

**MemeShare** is a fun Android application that fetches random memes from the internet and allows users to view and share them with their friends.

---

## Features

- Fetch random memes using the **Meme API**.  
- Share memes via any app that supports sharing text or URLs.  
- User-friendly interface with seamless meme loading.  

---

## Technologies Used

- **Kotlin**: Programming language used for Android development.  
- **Volley**: For making HTTP requests to fetch memes.  
- **Glide**: For loading and displaying images.  

---

## API Used

This project utilizes the **Meme API** to fetch random memes.

---

## How to Use

1. Launch the application.  
2. Tap on the "Next Meme" button to load a new meme.  
3. Tap on the "Share" button to share the meme with your friends.

---

## Dependencies

Add the following dependencies to your `build.gradle` file:

```gradle
implementation 'com.android.volley:volley:1.2.1'
implementation 'com.github.bumptech.glide:glide:4.13.0'
kapt 'com.github.bumptech.glide:compiler:4.13.0'
