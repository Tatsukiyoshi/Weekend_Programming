# Start Docker 
- Build Container Image
	```
	docker build --pull -t bun-astro .
	```

-	Run Container
	```
	docker run --name Astro_Sample -d -p 8000:80 bun-astro
	```

-	Access [Web-Site](http://localhost:8000)
