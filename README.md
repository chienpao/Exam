# Exam by Pao

## App Screenshot

## Use Library
- Dagger2 for dependency injection
- Rxjava2 for async task
- Timber for log
- Retrofit2 for API request
- Okhttp3 for web client
- Gson for api json parsing
- Glide for showing image
- Google Map SDK for mark deliver location in map

## How to add Google map customize key
1. Go to "https://cloud.google.com/maps-platform/" to apply the account
2. Enable the Google map SDK service to the current project
3. Download "google_maps_api.xml" file, and put into res/values folder
4. Make sure AndroidManifest.xml already add "ACCESS_FINE_LOCATION" permission
5. Make sure the google key copy from web is set in AndroidManifest.xml metadata as below,
```
android:name="com.google.android.geo.API_KEY"
android:value="@string/google_maps_key" />
```
6. Now we can start to use Google Map SDK!

## Requirement
- (done) Source code must be stored in a Git repository
- (not yet) App should cache deliveries (Cached deliveries should be available offline)
---> Will use cursorLoader with Recycler to save cache in database
- (done) Should implement pagination, retrieve up to 20 items per page
- (done) Candidates are free to use any libraries
- (Pass) Project must compile ./gradlew build

