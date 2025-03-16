import { AppDataSource } from "./data-source"
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
}).catch((error) => console.log(error))
