import { Photo } from "./entity/Photo"
import { AppDataSource } from "./data-source"

AppDataSource.initialize().then(async () => {
	const photo = new Photo()
	photo.name = "Me and Bears"
	photo.description = "I am near polar bears"
	photo.filename = "photo-with-bears.jpg"
	photo.views = 1
	photo.isPublished = true

	await AppDataSource.manager.save(photo)
	console.log("Photo has been saved. Photo id is", photo.id)

	const savedPhotos = await AppDataSource.manager.find(Photo)
	console.log("All photos from the db: ", savedPhotos)
}).catch(error => console.log(error))
