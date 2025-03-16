import { Photo } from "./entity/Photo"
import { AppDataSource } from "./data-source"

AppDataSource.initialize().then(async () => {
	const photo = new Photo()
	photo.name = "Me and Bears"
	photo.description = "I am near polar bears"
	photo.filename = "photo-with-bears.jpg"
	photo.views = 1
	photo.isPublished = true
	
	const photoRepository = AppDataSource.getRepository(Photo)
	
	// Save the photo
	await photoRepository.save(photo)
	console.log("Photo has been saved")
	
	// Find the photo
	const allPhotos = await photoRepository.find()
	console.log("All photos from the db: ", allPhotos)
	
	// Find the photo by id
	const firstPhoto = await photoRepository.findOneBy({
		id: 1,
	})
	console.log("First photo from the db: ", firstPhoto)
	
	// Find the photo by name
	const meAndBearsPhoto = await photoRepository.findOneBy({
		name: "Me and Bears",
	})
	console.log("Me and Bears photo from the db: ", meAndBearsPhoto)

	// Find the photo by views
	const allViewedPhotos = await photoRepository.findBy({ views: 1 })
	console.log("All viewed photos: ", allViewedPhotos)
	
	// Find the photo by isPublished
	const allPublishedPhotos = await photoRepository.findBy({ isPublished: true })
	console.log("All published photos: ", allPublishedPhotos)
	
	// Find the photos and count
	const [photos, photosCount] = await photoRepository.findAndCount()
	console.log("All photos: ", photos)
	console.log("Photos count: ", photosCount)

	// Update the photo
	const photoToUpdate = await photoRepository.findOneBy({
		views: 1
	})
	photoToUpdate.name = "Me, my friends and polar bears"
	await photoRepository.save(photoToUpdate)
	const photoUpdated = await photoRepository.findOneBy({
		id: photoToUpdate.id,
	})
	console.log("Photo has been updated: ", photoUpdated)

	// Remove the photo
	const photoToRemove = await photoRepository.findOneBy({
		views: 1
	})
	const removeResult = await photoRepository.remove(photoToRemove)
	if (removeResult.id === undefined) {
		console.log("Photo has been removed.")
	}
}).catch(error => console.log(error))
