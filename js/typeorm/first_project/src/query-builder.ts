import { AppDataSource } from "./data-source"
import { Album } from "./entity/Album"
import { Author } from "./entity/Author"
import { Photo } from "./entity/Photo"
import { PhotoMetadata } from "./entity/PhotoMetadata"

AppDataSource.initialize().then(async () => {
    createPhoto("My")
    createPhoto("Mishka")

    const photos = await AppDataSource.getRepository(Photo)
        .createQueryBuilder("photo") // first argument is an alias. Alias is what you are selecting - photos. You must specify it.
        .innerJoinAndSelect("photo.metadata", "metadata")
        .leftJoinAndSelect("photo.albums", "album")
        .where("photo.isPublished = true")
        .andWhere("(photo.name = :photoName OR photo.name = :bearName)")
        .orderBy("photo.id", "DESC")
        .skip(5)
        .take(10)
        .setParameters({ photoName: "My", bearName: "Mishka" })
        .getMany()

    console.log("photos specified My and Mishka:", photos)
}).catch((error) => console.log(error))

/// Create a photo
// @module createPhoto
// @param photoName - The name of the photo
// @returns void
async function createPhoto(photoName: string) {
    // create a photo
    const photo = new Photo()
    photo.name = "My"
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
}
