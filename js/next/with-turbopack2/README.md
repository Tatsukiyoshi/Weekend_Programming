#	How to build container
-	How to set environment variables in PowerShell
	```
	$env:NODE_ENV="production"
	```

-	Path of the content built with next.js
	```
	.next/server/app/inde.html
	```

# Start Docker 
- Build Container Image
	```
	docker build --pull -t bun-nextjs .
	```

-	Run Container
	```
	docker run --name Nextjs_Sample -d -p 8000:80 bun-nextjs
	```

-	Access [Web-Site](http://localhost:8000)
