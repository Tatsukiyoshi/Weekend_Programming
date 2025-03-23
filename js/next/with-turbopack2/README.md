#	How to build container
-	Configuration to export static
	```js
	/**
	 * @type {import('next').NextConfig}
	*/
	const nextConfig = {
		output: 'export',
	
		// Optional: Change links `/me` -> `/me/` and emit `/me.html` -> `/me/index.html`
		// trailingSlash: true,
	
		// Optional: Prevent automatic `/me` -> `/me/`, instead preserve `href`
		// skipTrailingSlashRedirect: true,
	
		// Optional: Change the output directory `out` -> `dist`
		// distDir: 'dist',
	}
	
	module.exports = nextConfig
	```

-	How to set environment variables in PowerShell
	```
	$env:NODE_ENV="production"
	```

-	Path of the content built with next.js
	```
	out/inde.html
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
