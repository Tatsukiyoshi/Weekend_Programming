import "reflect-metadata"
import { DataSource } from "typeorm"
import { User } from "./entity/User"
import { Photo } from "./entity/Photo"
import { PhotoMetadata } from "./entity/PhotoMetadata"
import { Author } from "./entity/Author"

export const AppDataSource = new DataSource({
    type: "mysql",
    host: "localhost",
    port: 3306,
    username: "taish",
    password: "password",
    database: "test",
    synchronize: true,
    logging: false,
    entities: [User, Photo, PhotoMetadata, Author],
    migrations: [],
    subscribers: [],
})
