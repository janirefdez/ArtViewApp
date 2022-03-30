# Art View App
[![Kotlin](https://img.shields.io/badge/Kotlin--blue.svg)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android--blue.svg)](https://developer.android.com/)


Art View app made in Kotlin. This app is a basic android example where you can find how to display list of items in a GridLayout.
In this case the app will display a list of art prints from Hardvard Art Museum.

## Requirements
- Android API 24 - 31
- Gradle 7.2
- Kotlin 1.6.10

## Characteristics
- MVVM 
- Clean Architecture
- Dagger Hilt
- LiveData
- Coroutines
- Retrofit

## Functionalities

- Display list of art prints in a grid layout. When scrolling down, new art prints will appear.
   - There is a maximum of 100 items displayed in the grid layout. Which means you can only scroll and get new art prints until you reach the maximum of 100 items => This, of course, can be modified. This setup was for testing purposes only.
   - Art prints displayed come from [hardvard art museum's API](https://github.com/harvardartmuseums/api-docs).
In this case request [GET /objects](https://github.com/harvardartmuseums/api-docs/blob/master/sections/object.md) is used to get detailed 
information on the items.
```
https://api.harvardartmuseums.org/object?classification=Prints&size=20&hasimage=1
```
- Click on an art print and be able to see it more in detail.
  - The detail view is a WebView that shows the URL of the art print, which contains all its details. Example url:
```
https://www.harvardartmuseums.org/collections/object/4952
```

## Notes

To be able to get new art prints when scrolling down, an OnScrollListener is included in the recyclerView. When recyclerView is detected to have reached the bottom, a new GET request is made.

There is a better way to handle this, using [Paging library](https://developer.android.com/topic/libraries/architecture/paging/v3-overview). If you want to check how to implement it, check this repository: [Paging3Example](https://github.com/janirefdez/Paging3Example)


## Demo
  [Art view app demo](https://user-images.githubusercontent.com/20024632/159034995-531eacfb-e427-4215-8f6e-7b701da38f5c.mp4)
