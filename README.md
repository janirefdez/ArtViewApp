# Art View App
[![Kotlin](https://img.shields.io/badge/Kotlin--blue.svg)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android--blue.svg)](https://developer.android.com/)

Art View app made in Kotlin. This app will display a list of art prints from Hardvard Art Museum.

## Requirements
- Android API 24 - 31

## Characteristics
- MVVM 
- Clean Architecture
- Dagger Hilt
- LiveData
- Coroutines
- Retrofit

## Functionalities

- Display list of art prints in a grid layout.
  - When scrolling down, new art prints will appear.
- Click on an art print and be able to see it more in detail.
  
## Notes
- Art prints displayed come from [hardvard art museum's API](https://github.com/harvardartmuseums/api-docs). 

In this case I'm just using request [GET /objects](https://github.com/harvardartmuseums/api-docs/blob/master/sections/object.md) to get detailed 
information on the items. But if you check the API documentation, you can see that there are many more requests. 

For this project I just wanted to display a simple GridLayout so the request used is:

```
https://api.harvardartmuseums.org/object?classification=Prints&size=20&hasimage=1
```

- There is a maximum of 100 items displayed in the grid layout. Which means you can only scroll and get new art prints until you reach the maximum of 100 items.
- The detail view is a WebView that shows the URL of the art print, which contains all its details.

Example url:
```
https://www.harvardartmuseums.org/collections/object/4952
```

## Demo
  [Art view app demo](https://user-images.githubusercontent.com/20024632/159034995-531eacfb-e427-4215-8f6e-7b701da38f5c.mp4)
