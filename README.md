"# VismaHomework" 
Weather_app

1. Write Weather app using Kotlin.

2. Make a weather request to API using the endpoint with the city name that user enters.

3. Retrieve weather icon from the second API endpoint (icon_name can be found in a first response - "weather.icon").

4. Design should be recreated as closely as possible.

5. Use best practices you know to write clear, readable & extendable code.

6. BONUS: Change City card text colours based on temperature value. If temperature is 
	* <= 10 then City name - yellow, temperature - green, date - red;
	* \> 10 < 20 then City name - red, temperature - yellow, date - green;
	* \>= 20 then City name - green, temperature - red, date - yellow.

7. BONUS: Implement persistent layer which would store last 5 searched cities. When "View History" is hit app should show last 5 (or less if where isn't 5 searches yet) cities in a list.

8. BONUS: Add Automatic tests.


---
* Weather API endpoint: "http://api.openweathermap.org/data/2.5/weather?q={city_name},LTU&appid={api_key}"

* Weather icon API endpoint: "http://openweathermap.org/img/wn/{icon_name}@2x.png"

* Parameters you'll need from the API: weather.description, main.temp, main.temp_min, main.temp_max, dt, name.
---
