## RIDANGO News

A modern Android application fetching top news headlines using the [News API](https://newsapi.org/), built with Jetpack Compose, Clean Architecture, and modern Android libraries.

### Features
- **Grid Layout**: 2 columns (portrait) / 3 columns (landscape)
- **Material Design**: Theming, typography, and adaptive layouts
- **Pagination**: Loads 21 articles initially, endless scrolling
- **Article Details**: Full article view with save functionality
- **Protocol Buffers**: Serialization for mock API save operations

### Technologies
- **Jetpack Compose**: Declarative UI toolkit
- **Retrofit/OkHttp**: Networking with JSON/protobuf
- **Hilt**: Dependency injection
- **Paging 3**: Pagination with RecyclerView/Compose
- **Protocol Buffers**: Article serialization
- **Coil**: Image loading
- **KSP**: Kotlin Symbol Processing

### Setup
1. Get your API key from [News API Key](https://newsapi.org/register)
2. Clone the repository
3. Add the API key to your local.properties file to get started.
```
NEWS_API_KEY="your-api-key-from-above-link"
```

### Future Improvements

- Implement real backend for saved articles
- Expand offline support with Room synchronization 
- Add dark mode toggle 
- Introduce user preferences (country/category filters)