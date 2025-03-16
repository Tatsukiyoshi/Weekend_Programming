import { AppDataSource } from "./data-source"
import { Album } from "./entity/Album"
import { Author } from "./entity/Author"
import { Photo } from "./entity/Photo"
import { PhotoMetadata } from "./entity/PhotoMetadata"

AppDataSource.initialize().then(async () => {

    // create a photo
    const photo = new Photo()
    photo.name = "Me and Bears"
    photo.description = "I am near polar bears"
    photo.filename = "photo-with-bears.jpg"
    photo.views = 1
    photo.isPublished = true

    // create a photo metadata
    const metadata = new PhotoMetadata()
    metadata.height = 640
    metadata.width = 480
    metadata.compressed = true
    metadata.comment = "cybershoot"
    metadata.orientation = "portrait"

    photo.metadata = metadata // this way we connect them

    const author = new Author()
    author.name = "John Doe"
    photo.author = author

    // get repository
    const photoRepository = AppDataSource.getRepository(Photo)
    
    // saving a photo also save the metadata
    await photoRepository.save(photo)

    console.log("Photo is saved, photo metadata is saved too.")

    // load photos with metadata
    const photos = await photoRepository.find({
        relations: {
            metadata: true,
            author: true
        },
    })
    console.log("All photos: ", photos)

    // create a few albums
    const album1 = new Album()
    album1.name = "Bears"
    await AppDataSource.manager.save(album1)

    const album2 = new Album()
    album2.name = "Me"
    await AppDataSource.manager.save(album2)

    // create a few photos
    const photo_in_albums = new Photo()
    photo_in_albums.name = "Me and Bears"
    photo_in_albums.description = "I am near polar bears"
    photo_in_albums.filename = "photo-with-bears.jpg"
    photo_in_albums.views = 1
    photo_in_albums.isPublished = true
    photo_in_albums.metadata = metadata
    photo_in_albums.author = author
    photo_in_albums.albums = [album1, album2]
    await AppDataSource.manager.save(photo_in_albums)

    // now our photo is saved and albums are attached to it
    // now lets load them:
    const loadedPhoto = await AppDataSource.getRepository(Photo).findOne({
        where: {
            id: photo_in_albums.id,
        },
        relations: {
            albums: true,
        },
    })
    console.log("Photo in Albums: ", loadedPhoto)
}).catch((error) => console.log(error))
