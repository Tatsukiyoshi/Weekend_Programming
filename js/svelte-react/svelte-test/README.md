# Start Docker 
- Build Container Image
	```
	docker build --pull -t bun-svelte .
	```

-	Run Container
	```
	docker run --name Svelte_Sample -d -p 8000:80 bun-svelte
	```

-	Access [Web-Site](http://localhost:8000)
